package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    tabLayout=(TabLayout) findViewById(R.id.menugorne_id);
    viewPager=(ViewPager) findViewById(R.id.viewPager_id);
    ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager());
    adapter.addFragment(new FragmentSingle(),"Gra pojedyncza");
    adapter.addFragment(new FragmentMulti(),"Gra wieloosobowa");
    adapter.addFragment(new FragmentGablota(),"Gablota");
    viewPager.setAdapter(adapter);
tabLayout.setupWithViewPager(viewPager);

    }
}
