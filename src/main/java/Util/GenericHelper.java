package Util;

import java.util.UUID;

/**
 * @author aelmick
 * Des: GenericHelper class
 * date: 29 August 2020
 */

public class GenericHelper
{
    public static String generateRandomId()
    {
        return UUID.randomUUID().toString();
    }
}
