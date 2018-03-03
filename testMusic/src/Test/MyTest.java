

import com.alibaba.fastjson.JSON;
import com.dylan.music.controller.MainController;
import com.dylan.music.entity.MusicBean;
import com.dylan.music.services.GetMusicServices;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:spring-database.xml","classpath:spring-servlet.xml"}) //加载配置文件
public class MyTest {


//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
    @Autowired GetMusicServices getMusicServices;

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private MainController mainController;

//    @Autowired
//    private MockHttpSession session;// 注入模拟的http session
//
//    @Autowired
//    private MockHttpServletRequest request;// 注入模拟的http request\

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testSelect() {
        System.out.println( JSON.toJSONString(getMusicServices.getGetMusicData()));
    }

    @Test
    public void testController() throws Exception {
        MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/getMusic"))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testController1() throws Exception {
        String url ="http://localhost:8080/serach_bySongerName?serach_content=告白&need_page=1";
        MvcResult result = mockMvc.perform(post(url)).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
    Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void testController2() throws Exception {
        String url ="http://localhost:8080/serach_byArtistName?serach_content=周&need_page=1";
        MvcResult result = mockMvc.perform(post(url)).andReturn();
        logger.info(""+result.getResponse().getContentAsString());
    }

    



}