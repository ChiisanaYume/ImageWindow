### 项目异常相关
* 堆空间不足???
```
Error occurred during initialization of VM
Could not reserve enough space for 786432KB object heap

可能的解决方案:
- 检查您的 Maven 导入虚拟机选项。打开 Maven 导入设置。
```
* 非常经典的空指针异常，java IO无法直接读取jar包中数据，要封装成流
```
Exception in thread "main" java.lang.NullPointerException
at java.util.Objects.requireNonNull(Objects.java:203)
        at com.faintdream.gui.swing.ImageWindow.getListFiles(ImageWindow.java:109)
        at com.faintdream.gui.swing.ImageWindow.<init>(ImageWindow.java:51)
        at com.faintdream.gui.swing.ImageWindow.main(ImageWindow.java:358)
```