package com.open.springqianbailu.model;

import com.open.springqianbailu.Result;

import java.io.Serializable;
import java.util.List;

public class AppStart  extends Result<AppStart.AppStartModel> implements   Serializable {

    public class AppStartModel{
        public String Motto;
        public int api_version;
        public int api_timeoutms;
        public boolean token_expire;
        public boolean skip_splash;
        public String preload_plugins;
        public List<String> clear_apis;
        public SplashBean splash;
        public TabCfgBean tabCfg;

        public String getMotto() {
            return Motto;
        }

        public void setMotto(String motto) {
            Motto = motto;
        }

        public int getApi_version() {
            return api_version;
        }

        public void setApi_version(int api_version) {
            this.api_version = api_version;
        }

        public int getApi_timeoutms() {
            return api_timeoutms;
        }

        public void setApi_timeoutms(int api_timeoutms) {
            this.api_timeoutms = api_timeoutms;
        }

        public boolean isToken_expire() {
            return token_expire;
        }

        public void setToken_expire(boolean token_expire) {
            this.token_expire = token_expire;
        }

        public boolean isSkip_splash() {
            return skip_splash;
        }

        public void setSkip_splash(boolean skip_splash) {
            this.skip_splash = skip_splash;
        }

        public String getPreload_plugins() {
            return preload_plugins;
        }

        public void setPreload_plugins(String preload_plugins) {
            this.preload_plugins = preload_plugins;
        }

        public List<String> getClear_apis() {
            return clear_apis;
        }

        public void setClear_apis(List<String> clear_apis) {
            this.clear_apis = clear_apis;
        }

        public SplashBean getSplash() {
            return splash;
        }

        public void setSplash(SplashBean splash) {
            this.splash = splash;
        }

        public TabCfgBean getTabCfg() {
            return tabCfg;
        }

        public void setTabCfg(TabCfgBean tabCfg) {
            this.tabCfg = tabCfg;
        }

        public class SplashBean implements Serializable {
            public String ID;
            public String ShowTimes;
            public String start;
            public String url;
            public String full_display_img_url;
            public String end;
            public boolean skip_hide;
            public String skip_url;
            public String duration;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getShowTimes() {
                return ShowTimes;
            }

            public void setShowTimes(String showTimes) {
                ShowTimes = showTimes;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getFull_display_img_url() {
                return full_display_img_url;
            }

            public void setFull_display_img_url(String full_display_img_url) {
                this.full_display_img_url = full_display_img_url;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public boolean isSkip_hide() {
                return skip_hide;
            }

            public void setSkip_hide(boolean skip_hide) {
                this.skip_hide = skip_hide;
            }

            public String getSkip_url() {
                return skip_url;
            }

            public void setSkip_url(String skip_url) {
                this.skip_url = skip_url;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }
        }


        class TabCfgBean implements Serializable {
            public String tab_bg;
            public List<TabConfigBean> tab_config;

            public String getTab_bg() {
                return tab_bg;
            }

            public void setTab_bg(String tab_bg) {
                this.tab_bg = tab_bg;
            }

            public List<TabConfigBean> getTab_config() {
                return tab_config;
            }

            public void setTab_config(List<TabConfigBean> tab_config) {
                this.tab_config = tab_config;
            }
        }

        class TabConfigBean implements Serializable {
            public String icon_normal;
            public String icon_selected;
            public String name;
            public String type;
            public String text_color_normal;
            public String text_color_selected;
            public boolean show;

            public String getIcon_normal() {
                return icon_normal;
            }

            public void setIcon_normal(String icon_normal) {
                this.icon_normal = icon_normal;
            }

            public String getIcon_selected() {
                return icon_selected;
            }

            public void setIcon_selected(String icon_selected) {
                this.icon_selected = icon_selected;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getText_color_normal() {
                return text_color_normal;
            }

            public void setText_color_normal(String text_color_normal) {
                this.text_color_normal = text_color_normal;
            }

            public String getText_color_selected() {
                return text_color_selected;
            }

            public void setText_color_selected(String text_color_selected) {
                this.text_color_selected = text_color_selected;
            }

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }
        }
    }


}
