package com.youthfireit.dora.constants;

public class ConstantResources {
    public static final String BASE_URL = "https://youthfireit.com/dora/api/v1/";
    public static final String IMAGE_BASE_URL = "https://youthfireit.com/dora/";
    public static final String CURRENCY_CODE = "BDT";
    public static String calculateDiscountPercentage(String old_price, String price)
    {
        double pOld, pNew;
        pOld = Double.parseDouble(old_price);
        pNew = Double.parseDouble(price);
        double percent = (pOld - pNew) / pOld * 100;
        return (percent>0)?String.valueOf(Math.round(percent)):"0";
    }
}
