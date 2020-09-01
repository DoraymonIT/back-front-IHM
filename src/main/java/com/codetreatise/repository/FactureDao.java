package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Facture;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {

}
