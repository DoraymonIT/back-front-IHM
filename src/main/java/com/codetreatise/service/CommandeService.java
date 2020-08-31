package com.codetreatise.service;

import java.util.List;

import com.codetreatise.bean.Commande;

public interface CommandeService {

	List<Commande> findAll();
	int save(Commande commande);
}
