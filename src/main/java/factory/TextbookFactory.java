package factory;

import entity.Textbook;

/**
 * @author aelmick
 * Des: Entity Textbook with Factory pattern
 * date: 01 July 2020
 */

public class TextbookFactory
{
    public static Textbook createTextbook(int bookNumber, String nameOfBook, int editionOfBook, String ISBNofBook, int volumeOfBook, double priceOfBook)
    {
        Textbook textbook = new Textbook.Builder()
                .setBookNum(bookNumber)
                .setBookName(nameOfBook)
                .setBookEdition(editionOfBook)
                .setBookISBN(ISBNofBook)
                .setBookVolume(volumeOfBook)
                .setBookPrice(priceOfBook)
                .build();
        return textbook;
    }
}
