package com.xiaoma.skinfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * 2018/9/11.
 */
public class ColorBean {
    private String clockTime;
    private String clockDate;
    private String clockWeek;
    private String weatherTitle;
    private String weatherContent;
    private String weatherTemp;
	private String weatherDesc;
    private String weatherCity;
    private String musicName;
    private String musicSinger;
    private String naviHudDistance;
    private String naviHudRoad;
    private String naviHudLocation;
    private String naviHudTimeRemain;
    private String naviHudDistanceRemain;
    private String radioTitle;
    private String radioClassify;
    private String radioName;
    private String radioSkip;
    private String loginHint;

    private String clockTimeS1;
    private String clockDateS1;
    private String clockWeekS1;
    private String weatherTempS1;
    private String weatherCityS1;
    private String naviHudDistanceS1;
    private String naviHudRoadS1;
    private String naviHudLocationS1;
    private String naviHudTimeRemainS1;
    private String naviHudDistanceRemainS1;
    private String radioTitleS1;
    private String radioClassifyS1;
    private String radioNameS1;
    private String radioSkipS1;

    private String clockTimeS2;
    private String clockDateS2;
    private String clockWeekS2;
    private String weatherTempS2;
    private String weatherDescS2;
    private String weatherCityS2;
    private String naviHudDistanceS2;
    private String naviHudRoadS2;
    private String naviHudLocationS2;
    private String naviHudTimeRemainS2;
    private String naviHudDistanceRemainS2;
    private String radioTitleS2;
    private String radioClassifyS2;
    private String radioNameS2;
    private String radioSkipS2;

    private String clockTimeS3;
    private String clockDateS3;
    private String clockWeekS3;
    private String weatherTempS3;
    private String weatherDescS3;
    private String weatherCityS3;
    private String musicNameS3;
    private String musicSingerS3;
    private String naviHudDistanceS3;
    private String naviHudRoadS3;
    private String naviHudLocationS3;
    private String naviHudTimeRemainS3;
    private String naviHudDistanceRemainS3;
    private String radioTitleS3;
    private String radioClassifyS3;
    private String radioNameS3;

    private String naviBarText;
    private String searchBarColor;

    private List<ColorDetailBean> mColorDetailBeans = new ArrayList<>();


    public void isLeakColorValue() {
        boolean isAllCollect = true;
        for (ColorDetailBean colorDetailBean : getColorDetailList()) {
            if (isStringEmpty(colorDetailBean.getData())) {
                System.out.println(colorDetailBean.getDesc() + "颜色缺失");
                isAllCollect = false;
            }
        }
        if (isAllCollect) {
            System.out.println("完整的色值适配表格");
        }
    }


    public void isFormatError(){
        String[] values = new String[]{
        clockTime, clockDate, clockWeek, weatherTitle, weatherContent, weatherTemp, weatherDesc, weatherCity, musicName, musicSinger,naviHudDistance,naviHudRoad,naviHudLocation,naviHudTimeRemain,naviHudDistanceRemain,radioTitle,radioClassify,radioName,radioSkip,loginHint,
                clockTimeS1,clockDateS1,clockWeekS1,weatherTempS1,weatherCityS1,naviHudDistanceS1,naviHudRoadS1,naviHudLocationS1,naviHudTimeRemainS1,naviHudDistanceRemainS1,radioTitleS1,radioClassifyS1,radioNameS1,radioSkipS1,
                clockTimeS2,clockDateS2,clockWeekS2,weatherTempS2,weatherDescS2,weatherCityS2,naviHudDistanceS2,naviHudRoadS2,naviHudLocationS2,naviHudTimeRemainS2,naviHudDistanceRemainS2,radioTitleS2,radioClassifyS2,radioNameS2,radioSkipS2,
                clockTimeS3,clockDateS3,clockWeekS3,weatherTempS3,weatherDescS3,weatherCityS3,musicNameS3,musicSingerS3,naviHudDistanceS3,naviHudRoadS3,naviHudLocationS3,naviHudTimeRemainS3,naviHudDistanceRemainS3,radioTitleS3,radioClassifyS3,radioNameS3,
                naviBarText,searchBarColor};
        for (String color : values) {
            if (!isBeingTypeCode(color)) {
                System.out.println("色值文件格式出错，请检查ColorJson文件");
            }
        }
    }

    private boolean isBeingTypeCode (String color){
        return !isStringEmpty(color) && color.startsWith("#") && color.length() <= 9;
    }


    private boolean isStringEmpty(String str){
        return str == null || str.isEmpty();

    }

