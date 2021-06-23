package com.youthfireit.dora.constants;

public class ConstantResources {
    public static final String BASE_URL = "https://dora.com.bd/api/v1/";
    public static final String IMAGE_BASE_URL = "https://dora.com.bd/";
    public static final String CURRENCY_CODE = "BDT";
    public static String calculateDiscountPercentage(String old_price, String price)
    {
        double pOld, pNew;
        pOld = Double.parseDouble(old_price);
        pNew = Double.parseDouble(price);
        double percent = (pOld - pNew) / pOld * 100;
        return (percent>0)?String.valueOf(Math.round(percent)):"0";
    }
    public static String calculateDiscountAmountFromPercent(String price, String percent)
    {
        double p;
        int per;
        p = Double.parseDouble(price);
        per = Integer.parseInt(percent);
        return String.valueOf(p-((p*per)/100.0));
    }
}
