package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.driver.MyDriver;
import org.junit.jupiter.api.AfterEach;


public class BaseTest {
    @AfterEach
    public void quitDriver() {
        MyDriver.quitDriver();
    }
}

