package mk.finki.ukim.mk.wp.lab;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import mk.finki.ukim.mk.wp.lab.service.ManufacturerService;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
class EShopApplicationTests {

    MockMvc mockMvc;


//    @Autowired
//    AuthService userService;
//
//    @Autowired
//    ManufacturerService manufacturerService;
//
//    @Autowired
//    BalloonService balloonService;
//
//
//    @Autowired
//    OrderService orderService;


    private static Balloon b1;
    private static Manufacturer m1;
    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        initData();
    }

//    private void initData() {
//        if (!dataInitialized) {
//            m1 = manufacturerService.save("m1", "m1","m1");
//            manufacturerService.save("m2", "m2","m2");
//
//            b1 = balloonService.saveOrUpdate("c1", "c1", m1.getId());
//            balloonService.saveOrUpdate("c2", "c2",m1.getId());
//
//            String user = "user";
//            String admin = "admin";
//
//            userService.addUser(user, user, user, user, user, Role.ROLE_USER);
//            userService.register(admin, admin, admin, admin, admin, Role.ROLE_ADMIN);
//            dataInitialized = true;
//        }
//    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetBalloons() throws Exception {
        MockHttpServletRequestBuilder productRequest = MockMvcRequestBuilders.get("/balloons");
        this.mockMvc.perform(productRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("balloons"))
                .andExpect(MockMvcResultMatchers.model().attribute("bodyContent","listBalloons"))
                .andExpect(MockMvcResultMatchers.view().name("master-template"));
    }

}
