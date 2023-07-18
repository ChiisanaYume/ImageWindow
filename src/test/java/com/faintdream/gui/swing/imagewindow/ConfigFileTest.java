package com.faintdream.gui.swing.imagewindow;

import org.junit.Test;

import java.io.IOException;

public class ConfigFileTest {
    @Test
    public void loadTest() throws IOException {
        ConfigFile configFile = new ConfigFile();
        configFile.load("ImageWindow.properties");
    }
}
