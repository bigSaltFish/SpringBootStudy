package com.frank.my_test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    // junit5版本，必须使用 @BeforeEach 注解
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testController() throws Exception {
        ResultActions resultActions = null;
        MockHttpServletRequestBuilder mockBuilder = null;

        // 1.模拟get请求
//        mockBuilder = MockMvcRequestBuilders.get("/regist?username={username}&password={password}", "张三", "123456");

        // 2.模拟post请求
        //    直接拼参数方式
//        mockBuilder = MockMvcRequestBuilders.post("/login?username={username}&password={password}&rememberMe={rememberMe}", "test", "test", true);
        mockBuilder = MockMvcRequestBuilders.post("/login");

        //    参数放入map方式
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username", "test");
        params.add("password", "test");
        params.add("rememberMe", "");
        mockBuilder.params(params);


        resultActions = mockMvc.perform(mockBuilder);
        System.err.println("response:" + resultActions.andReturn().getResponse().getContentAsString());
    }

}
