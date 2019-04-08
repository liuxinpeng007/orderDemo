package com.mall.order.controller;

import com.mall.order.OrderServerApplication;
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
@SpringBootTest(classes = OrderServerApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class OrderControllerTest {

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
    public void testGetOrderById() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/2")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(content().string("1wqeqweqweqweqweq"))
                .andDo(print());
    }

    @Test
    public void getOrderByUserId() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/user/1")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getOrderByUserIdAndStatus() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/user/1/1")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }


}
