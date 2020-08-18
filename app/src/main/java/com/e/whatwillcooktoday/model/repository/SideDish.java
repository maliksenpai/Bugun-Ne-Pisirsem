package com.e.whatwillcooktoday.model.repository;

import android.view.View;

import androidx.room.Room;

import com.e.whatwillcooktoday.di.Food.IFood;
import com.e.whatwillcooktoday.model.database.FoodDatabase;
import com.e.whatwillcooktoday.model.database.entity.Food;

public class SideDish implements IFood {

    String name;

    public SideDish(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addfood(View v) {
        FoodDatabase database = Room.databaseBuilder(
                v.getContext(),
                FoodDatabase.class,
                "yemekler").allowMainThreadQueries().build();
        database.foodDao().yemekekle(new Food(name,"yanyemek"));
    }
}
