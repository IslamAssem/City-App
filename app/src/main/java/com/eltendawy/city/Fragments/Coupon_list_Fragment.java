package com.eltendawy.city.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eltendawy.city.Activities.BaseActivity;
import com.eltendawy.city.Adapters.Coupons_recycler_Adapter;
import com.eltendawy.city.Models.Coupon;
import com.eltendawy.city.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Coupon_list_Fragment extends Fragment {

    //FragmentActivity activity;
    View view;
    RecyclerView recyclerView;
    public Coupon_list_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_coupon_list, container, false);
        // Inflate the layout for this fragment
        //activity=getActivity();
        initViews();
        return view;
    }

    public void initViews()
    {
        ArrayList<Coupon>coupons=new ArrayList<>();
        coupons.add(new Coupon("offer to get free iphone","17000LE","0LE"));
        Coupon coupon=new Coupon("offer to get 50% discount on car","200000LE","100000LE");
        coupon.setNote("coupon availbale for 5 times");
        coupon.setFavourite(true);
        coupons.add(coupon);
        recyclerView=view.findViewById(R.id.coupons_recycler);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        final Coupons_recycler_Adapter adapter=new Coupons_recycler_Adapter(coupons,getContext());
        recyclerView.setLayoutManager(manager);
        adapter.setOnFavouriteClickListener(new Coupons_recycler_Adapter.onFavouriteClickListener() {

            @Override
            public void onClick(int Position, Coupon coupon, ImageView view) {
                adapter.setFavourite(view,!coupon.isFavourite());
            }
        });
        adapter.setOnAllDetailsClickListener(new Coupons_recycler_Adapter.onAllDetailsClickListener() {
            @Override
            public void onClick(int Position, Coupon coupon) {

            }
        });
        adapter.setOnBuyClickListener(new Coupons_recycler_Adapter.onBuyClickListener() {
            @Override
            public void onClick(int Position, Coupon coupon) {

            }
        });
        recyclerView.setAdapter(adapter);

    }

}
