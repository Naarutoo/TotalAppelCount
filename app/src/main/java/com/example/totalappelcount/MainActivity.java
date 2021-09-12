package com.example.totalappelcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListner {
FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       fragmentManager = getSupportFragmentManager();
       FragmentTransaction transaction = fragmentManager.beginTransaction();
       TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
       transaction.add(R.id.container,totalApplesFragment,"TotalAppleFragment").commit();

    }

    @Override
    public void LaunchBuyApplesFragment(Bundle bundle) {
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
buyApplesFragment.setArguments(bundle);
fragmentTransaction.replace(R.id.container,buyApplesFragment,"buyFragment").addToBackStack("buyFragment").commit();
    }

    @Override
    public void LaunchTotalApplesFragment(Bundle bundle) {
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
TotalApplesFragment totalApplesFragment =new TotalApplesFragment();
totalApplesFragment.setArguments(bundle);
fragmentTransaction.replace(R.id.container,totalApplesFragment,"TotalAppleFragment").commit();
    }
}