package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Tienda;

public interface TiendaService {

	int create(String name, String desc) throws DAOException;

	void delete(int id) throws DAOException;

	void update(int id, String name, String desc) throws DAOException;

	Tienda findById(int id) throws DAOException, EmptyResultException;

	Tienda findByName(String name) throws DAOException, EmptyResultException;

	List<Tienda> findAll() throws DAOException, EmptyResultException;

}
