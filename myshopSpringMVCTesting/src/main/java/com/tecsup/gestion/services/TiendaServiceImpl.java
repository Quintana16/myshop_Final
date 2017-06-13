package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.TiendaDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private TiendaDAO tiendaDAO;

	@Override
	public int create(String name, String desc) throws DAOException {
		
		int tndaId = tiendaDAO.create(name, desc);

		return tndaId;
	}

	@Override
	public void delete(int id) throws DAOException {
		
		tiendaDAO.delete(id);

	}

	@Override
	public void update(int id, String name, String desc) throws DAOException {
		
		tiendaDAO.update(id, name, desc);
		
	}

	@Override
	public Tienda findById(int id) throws DAOException, EmptyResultException {
		
		Tienda tnda = tiendaDAO.findById(id);

		return tnda;
	}

	@Override
	public Tienda findByName(String name) throws DAOException, EmptyResultException {
		
		Tienda tnda = tiendaDAO.findByName(name);

		return tnda;
	}

	@Override
	public List<Tienda> findAll() throws DAOException, EmptyResultException {
	
		List<Tienda> tndas = tiendaDAO.findAll();

		return tndas;
	}

}
