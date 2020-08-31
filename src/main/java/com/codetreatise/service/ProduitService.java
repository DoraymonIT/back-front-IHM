package com.codetreatise.service;

import java.util.List;

import com.codetreatise.bean.Product;

public interface ProduitService {
    Product findByid(Long id);

    Product findByNom(String nom);

    List<Product> findAll();

    int save(Product Product);

    int deleteById(Long id);
    List<Product> findByCategorieLibelle(String libelle);
}
