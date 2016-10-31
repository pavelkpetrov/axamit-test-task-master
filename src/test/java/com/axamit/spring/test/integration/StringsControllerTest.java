package com.axamit.spring.test.integration;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by Pavel on 31.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appServlet/servlet-context.xml")
@WebAppConfiguration
public class StringsControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private String validJson;

    @Before
    public void init() throws IOException {
        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        validJson = IOUtils.toString(this.getClass().getResourceAsStream("SorterTest.json"));
    }

    @Test
    public void test_string_sort_valid() throws Exception {
        RequestBuilder rb = post("/strings/sort").header("Content-type", "application/json").content(validJson);
        this.mockMvc.perform(rb)
            .andExpect(status().isOk())
            .andExpect(content().encoding("UTF-8"))
            .andExpect(jsonPath("$", hasSize(7)))
            .andExpect(jsonPath("$[0].string").exists())
            .andExpect(jsonPath("$[0].string").value("Aliens are watching up in the sky"))
            .andExpect(jsonPath("$[0].longestWord").exists())
            .andExpect(jsonPath("$[0].longestWord").value(8));
    }

}
