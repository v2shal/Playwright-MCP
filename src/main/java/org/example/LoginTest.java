package org.example;
import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    public class LoginTest {
        Playwright playwright;
        Browser browser;
        Page page;
        String url = "https://www.saucedemo.com";
        String title = "Swag Labs";

        @BeforeClass
        public void setup(){
            playwright = Playwright.create();

            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            page = browser.newPage();
        }

        @Test(description = "Verify The Home Page Opens")
        public void verifyPageOpen(){
            page.navigate(url);

            assertThat(page).hasTitle(title);
        }

        @Test(description = "Verify Login Works As Expected")
        public void verifyStandardLogin() throws InterruptedException {
            page.navigate(url);

            assertThat(page).hasTitle(title);

            page.locator("[data-test=\"username\"]").fill("standard_user");
            page.locator("[data-test=\"password\"]").fill("secret_sauce");

            Thread.sleep(2000);

            page.locator("[data-test=\"login-button\"]").click();

            Thread.sleep(10000);
        }
        @AfterClass
        public void cleanup(){
            browser.close();
            playwright.close();
        }
    }

