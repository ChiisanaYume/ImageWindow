package com.faintdream.gui.swing.imagewindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class GlobalDataTest {
    @Test
    public void getDataTest(){
        GlobalData gd = new GlobalData();

        Map<String, Object> data1 = gd.getData();
        Map<String, Object> data2 = gd.getData();
        // 相同的对象
        Assert.assertEquals(data1,data2);
    }

    @Test
    public void setTest(){
        GlobalData gd = new GlobalData();
        gd.set("Amber","アンバー，好きです！");
        gd.set("KLee","KLeeeeeeeeeeeeeeee");

        Map<String, Object> data = gd.getData();

        data.put("Nahida","嘿嘿嘿嘿嘿嘿嘿嘿~");
        Set<String> keys = data.keySet();
        for(String key:keys){
            System.out.println(key + ":" + data.get(key));
        }
    }
}
