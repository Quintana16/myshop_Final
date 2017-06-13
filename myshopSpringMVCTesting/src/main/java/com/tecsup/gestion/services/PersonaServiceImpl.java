package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecsup.gestion.dao.PersonaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public int create(String login, String password, String firstname, String correo, int tndaId)
			throws DAOException {

		int perId = personaDAO.create(login, password, firstname, correo, tndaId);

		return perId;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public int createWithRole(String login, String password, String firstname, String correo, int tndaId, String roleId)
			throws DAOException {

		int perId = personaDAO.create(login, password, firstname, correo, tndaId);
		
		personaDAO.addRole(login, roleId);

		return perId;
	}

	@Override
	public void delete(int persona_id) throws DAOException {
		 
		personaDAO.delete(persona_id);

	}

	@Override
	public void update(int persona_id, String password, String firstname, String correo, int tndaId)
			throws DAOException {
	 
		personaDAO.update(persona_id, password, firstname, correo, tndaId);
	}

	@Override
	public Persona find(int persona_id) throws DAOException, EmptyResultException {
		
		Persona per = personaDAO.findPersona(persona_id);

		return per;
	}

	@Override
	public Persona findByLogin(String login) throws DAOException, EmptyResultException {
		 
		Persona per = personaDAO.findPersonaByLogin(login);

		return per;
	}

	@Override
	public List<Persona> findAll() throws DAOException, EmptyResultException {
		
		List<Persona> pers = personaDAO.findAllPersonas();

		return pers;
	}

	@Override
	public List<Persona> findByName(String name) throws DAOException, EmptyResultException {
		 
		List<Persona> pers = personaDAO.findPersonasByName(name);

		return pers;
	}

}
