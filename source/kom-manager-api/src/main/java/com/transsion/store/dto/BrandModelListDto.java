package com.transsion.store.dto;

import java.io.Serializable;

/**
 * Created by pradmin on 2016/5/31.
 */
public class BrandModelListDto implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brandCode;
    private String brandName;
    private Integer isSelf;
    private String seriesCode;
    private String modelMatName;
    private String modelMatCode;

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Integer isSelf) {
        this.isSelf = isSelf;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }


    public String getModelMatName() {
        return modelMatName;
    }

    public void setModelMatName(String modelMatName) {
        this.modelMatName = modelMatName;
    }

    public String getModelMatCode() {
        return modelMatCode;
    }

    public void setModelMatCode(String modelMatCode) {
        this.modelMatCode = modelMatCode;
    }

    @Override
    public String toString() {
        return "BrandModelListDto{" +
                "brandCode='" + brandCode + '\'' +
                ", brandName='" + brandName + '\'' +
                ", isSelf=" + isSelf +
                ", seriesCode='" + seriesCode + '\'' +
                ", modelMatName='" + modelMatName + '\'' +
                ", modelMatCode='" + modelMatCode + '\'' +
                '}';
    }
}
