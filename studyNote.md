### 学习笔记(与项目无关)

* properties配置文件可以使用#注释

``` properties
#Tue Jul 18 21:33:40 CST 2023
maxImageWidth=800
iconPath=/icon_kaguyahime.imageWindow
imageLoop=true
windowWidth=1200
imageDirPath=E\:\\BaiduSyncdisk\\project\\ero_image
windowHeight=1000
```

* `File.separator` 是一个 Java 中的常量，用于表示文件路径中的分隔符。
  它是一个字符串，根据操作系统的不同而有所不同：

  - 在 Windows 系统中，`File.separator` 的值为反斜杠（` \ `）。
  - 在 Unix/Linux 系统中，`File.separator` 的值为正斜杠（` / `）。
  - 使用 `File.separator` 可以确保在不同操作系统上使用正确的文件路径分隔符，以增加代码的可移植性。

* 如果您希望构建一个跨平台的文件路径，可以使用 `File.separator`，如下所示：

``` java
String filePath = "path" + File.separator + "to" + File.separator + "file.txt";
```

* 在上述示例中，无论在 Windows 还是 Unix/Linux 系统上运行，都会使用适当的分隔符连接路径中的各个部分。

  - 请注意，Java 7 引入了更简洁的 `Path` 和 `Paths`
  - 类来处理文件路径，提供了更灵活和跨平台的方式来操作文件路径。推荐在新项目中使用 `Path`
  - 类来处理文件路径，以取代直接使用 `File.separator`。