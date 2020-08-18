package com.e.whatwillcooktoday.model.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "yemekler")
public class Food {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "isim")
    public String isim;
    @NonNull
    @ColumnInfo(name = "tur")
    public String tur;

    public Food(String isim,String tur){
        this.isim=isim;
        this.tur=tur;
    }
}
