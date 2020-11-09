package com.thulani.entity;

import antlr.preprocessor.PreprocessorTokenTypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subject implements Serializable {

    @Id
    private String subNumber;
    private String subName;

    @OneToMany
    private Set<Subject> subjects;

    protected Subject(){}

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
        public String id;
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

        public com.thulani.entity.Subject Build() {
            return new com.thulani.entity.Subject(this);
        }

        public Builder copy(Subject subject) {
            this.subName = subject.subName;
            this.subNumber = subject.subNumber;
            return this;
        }

        public Subject build()
        {
            return new Subject(this);
        }

        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;

            Subject subject = (Subject) o;
            return subNumber.equals(subject.subNumber);
        }

        @Override
        public int hashCode(){
            return Objects.hash(subNumber);
        }
    }
}

