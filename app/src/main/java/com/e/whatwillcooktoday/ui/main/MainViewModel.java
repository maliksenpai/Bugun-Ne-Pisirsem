package com.e.whatwillcooktoday.ui.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.e.whatwillcooktoday.model.database.FoodDatabase;
import com.e.whatwillcooktoday.model.database.entity.Food;
import com.e.whatwillcooktoday.ui.newfood.NewFoodActivity;
import com.e.whatwillcooktoday.utils.ListFoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<String>> liveData = new MutableLiveData<>();

    public void addbutton(View v) {
        Context context = v.getContext();
        context.startActivity(new Intent(context, NewFoodActivity.class));
    }

    public void refresh(View v){
        foodlivedata(v.getContext());
    }

    LiveData<List<String>> foodlivedata(Context context){
        liveData.setValue(new ListFoods().ListFoods(context));
        return liveData;
    }
}
