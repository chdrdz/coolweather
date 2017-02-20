package com.random.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by random on 17/2/17.
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    @SerializedName("sport")
    public Sport sport;

    public class Comfort{

        @SerializedName("txt")
        public String info;
    }

    public class CarWash{

        @SerializedName("txt")
        public String info;
    }
    public class Sport{

        @SerializedName("txt")
        public String info;
    }
}
