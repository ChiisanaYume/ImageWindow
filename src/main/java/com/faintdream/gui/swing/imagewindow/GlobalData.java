package com.faintdream.gui.swing.imagewindow;

import java.util.Map;

/**
 * 公用的数据,底层通过维护一个ThreadLocal实现
 * @version 1.0
 * @author faintdream
 * */
public class GlobalData<V> extends ThreadLocal<Map<String,V>>{

}
