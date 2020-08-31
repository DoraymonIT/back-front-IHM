package com.codetreatise.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Product;

@Repository
public interface ProduitDao extends JpaRepository<Product, Long> {
    Product findByNom(String nom);
    List<Product> findByCategorieLibelle(String libelle);

}
	