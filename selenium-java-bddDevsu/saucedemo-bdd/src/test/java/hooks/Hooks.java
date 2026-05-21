package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.DriverManager;

public class Hooks {
    private static final DriverManager driverManager = new DriverManager();

    @BeforeAll
    public static void beforeAll() {

    }

    @AfterAll
    public static void afterAll() {

    }

    @Before
    public static void before(Scenario scenario) {
        driverManager.buildDriver();
    }

    @After
    public static void after(Scenario scenario) {
        driverManager.quitDriver();
    }
}