package ca.ucalgary.farmersmarketapp;

import java.util.ArrayList;

/**
 * Created by Whoosp on 2016-11-26.
 */

public class favoriteScreens {
    ArrayList <String> favorites = new ArrayList<String>();

    public void addFavorites (String s){
        favorites.add(s);
    }

    public ArrayList<String> getFavorites (){
        return favorites;
    }
}
