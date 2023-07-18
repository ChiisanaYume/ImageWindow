package com.faintdream.tool.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class IOUtil {

    private IOUtil() {
    }

    /**
     * 获取类路径
     *
     * @return 类路径(String)
     */
    public static String getClassPath() throws Exception {
        return getPath();
    }

    /**
     * 获取类加载器
     *
     * @return 类加载器(ClassLoader)
     */

    public static ClassLoader getClassLoader() {
        return IOUtil.class.getClassLoader();
    }

    /**
     * 获取类路径下的某个文件的url
     *
     * @param filename 文件名
     * @return url
     */
    public static URL getURL(String filename) {
        URL resourceURL = getClassLoader().getResource(filename);

        // 假如url路径不存在,让它存在(创建一个文件)
        if (resourceURL == null) {
            try {
                File classPath = new File(getURL("").toURI());
                String filePath = classPath.getAbsolutePath()+File.separator + filename;
                File file = new File(filePath);
                boolean created = file.createNewFile();
                // 文件创建成功
                if(created){
                    return getURL(filePath);
                }
                throw new IOException("url路径不存在,且无法创建文件");

            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        }

        return resourceURL;
    }

    /**
     * 获取类路径下的某个文件的路径(String格式)
     *
     * @param filename 文件名
     * @return 文件路径(String格式)
     */
    public static String getPath(String filename) {
        return getURL(filename).getPath();
    }

    /**
     * 获取类路径下的某个文件的路径(String格式);
     * 通过File()封装了一层，去掉了前面的`/`
     *
     * @param filename 文件名
     * @return 文件路径(String格式)
     */
    public static String getPathF(String filename) {
        return getFile(filename).getPath();
    }

    /**
     * 获取类路径
     *
     * @return 类路径(String格式)
     */
    public static String getPath() {
        return getPath("");
    }

    /**
     * 获取类路径下的某个文件的路径(File格式)
     *
     * @param filename 文件名
     * @return 文件路径(File格式)
     */
    public static File getFile(String filename) {
        return new File(getPath(filename));
    }

    /**
     * 获取类路径下的某个文件(封装成输入流 InputStream格式)
     *
     * @param filename 文件名
     * @return 文件(输入流 InputStream格式)
     */
    public static InputStream getInputStream(String filename) throws IOException {
        return new FileInputStream(getFile(filename));
    }

}
