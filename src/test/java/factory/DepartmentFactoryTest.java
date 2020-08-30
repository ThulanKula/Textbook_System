package factory;

import entity.Author;
import entity.Department;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentFactoryTest {
    private Department department1, department2, department3;

    @Test
    public void createDepartment() {
        Department department = DepartmentFactory.createDepartment("123", "Department of Informatics and Design");
        Assert.assertNotNull(department.getDepartmentName());
        System.out.println(department);
    }

    @Test
    public void equalityObjectDepartment() {
        department1 = DepartmentFactory.createDepartment("123", "Department of Informatics and Design");
        department2 = DepartmentFactory.createDepartment("123", "Department of Informatics and Design");

        Assert.assertEquals(department1, department2);
    }

    @Test
    public void identityTest() {
        department3 = DepartmentFactory.createDepartment("123", "Department of Informatics and Design");

        String deptName = "Department of Informatics and Design";
        String deptNum = "123";

        Assert.assertNotNull(department3.getDepartmentNum());
        Assert.assertEquals(department3.getDepartmentNum(), deptNum);
        Assert.assertEquals(department3.getDepartmentName(), deptName);
    }
}
