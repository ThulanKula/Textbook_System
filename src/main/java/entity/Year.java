package entity;

/**
 * @Author: Thulani Kula
 * Date: 21 June 2020
 * this year class refers to the year of study and not the year date.
 *  do not confuse the two.
 */

public class Year {

    private int year;

    private Year (Builder builder){
        this.year = year;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }

    public int getYear() {
        return year;
    }

    public static class Builder{
        private int year;

        public Builder setYear(int year){
            this.year = year;
            return this;
        }

        public Year Build(){
            return new Year(this);
        }

    }// end of builder
}// end of class
