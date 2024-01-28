package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.driver.SingletonDriver;
import org.junit.jupiter.api.AfterEach;


public class BaseTest {

    @AfterEach
    public void quitDriver() {
        SingletonDriver.quitDriver();
    }

}

