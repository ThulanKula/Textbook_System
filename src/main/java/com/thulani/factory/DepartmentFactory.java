package com.thulani.factory;

import com.thulani.entity.Department;
import com.thulani.util.GenericHelper;
import com.thulani.util.StringHelper;

public class DepartmentFactory {
    public static Department createDepartment(String departmentName) {
        if (StringHelper.isNullorEmpty(departmentName))
            return new Department.Builder().build();
        String departmentNum = GenericHelper.generateRandomId();
        return new Department.Builder()
                .setDepartmentNum(departmentNum)
                .setDepartmentName(departmentName)
                .build();
    }
}
