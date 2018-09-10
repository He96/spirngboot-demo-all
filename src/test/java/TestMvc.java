import com.alibaba.fastjson.JSON;
import com.config.LoginContext;
import com.config.MvcConfig;
import com.entity.User;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestMvc {
    private MockMvc mockMvc;//模拟MVC对象
    @Autowired
    LoginContext loginContext;
    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession mockHttpSession;
    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test1() throws Exception{

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/index.html"))
                .andExpect(model().attribute("userInfo",loginContext.getInfo()));
    }
    @Test
    public void test2() throws Exception{
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(JSON.toJSONString(loginContext.getInfo())));
    }

}
