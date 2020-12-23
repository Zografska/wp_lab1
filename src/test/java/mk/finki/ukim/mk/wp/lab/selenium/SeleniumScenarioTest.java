package mk.finki.ukim.mk.wp.lab.selenium;


import mk.finki.ukim.mk.wp.lab.service.AuthService;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
public class SeleniumScenarioTest {


    @Autowired
    AuthService userService;

    @Autowired
    BalloonService balloonService;


    private HtmlUnitDriver driver;


    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @Test
    public void testScenario() throws Exception {
        BalloonsPage balloonsPage = BalloonsPage.to(this.driver);
        balloonsPage.assertElements(0,0,0);
        System.out.println(driver.getCurrentUrl());
        LoginPage loginPage = LoginPage.openLogin(this.driver);
        System.out.println(driver.getCurrentUrl());
        balloonsPage = LoginPage.doLogin(this.driver, loginPage, "admin", "admin");
        balloonsPage.assertElements(4, 4,  1);



    }


}
