package com.jx2lee.mockito.domain;

public class Study {
    private String owner;

    public Study(String owner) {
        this.owner = owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner.getName();
    }
}