    public List<ColorDetailBean> getColorDetailList() {
        if(mColorDetailBeans.size() == 0) {
            mColorDetailBeans.add(new ColorDetailBean("时钟时间", "time_clock", "clockTime", clockTime));
            mColorDetailBeans.add(new ColorDetailBean("时钟日期", "time_date", "clockDate", clockDate));
            mColorDetailBeans.add(new ColorDetailBean("时钟星期", "time_week", "clockWeek", clockWeek));
            mColorDetailBeans.add(new ColorDetailBean("天气介绍标题", "weather_desc_title_color", "weatherTitle", weatherTitle));
            mColorDetailBeans.add(new ColorDetailBean("天气介绍内容", "weather_desc_content_color", "weatherContent", weatherContent));
            mColorDetailBeans.add(new ColorDetailBean("天气温度", "weather_temp_color", "weatherTemp", weatherTemp));
            mColorDetailBeans.add(new ColorDetailBean("天气描述", "weather_desc_color", "weatherDesc", weatherDesc));
            mColorDetailBeans.add(new ColorDetailBean("天气城市名称", "weather_city_color_new", "weatherCity", weatherCity));
            mColorDetailBeans.add(new ColorDetailBean("歌曲名称", "music_info_name_color", "musicName", musicName));
            mColorDetailBeans.add(new ColorDetailBean("歌手名称", "music_info_singer_color", "musicSinger", musicSinger));
            mColorDetailBeans.add(new ColorDetailBean("导航HUD引导距离", "navi_hud_distance", "naviHudDistance", naviHudDistance));
            mColorDetailBeans.add(new ColorDetailBean("导航HUD引导描述", "navi_hud_road", "naviHudRoad", naviHudRoad));
            mColorDetailBeans.add(new ColorDetailBean("导航HUD定位地址", "navi_hud_locaion", "naviHudLocation", naviHudLocation));
            mColorDetailBeans.add(new ColorDetailBean("导航HUD剩余距离标题", "navi_hud_time_remain", "naviHudTimeRemain", naviHudTimeRemain));
            mColorDetailBeans.add(new ColorDetailBean("导航HUD剩余距离内容", "navi_hud_distance_remain", "naviHudDistanceRemain", naviHudDistanceRemain));
            mColorDetailBeans.add(new ColorDetailBean("每日必听文字标题", "launcher_color_radio_title", "naviHudDistanceRemain", radioTitle));
            mColorDetailBeans.add(new ColorDetailBean("每日必听分类", "launcher_color_radio_classify", "naviHudDistanceRemain", radioClassify));
            mColorDetailBeans.add(new ColorDetailBean("每日必听电台名称", "launcher_color_radio_name", "naviHudDistanceRemain", radioName));
            mColorDetailBeans.add(new ColorDetailBean("每日必听文字跳过", "launcher_color_radio_skip", "naviHudDistanceRemain", radioSkip));
            mColorDetailBeans.add(new ColorDetailBean("登陆提示", "music_info_singer_color", "naviHudDistanceRemain", loginHint));

            mColorDetailBeans.add(new ColorDetailBean("样式1时钟时间", "time_clock_s1", "clockTimeS1", clockTimeS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1时钟日期", "time_date_s1", "clockDateS1", clockDateS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1时钟星期", "time_week_s1", "clockWeekS1", clockWeekS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1天气温度", "weather_temp_color_s1", "weatherTempS1", weatherTempS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1天气城市名称", "weather_city_color_new_s1", "weatherCityS1", weatherCityS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1导航HUD引导距离", "navi_hud_distance_s1", "naviHudDistanceS1", naviHudDistanceS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1导航HUD引导描述", "navi_hud_road_s1", "naviHudRoadS1", naviHudRoadS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1导航HUD定位地址", "navi_hud_locaion_s1", "naviHudLocationS1", naviHudLocationS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1导航HUD剩余距离标题", "navi_hud_time_remain_s1", "naviHudTimeRemainS1", naviHudTimeRemainS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1导航HUD剩余距离内容", "navi_hud_distance_remain_s1", "naviHudDistanceRemainS1", naviHudDistanceRemainS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1每日必听文字标题", "launcher_color_radio_title_s1", "radioTitleS1", radioTitleS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1每日必听分类", "launcher_color_radio_classify_s1", "radioClassifyS1", radioClassifyS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1每日必听电台名称", "launcher_color_radio_name_s1", "radioNameS1", radioNameS1));
            mColorDetailBeans.add(new ColorDetailBean("样式1每日必听文字跳过", "launcher_color_radio_skip_s1", "radioSkipS1", radioSkipS1));

            mColorDetailBeans.add(new ColorDetailBean("样式2时钟时间", "time_clock_s2", "clockTimeS2", clockTimeS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2时钟日期", "time_date_s2", "clockDateS2", clockDateS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2时钟星期", "time_week_s2", "clockWeekS2", clockWeekS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2天气温度", "weather_temp_color_s2", "weatherTempS2", weatherTempS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2天气描述", "weather_desc_color_s2", "weatherDescS2", weatherDescS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2天气城市名称", "weather_city_color_new_s2", "weatherCityS2", weatherCityS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2导航HUD引导距离", "navi_hud_distance_s2", "naviHudDistanceS2", naviHudDistanceS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2导航HUD引导描述", "navi_hud_road_s2", "naviHudRoadS2", naviHudRoadS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2导航HUD定位地址", "navi_hud_locaion_s2", "naviHudLocationS2", naviHudLocationS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2导航HUD剩余距离标题", "navi_hud_time_remain_s2", "naviHudTimeRemainS2", naviHudTimeRemainS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2导航HUD剩余距离内容", "navi_hud_distance_remain_s2", "naviHudDistanceRemainS2", naviHudDistanceRemainS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2每日必听文字标题", "launcher_color_radio_title_s2", "radioTitleS2", radioTitleS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2每日必听分类", "launcher_color_radio_classify_s2", "radioClassifyS2", radioClassifyS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2每日必听电台名称", "launcher_color_radio_name_s2", "radioNameS2", radioNameS2));
            mColorDetailBeans.add(new ColorDetailBean("样式2每日必听文字跳过", "launcher_color_radio_skip_s2", "radioSkipS2", radioSkipS2));

            mColorDetailBeans.add(new ColorDetailBean("样式3时钟时间", "time_clock_s3", "clockTimeS3", clockTimeS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3时钟日期", "time_date_s3", "clockDateS3", clockDateS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3时钟星期", "time_week_s3", "clockWeekS3", clockWeekS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3天气温度", "weather_temp_color_s3", "weatherTempS3", weatherTempS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3天气描述", "weather_desc_color_s3", "weatherDescS3", weatherDescS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3天气城市名称", "weather_city_color_new_s3", "weatherCityS3", weatherCityS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3歌曲名称", "music_info_name_color_s3", "musicNameS3", musicNameS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3歌手名称", "music_info_singer_color_s3", "musicSingerS3", musicSingerS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3导航HUD引导距离", "navi_hud_distance_s3", "naviHudDistanceS3", naviHudDistanceS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3导航HUD引导描述", "navi_hud_road_s3", "naviHudRoadS3", naviHudRoadS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3导航HUD定位地址", "navi_hud_locaion_s3", "naviHudLocationS3", naviHudLocationS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3导航HUD剩余距离标题", "navi_hud_time_remain_s3", "naviHudTimeRemainS3", naviHudTimeRemainS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3导航HUD剩余距离内容", "navi_hud_distance_remain_s3", "naviHudDistanceRemainS3", naviHudDistanceRemainS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3每日必听文字标题", "launcher_color_radio_title_s3", "radioTitleS3", radioTitleS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3每日必听分类", "launcher_color_radio_classify_s3", "radioClassifyS3", radioClassifyS3));
            mColorDetailBeans.add(new ColorDetailBean("样式3每日必听电台名称", "launcher_color_radio_name_s3", "radioNameS3", radioNameS3));

            mColorDetailBeans.add(new ColorDetailBean("桌面底部tab文字", "launcher_bottom_text_color", "naviBarText", naviBarText));
            mColorDetailBeans.add(new ColorDetailBean("搜索框颜色缺失", "edit_search_hint_color", "searchBarColor", searchBarColor));
        }
        return mColorDetailBeans;
    }


    @Override
    public String toString() {
        return "ColorBean{" +
                "clockTime='" + clockTime + '\'' +
                ", clockDate='" + clockDate + '\'' +
                ", clockWeek='" + clockWeek + '\'' +
                ", weatherTitle='" + weatherTitle + '\'' +
                ", weatherContent='" + weatherContent + '\'' +
                ", weatherTemp='" + weatherTemp + '\'' +
                ", weatherCity='" + weatherCity + '\'' +
                ", musicName='" + musicName + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                ", naviHudDistance='" + naviHudDistance + '\'' +
                ", naviHudRoad='" + naviHudRoad + '\'' +
                ", naviHudLocation='" + naviHudLocation + '\'' +
                ", naviHudTimeRemain='" + naviHudTimeRemain + '\'' +
                ", naviHudDistanceRemain='" + naviHudDistanceRemain + '\'' +
                ", naviBarText='" + naviBarText + '\'' +
                ", searchBarColor='" + searchBarColor + '\'' +
                '}';
    }
}
