package com.thulani.factory;

import com.thulani.entity.Author;
import com.thulani.util.GenericHelper;
import com.thulani.util.StringHelper;

/**
 * Author: Avery Daniels
 * Date: 03 July 2020
 * Desc: This is a com.thulani.factory class for the Author domain.
 *
 * */
public class AuthorFactory {
    public static Author createAuthor(String authFirstName, String authLastName) {
        if (StringHelper.isNullorEmpty(authFirstName)||StringHelper.isNullorEmpty(authLastName))
            return new Author.Builder().Build();
        String authNumber = GenericHelper.generateRandomId();
        return new Author.Builder().
                setAuthNumber(authNumber).
                setAuthFirstName(authFirstName).
                setAuthLastName(authLastName).Build();
    }
}
