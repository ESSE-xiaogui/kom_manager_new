package com.transsion.store.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pradmin on 2016/5/30.
 */
public class ScanValidateDto implements Serializable{
    private String brand;
    private String model;
    private String[] imeis;
    private String vc;
    private String cpuid;
    private String saleDate;
    private String facotryEN;
    private String color;
    private String facotryCN;
    private String date;
    private String type;
    private String imei1;

    private List<ScanValidateDto> kom;

    public List<ScanValidateDto> getKom() {
        return kom;
    }

    public void setKom(List<ScanValidateDto> kom) {
        this.kom = kom;
    }

    public String[] getImeis() {
        return imeis;
    }

    public void setImeis(String[] imeis) {
        this.imeis = imeis;
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc;
    }

    public String getCpuid() {
        return cpuid;
    }

    public void setCpuid(String cpuid) {
        this.cpuid = cpuid;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getFacotryEN() {
        return facotryEN;
    }

    public void setFacotryEN(String facotryEN) {
        this.facotryEN = facotryEN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFacotryCN() {
        return facotryCN;
    }

    public void setFacotryCN(String facotryCN) {
        this.facotryCN = facotryCN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    @Override
    public String toString() {
        return "ScanValidateDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", imeis=" + Arrays.toString(imeis) +
                ", vc='" + vc + '\'' +
                ", cpuid='" + cpuid + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", facotryEN='" + facotryEN + '\'' +
                ", color='" + color + '\'' +
                ", facotryCN='" + facotryCN + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", imei1='" + imei1 + '\'' +
                '}';
    }
}
