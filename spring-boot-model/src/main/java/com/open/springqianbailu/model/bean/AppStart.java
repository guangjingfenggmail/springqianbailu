package com.open.springqianbailu.model.bean;

import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.bean.tab.TabCfgBean;
import com.open.springqianbailu.model.table.Splash;

import java.io.Serializable;
import java.util.List;

public class AppStart  extends Result<AppStart.AppStartModel> implements   Serializable {

    public class AppStartModel implements Serializable{
        public String Motto;
        public int api_version;
        public int api_timeoutms;
        public boolean token_expire;
        public boolean skip_splash;
        public String preload_plugins;
        public List<String> clear_apis;
        public Splash splash;
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

        public Splash getSplash() {
            return splash;
        }

        public void setSplash(Splash splash) {
            this.splash = splash;
        }

        public TabCfgBean getTabCfg() {
            return tabCfg;
        }

        public void setTabCfg(TabCfgBean tabCfg) {
            this.tabCfg = tabCfg;
        }

    }


}
