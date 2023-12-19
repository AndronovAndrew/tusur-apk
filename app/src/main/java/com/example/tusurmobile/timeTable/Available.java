package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.net.ConnectivityManager;

import java.net.InetAddress;

public class Available {
    public boolean isNetworkAvailable(Context c){
        ConnectivityManager connectivityManager = ((ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() !=null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
    public boolean isInternetAvailable(){
        try{
            InetAddress id = InetAddress.getByName("www.google.com");
            return !id.equals("");
        }catch (Exception ex)
        {
            return false;
        }
    }
}

