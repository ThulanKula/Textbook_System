package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
