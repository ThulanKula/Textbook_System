package entity;

public class Subject {
    private String subNumber;
    private String subName;

    public Subject(Builder builder) {
        this.subNumber = builder.subNumber;
        this.subNumber = builder.subName;
    }

    public String getSubNumber() {
        return subNumber;
    }

    public String getSubName() {
        return subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subNumber='" + subNumber + '\'' +
                ", subName='" + subName + '\'' +
                '}';
    }

    public static class Builder {
        private String subNumber;
        private String subName;

        public Builder setSubNumber(String subNumber) {
            this.subNumber = subNumber;
            return this;
        }

        public Builder setSubName(String subName) {
            this.subName = subName;
            return this;
        }

        public entity.Subject Build() {
            return new entity.Subject(this);
        }
    }
}

