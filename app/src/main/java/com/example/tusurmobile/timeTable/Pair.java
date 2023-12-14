package com.example.tusurmobile.timeTable;

import android.util.Log;

import java.util.Arrays;

public class Pair {
    public String[] splitPair(String pair){
        String[] splitPair = new String[4];
        splitPair = pair.split("\n");
        return splitPair;
    }

    public String[] splitPairs(String day){
        try{
        String[] splitPairs = new String[8];
        splitPairs = day.split(",");
        return splitPairs;}
        catch (Exception ignored){

        }
        return null;
    }

//    public String getName(String[] namePair, int pair){
//        try {
//            String[] name = splitPair((namePair[pair]));
//            return name[0];
//        }
//        catch (Exception ignored){
//            return "";
//        }
//    }
    public String getType(String[] dataPair, int pair, int part){
        try {
            String[] type = splitPair((dataPair[pair]));
            return type[part];
        }
        catch (Exception ignored){
            return "";
        }
    }
//    public String getCabinet(String[] namePair, int pair){
//        try{
//        String[] cabinet = splitPair((namePair[pair]));
//        return cabinet[2];
//        }
//        catch (Exception ignored){
//            return "";
//        }
//    }
//    public String getTeacher(String[] namePair, int pair){
//        try {
//            String[] teacher = splitPair((namePair[pair]));
//            return teacher[3];
//        }
//        catch (Exception ignored){
//            return "";
//        }
//    }
}
