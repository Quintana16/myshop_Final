package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Persona;

public interface PersonaService {

	int create(String login, String password, String firstname, String correo, int tndaId) throws DAOException;

	int createWithRole(String login, String password, String firstname, String correo, int tndaId, String roleId) throws DAOException;

	void delete(int id) throws DAOException;

	void update(int persona_id, String password, String firstname, String correo, int tndaId) throws DAOException;

	Persona find(int persona_id) throws DAOException, EmptyResultException;

	Persona findByLogin(String login) throws DAOException, EmptyResultException;

	List<Persona> findAll() throws DAOException, EmptyResultException;

	List<Persona> findByName(String name) throws DAOException, EmptyResultException;

	

}
