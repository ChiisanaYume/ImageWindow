package com.faintdream.gui.swing.imagewindow;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ImageWindowCacheTest {
    @Test
    public void getFileSystem(){
        ImageWindowCache cache = new ImageWindowCache();
        FileSystem fileSystem = cache.getFileSystem();
        System.out.println(fileSystem);

        // System.out.println(FileSystem.valueOf("WINDOWS"));
    }

    @Test
    public void cacheFileTest() throws IOException {
        ImageWindowCache cache = new ImageWindowCache();
        cache.cacheFile();
    }

    @Test
    public void createNewFileTest() throws IOException{
        File file = new File("C:\\Program Files\\ImageWindow.properties");
        ImageWindowCache cache = new ImageWindowCache();
        cache.createNewFile(file);

        Assert.assertTrue(file.exists());

        if (file.exists()){
            Assert.assertTrue(file.delete());
        }
    }
}
