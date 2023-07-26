package com.faintdream.gui.swing.imagewindow;

import org.junit.Test;

public class ImageWindowCacheTest {
    @Test
    public void getFileSystem(){
        ImageWindowCache cache = new ImageWindowCache();
        FileSystem fileSystem = cache.getFileSystem();
        System.out.println(fileSystem);

        // System.out.println(FileSystem.valueOf("WINDOWS"));
    }
}
