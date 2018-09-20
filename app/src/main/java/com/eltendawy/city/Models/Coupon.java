package com.eltendawy.city.Models;

import java.util.ArrayList;

public class Coupon {
    private int _ID;
    private String Title;
    private String Image_Path;
    private String Note;
    private String Price_before_discount;
    private String Price_after_discount;
    private ArrayList<String>Locations;
    private boolean IsFavourite;

    public Coupon(String title, String price_before_discount, String price_after_discount) {
        Title = title;
        Price_before_discount = price_before_discount;
        Price_after_discount = price_after_discount;
    }

    public Coupon(String title, String image_Path, String note, String price_before_discount, String price_after_discount, ArrayList<String> locations) {
        Title = title;
        Image_Path = image_Path;
        Note = note;
        Price_before_discount = price_before_discount;
        Price_after_discount = price_after_discount;
        Locations = locations;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage_Path() {
        return Image_Path;
    }

    public void setImage_Path(String image_Path) {
        Image_Path = image_Path;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getPrice_before_discount() {
        return Price_before_discount;
    }

    public void setPrice_before_discount(String price_before_discount) {
        Price_before_discount = price_before_discount;
    }

    public String getPrice_after_discount() {
        return Price_after_discount;
    }

    public void setPrice_after_discount(String price_after_discount) {
        Price_after_discount = price_after_discount;
    }

    public ArrayList<String> getLocations() {
        return Locations;
    }

    public void setLocations(ArrayList<String> locations) {
        Locations = locations;
    }

    public boolean isFavourite() {
        return IsFavourite;
    }

    public void setFavourite(boolean favourite) {
        IsFavourite = favourite;
    }

    public void add_Location(String Location)
    {
        if(Locations==null)
            Locations=new ArrayList<String>();
        Locations.add(Location);
    }
    public int get_number_of_locations()
    {
        return Locations==null||Locations.isEmpty()?0:Locations.size();
    }

    public String getLocationsNumber() {
        return Locations==null?"0":String.valueOf(Locations.size());
    }
}

