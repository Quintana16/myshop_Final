package com.tecsup.gestion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Persona;

public class PersonaMapper implements RowMapper<Persona>{

	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona per = new Persona();
		per.setPersonaId(rs.getInt("persona_id"));
		per.setLogin(rs.getString("login"));
		per.setPassword(rs.getString("password"));
		per.setFirstname(rs.getString("first_name"));
		per.setCorreo(rs.getString("correo"));
		per.getTienda().setTiendaId(rs.getInt("tienda_id"));
		return per;
	}
}
