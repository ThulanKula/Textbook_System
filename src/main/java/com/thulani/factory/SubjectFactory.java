package com.thulani.factory;

import com.thulani.entity.Subject;

public class SubjectFactory {
        public static Subject createSubject(String subNumber, String subName){
            Subject subject = new Subject.Builder().
                    setSubNumber(subNumber).
                    setSubName(subName).Build();

            return subject;
        }
}
