package com.transsion.store.dto;

import com.transsion.store.bo.ReportSaleWeek;

/**
 * Created by liuzh on 17-3-10.
 */
public class ReportSaleWeek4CityDto extends ReportSaleWeek {
    private static final long	serialVersionUID	= 1L;

    private java.lang.Integer saleQty0;
    private java.lang.Integer saleQty1;

    private java.lang.Integer saleQty2;

    private java.lang.Integer saleQty3;
    private java.lang.Integer saleQty4;
    private java.lang.Integer saleQty5;
    private java.lang.Integer saleQty6;
    private java.lang.Integer saleQty7;

    public Integer getSaleQty1() {
        return saleQty1;
    }

    public void setSaleQty1(Integer saleQty1) {
        this.saleQty1 = saleQty1;
    }

    public Integer getSaleQty2() {
        return saleQty2;
    }

    public void setSaleQty2(Integer saleQty2) {
        this.saleQty2 = saleQty2;
    }

    public Integer getSaleQty3() {
        return saleQty3;
    }

    public void setSaleQty3(Integer saleQty3) {
        this.saleQty3 = saleQty3;
    }

    public Integer getSaleQty4() {
        return saleQty4;
    }

    public void setSaleQty4(Integer saleQty4) {
        this.saleQty4 = saleQty4;
    }

    public Integer getSaleQty5() {
        return saleQty5;
    }

    public void setSaleQty5(Integer saleQty5) {
        this.saleQty5 = saleQty5;
    }

    public Integer getSaleQty6() {
        return saleQty6;
    }

    public void setSaleQty6(Integer saleQty6) {
        this.saleQty6 = saleQty6;
    }

    public Integer getSaleQty7() {
        return saleQty7;
    }

    public void setSaleQty7(Integer saleQty7) {
        this.saleQty7 = saleQty7;
    }

    public Integer getSaleQty0() {
        return saleQty0;
    }

    public void setSaleQty0(Integer saleQty0) {
        this.saleQty0 = saleQty0;
    }

    @Override
    public String toString() {
        return "ReportSaleWeek4CityDto{" +
                "saleQty0=" + saleQty0 +
                ", saleQty1=" + saleQty1 +
                ", saleQty2=" + saleQty2 +
                ", saleQty3=" + saleQty3 +
                ", saleQty4=" + saleQty4 +
                ", saleQty5=" + saleQty5 +
                ", saleQty6=" + saleQty6 +
                ", saleQty7=" + saleQty7 +
                '}';
    }
}
