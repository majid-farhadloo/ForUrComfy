package com.example.majid.forurcomfy.Sample;

/**
 * Created by farha on 3/11/2018.
 */

public class SampleRestaurantItem {
    private static final SampleRestaurantItem ourInstance = new SampleRestaurantItem();

    public static SampleRestaurantItem getInstance() {
        return ourInstance;
    }

    private SampleRestaurantItem() {
    }
}
