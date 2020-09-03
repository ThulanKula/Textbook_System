package entity;

import org.junit.Test;

public class DepartmentTest {
    @Test
    public void deptBuild() {
        Department.Builder builder = new Department.Builder();
        Department dept1 = builder
                .setDepartmentNum("1521")
                .setDepartmentName("Department of Informatics and Design")
                .build();
        System.out.println(dept1.toString());
    }

    @Test
    public void departBuild() {
        final Department.Builder builder = new Department.Builder();
        Department dept2 = builder
                .setDepartmentNum("")
                .setDepartmentName("")
                .build();
        System.out.println(dept2.toString());
    }

    @Test
    public void departmBuild() {
        final Department.Builder builder = new Department.Builder();
        Department dept3 = builder
                .setDepartmentNum("1234")
                .setDepartmentName("Department of Information Technology")
                .build();
        System.out.println(dept3.toString());
    }
}
