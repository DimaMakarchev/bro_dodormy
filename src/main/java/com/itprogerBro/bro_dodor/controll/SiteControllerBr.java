package com.itprogerBro.bro_dodor.controll;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Controller
public  class SiteControllerBr implements Statics {
    /*const*/
    private static final String URL = "https://history.openweathermap.org/data/2.5/aggregated/year?q=";
    private static final String API = "b197ab69b9e9fb7fed194b90dea0bf9b";

    @GetMapping("/site")
    public  ModelAndView methodGetSite(ModelMap modelMap) {
        modelMap.addAttribute("title", "Site");
        return new ModelAndView("site", modelMap);
    }


    @PostMapping("/site")
    public ModelAndView methodPostWeater(@RequestParam String date, ModelMap map) {
        String city = date;
        String outPut = getUrlContent(URL + city + "&appid=" + API);
        if (!outPut.isEmpty()) {

            JSONObject json = new JSONObject(outPut);
            double aDouble = json.getJSONObject("main").getDouble("temp");
            map.addAttribute("weater", aDouble);
        }
        //Client method :
/*
String serviceJaxWSBr = getServiceJaxWSBr();
        System.out.println("n\"++++++++++++++++++++++++++++++++++++++++");
        System.out.println(serviceJaxWSBr);
        System.out.println("n\"++++++++++++++++++++++++++++++++++++++++");
*/

        return new ModelAndView("site", map);
    }

/*    private String getServiceJaxWSBr() {

        ServiceBR serviceBro = new ServiceBR();
        ServiceBrImpl serviceJaxWSBr = serviceBro.getServiceBRPort();
        Dao listBrOne = serviceJaxWSBr.getPaymentForServiceBR(1123, "bro");
        //System.out.println(listBrOne.getName());
        System.out.println(listBrOne.getId());
        return listBrOne.getName();
    }*/

    public static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConnection = url.openConnection();
            /***Here error((*/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("CITY NO BRO" + e);
        }
        return content.toString();
    }

}
