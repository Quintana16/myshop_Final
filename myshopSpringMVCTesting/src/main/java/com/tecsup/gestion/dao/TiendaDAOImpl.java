package com.tecsup.gestion.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.mapper.TiendaMapper;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Tienda;

@Repository
public class TiendaDAOImpl implements TiendaDAO {

	private static final Logger logger = LoggerFactory.getLogger(TiendaDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(String name, String desc) throws DAOException {
		
		String query = "INSERT INTO tiendas (tienda_name, tienda_desc)  VALUES ( ?,? )";

		Object[] params = new Object[] { name, desc };

		Tienda tnda = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			tnda = this.findByName(name);

		} catch (EmptyResultException e) {
			logger.info("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
		return tnda != null ? tnda.getTiendaId() : -1;
	}

	@Override
	public void delete(int id) throws DAOException {
		
		String query = "DELETE FROM  tiendas WHERE tienda_id = ? ";

		Object[] params = new Object[] { id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(int id, String name, String desc) throws DAOException {
		logger.info("name = " + name);
		
//		String query = "UPDATE departments SET department_name = ?, department_desc =?  WHERE department_id = ?";

//		Object[] params = new Object[] { name, desc, id };

		String query = "UPDATE tiendas SET tienda_desc =?  WHERE tienda_id = ?";

		Object[] params = new Object[] { desc, id };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Tienda findByName(String name) throws DAOException, EmptyResultException {
		 
		String query = "SELECT tienda_id, tienda_name, tienda_desc "
				+ " FROM tiendas WHERE upper(tienda_name) like upper(?) ";

		Object[] params = new Object[] { "%" + name + "%" };

		try {

			Tienda tnda = jdbcTemplate.queryForObject(query, params, new TiendaMapper());
			//
			return tnda;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Tienda findById(int id) throws DAOException, EmptyResultException {
		 
		String query = "SELECT tienda_id, tienda_name, tienda_desc "
				+ " FROM tiendas WHERE tienda_id = ? ";

		Object[] params = new Object[] { id };

		try {

			Tienda tnda = jdbcTemplate.queryForObject(query, params, new TiendaMapper());
			//
			return tnda;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Tienda> findAll() throws DAOException, EmptyResultException {
		 
		String query = "SELECT tienda_id, tienda_name, tienda_desc "
				+ " FROM tiendas ";

		try {

			List<Tienda> tndas = jdbcTemplate.query(query, new TiendaMapper());
			//
			return tndas;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
}
