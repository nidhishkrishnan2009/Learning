package com.learning.test;

public enum TestEnum {
    NIDISH("nidish");
    private String value;
    private TestEnum(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
