package com.e.whatwillcooktoday.utils;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.e.whatwillcooktoday.model.database.FoodDatabase;
import com.e.whatwillcooktoday.model.database.entity.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListFoods {
    public List<String> ListFoods(Context context){
        FoodDatabase database = Room.databaseBuilder(context,
                FoodDatabase.class,
                "yemekler").allowMainThreadQueries().build();
        List<Food> soups = database.foodDao().corbalar();
        List<Food> maindishes = database.foodDao().anayemekler();
        List<Food> sidedishes = database.foodDao().yanyemekler();
        List<String> foods = new ArrayList<>();
        List<Integer> randomnumbers = new ArrayList<>();
        if(soups.size()!=0 && maindishes.size()!=0 && sidedishes.size()!=0){
            randomnumbers.add(new Random().nextInt(soups.size()));
            randomnumbers.add(new Random().nextInt(maindishes.size()));
            randomnumbers.add(new Random().nextInt(sidedishes.size()));
            foods.add(soups.get(new Random().nextInt(soups.size())).isim);
            foods.add(maindishes.get(new Random().nextInt(maindishes.size())).isim);
            foods.add(sidedishes.get(new Random().nextInt(sidedishes.size())).isim);
            return foods;
        }else{
            foods.add("Her tür yemekten en az 1 tane eklemelisin");
            foods.add("Her tür yemekten en az 1 tane eklemelisin");
            foods.add("Her tür yemekten en az 1 tane eklemelisin");
            return foods;
        }
    }
}
