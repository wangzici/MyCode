package com.xiaoma.skinfactory;

import com.google.gson.Gson;
/*import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;*/

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User:Created by Terence
 * IDE: IDEA
 * Date:2018/9/06
 * Desc：皮肤内容转换定制
 */
public class SkinAdapt {
    //切图资源文件放置目录
    private static final String RES_PATH = "D:\\skin\\skinResource\\";
    //皮肤包编译项目地址
    private static final String PROJECT_PATH = "D:\\myCode\\MyCode\\skinModule\\src\\main\\res\\";
    //编译输出目录
    private static final String BUILD_PATH = "D:\\myCode\\MyCode\\skinModule\\build\\outputs\\apk\\debug";
    //皮肤包放置位置
    private static final String SKIN_PATH = "D:\\Skin\\allSkins";

    private static final int DEFAULT_LAUNCHER_STYLE_ID = 0;
    private static final int LAUNCHER_STYLE_ID_1 = 1;
    private static final int LAUNCHER_STYLE_ID_2 = 2;
    private static final int LAUNCHER_STYLE_ID_3 = 3;

    private String skinName;
    //检测状态次数
    private Process process;

    public static void main(String[] args){
        SkinAdapt skinAdapt = new SkinAdapt();
        skinAdapt.getSkinName();
        boolean renameResult = skinAdapt.changeAllIconName();
        //如果命名出错的话也停止操作
        if (!renameResult) {
            return;
        }
        //第一步如果文件拷贝异常就停止
        if (!skinAdapt.copyIconToAsProject()) {
            System.out.println("----皮肤制作进程结束，请检查是否切图命名或是配置异常！！！");
            return;
        }
        boolean colorResult = skinAdapt.changeColor();
        if (!colorResult) {
            return;
        }
        skinAdapt.buildApk();
    }

    /**
     * 遍历每个桌面样式文件夹
     */
    private boolean changeAllIconName() {
        return changeIconName(DEFAULT_LAUNCHER_STYLE_ID) && changeIconName(LAUNCHER_STYLE_ID_1)
                && changeIconName(LAUNCHER_STYLE_ID_2) && changeIconName(LAUNCHER_STYLE_ID_3);
    }

    /**
     * 修改切图名字
     */
    private boolean changeIconName(int styleId){
        String dirName = "默认样式";
        String suffix = "";
        switch (styleId) {
            case LAUNCHER_STYLE_ID_1:
                suffix = "_s1";
                dirName = "桌面样式1";
                break;
            case LAUNCHER_STYLE_ID_2:
                suffix = "_s2";
                dirName = "桌面样式2";
                break;
            case LAUNCHER_STYLE_ID_3:
                suffix = "_s3";
                dirName = "桌面样式3";
                break;
            case DEFAULT_LAUNCHER_STYLE_ID:
            default:
                break;
        }
        System.out.println("----开始进行《" + skinName + "》皮肤包制作");
        System.out.println("---开始查找并转换 " + dirName + " 图片名称----");
        Map<String, String> nameMap = new NameMap().getNameMap();
        File[] fileList = new File(RES_PATH + "Icons\\" + dirName).listFiles();


        if (fileList == null || fileList.length == 0){
            System.out.println("该文件夹下没有任何内容，请检查是否将文件导入了");
            return false;
        }

        for (File file : fileList) {
            if (file.getName().endsWith(".png")||file.getName().endsWith(".jpg")) {
                String name = file.getName().replaceAll(".png","").replaceAll(".jpg","");
                if (nameMap.containsKey(name)){
                    String newName = file.getAbsolutePath().replaceAll(name, nameMap.get(name) + suffix).replaceAll(".jpg", ".png");
                    File newFile = new File(newName);
                    if (file.renameTo(newFile)) {
                        System.out.println(name + "   ---重命名成功");
                    } else {
                        System.out.println(name + "   ---重命名失败");
                        return false;
                    }
                }
            }
        }
        System.out.println("---图片转换结束----");
        return true;
    }


