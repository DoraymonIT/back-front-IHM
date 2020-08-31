package com.codetreatise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.Product;
import com.codetreatise.repository.ProduitDao;
import com.codetreatise.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitDao produitDao;


    @Override
    public int save(Product produit) {
        if (findByid(produit.getId()) != null) {
            return -1;
        } else {
            produitDao.save(produit);
            return 1;
        }
    }

    @Override
    public Product findByid(Long id) {
        if (id!=null) {
            return produitDao.findOne(id);
        } else
            return null;
    }

    @Override
    public int deleteById(Long id) {
        produitDao.delete(id);;
        if (findByid(id) == null) {
            return 1;
        } else
            return -1;
    }


    @Override
    public List<Product> findAll() {
        return produitDao.findAll();
    }

    @Override
    public Product findByNom(String nom) {
        return produitDao.findByNom(nom);
    }

	@Override
	public List<Product> findByCategorieLibelle(String libelle) {
		// TODO Auto-generated method stub
		return produitDao.findByCategorieLibelle(libelle);
	}


}
