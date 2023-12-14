package com.example.tusurmobile.timeTable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.opengl.Visibility;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.tusurmobile.MainActivity;
import com.example.tusurmobile.R;

import java.util.Arrays;

public class Points {

    public void Drow_point(String[] strings,TextView t1,TextView t2,TextView t3,TextView t4,TextView t5,
                           TextView t6,TextView t7){
        int points = 0;
        for(int i=0; i<strings.length;i++) {
            if(strings[i]!= "" && strings[i]!= null){
                points++;
            }
        }
        Switch(points,t1,t2,t3,t4,t5,t6,t7,strings);
    }
    @SuppressLint("ResourceAsColor")
    public void Switch(int points, TextView t1, TextView t2, TextView t3, TextView t4, TextView t5,
                       TextView t6, TextView t7, String[] strings){
        switch (points){
            case (0):
                break;
            case (1):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.INVISIBLE);
                t6.setVisibility(View.INVISIBLE);
                t7.setVisibility(View.INVISIBLE);
                Switch_String(For1(strings),t4);
                break;
            case (2):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.INVISIBLE);
                t6.setVisibility(View.INVISIBLE);
                t7.setVisibility(View.INVISIBLE);
                String[] arr = For(strings);
                Switch_String((arr[0]),t3);
                Switch_String((arr[1]),t4);
                break;
            case (3):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.INVISIBLE);
                t7.setVisibility(View.INVISIBLE);
                String[] arr1 = For(strings);
                Switch_String((arr1[0]),t3);
                Switch_String((arr1[1]),t4);
                Switch_String((arr1[2]),t5);
                break;
            case (4):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.INVISIBLE);
                String[] arr2 = For(strings);
                Switch_String((arr2[0]),t3);
                Switch_String((arr2[1]),t4);
                Switch_String((arr2[2]),t5);
                Switch_String((arr2[3]),t6);
                break;
            case (5):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.INVISIBLE);
                String[] arr3 = For(strings);
                Switch_String((arr3[0]),t2);
                Switch_String((arr3[1]),t3);
                Switch_String((arr3[2]),t4);
                Switch_String((arr3[3]),t5);
                Switch_String((arr3[4]),t6);
                break;
            case (6):
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);
                String[] arr4 = For(strings);
                Switch_String((arr4[0]),t2);
                Switch_String((arr4[1]),t3);
                Switch_String((arr4[2]),t4);
                Switch_String((arr4[3]),t5);
                Switch_String((arr4[4]),t6);
                Switch_String((arr4[4]),t7);
                break;
            case (7):
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);
                String[] arr5 = For(strings);
                Switch_String((arr5[0]),t1);
                Switch_String((arr5[1]),t2);
                Switch_String((arr5[2]),t3);
                Switch_String((arr5[3]),t4);
                Switch_String((arr5[4]),t5);
                Switch_String((arr5[5]),t6);
                Switch_String((arr5[6]),t7);
                break;

        }
    }
    public String For1(String[] strings){
        for(int i = 0 ; i<strings.length;i++){
            if(strings[i]!=null && strings[i]!=""){
                return strings[i];
            }
        }
        return null;
    }
    public String[] For(String[] strings){
        String [] array = new String[strings.length];
        for(int i = 0 , j = 0; i<strings.length;i++){
            if(strings[i]!=null && strings[i]!=""){
                array[j] = strings[i];
                j++;
            }
        }
        return array;
    }
    @SuppressLint("ResourceAsColor")
    public void Switch_String(String string, TextView t){
        switch (string){
            case ("Лекция"):
                t.setTextColor(Color.parseColor("#9FC53A"));;
                break;
            case ("Лабораторная работа"):
                t.setTextColor(Color.parseColor("#652580"));;
                break;
            case ("Практика"):
                t.setTextColor(Color.parseColor("#3BBCD4"));;
                break;
            case ("Курсовая работа"):
                t.setTextColor(Color.parseColor("#ff57f9"));;
                break;
            default: t.setTextColor(Color.parseColor("#FF0000"));;
        }
    }
}
