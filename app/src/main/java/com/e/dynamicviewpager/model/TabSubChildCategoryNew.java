
package com.e.dynamicviewpager.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabSubChildCategoryNew {

    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("sub_id")
    @Expose
    private String subId;
    @SerializedName("c_title")
    @Expose
    private String cTitle;

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

}
