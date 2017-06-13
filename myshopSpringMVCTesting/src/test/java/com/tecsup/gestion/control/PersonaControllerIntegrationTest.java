package com.tecsup.gestion.control;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Assert; 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")

@WebAppConfiguration

public class PersonaControllerIntegrationTest {

	@Autowired

	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	//@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {

		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean("employeeController"));

	}

	@SuppressWarnings("unchecked")
	//@Test
	public void list() throws Exception {

		mockMvc.perform(get("/admin/per/list"))

				.andExpect(status().isOk())
				.andExpect(view().name("admin/per/list"))
				.andExpect(forwardedUrl("/WEB-INF/views/admin/per/list.jsp"))
				.andExpect(model().attribute("personas", hasSize(6)))
				.andExpect(model().attribute("personas", hasItem(
						allOf(
								hasProperty("personaId", is(100)),
								hasProperty("login", is("jgomez")),
								hasProperty("password", is("123456")),
								hasProperty("firstname", is("Jaime")),
								//hasProperty("correo", is(j.gomez@tecsup.edu.pe)),
								hasProperty("tienda",
										hasProperty("tiendaId", is(15)))
						)
		)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void editsave() throws Exception {

		mockMvc.perform(post("/admin/per/editsave")
				.param("employeeId", "100")
//				.param("login", "jgomez")
				.param("password", "1234567")
				.param("firstname", "Jaime7")
				.param("lastname", "Gomez7")
				.param("salary", "25357")
				.param("department.departmentId", "15"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/admin/emp/list"));
		
		mockMvc.perform(get("/admin/emp/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("admin/emp/list"))
				.andExpect(forwardedUrl("/WEB-INF/views/admin/emp/list.jsp"))
				.andExpect(model().attribute("employees", hasSize(6)))
				.andExpect(model().attribute("employees", hasItem(
						allOf(
								hasProperty("employeeId", is(100)),
//								hasProperty("login", is("jgomez")),
								hasProperty("password", is("1234567")),
								hasProperty("firstname", is("Jaime7")),
								hasProperty("lastname", is("Gomez7")), 
								hasProperty("salary", is(25357)),
								hasProperty("department",
										hasProperty("departmentId", is(15)))
						)
		)));
		
		
	}
	
}