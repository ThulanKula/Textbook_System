package factory;

import entity.Year;

/**
 * @Author: Thulani Kula
 * Date: 01 July 2020
 * Desc: Factory class for year domain
 * this year class refers to the year of study and not the year date.
 * do not confuse the two.
 * */

public class YearFactory {
    public static Year createYear(String year){

        // year1 is the name of the object and is not to be confused for the actual year e.g 2020
        Year year1 = new Year.Builder().
                setYear(year).build();
        return year1;
    }// end of  method

}// end of class
