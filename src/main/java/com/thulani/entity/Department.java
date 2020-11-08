package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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

        public Department.Builder copy(Department department) {
            this.departmentNum = department.departmentNum;
            this.departmentName = department.getDepartmentName();
            return this;
        }

        public Department build () {
            return new Department (this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department department = (Department) o;
        return departmentNum.equals(department.departmentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentNum);
    }
}
