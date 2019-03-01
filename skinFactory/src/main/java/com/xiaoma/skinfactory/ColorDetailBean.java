package com.xiaoma.skinfactory;

/**
 * Created by wzt on 2019/2/28
 */

public class ColorDetailBean {
    //颜色的中文描述
    private String desc;

    //对应在R文件中的名称
    private String nameR;

    //json中的名称
    private String nameDesign;

    //色值
    private String data;

    public ColorDetailBean(String desc, String nameR, String nameDesign, String data) {
        this.desc = desc;
        this.nameR = nameR;
        this.nameDesign = nameDesign;
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNameR() {
        return nameR;
    }

    public void setNameR(String nameR) {
        this.nameR = nameR;
    }

    public String getNameDesign() {
        return nameDesign;
    }

    public void setNameDesign(String nameDesign) {
        this.nameDesign = nameDesign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
