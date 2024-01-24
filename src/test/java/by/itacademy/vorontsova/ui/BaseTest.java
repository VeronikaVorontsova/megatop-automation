package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.MyDriver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void quit() {
        MyDriver.getDriver().quit();
    }
}
