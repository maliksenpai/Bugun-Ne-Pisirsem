package com.e.whatwillcooktoday.model.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.e.whatwillcooktoday.model.database.entity.Food;

import java.util.List;
@Dao
public interface FoodDao {
    @Query("Select * From yemekler where tur in ('anayemek')")
    List<Food> anayemekler();

    @Query("Select * From yemekler where tur in ('yanyemek')")
    List<Food> yanyemekler();

    @Query("Select * From yemekler where tur in ('corba')")
    List<Food> corbalar();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void yemekekle(Food food);
}
