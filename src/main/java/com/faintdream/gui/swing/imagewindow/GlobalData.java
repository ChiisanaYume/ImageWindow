package com.faintdream.gui.swing.imagewindow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 公用的数据,底层通过维护一个ThreadLocal实现
 *
 * @author faintdream
 * @version 1.0
 */
public class GlobalData<V> extends ThreadLocal<Map<String, V>> {
    ThreadLocal<Map<String, V>> content;

    /**
     * 获取数据
     *
     * @return Map<String, V> 第一次执行：创建一个新的map集合,之后的每次执行，都返回这个集合
     */
    public Map<String, V> getData() {
        Map<String, V> data = content.get();
        if (data == null) {
            data = new HashMap<String, V>();
            content.set(data);
        }
        return data;
    }

    public void remove() {
        // 代码
        content.remove();
    }
}
