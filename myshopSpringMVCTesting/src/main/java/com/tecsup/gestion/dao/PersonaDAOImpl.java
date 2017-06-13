package com.tecsup.gestion.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.mapper.PersonaMapper;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonaDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public Persona validate(String login, String pwd) throws LoginException, DAOException {

		logger.info("validate(): login: " + login + ", clave: " + pwd);

		if ("".equals(login) && "".equals(pwd)) {
			throw new LoginException("Login and password incorrect");
		}

		String query = "SELECT login, password, persona_id, first_name, correo, tienda_id  "
				+ " FROM personas WHERE login=? AND password=?";

		Object[] params = new Object[] { login, pwd };

		try {

			Persona per = (Persona) jdbcTemplate.queryForObject(query, params, new PersonaMapper());
			//
			return per;

		} catch (EmptyResultDataAccessException e) {
			logger.info("Persona y/o clave incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	
	@Override
	public int create(String login, String password, String lastname, String correo, int tndaId) throws DAOException {

		String query = "INSERT INTO personas (login, password, first_name, correo, tienda_id)  VALUES ( ?,?,?,?,? )";

		Object[] params = new Object[] { login, password, lastname, correo, tndaId };

		Persona per = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			per = this.findPersonaByLogin(login);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
		return per != null ? per.getPersonaId() : -1;
	}
	
	@Override
	public void addRole(String login, String roleId) throws DAOException {

		String query = "INSERT INTO personas_roles (login, role)  VALUES ( ?,? )";

		Object[] params = new Object[] { login, roleId };

		Persona per = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);

		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int persona_id) throws DAOException {

		String query = "DELETE FROM  personas WHERE persona_id = ? ";

		Object[] params = new Object[] { persona_id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(int persona_id, String password, String lastname, String correo, int tndaId) throws DAOException {

		String query = "UPDATE personas SET password = ?, first_name =?, correo = ?, tienda_id = ? WHERE persona_id = ?";

		Object[] params = new Object[] { password, lastname, correo, tndaId, persona_id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Persona findPersona(int persona_id) throws DAOException, EmptyResultException {

		String query = "SELECT persona_id, login, password, first_name, correo, tienda_id "
				+ " FROM personas WHERE persona_id = ?";

		Object[] params = new Object[] { persona_id };

		try {

			Persona per = (Persona) jdbcTemplate.queryForObject(query, params, new PersonaMapper());
			//
			return per;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Persona findPersonaByLogin(String login) throws DAOException, EmptyResultException {

		String query = "SELECT persona_id, login, password, first_name, correo, tienda_id "
				+ " FROM personas WHERE login = ? ";

		Object[] params = new Object[] { login };

		try {

			Persona persona = jdbcTemplate.queryForObject(query, params, new PersonaMapper());
			//
			return persona;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Persona> findAllPersonas() throws DAOException, EmptyResultException {

		String query = "SELECT persona_id, login, password, first_name, correo, tienda_id FROM personas ";

		try {

			List<Persona> personas = jdbcTemplate.query(query, new PersonaMapper());
			//
			return personas;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Persona> findPersonasByName(String name) throws DAOException, EmptyResultException {

		String query = "SELECT persona_id, login, password, first_name, correo, tienda_id "
				+ " FROM personas WHERE upper(first_name) like upper(?) ";

		Object[] params = new Object[] { "%" + name + "%" };

		try {

			List<Persona> personas = jdbcTemplate.query(query, params, new PersonaMapper());
			//
			return personas;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}



}