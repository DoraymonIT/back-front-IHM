package com.codetreatise.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codetreatise.bean.Commande;
import com.codetreatise.repository.CommandeDao;
import com.codetreatise.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{

	private CommandeDao commandeDao;

	@Override
	public List<Commande> findAll() {
		
		return commandeDao.findAll();
	}

	@Override
	public int save(Commande commande) {
		if(commandeDao.exists(commande.getId())){
			return -1;
		}
		commandeDao.save(commande);
		return 1;
	}
}
