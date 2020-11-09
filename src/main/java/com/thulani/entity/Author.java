package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

/**
 *
 * Author: Avery Daniels
 * Date: 23 June 2020
 * Desc: This class is an com.thulani.entity of an Author which contains a author number, name (first and last)
 *
 * */
@Entity
public class Author {
    @Id
    private String authNumber;
    private String authFirstName;
    private String authLastName;
    @OneToMany
    private Set<Textbook> textbooks;
    protected Author() {};

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

        public Builder copy(Author author) {
            this.authNumber = author.authNumber;
            this.authFirstName = author.authFirstName;
            this.authLastName = author.authLastName;
            return this;
        }

        public Author Build(){
            return new Author(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authNumber.equals(author.authNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authNumber);
    }
}
