package com.example.demo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.MysqlController;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlSpringBootApplicationTests {

	MockMvc mockMvc;

	@InjectMocks
	MysqlController controller;

	@Mock
	UserService service;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(MysqlController.class).build();
	}

	@Test
	public void welcomeTest() {
		when(service.welcome()).thenReturn("welcome");
		verify(service).welcome();
	}

	@Test
	public void contextLoads() {

		System.out.println("Test ");
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
