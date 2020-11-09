package com.thulani.factory;

import com.thulani.util.GenericHelper;
import com.thulani.util.StringHelper;
import com.thulani.entity.StudClass;

public class StudClassFactory
{
    public static StudClass createStudClass(String studCourse)
    {
        // added by me
        if (StringHelper.isNullorEmpty(studCourse))
        {
            return new StudClass.Builder().build();
        }
        String studClassId = GenericHelper.generateRandomId();
        return new StudClass.Builder()
                .setStudCourseId(studClassId)
                .setStudCourse(studCourse)
                .build();
    }

}
