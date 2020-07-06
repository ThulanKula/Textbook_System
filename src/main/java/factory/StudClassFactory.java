package factory;

import entity.StudClass;

public class StudClassFactory {
    public static StudClass createStudClass(String studCourse){
        StudClass studclass = new StudClass.Builder().setStudCourse(studCourse).Build();
        return studclass;
    }

}
