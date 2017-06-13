package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Persona;

public interface SecurityService {

	Persona validate(String idPersona, String clave) throws LoginException, DAOException;

}
