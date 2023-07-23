package com.faintdream.gui.swing.temp;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.*;

public class ModifyJarFile {
    public static void main(String[] args) {
        String jarFilePath = "imagewindow-1.0-SNAPSHOT.jar";
        String fileNameToModify = "file_to_modify.txt";
        String modifiedContent = "This is the modified content.";
        try {
            File tempDir = new File("temp_dir");
            tempDir.mkdir();

            // Step 1: 解压JAR文件
            JarFile jarFile = new JarFile(new File(jarFilePath));
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                File entryFile = new File(tempDir, entry.getName());
                entryFile.getParentFile().mkdirs();

                if (!entry.isDirectory()) {
                    try (InputStream is = jarFile.getInputStream(entry);
                         OutputStream os = new FileOutputStream(entryFile)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            os.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
            jarFile.close();

            // Step 2: 修改文件
            File fileToModify = new File(tempDir, fileNameToModify);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToModify))) {
                writer.write(modifiedContent);
            }

            // Step 3: 重新打包JAR文件
            String modifiedJarFilePath = "path/to/your/modified.jar";
            try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(modifiedJarFilePath))) {
                File[] files = tempDir.listFiles();
                for (File file : files) {
                    String entryName = file.getName();
                    JarEntry entry = new JarEntry(entryName);
                    jarOutputStream.putNextEntry(entry);

                    if (!file.isDirectory()) {
                        try (InputStream is = new FileInputStream(file)) {
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = is.read(buffer)) != -1) {
                                jarOutputStream.write(buffer, 0, bytesRead);
                            }
                        }
                    }

                    jarOutputStream.closeEntry();
                }
            }

            System.out.println("JAR file modified successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
