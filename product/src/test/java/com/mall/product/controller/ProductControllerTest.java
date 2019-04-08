package com.mall.product.controller;

import com.mall.product.ProductServerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServerApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext context;


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void testGetProductById() throws Exception {
        RequestBuilder request = null;
        request = get("/product/query/1")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(content().string("1wqeqweqweqweqweq"))
                .andDo(print());
    }

}
