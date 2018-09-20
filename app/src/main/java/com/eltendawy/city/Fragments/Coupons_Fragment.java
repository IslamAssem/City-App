package com.eltendawy.city.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eltendawy.city.Activities.BaseActivity;
import com.eltendawy.city.Adapters.SimpleFragmentPagerAdapter;
import com.eltendawy.city.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Coupons_Fragment extends Fragment {

    String title;
    ViewPager viewPager;
    TabLayout tabLayout;
    SimpleFragmentPagerAdapter adapter;
    View view;

    public Coupons_Fragment() {
        title="Discount Coupons";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_coupons, container, false);
        // Inflate the layout for this fragment
        initiateViews();
        return view;
    }

    private void initiateViews() {
        viewPager =view.findViewById(R.id.coupons_view_pager);
        tabLayout =view.findViewById(R.id.coupons_tab);
        //getActivity().getSupportFragmentManager().getFragments().clear();
        adapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.add(new Coupon_list_Fragment(),"NEW");
        adapter.add(new Coupon_list_Fragment(),"FOOD");
        adapter.add(new Coupon_list_Fragment(),"ACTIVITY");
        adapter.add(new Coupon_list_Fragment(),"AUTO");
        adapter.add(new Coupon_list_Fragment(),"CLOTH");
        adapter.add(new Coupon_list_Fragment(),"FOOD");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public String toString() {
        return title;
    }
}
