package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class PersonaDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(PersonaDAOTest.class);

	@Autowired
	private PersonaDAO employeeDAO;

	@Test
	public void testCredentialValidate() {

		try {
			//
			employeeDAO.validate("jgomez", "123456");
		} catch (LoginException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testFindPersonaById() {

//		try {
			//
			//Persona per = personaDAO.findPersona(100);
			//logger.info(per.toString());
		//} catch (EmptyResultException e) {
		//	fail(e.getMessage());
		//} catch (DAOException e) {
		//	fail(e.getMessage());
		//}

	}

	@Test
	public void testFindAllPersonas() {

	//	try {
			//
			//List<Persona> pers = personaDAO.findAllPersonas();
		//	logger.info(pers.toString());
		//} catch (EmptyResultException e) {
			//fail(e.getMessage());
		//} catch (DAOException e) {
			//fail(e.getMessage());
		//}

	}

	@Test
	public void testFindPersonaByName() {

		//try {
			//
			//List<Persona> pers = personaDAO.findPersonasByName("ai");
			//logger.info(pers.toString());
		//} catch (EmptyResultException e) {
			//fail(e.getMessage());
		//} catch (DAOException e) {
			//fail(e.getMessage());
		//}

	}

	@Test
	public void testCreatePersona() {

		String LOGIN = "aromero" + (int)(Math.random() * 100);
		logger.info(LOGIN);
		String PWD = "123";
		String FIRSTNAME = "Alberto";
		String CORREO = "ALAL@LAALAL";
		int TNDA_ID = 15;

	//	try {
			//
		//	int perId = personaDAO.create(LOGIN, PWD, FIRSTNAME, CORREO, TNDA_ID);

			//
			//Persona per = personaDAO.findPersona(perId);

			//Assert.assertEquals(LOGIN, per.getLogin());
			//Assert.assertEquals(PWD, per.getPassword());
			//Assert.assertEquals(FIRSTNAME, per.getFirstname());
			//Assert.assertEquals(CORREO, per.getCorreo());

		//} catch (DAOException e) {
			//fail(e.getMessage());
		//} catch (EmptyResultException e) {
			//fail(e.getMessage());
		//}

	}

	
	@Test
	public void testUpdatePersona() {

		String LOGIN = "jgomez" + (int)(Math.random() * 100);
		String PWD = "123";
		String FIRSTNAME = "Jaime";
		String LASTNAME = "Gomez";
		int SALARY = 3000;
		int DEPT_ID = 15;
		
		String UP_PWD = "456";
		String UP_FIRSTNAME = "Jaime5";
		String UP_LASTNAME = "Gomez6";
		int UP_SALARY = 3500;
		int UP_DEPT_ID = 15;
		
		//try {
			//
			//int perId = personaDAO.create(LOGIN, PWD, FIRSTNAME, CORREO, DEPT_ID);
			//
			//personaDAO.update(perId, UP_PWD, UP_FIRSTNAME, UP_CORREO, UP_TNDA_ID);
			//
			//Persona emp = personaDAO.findPersona(perId);

			//Assert.assertEquals(UP_PWD, emp.getPassword());
			//Assert.assertEquals(UP_FIRSTNAME, emp.getFirstname());
			//Assert.assertEquals(UP_CORREO, emp.getCorreo());
			//Assert.assertEquals(UP_TNDA_ID, emp.getTienda().getTiendaId());

		//} catch (DAOException e) {
			//fail(e.getMessage());
		//} catch (EmptyResultException e) {
			//fail(e.getMessage());
		//}

	}
	
	
	//@Test
	public void testDeletePersona() {

		String LOGIN = "jromero";
		String PWD = "123";
		String FIRSTNAME = "Juan";
		String LASTNAME = "Romero";
		int SALARY = 3000;
		int DEPT_ID = 14;

		int perId = -1;
		//try {
			//
			//perId = personaDAO.create(LOGIN, PWD, FIRSTNAME, LASTNAME, SALARY, DEPT_ID);

		//} catch (DAOException e) {
			//fail(e.getMessage());
		//}

		//try {

			//employeeDAO.delete(empId);

			//employeeDAO.findEmployee(empId);

		//} catch (DAOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}

