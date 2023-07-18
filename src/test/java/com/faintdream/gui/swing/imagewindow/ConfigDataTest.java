package com.faintdream.gui.swing.imagewindow;

import org.junit.Test;

import java.io.IOException;

public class ConfigDataTest {

    @Test
    public void readTest() throws IOException {
        ConfigData data = new ConfigData();
        System.out.println(data);
        data.setPropertiesFilePath("ImageWindowTest.properties");
        data.read();
        System.out.println(data);
    }

    @Test
    public void saveTest() throws IOException {
        ConfigData data = new ConfigData();
        System.out.println(data);
        data.setPropertiesFilePath("ImageWindowTest.properties");
        data.read();
        System.out.println(data);

        data.setPropertiesFilePath("ImageWindow_test2.properties");
        data.save();
    }
}
