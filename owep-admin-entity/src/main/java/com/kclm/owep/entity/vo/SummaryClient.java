package com.kclm.owep.entity.vo;

public class SummaryClient {
    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SummaryClient{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
