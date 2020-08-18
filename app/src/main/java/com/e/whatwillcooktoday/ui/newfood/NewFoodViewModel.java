package com.e.whatwillcooktoday.ui.newfood;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.e.whatwillcooktoday.di.Food.IFood;
import com.e.whatwillcooktoday.ui.main.MainActivity;
import com.e.whatwillcooktoday.model.repository.MainDish;
import com.e.whatwillcooktoday.model.repository.SideDish;
import com.e.whatwillcooktoday.model.repository.Soup;

public class NewFoodViewModel extends ViewModel {

    public String name;
    public MutableLiveData<String> nameerror;
    IFood iFood;

    public void addsoup(View v){
        if(!checkname(name)){
            return;
        }
        iFood = new Soup(name);
        iFood.addfood(v);
        v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
    }
    public void addmaindish(View v){
        if (!checkname(name)) {
           return;
        }
        iFood = new MainDish(name);
        iFood.addfood(v);
        v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
    }
    public void addsidedish(View v){
        if (!checkname(name)) {
           return;
        }
        iFood = new SideDish(name);
        iFood.addfood(v);
        v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
    }

    boolean checkname(String name){
        if(name==null){
            nameerror = new MutableLiveData<>();
            nameerror.postValue("Bos birakma");
            return false;
        }else{
            return true;
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        nameerror.setValue(null);
    }
}
