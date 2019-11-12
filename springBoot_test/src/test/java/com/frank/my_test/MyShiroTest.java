package com.frank.my_test;

import com.frank.util.MD5Utils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.subject.WebSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;


/**
 * shiro情况下，和springBootTest结合，需要额外处理。需要绑定SecurityManger
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyShiroTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @Resource
    private DefaultWebSecurityManager securityManager;


    // junit5版本，必须使用 @BeforeEach 注解
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        // 1.需要手动绑定SM
        ThreadContext.bind(securityManager);
//        SecurityUtils.setSecurityManager(securityManager);

        // 2.绑subject
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest(wac.getServletContext());
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Subject subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse)
                .buildWebSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("test", MD5Utils.encrypt("test", "test"), true);
        subject.login(token);
        ThreadContext.bind(subject);
    }

    @Test
    public void testController() throws Exception {
        ResultActions resultActions = null;
        MockHttpServletRequestBuilder mockBuilder = null;


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
