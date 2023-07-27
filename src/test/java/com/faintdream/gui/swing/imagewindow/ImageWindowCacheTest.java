package com.faintdream.gui.swing.imagewindow;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ImageWindowCacheTest {
    @Test
    public void getFileSystem() {
        ImageWindowCache cache = new ImageWindowCache();
        FileSystem fileSystem = cache.getFileSystem();
        System.out.println(fileSystem);

        // System.out.println(FileSystem.valueOf("WINDOWS"));
    }

    @Ignore
    @Test
    public void cacheFileTest() throws IOException {
        ImageWindowCache cache = new ImageWindowCache();
        cache.cacheFile();
    }

    @Test
    public void createNewFileTest() throws IOException {

        ImageWindowCache cache = new ImageWindowCache();
        File file = new File("C:\\test20230728\\test2\\test3\\test4.tmp");
        switch (cache.getFileSystem()) {
            case WINDOWS:
                cache.createNewFile(file);
                Assert.assertTrue(file.exists());
                if (file.exists()) {
                    Assert.assertTrue(file.delete());
                    cache.deleteDirectory(new File("C:\\test20230728"));
                }
                break;
            case LINUX:
                break;
        }

    }
}
