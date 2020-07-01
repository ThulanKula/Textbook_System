package entity;

/**
 * @author Airmick
 * Desc: Entity Textbook with Builder pattern
 * date: 24 june 2020
 */

public class Textbook
{
    private int bookNum;
    private String bookName;
    private int bookEdition;
    private String bookISBN;
    private int bookVolume;
    private double bookPrice;

    private Textbook(Builder builder)
    {
        this.bookNum = builder.bookNum;
        this.bookName = builder.bookName;
        this.bookEdition = builder.bookEdition;
        this.bookISBN = builder.bookISBN;
        this.bookVolume = builder.bookVolume;
        this.bookPrice = builder.bookPrice;
    }

    public int getBookNum()
    {
        return bookNum;
    }

    public String getBookName()
    {
        return bookName;
    }

    public int getBookEdition()
    {
        return bookEdition;
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
                "bookNum= " + bookNum +
                ", bookName='" + bookName + '\'' +
                ", bookEdition= " + bookEdition +
                ", bookISBN='" + bookISBN + '\'' +
                ", bookVolume= " + bookVolume +
                ", bookPrice= " + bookPrice +
                '}';
    }

    public static class Builder
    {
        private int bookNum;
        private String bookName;
        private int bookEdition;
        private String bookISBN;
        private int bookVolume;
        private double bookPrice;

        public Builder setBookNum(int bookNum)
        {
            this.bookNum = bookNum;
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

        public Textbook build()
        {
            return new Textbook(this);
        }

    }
}
