package com.faintdream.tool.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IOUtilTest {
    @Test
    public void getClassPathTest() throws Exception {
        String classPath = IOUtil.getClassPath();
        System.out.println(classPath);

    }

    @Test
    public void getPathTest() throws Exception {
        String path1 = IOUtil.getPath();
        System.out.println(path1);
        String classPath = IOUtil.getClassPath();
        System.out.println(classPath);

        Assert.assertEquals(path1,classPath);

        String path2 = IOUtil.getPath("box.png");
        System.out.println(path2);
    }

    @Test
    public void getPathFTest(){
        String path1 = IOUtil.getPathF("box.png");
        System.out.println(path1);
    }
    @Test
    public void getFileTest(){
        File file1 = IOUtil.getFile("box.png");
        System.out.println(file1);

        String path2 = IOUtil.getPath("box.png");
        File file2 = new File(path2);
        System.out.println(file2);

        Assert.assertEquals(file1,file2);


    }

    @Test
    public void getURLTest() throws IOException {
        URL url = IOUtil.getURL("box.png");
        System.out.println(url);
    }

    @Test
    public void getInputStreamTest() throws Exception {
        InputStream inputStream = IOUtil.getInputStream("box.png");
        System.out.println(inputStream);
        System.out.println(inputStream.read());
        inputStream.close();
    }

    @Test
    public void getClassLoaderTest(){
        ClassLoader classLoader = IOUtil.getClassLoader();
        System.out.println(classLoader);
    }
}