    /**
     * 文件拷贝操作
     */
    private boolean copyIconToAsProject() {
        System.out.println("---开始拷贝文件----");
        File[] fileDirList = new File(RES_PATH + "Icons").listFiles();
        if (fileDirList == null){
            return false;
        }
        for (File fileDir : fileDirList) {
            File[] fileList = fileDir.listFiles();
            if (fileList == null){
                return false;
            }
            for (File file : fileList) {
                //拷贝文件
                File copyFile = new File(PROJECT_PATH + "drawable-mdpi");
                try {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(copyFile,file.getName()));
                    byte[] b = new byte[1024];
                    int len;
                    while((len  = fis.read(b)) !=-1){
                        fos.write(b, 0, len);
                    }

                    fos.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(file.getName() + " ----文件copy异常");
                    return false;
                }
            }
        }
        System.out.println("---文件拷贝结束----");
        return true;
    }


    /**
     * 获取新主题颜色设置文件
     */
    private ColorBean getNewColor(){
        ColorBean colorBean = new ColorBean();
        try {
            String colorJson = "";
            StringBuilder result = new StringBuilder();
            File file = new File(RES_PATH + "ColorJson.txt");
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                result.append(line);
                line = br.readLine();
            }

            colorJson = result.toString();
            if (colorJson.isEmpty()) {
                return colorBean;
            }

            Gson gson = new Gson();
            colorBean = gson.fromJson(colorJson, ColorBean.class);
            if (colorBean != null) {
                System.out.println(colorBean.toString());
                colorBean.isLeakColorValue();
                colorBean.isFormatError();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colorBean;
    }


    /**
     * 转换颜色文案
     */
    private boolean changeColor() {
        System.out.println("------开始进行颜色文件修改------");
        File file = new File(PROJECT_PATH + "values\\colors.xml");
        if (!file.exists()){
            System.out.println("文件不存在，请检查文件类型");
            return false;
        }
        ColorBean newColor = getNewColor();
        if (newColor ==  null) {
            System.out.println("色值设置文件异常，请检查文件格式");
            return false;
        }
        // 创建SAXReader的对象reader
        /*SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element colorStore = document.getRootElement();
            Iterator it = colorStore.elementIterator();
            System.out.println("=====开始遍历color文件=====");
            while (it.hasNext()) {
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                    System.out.println("内容是" + book.getText());
                    //修改字体颜色
                    setElementColor(book,attr.getValue(),newColor);
                }
            }

            //指定文件输出的位置
            FileOutputStream out =new FileOutputStream(PROJECT_PATH + "values\\colors.xml");
            // 指定文本的写出的格式：
            OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
            format.setEncoding("UTF-8");
            //1.创建写出对象
            XMLWriter writer=new XMLWriter(out,format);
            //2.写出Document对象
            writer.write(document);
            //3.关闭流
            writer.close();

            System.out.println("=====结束遍历color文件=====");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("xml文件操作异常，请检查文件格式之类是否异常");
            return false;
        }*/
        System.out.println("------进行颜色文件修改结束------");
        return true;
    }


/*    private void setElementColor(Element element, String name, ColorBean color) {
        if (element == null || name == null || name.isEmpty() || color == null) {
            return;
        }

        for (ColorDetailBean colorDetailBean : color.getColorDetailList()) {
            if (name.equals(colorDetailBean.getNameR())) {
                element.setText(colorDetailBean.getData());
                break;
            }
        }
    }*/


    private void buildApk(){
        System.out.println("------开始编译--------");
        //先清理编译目录下的文件
        cleanFilePath(BUILD_PATH);
        //开始执行编译脚本
        executeGradleCmd();
        //检查是否编译成功
        checkBuildState();
    }


    private void cleanFilePath(String path){
        try {
            File[] fileList = new File(path).listFiles();
            if (fileList != null){
                for (File file : fileList) {
                    if (file.isDirectory()){
                        cleanFilePath(file.getPath());
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void executeGradleCmd(){
        executeCmd("d: & cd D:\\myCode\\MyCode & gradlew :skinModule:assembleDebug");
    }


    private void executeCmd(String cmd){
        try {
            System.out.println("Execute command : " + cmd);
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec("cmd /c " + cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("指令执行异常");
        }
    }


    private void checkBuildState(){
        System.out.println("----开始检测编译是否完成----");
        File file = new File(BUILD_PATH + "\\app-debug.apk");
        if (file.exists()) {
            System.out.println("编译完成");
            if (process != null && process.isAlive()) {
                process.destroy();
            }
            copySkin();
        } else {
            System.out.println("没有检测到，编译出错了~~~");
        }
    }


    /**
     * 重命名并拷贝
     */
    private void copySkin() {
        System.out.println("----开始导出皮肤包----");
        File file = new File(BUILD_PATH + "\\app-debug.apk");
        //拷贝文件
        File copyFile = new File(SKIN_PATH);
        if (!copyFile.exists()){
            copyFile.mkdir();
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(new File(copyFile,skinName + ".skin"));
            byte[] b = new byte[1024];
            int len;
            while((len  = fis.read(b)) !=-1){
                fos.write(b, 0, len);
            }

            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(file.getName() + " ----文件copy异常");
        }
        System.out.println("----皮肤包导出结束----");
        clearIcon();
    }


    private void clearIcon() {
        File[] fileList = new File(RES_PATH + "Icons").listFiles();
        if (fileList == null){
            return;
        }
        for (File file : fileList) {
            //拷贝文件
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(file.getName() + " ----文件delete异常");
            }
        }
    }


    /**
     * 获取编译后需要打包出来的skin包的名字
     */
    private void getSkinName() {
        try {
            StringBuilder result = new StringBuilder();
            File file = new File(RES_PATH + "skinName.txt");
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                result.append(line);
                line = br.readLine();
            }

            skinName = result.toString().trim();
            if (skinName.isEmpty()){
                skinName = "小马主题皮肤";
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
