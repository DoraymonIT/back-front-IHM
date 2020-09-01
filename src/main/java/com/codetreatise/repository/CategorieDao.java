package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Categorie;


	@Repository
	public interface CategorieDao extends JpaRepository<Categorie, Long> {
}
