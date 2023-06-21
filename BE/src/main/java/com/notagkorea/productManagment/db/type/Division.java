package com.notagkorea.productManagment.db.type;

import lombok.Getter;

@Getter
public enum Division {

    DIVISION1("대분류", 1),
    DIVISION2("중분류", 2),
    DIVISION3("소분류", 3),
    DIVISION4("세분류", 4);

    private final String divisionName;
    private final int divisionLevel;

    Division(String divisionName, int divisionLevel) {
        this.divisionName = divisionName;
        this.divisionLevel = divisionLevel;
    }

    public int getCategoryCodeLength(){
        return this.divisionLevel * 2;
    }

    public static Division of(int divisionLevel) {
        switch (divisionLevel) {
            case 1 : return DIVISION1;
            case 2 : return DIVISION2;
            case 3 : return DIVISION3;
            default: return DIVISION4;
        }
    }

}
