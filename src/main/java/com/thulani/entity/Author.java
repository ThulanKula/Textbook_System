package com.thulani.entity;
/**
 *
 * Author: Avery Daniels
 * Date: 23 June 2020
 * Desc: This class is an com.thulani.entity of an Author which contains a author number, name (first and last)
 *
 * */

public class Author {
    private String authNumber
            , authFirstName
            , authLastName;

    private Author(Builder builder) {
        this.authNumber = builder.authNumber;
        this.authFirstName = builder.authFirstName;
        this.authLastName = builder.authLastName;
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public String getAuthFirstName() {
        return authFirstName;
    }

    public String getAuthLastName() {
        return authLastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authNumber='" + authNumber + '\'' +
                ", authfirstName='" + authFirstName + '\'' +
                ", authlastName='" + authLastName + '\'' +
                '}';
    }

    public static class Builder {
        private String authNumber
                , authFirstName
                , authLastName;

        public Builder setAuthNumber(String authNumber) {
            this.authNumber = authNumber;
            return this;
        }

        public Builder setAuthFirstName(String authFirstName) {
            this.authFirstName = authFirstName;
            return this;
        }

        public Builder setAuthLastName(String authLastName) {
            this.authLastName = authLastName;
            return this;
        }

        public Author Build(){
            return new Author(this);
        }
    }
}
