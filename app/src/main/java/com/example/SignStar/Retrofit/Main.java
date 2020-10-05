package com.example.SignStar.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {


    @SerializedName("ascendant")
    String ascendant;

    @SerializedName("Varna")
    String Varna;

    @SerializedName("Vashya")
    String Vashya;


    public String getName() {
        return ascendant;
    }

    public void setName(String name) {
        this.ascendant = name;
    }

    public String getSignLord() {
        return Varna;
    }

    public void setSignLord(String signLord) {
        this.Varna = signLord;
    }

    public String getSign() {
        return Vashya;
    }

    public void setSign(String sign) {
        this.Vashya = sign;
    }
}


