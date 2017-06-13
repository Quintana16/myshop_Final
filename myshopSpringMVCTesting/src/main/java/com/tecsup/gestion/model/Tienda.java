package com.tecsup.gestion.model;

public class Tienda {

	int tiendaId;
	String name;
	String description;
	
	public int getTiendaId() {
		return tiendaId;
	}
	public void setTiendaId(int tiendaId) {
		this.tiendaId = tiendaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Tienda [tiendaId=" + tiendaId + ", name=" + name + ", description=" + description + "]";
	}


	
}
