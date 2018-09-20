package com.eltendawy.city.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.eltendawy.city.R;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity {
    protected BaseActivity activity;
    protected Context context;

    public BaseActivity() {
        activity = this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getApplicationContext();
    }
}
