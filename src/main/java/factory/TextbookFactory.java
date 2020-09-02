package factory;

import Util.GenericHelper;
import Util.PriceChecker;
import Util.StringHelper;
import entity.Textbook;

/**
 * @author aelmick
 * Des: Entity Textbook with Factory pattern
 * date: 01 July 2020
 */

public class TextbookFactory
{
    public static Textbook createTextbook(String nameOfBook, int editionOfBook, String bookDesc, String ISBNofBook, int volumeOfBook, double priceOfBook)
    {
        if (StringHelper.isNullorEmpty(nameOfBook) || StringHelper.isNullorEmpty(bookDesc) || PriceChecker.isValidPrice(priceOfBook))
        {
            return new Textbook.Builder().build();
        }
        String textbookId = GenericHelper.generateRandomId();
        return new Textbook.Builder()
                .setBookId(textbookId)
                .setBookName(nameOfBook)
                .setBookEdition(editionOfBook)
                .setBookDescription(bookDesc)
                .setBookISBN(ISBNofBook)
                .setBookVolume(volumeOfBook)
                .setBookPrice(priceOfBook)
                .build();
    }
}
