package com.open.springqianbailu.model.bean.tab;

import com.open.springqianbailu.model.table.viewtype.ViewTypeTable;

import java.io.Serializable;
import java.util.List;

public class HomeSections implements Serializable {
    private List<ViewTypeTable>  sections;

    public List<ViewTypeTable> getSections() {
        return sections;
    }

    public void setSections(List<ViewTypeTable> sections) {
        this.sections = sections;
    }
}
