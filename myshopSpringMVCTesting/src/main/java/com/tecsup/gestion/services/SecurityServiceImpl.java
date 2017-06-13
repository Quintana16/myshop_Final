package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.PersonaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Persona;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public Persona validate(String login, String password) throws LoginException, DAOException {

		Persona per = personaDAO.validate(login, password);

		return per;
	}

}
