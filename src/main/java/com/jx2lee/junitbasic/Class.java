package com.jx2lee.junitbasic;

public class Class {
    private ClassStatus classStatus = ClassStatus.ON;
    private int limit;
    private String member;

    public Class(int limit, String member) {
        if (limit < 0 ) {
            throw new IllegalArgumentException("limit은 0보다 커야한다");
        }
        this.limit = limit;
        this.member = member;
    }

    public Class(int limit) {
        if (limit < 0 ) {
            throw new IllegalArgumentException("limit은 0보다 커야한다");
        }
        this.limit = limit;
    }

    public ClassStatus getStatus() {
        return this.classStatus;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Class{" +
                "limit=" + limit +
                ", member='" + member + '\'' +
                '}';
    }
}
