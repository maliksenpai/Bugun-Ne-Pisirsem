package com.e.whatwillcooktoday.ui.newfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.e.whatwillcooktoday.R;
import com.e.whatwillcooktoday.databinding.ActivityNewFoodBinding;

public class NewFoodActivity extends AppCompatActivity {
    ActivityNewFoodBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initilaze();

    }
    void initilaze(){
        initviewmodel();
    }

    void initviewmodel(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_food);
        NewFoodViewModel viewModel = new NewFoodViewModel();
        binding.setLifecycleOwner(this);
        binding.setViewmodel(viewModel);
    }

}
