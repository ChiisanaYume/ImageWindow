package com.faintdream.gui.swing.imagewindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        exit(0);
    }

    public void exit(Integer i) {
        System.out.println("退出程序【" + i + "】");
        System.exit(i);
    }
}
