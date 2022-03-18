package com.DoSwipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class WebMvcProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order(1)
	@DisplayName("Create Product")
	public void testCreateProduct() throws Exception
	{
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
										.post("/rest/prod/save")
										.contentType(MediaType.APPLICATION_JSON)
										.content("{\n"
												+ "\"proName\" : \"rice\",\n"
												+ "\"proDisc\" : \"Basmatiii Rice\",\n"
												+ "\"prodQnt\" : \"10\",\n"
												+ "\"prodCost\" : \"80\"\n"
												+ "}");
		MvcResult result = mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}
	
	@Disabled
	@Test
	@Order(2)
	@DisplayName("Get All Product")
	public void testGetAllProduct() throws Exception
	{
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
												.get("/rest/prod/all")
												.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}
	
	@Disabled
	@Test
	@Order(3)
	@DisplayName("Remove One  Product")
	public void testRemoveOneProduct() throws Exception
	{
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/rest/prod/deleted/{id}",9);
		
		MvcResult result =  mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		//assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		
		
	}
	

	@Disabled
	@Test
	@Order(4)
	@DisplayName("Remove One  Product Not Found")
	public void testRemoveOneProductNotFound() throws Exception
	{
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/rest/prod/deleted/{id}",555);
		
		MvcResult result =  mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		
		
	}
}
