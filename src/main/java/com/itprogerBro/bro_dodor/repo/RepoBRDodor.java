package com.itprogerBro.bro_dodor.repo;

import com.itprogerBro.bro_dodor.modeldao.Dodor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoBRDodor extends JpaRepository<Dodor,Long> {
}
