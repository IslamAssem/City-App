package com.eltendawy.city.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eltendawy.city.Models.Coupon;
import com.eltendawy.city.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Islam_Assem on 18-09-18.
 */

public class Coupons_recycler_Adapter extends RecyclerView.Adapter<Coupons_recycler_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Coupon>coupons;
    private LayoutInflater inflater;
    private onBuyClickListener onBuyClickListener;
    private onAllDetailsClickListener onAllDetailsClickListener;
    private onFavouriteClickListener onFavouriteClickListener;


    public Coupons_recycler_Adapter(ArrayList<Coupon> coupons, Context context) {
        this.coupons = coupons;
        this.context=context;
        this.inflater =LayoutInflater.from(context);
    }
    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setOnBuyClickListener(Coupons_recycler_Adapter.onBuyClickListener onBuyClickListener) {
        this.onBuyClickListener = onBuyClickListener;
    }

    public void setFavourite(ImageView fav,boolean state)
    {
        if(state)
            fav.setImageResource(R.drawable.favourite_on);
        else
            fav.setImageResource(R.drawable.favourite_off);
    }
    public void setOnAllDetailsClickListener(Coupons_recycler_Adapter.onAllDetailsClickListener onAllDetailsClickListener) {
        this.onAllDetailsClickListener = onAllDetailsClickListener;
    }

    public void setOnFavouriteClickListener(Coupons_recycler_Adapter.onFavouriteClickListener onFavouriteClickListener) {
        this.onFavouriteClickListener = onFavouriteClickListener;
    }
    public void add_Coupon(Coupon coupon)
    {
        if(coupons==null)
            coupons=new ArrayList<>();
        coupons.add(coupon);
    };
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.new_coupon_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(context)
                .load(coupons.get(position).getImage_Path())
                .placeholder(R.drawable.summer_image)
                .error(R.drawable.summer_image)
                .into(holder.image);
        holder.title.setText(coupons.get(position).getTitle());
        if(coupons.get(position).getNote()==null||coupons.get(position).getNote().equals(""))
            holder.note.setVisibility(View.GONE);
        else
            holder.note.setText(coupons.get(position).getNote());
        holder.locations_number.setText(coupons.get(position).getLocationsNumber());
        holder.price_before_discount.setText(coupons.get(position).getPrice_after_discount());
        holder.price_after_discount.setText(coupons.get(position).getPrice_after_discount());
        if(coupons.get(position).isFavourite())
            holder.favButton.setImageResource(R.drawable.favourite_off);
        else
            holder.favButton.setImageResource(R.drawable.favourite_on);
        if(onBuyClickListener!=null)
            holder.buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBuyClickListener.onClick(holder.getAdapterPosition(),coupons.get(holder.getAdapterPosition()));
                }
            });
        if(onAllDetailsClickListener!=null)
            holder.allDetailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAllDetailsClickListener.onClick(holder.getAdapterPosition(),coupons.get(holder.getAdapterPosition()));
                }
            });
        if(onFavouriteClickListener!=null)
            holder.favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFavouriteClickListener.onClick(holder.getAdapterPosition(),coupons.get(holder.getAdapterPosition()),holder.favButton);
                }
            });

    }

    @Override
    public int getItemCount() {
        return coupons==null?0:coupons.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView image;
        ImageView favButton;
        TextView title;
        TextView note;
        TextView locations_number;
        TextView price_before_discount;
        TextView price_after_discount;
        TextView buyButton;
        TextView allDetailsButton;

        ViewHolder(View view) {
            super(view);
            image=view.findViewById(R.id.coupon_image);
            favButton=view.findViewById(R.id.fav_button);
            title=view.findViewById(R.id.coupon_title);
            note=view.findViewById(R.id.coupon_note);
            locations_number=view.findViewById(R.id.locations_number);
            price_before_discount=view.findViewById(R.id.price_before_discount);
            price_after_discount=view.findViewById(R.id.price_after_discount);
            buyButton=view.findViewById(R.id.buy);
            allDetailsButton =view.findViewById(R.id.all_details);

        }

    }

    public interface onBuyClickListener
    {
        void onClick(int Position,Coupon coupon);
    }
    public interface onAllDetailsClickListener
    {
        void onClick(int Position,Coupon coupon);
    }
    public interface onFavouriteClickListener
    {
        void onClick(int Position,Coupon coupon,ImageView view);
    }
}
