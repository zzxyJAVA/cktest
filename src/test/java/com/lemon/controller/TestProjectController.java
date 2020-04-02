package com.lemon.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSONPath;

//支持junit + mockmvc
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestProjectController {
	
	@Autowired
	private MockMvc mockMvc;
	
	//参数为json 新增project
	@Test
	public void testToList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/project/toList")
				.param("userId", "20")
							
				)
		.andDo(print())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("3"))
		.andReturn();		
	}
	
	
}
