package com.thulani.util;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

public class StringHelper {
    public static boolean isNullorEmpty(String value)
    {
        if (value == null || value.length() == 0 || value.equalsIgnoreCase("null"))
        {
            return true;
        }
        return false;
    }

}
