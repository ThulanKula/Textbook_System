package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Thulani Kula
 * Date: 21 June 2020
 * this year class refers to the year of study and not the year date.
 *  do not confuse the two.
 */

@Entity
public class Year {

    @Id
    private String year;

    protected Year() {
    }

    private Year (Builder builder){
        this.year = year;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }

    public String getYear() {
        return year;
    }

    public static class Builder{
        private String year;

        public Builder setYear(String year){
            this.year = year;
            return this;
        }

        public Year build(){
            return new Year(this);
        }

    }// end of builder
}// end of class
