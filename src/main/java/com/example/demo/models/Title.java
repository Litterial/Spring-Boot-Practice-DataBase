package com.example.demo.models;

public enum Title {
    DR("Dr."),
    MR("Mr."),
    MISS("Miss"),
    MS("Ms."),
    MRS("Mrs. ");

    private String prefix;

    Title (String prefix){this.prefix=prefix;}
    public String getPrefix() {return prefix;}





}
