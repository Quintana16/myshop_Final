package com.tecsup.gestion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Tienda;

public class TiendaMapper implements RowMapper<Tienda>{

	public Tienda mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tienda tnda = new Tienda();
		tnda.setTiendaId(rs.getInt("tienda_id"));
		tnda.setName(rs.getString("tienda_name"));
		tnda.setDescription(rs.getString("tienda_desc"));
		return tnda;
	}
}
