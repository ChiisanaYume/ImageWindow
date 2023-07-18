package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.Folder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FDFolder implements Folder{
    /**
     * 获取文件夹中的文件
     *
     * @param folder
     * @return List<File> 文件集合
     * @throws IOException
     */
    @Override
    public List<File> getListFiles(File folder) throws IOException {

        List<File> fileList = new LinkedList<>();
        File[] files = folder.listFiles(filter);
        for(int i =0;i<files.length;i++){
            fileList.add(files[i]);
        }
        return fileList;
    }


    private FilenameFilter filter = new DefImageFilter();


    public FilenameFilter getFilter() {
        return filter;
    }

    public void setFilter(FilenameFilter filter) {
        this.filter = filter;
    }
}
