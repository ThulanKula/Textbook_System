package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Airmick
 * Desc: Entity Textbook with Builder pattern
 * date: 24 june 2020
 */


@Entity
public class Textbook //implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String bookId;

    private String bookName;
    private int bookEdition;
    private String bookDescription;
    private String bookISBN;
    private int bookVolume;
    private double bookPrice;

    protected Textbook(){}

    private Textbook(Builder builder)
    {
        this.bookId = builder.bookId;
        this.bookName = builder.bookName;
        this.bookEdition = builder.bookEdition;
        this.bookDescription = builder.bookDescription;
        this.bookISBN = builder.bookISBN;
        this.bookVolume = builder.bookVolume;
        this.bookPrice = builder.bookPrice;
    }

    public String getBookId()
    {
        return bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public int getBookEdition()
    {
        return bookEdition;
    }

    public String getBookDescription()
    {
        return bookDescription;
    }

    public String getBookISBN()
    {
        return bookISBN;
    }

    public int getBookVolume()
    {
        return bookVolume;
    }

    public double getBookPrice()
    {
        return bookPrice;
    }

    @Override
    public String toString()
    {
        return "Textbook{" +
                "bookId= " + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookEdition= " + bookEdition +
                ", bookDescription= " + bookDescription +
                ", bookISBN='" + bookISBN + '\'' +
                ", bookVolume= " + bookVolume +
                ", bookPrice= " + bookPrice +"$"+
                '}';
    }

    public static class Builder
    {
        private String bookId;
        private String bookName;
        private int bookEdition;
        private String bookDescription;
        private String bookISBN;
        private int bookVolume;
        private double bookPrice;

        public Builder setBookId(String bookId)
        {
            this.bookId = bookId;
            return this;
        }

        public Builder setBookName(String bookName)
        {
            this.bookName = bookName;
            return this;
        }

        public Builder setBookEdition(int bookEdition)
        {
            this.bookEdition = bookEdition;
            return this;
        }

        public Builder setBookDescription(String bookDescription)
        {
            this.bookDescription = bookDescription;
            return this;
        }

        public Builder setBookISBN(String bookISBN)
        {
            this.bookISBN = bookISBN;
            return this;
        }

        public Builder setBookVolume(int bookVolume)
        {
            this.bookVolume = bookVolume;
            return this;
        }

        public Builder setBookPrice(double bookPrice)
        {
            this.bookPrice = bookPrice;
            return this;
        }

        public Builder copy(Textbook textbook)
        {
            this.bookId = textbook.bookId;
            this.bookName = textbook.bookName;
            this.bookEdition = textbook.bookEdition;
            this.bookDescription = textbook.bookDescription;
            this.bookISBN = textbook.bookISBN;
            this.bookVolume = textbook.bookVolume;
            this.bookPrice = textbook.bookPrice;
            return this;
        }

        public Textbook build()
        {
            return new Textbook(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return bookId.equals(textbook.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
