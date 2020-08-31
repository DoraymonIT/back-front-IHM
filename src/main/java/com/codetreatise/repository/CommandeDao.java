package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {

}
