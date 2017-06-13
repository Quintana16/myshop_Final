package com.tecsup.gestion.dao;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Persona;

public interface PersonaDAO {

	public Persona validate(String idPersona, String clave) throws LoginException, DAOException;

	int create(String login, String password, String lastname, String correo, int tndaId) throws DAOException;

	void addRole(String login, String roleId) throws DAOException;

	void delete(int id) throws DAOException;

	void update(int persona_id, String password, String lastname, String correo, int tndaId) throws DAOException;

	Persona findPersona(int id) throws DAOException, EmptyResultException;

	Persona findPersonaByLogin(String login) throws DAOException, EmptyResultException;

	List<Persona> findAllPersonas() throws DAOException, EmptyResultException;

	List<Persona> findPersonasByName(String name) throws DAOException, EmptyResultException;

}
