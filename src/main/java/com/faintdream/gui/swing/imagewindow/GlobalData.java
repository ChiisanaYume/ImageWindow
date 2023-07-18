package com.faintdream.gui.swing.imagewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 公用的数据,底层通过维护一个ThreadLocal实现
 *
 * @author faintdream
 * @version 1.0
 */
public class GlobalData {
    static final ThreadLocal<Map<String, Object>> content = new ThreadLocal<>();

    /**
     * 获取数据(取数据)
     *
     * @return Map<String, V> 第一次执行：创建一个新的map集合,之后的每次执行,都返回这个集合
     */
    public Map<String, Object> getData() {
        Map<String, Object> data = content.get();
        if (data == null) {
            data = new HashMap<>();
            content.set(data);
        }
        return data;
    }

    public void remove() {
        // 代码
        content.remove();
    }

    /**
     * 存数据
     *
     * @param key   数据键
     * @param value 数据值
     */
    public void set(String key, Object value) {
        put(key, value);
    }



    /**
     * 存数据(别名)
     */
    public void put(String key, Object value) {
        getData().put(key, value);
    }

    /**
     * 取数据(别名)
     * */
    public Map<String, Object> get(){
        return getData();
    }
}
