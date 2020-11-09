package com.thulani.util;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

public class PriceChecker {
    public static boolean isValidPrice(Double price)
    {
        if (price <= 0)
        {
            return true;
        }
        return false;
    }
}
