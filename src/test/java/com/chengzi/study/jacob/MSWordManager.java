package com.chengzi.study.jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MSWordManager {

    // word文档
    public Dispatch doc;
    // word运行程序对象
    public ActiveXComponent word;
    // 所有word文档集合
    public Dispatch documents;
    // 选定的范围或插入点
    public Dispatch selection;

    public boolean saveOnExit = true;

    public MSWordManager(boolean visible) {
        if (word == null) {
            word = new ActiveXComponent("Word.Application");
            word.setProperty("Visible", new Variant(visible));
        }
        if (documents == null) {
            documents = word.getProperty("Documents").toDispatch();
        }
        ComThread.InitSTA();
    }

    /**
     * 打开一个已存在的文档
     *
     * @param docPath
     */
    public void open(String docPath) {
        doc = Dispatch.call(documents, "Open", docPath).toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }

    public void setSaveOnExit(boolean saveOnExit) {
        this.saveOnExit = saveOnExit;
    }

    public void save(String savePath) {
        Dispatch.call((Dispatch) Dispatch.call(word, "WordBasic").getDispatch(), "FileSaveAs", savePath);
    }

    public void closeDocument() {
        if (doc != null) {
            Dispatch.call(doc, "Save");
            Dispatch.call(doc, "Close", new Variant(saveOnExit));
            doc = null;
        }
    }

    public void close() {
        closeDocument();
        if (word != null) {
            Dispatch.call(word, "Quit");
            word = null;
        }
        selection = null;
        documents = null;
        ComThread.Release();
    }

    public void moveUp(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveUp");
    }

    /**
     * 把选定的内容或者插入点向右移动
     *
     * @param pos
     *            移动的距离
     */
    public void moveRight(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveRight");
    }

    /**
     * 把选定的内容或者插入点向下移动
     *
     * @param pos
     *            移动的距离
     */
    public void moveDown(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveDown");
    }


    /**
     * 把选定的内容或者插入点向左移动
     *
     * @param pos
     *            移动的距离
     */
    public void moveLeft(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++) {
            Dispatch.call(selection, "MoveLeft");
        }
    }

    public void createCatalog() {
        Dispatch activeDocument = Dispatch.get(word, "ActiveDocument").toDispatch();

        //Dispatch.call(selection, "HomeKey", new Variant(6)); // 将光标移到文件首的位置
        //Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        //Dispatch.call(selection, "InsertBreak", new Variant(7));
        //moveUp(1);

        Dispatch.put(selection, "Text", "目录");
        Dispatch font = Dispatch.get(selection, "Font").toDispatch();
        Dispatch.put(font, "Size", 14);
        //Dispatch style = Dispatch.call(activeDocument, "Styles", new Variant(-2)).toDispatch();;
        //Dispatch.put(selection, "Style", style);
        Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
        Dispatch.put(alignment, "Alignment", "3"); // (1:置中 2:靠右 3:靠左)
        moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行

        Dispatch myRange = Dispatch.call(selection, "Range").toDispatch();

        /** 获取目录 */
        Dispatch tablesOfContents = Dispatch.get(activeDocument, "TablesOfContents").toDispatch();

        Dispatch add = Dispatch.call(tablesOfContents, "Add", myRange, new Variant(true),
                new Variant(1), new Variant(3), new Variant(true), new Variant(true), new Variant('T'),
                new Variant(true), new Variant(true), new Variant(1), new Variant(true)).toDispatch();

//        Dispatch.put(add, "RightAlignPageNumbers", new Variant(true));
//        Dispatch.put(add, "UseHeadingStyles", new Variant(true));
//        Dispatch.put(add, "UpperHeadingLevel", new Variant(1));
//        Dispatch.put(add, "LowerHeadingLevel", new Variant(3));
//        Dispatch.put(add, "IncludePageNumbers", new Variant(true));
//        Dispatch.put(add, "UseHyperlinks", new Variant(true));
//        Dispatch.put(add, "HidePageNumbersInWeb", new Variant(true));

//        Dispatch.call(add, "Add", myRange);

        //插入一个分页符
        //Dispatch.call(selection, "InsertBreak", new Variant(7));
        //Dispatch.call(selection, "TypeBackspace");
    }

    /**
     * 更新目录
     * @param outputPath
     * @param doc
     */
    public void updateCatalog(String outputPath, Dispatch doc) {
        /** 打开word文档 */
        //Dispatch doc = Dispatch.invoke(documents, "Open", Dispatch.Method,
        //        new Object[] { outputPath, new Variant(false), new Variant(true) }, new int[1]).toDispatch();
        //Dispatch doc = Dispatch.call(documents, "Open", outputPath).toDispatch();

        Dispatch activeDocument = word.getProperty("ActiveDocument").toDispatch();
        /** 获取目录 */
        Dispatch tablesOfContents = Dispatch.get(activeDocument, "TablesOfContents").toDispatch();
        /** 获取第一个目录。若有多个目录，则传递对应的参数  */
        Variant tablesOfContent = Dispatch.call(tablesOfContents, "Item", new Variant(1));
        /** 更新目录，有两个方法：Update 更新域，UpdatePageNumbers 只更新页码 */
        Dispatch toc = tablesOfContent.toDispatch();
        toc.call(toc, "Update");

        /** 另存为 */
        Dispatch.call(Dispatch.call(word, "WordBasic").getDispatch(), "FileSaveAs", outputPath);
        //System.out.println("更新目录");
        /** 关闭word文档 */
        Dispatch.call(doc, "Close", new Variant(false));

        /** 退出word进程 */
        close();
    }

    public void createPageNo() {
        Dispatch activeDocument = Dispatch.get(word, "ActiveDocument").toDispatch();
        Dispatch pageSetup = Dispatch.get(activeDocument, "pageSetup").toDispatch();
        Dispatch.put(pageSetup, "OddAndEvenPagesHeaderFooter",  new Variant(false));//设置文档的一些配置信息，页码的奇偶页设置的相同
        Dispatch.put(pageSetup, "DifferentFirstPageHeaderFooter",  new Variant(true));
        Dispatch activeWindow = Dispatch.get(word, "ActiveWindow").toDispatch();
        Dispatch activePane = Dispatch.get(activeWindow, "ActivePane").toDispatch();
        Dispatch view = Dispatch.get(activePane, "View").toDispatch();
        Dispatch.put(view, "SeekView", "10");//打开页眉
        final Dispatch Sections = Dispatch.get(doc, "Sections").toDispatch();
        final Dispatch item = Dispatch.call(Sections, "Item", new Variant(1)).toDispatch();
        final Dispatch footer = Dispatch.get(item, "Footers").toDispatch();
        final Dispatch f1 = Dispatch.call(footer, "Item", new Variant(1)).toDispatch();
        final Dispatch range = Dispatch.get(f1, "Range").toDispatch();
        final Dispatch fields = Dispatch.get(range, "Fields").toDispatch();
        Dispatch paragraphFormat = Dispatch.get(selection,"ParagraphFormat").getDispatch();
        Dispatch.put(paragraphFormat, "Alignment", 2);
        //Dispatch.call(fields, "Add", new Variant(range), new Variant(-1), new Variant(""), new Variant("True")) .toDispatch();
        Dispatch.call(fields, "Add", Dispatch.get(selection, "Range").toDispatch(), new Variant(-1), "Page", true).toDispatch();
        //Dispatch.call(selection, "TypeText", "/");
        //Dispatch.call(fields, "Add", Dispatch.get(selection, "Range").toDispatch(), new Variant(-1), "NumPages",true).toDispatch();
        //Dispatch font = Dispatch.get(range, "Font").toDispatch();
        //Dispatch.put(font,"Name",new Variant("楷体_GB2312"));
        //Dispatch.put(font, "Bold", new Variant(true));
        //Dispatch.put(font, "Size", 9);
        Dispatch.put(view, "SeekView", new Variant(0));//关闭页眉
    }

    public void runMacro() {
        Dispatch.call(word, "Run", "xml");
    }

    /**
     * 把选定内容替换为设定文本
     * @param selection Dispatch 选定内容
     * @param newText String 替换为文本
     */
    public void replace(Dispatch selection,String newText) {
        // 设置替换文本
        Dispatch.put(selection,"Text",newText);
    }

    /**
     * 替换图片
     * @param selection Dispatch 图片的插入点
     * @param imagePath String 图片文件（全路径）
     */
    public void replaceImage(Dispatch selection,String imagePath) {
        Dispatch image = Dispatch.call(
                Dispatch.get(selection, "InlineShapes").toDispatch(),// InLineShapes是一个类
                "AddPicture", imagePath).toDispatch();// addpicture是其中的一个方法
    }
    /**
     * 替换图片
     * @param selection Dispatch 图片的插入点
     * @param imagePath String 图片文件（全路径）
     * @param width 宽度
     * @param height 高度
     */
    public void replaceImage(Dispatch selection,String imagePath,float width,float height) {
        Dispatch image = Dispatch.call(
                Dispatch.get(selection, "InlineShapes").toDispatch(),// InLineShapes是一个类
                "AddPicture", imagePath).toDispatch();// addpicture是其中的一个方法
        Dispatch.put(image, "Width", new Variant(width));
        Dispatch.put(image, "Height", new Variant(height));
    }


    /**
     * 向表格添加内容
     * @param selection   Dispatch 插入点
     */
    public void replaceTable(Dispatch selection, List dataList) throws Exception {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        Dispatch table = Dispatch.call(tables, "Item", new Variant(1)).toDispatch();
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        int rowsCount = Dispatch.get(rows, "Count").getInt();
        Dispatch Columns = Dispatch.get(table, "Columns").toDispatch();
        int Columnscount = Dispatch.get(Columns, "Count").getInt();
        for (int i = 1; i < rowsCount + 1; i++) {
            for (int j = 2; j < Columnscount + 1; j++) {
                Dispatch cell = Dispatch.call(table, "Cell", i + "", j + "").toDispatch();
                Dispatch innerTables = Dispatch.get(cell, "Tables").toDispatch();
                int innerTablesCount = Dispatch.get(innerTables, "Count").getInt();
                for(int k=0;k<innerTablesCount;k++){
                    Dispatch innerTable = Dispatch.call(innerTables, "Item", new Variant(k+1)).toDispatch();
                    Dispatch innerRows = Dispatch.get(innerTable, "Rows").toDispatch();
                    int innerRowsCount = Dispatch.get(innerRows, "Count").getInt();
                    Dispatch innerColumns = Dispatch.get(innerTable, "Columns").toDispatch();
                    int innerColumnscount = Dispatch.get(innerColumns, "Count").getInt();
                    if(innerColumnscount == 2 && innerRowsCount == 2){
                        for (int m = 0; m < dataList.size(); m++) {
                            // 某一行数据
                            String[] datas = (String[]) dataList.get(m);
                            // 在表格中添加一行
                            if (innerRowsCount < m+2)
                                Dispatch.call(innerRows, "Add");
                            // 填充该行的相关列
                            for (int n = 0; n < datas.length; n++) {
                                // 得到单元格
                                Dispatch innerCell = Dispatch.call(innerTable, "Cell",(m+2) + "", (n+1) + "").toDispatch();
                                // 选中单元格
                                Dispatch.call(innerCell, "Select");
                                // 设置格式
                                Dispatch font = Dispatch.get(selection, "Font").toDispatch();
                                Dispatch.put(font, "Bold", "0");
                                Dispatch.put(font, "Italic", "0");
                                // 输入数据
                                Dispatch.put(selection, "Text", datas[n]);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 从选定内容或插入点开始查找文本
     * @param selection Dispatch 选定内容
     * @param toFindText String 要查找的文本
     * @return boolean true-查找到并选中该文本，false-未查找到文本
     */
    public boolean find(Dispatch selection,String toFindText) {
        // 从selection所在位置开始查询
        Dispatch find = word.call(selection,"Find").toDispatch();
        // 设置要查找的内容
        Dispatch.put(find,"Text",toFindText);
        // 向前查找
        Dispatch.put(find,"Forward","True");
        // 设置格式
        Dispatch.put(find,"Format","True");
        // 大小写匹配
        Dispatch.put(find,"MatchCase","True");
        // 全字匹配
        Dispatch.put(find,"MatchWholeWord","True");
        // 查找并选中
        return Dispatch.call(find,"Execute").getBoolean();
    }

    /**
     * 把插入点移动到文件首位置
     * @param selection Dispatch 插入点
     */
    public void moveStart(Dispatch selection) {
        Dispatch.call(selection,"HomeKey",new Variant(6));
    }

    /**
     * 把插入点移动到文件末尾位置 # todo 需要开发
     * @param selection Dispatch 插入点
     *
     */
    public void moveEnd(Dispatch selection) {
        Dispatch.call(selection,"",new Variant(6));
    }

    /**
     * 全局替换
     * @param selection Dispatch 选定内容或起始插入点
     * @param oldText String 要替换的文本
     */
    public void replaceAll(Dispatch selection,String oldText,Object replaceObj) throws Exception{
        // 移动到文件开头
        moveStart(selection);
        if(oldText.startsWith("table") || replaceObj instanceof ArrayList){
            replaceTable(selection,(ArrayList)replaceObj);
        }else{
            String newText = (String) replaceObj;
            if(newText==null)
                newText="";
            //if(oldText.indexOf("image") != -1&!newText.trim().equals("") || newText.lastIndexOf(".bmp") != -1 || newText.lastIndexOf(".jpg") != -1 || newText.lastIndexOf(".gif") != -1){
            if(oldText.indexOf("image")!= -1){
                while(find(selection,oldText)) {
                    if(oldText.indexOf("image1")>0){
                        replaceImage(selection,newText,500,370);
                    }else{
                        replaceImage(selection,newText);
                    }

                    Dispatch.call(selection,"MoveRight");
                }
            }else{
                while(find(selection,oldText)) {
                    replace(selection,newText);
                    Dispatch.call(selection,"MoveRight");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String dir = "C:\\Users\\Administrator\\Desktop\\school";
        File file = new File(dir);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String fileName = fileList[i].getName();
                String filePath = dir + "\\" + fileName;
                try {
                    MSWordManager t = new MSWordManager(true);
                    t.open(filePath);
                    t.replaceAll(t.selection, "✖️", "*");
//                    if (fileName.contains("RE_1000000001")) {
//                        t.moveDown(21);//数学
//                    } else if (fileName.contains("RE_1000000002")) {
//                        t.moveDown(26);//语文
//                    } else {
//                        t.moveDown(27);//英语
//                    }
//                    //t.moveDown(27);//英语
//                    //t.moveDown(26);//语文
//                    //t.moveDown(21);//数学
//                    t.createCatalog();
//                    t.createPageNo();
                    t.close();
                } catch (Throwable a) {
                    System.out.println(fileName);
                }
            }
        }

//        MSWordManager t = new MSWordManager(true);
//        t.open("C:\\Users\\Administrator\\Desktop\\RE_1000000001school74789.docx");
//        t.moveDown(27);//英语
//        t.moveDown(26);//语文
//        t.moveDown(21);//数学
//        t.createCatalog();
//        t.createPageNo();
//        t.replaceAll(t.selection, "✖️", "*");
        //t.close();
    }

}
