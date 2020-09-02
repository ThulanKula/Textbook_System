package entity;

public class Department {
    private int departmentNum;
    private String departmentName;

    public Department(Department.Builder builder) {
        this.departmentNum = builder.departmentNum;
        this.departmentName = builder.departmentName;
    }

    public int getDepartmentNum() {
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
        private int departmentNum;
        private String departmentName;

        public Department.Builder setDepartmentNum (int departmentNum) {
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
