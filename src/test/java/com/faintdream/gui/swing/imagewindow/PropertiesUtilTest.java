package com.faintdream.gui.swing.imagewindow;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PropertiesUtilTest {
    @Test
    public void loadTest() throws IOException {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.load("ImageWindow.properties");
    }

    @Test
    public void getTest() throws IOException {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.load("ImageWindow.properties");

        String windowWidth = propertiesUtil.get("windowWidth");
        String windowHeight = propertiesUtil.get("windowHeight");
        String iconPath = propertiesUtil.get("iconPath");
        String imageLoop = propertiesUtil.get("imageLoop");


        Assert.assertEquals(windowWidth,"1200");
        Assert.assertEquals(windowHeight,"1000");
        Assert.assertEquals(iconPath,"/icon_kaguyahime.imageWindow");
        Assert.assertEquals(imageLoop,"true");

    }

    @Test
    public void setTest() throws IOException{
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.load("ImageWindow.properties");

        String key = "test20230718_set";
        String value = "Cooooooooool";

        propertiesUtil.set(key,value);
        String s = propertiesUtil.get(key);

        Assert.assertEquals(s,value);
    }

    @Test
    public void putTest() throws IOException{
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.load("ImageWindow.properties");

        String key = "test20230718_put";
        String value = "Easyyyyyyyyyyy";

        propertiesUtil.put(key,value);
        String s = propertiesUtil.get(key);

        Assert.assertEquals(s,value);
    }
}
