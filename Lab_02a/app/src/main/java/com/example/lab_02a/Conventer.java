package com.example.lab_02a;

public class Conventer {
    private final String numberStr;
    int number;

    public Conventer(String numerStr){
        this.numberStr = numerStr;
    }
    
    public String arabicToR() {
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return "Bledna liczba";
        }

        if (number <= 0 || number > 3999) {
            return "Zakres 1-3999";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int count = number / values[i]; // Liczba powtórzeń danego znaku
            number %= values[i]; // Pozostała liczba po odjęciu

            while (count-- > 0) {
                romanNumber.append(romans[i]);
            }
        }

        return romanNumber.toString();
    }
}
