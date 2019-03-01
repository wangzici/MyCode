package com.xiaoma.skinfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator
 * 2018/9/11.
 */
public class NameMap {
    private Map<String,String> nameMap = new HashMap<>();

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

    public NameMap(){
        initMap();
    }

    private void initMap() {
        nameMap.put("背景","bg_common_main");
        nameMap.put("广告占位图","banner_notice");
        nameMap.put("广告底图","bg_launcher_ad");
        nameMap.put("下方tab底图","bg_launcher_bottom");
        nameMap.put("语音","bg_launcher_bottom_voice");
        nameMap.put("语音点击","bg_launcher_bottom_voice_pressed");
        nameMap.put("收音机","bg_launcher_bottom_radio");
        nameMap.put("收音机点击","bg_launcher_bottom_radio_pressed");
        nameMap.put("更多","bg_launcher_bottom_more");
        nameMap.put("更多点击","bg_launcher_bottom_more_pressed");
        nameMap.put("皮肤","bg_launcher_bottom_vip");
        nameMap.put("皮肤点击","bg_launcher_bottom_vip_pressed");
        nameMap.put("设置","bg_launcher_bottom_setting");
        nameMap.put("设置点击","bg_launcher_bottom_setting_pressed");
        nameMap.put("导航底图","bg_launcher_navi");
        nameMap.put("音乐底图","bg_launcher_music");
        nameMap.put("专辑占位图","icon_music_disc_main");
        nameMap.put("上一首","icon_pre_nor");
        nameMap.put("上一首点击","icon_pre_press");
        nameMap.put("上一首置灰","icon_pre_un_click");
        nameMap.put("下一首","icon_next_nor");
        nameMap.put("下一首点击","icon_next_pre");
        nameMap.put("下一首置灰","icon_next_un_click");
        nameMap.put("播放","icon_play_normal_notify_normal");
        nameMap.put("播放点击","icon_play_normal_notify_pressed");
        nameMap.put("播放置灰","icon_play_normal_notify_unclick");
        nameMap.put("暂停","icon_pause_normal_notify_normal");
        nameMap.put("暂停点击","icon_pause_normal_notify_pressed");
        nameMap.put("天气底图","bg_launcher_weather_day");
        nameMap.put("天气框日间","bg_launcher_weather_day");
        nameMap.put("天气框夜间","bg_launcher_weather_night");
        nameMap.put("空气指数","icon_air_quarity");
        nameMap.put("紫外线指数","icon_un_ray");
        nameMap.put("洗车指数","icon_wind");
        nameMap.put("搜索","icon_search");
        nameMap.put("时钟底图","bg_launcher_clock");
        nameMap.put("表盘","icon_clock_dial");
        nameMap.put("时针","icon_hour_line");
        nameMap.put("分针","icon_min_line");
        nameMap.put("秒针","icon_second_line");
        nameMap.put("中心圆点","icon_clock_point");
        nameMap.put("每日必听播放","bg_launcher_btn_radio_play_normal");
        nameMap.put("每日必听播放点击","bg_launcher_btn_radio_play_pressed");
        nameMap.put("每日必听暂停","bg_launcher_btn_radio_pause_normal");
        nameMap.put("每日必听暂停点击","bg_launcher_btn_radio_pause_pressed");
        nameMap.put("每日必听分类","icon_daily_radio_classify_normal");
        nameMap.put("每日必听分类点击","icon_daily_radio_classify_pressed");
        nameMap.put("每日必听跳过","bg_launcher_btn_radio_normal");
        nameMap.put("每日必听跳过点击","bg_launcher_btn_radio_pressed");
        nameMap.put("每日必听占位图","icon_launcher_radio");
        nameMap.put("每日必听底图","bg_launcher_radio");
        nameMap.put("定位","icon_weather_city_location");

    }
}
