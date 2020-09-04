package service;

import entity.Department;
import java.util.Set;

public interface DepartmentService extends IService <Department, String> {
    Set<Department> getAll();
}
