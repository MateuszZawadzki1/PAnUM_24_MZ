package com.example.cafeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CoffeinaDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "coffeina"; // Nazwa bazy danych
    private static final int DB_VERSION = 1; // Numer wersji bazy danych
    CoffeinaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);

    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE PRODUCT ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RES_ID INTEGER, "
                    + "CATEGORY TEXT);");

            // Wstawianie produktów
            insertProduct(db, "Ciastko Owsiane", "Chrupiące ciastko z pełnoziarnistych płatków owsianych.", R.drawable.ciastkoowsiane, "Przekąski");
            insertProduct(db, "Miodownik", "Słodki przekładaniec z miodem i delikatnym kremem.", R.drawable.miodownik, "Przekąski");
            insertProduct(db, "Sernik Nowojorski", "Kremowy sernik o gęstej konsystencji i subtelnym smaku.", R.drawable.serniknowojorski, "Przekąski");
            insertProduct(db, "Brownie", "Wilgotne ciasto czekoladowe z intensywnym kakaowym aromatem.", R.drawable.brownie, "Przekąski");
            insertProduct(db, "Espresso", "Czarna kawa ze świeżo mielonych ziaren najwyższej jakości.", R.drawable.espresso, "Napoje");
            insertProduct(db, "Cappucino", "Kawa z mlekiem i puszystą pianką.", R.drawable.cappuccino, "Napoje");
            insertProduct(db, "Cold Brew", "Kawa parzona na zimno przez kilkanaście godzin.", R.drawable.coldbrew, "Napoje");
            insertProduct(db, "Drip", "Kawa przelewowa parzona metodą alternatywną.", R.drawable.drip, "Napoje");
            insertProduct(db, "Matcha", "Zielona herbata w proszku, spieniona z mlekiem lub wodą.", R.drawable.matcha, "Napoje");
            insertProduct(db, "Czestochowa", "", R.drawable.czestochowa, "Kafeterie");
            insertProduct(db, "Krakow", "", R.drawable.krakow, "Kafeterie");
            insertProduct(db, "Warszawa", "", R.drawable.warszawa, "Kafeterie");

        }
    }

    private void insertProduct(SQLiteDatabase db, String name, String description, int imageResId, String category) {
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        values.put("IMAGE_RES_ID", imageResId);
        values.put("CATEGORY", category);
        db.insert("PRODUCT", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }
}
