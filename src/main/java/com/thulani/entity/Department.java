package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    private String departmentNum;
    private String departmentName;

    protected Department () {
    }

    private Department(Department.Builder builder) {
        this.departmentNum = builder.departmentNum;
        this.departmentName = builder.departmentName;
    }

    public String getDepartmentNum() {
        return departmentNum;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNum =" + departmentNum +
                ", departmentName ='" + departmentName + '\'' +
                '}';
    }

    public static class Builder {
        private String departmentNum;
        private String departmentName;

        public Department.Builder setDepartmentNum (String departmentNum) {
            this.departmentNum = departmentNum;
            return this;
        }

        public Department.Builder setDepartmentName (String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Department build () {
            return new Department (this);
        }

    }
}
