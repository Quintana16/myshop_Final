package com.tecsup.gestion.model;

public class Persona {

	String login;
	String password;
	int personaId;
	String firstname;
	String correo;

	Tienda tienda = new Tienda();

	Role role = new Role();
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	// public Employee(int employeeId, String login, String password, String
	// firstname, String lastname, int salary) {
	// super();
	// this.employeeId = employeeId;
	// this.login = login;
	// this.password = password;
	// this.firstname = firstname;
	// this.lastname = lastname;
	// this.salary = salary;
	// }
	//
	public Persona(String login, String password, String firstname, String correo) {
		super();
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.correo = correo;
	}

	public Persona() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaID) {
		this.personaId = personaID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return "Persona [login=" + login + ", password=" + password + ", personaId=" + personaId + ", firstname="
				+ firstname + ", correo=" + correo + ", tienda=" + tienda+ "]";
	}

}
