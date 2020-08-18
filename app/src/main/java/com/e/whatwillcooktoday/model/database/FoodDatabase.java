package com.e.whatwillcooktoday.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.e.whatwillcooktoday.model.database.dao.FoodDao;
import com.e.whatwillcooktoday.model.database.entity.Food;

@Database(entities = {Food.class}, version = 1)
public abstract class FoodDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}
