package factory;

import entity.Author;
/**
 * Author: Avery Daniels
 * Date: 03 July 2020
 * Desc: This is a factory class for the Author domain.
 *
 * */
public class AuthorFactory {
    public static Author createAuthor(String authNumber, String authFirstName, String authLastName) {

        return new Author.Builder().

                setAuthNumber(authNumber).
                setAuthFirstName(authFirstName).
                setAuthLastName(authLastName).Build();
    }
}
