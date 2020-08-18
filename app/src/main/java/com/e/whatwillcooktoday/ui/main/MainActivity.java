package com.e.whatwillcooktoday.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.e.whatwillcooktoday.R;
import com.e.whatwillcooktoday.databinding.ActivityMainBinding;
import com.e.whatwillcooktoday.model.database.FoodDatabase;
import com.e.whatwillcooktoday.model.database.entity.Food;
import com.e.whatwillcooktoday.utils.ListFoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel viewModel = new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initilaze();
    }


    void initilaze(){
        initviewmodel();
        randomfoods();
        viewModel.foodlivedata(this).observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                Log.d("gelen","oldu");
                binding.soup.setText(strings.get(0));
                binding.mainDish.setText(strings.get(1));
                binding.sideDish.setText(strings.get(2));
            }
        });
    }

    void initviewmodel(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
    protected void randomfoods(){
        List<String> strings = new ListFoods().ListFoods(this);
        binding.soup.setText(strings.get(0));
        binding.mainDish.setText(strings.get(1));
        binding.sideDish.setText(strings.get(2));
    }
}
