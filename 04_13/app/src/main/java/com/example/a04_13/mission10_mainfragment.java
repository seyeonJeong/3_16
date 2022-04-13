package com.example.a04_13;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class mission10_mainfragment extends Fragment {

    mission10_fragment1 fragment1;
    mission10_fragment2 fragment2;
    mission10_fragment3 fragment3;
    ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_mission10_mainfragment,container,false);

        pager = (ViewPager)view.findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(3);

        MypaperAdapter adapter = new MypaperAdapter(getChildFragmentManager());
        fragment1 = new mission10_fragment1();
        adapter.addItem(fragment1);
        fragment2 = new mission10_fragment2();
        adapter.addItem(fragment2);
        fragment3 = new mission10_fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);

        return view;
    }

    class MypaperAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MypaperAdapter(FragmentManager fa) {
            super(fa);
        }

        public void addItem(Fragment f){
            items.add(f);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return  items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}