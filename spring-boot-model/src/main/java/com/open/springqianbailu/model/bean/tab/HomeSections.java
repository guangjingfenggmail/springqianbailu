package com.open.springqianbailu.model.bean.tab;

import java.io.Serializable;
import java.util.List;

public class HomeSections implements Serializable {
    private List<ViewTypeBean>  sections;

    public List<ViewTypeBean> getSections() {
        return sections;
    }

    public void setSections(List<ViewTypeBean> sections) {
        this.sections = sections;
    }
}
