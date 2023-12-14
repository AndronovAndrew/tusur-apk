package com.example.tusurmobile.timeTable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.tusurmobile.R;

public class Drow {
    TextView _tMon;
    TextView _tTue;
    TextView _tWed;
    TextView _tThu;
    TextView _tFri;
    TextView _tSat;
    Button _monday;
    Button _tuesday;
    Button _wednesday;
    Button _thursday;
    Button _friday;
    Button _saturday;
    int blue;
    int white;
    int black;
    public Drow(int blue, int white,int black,TextView t1,TextView t2,TextView t3,TextView t4,TextView t5,TextView t6,
    Button b1,Button b2,Button b3,Button b4,Button b5,Button b6){
        _tMon = t1;
        _tTue = t2;
        _tWed = t3;
        _tThu = t4;
        _tFri = t5;
        _tSat = t6;
        _monday = b1;
        _tuesday = b2;
        _wednesday = b3;
        _thursday = b4;
        _friday = b5;
        _saturday = b6;
        this.blue = blue;
        this.white = white;
        this.black = black;
    }

    private void Drow_Bcg(){
        _tMon.setBackgroundColor(white);
        _tTue.setBackgroundColor(white);
        _tWed.setBackgroundColor(white);
        _tThu.setBackgroundColor(white);
        _tFri.setBackgroundColor(white);
        _tSat.setBackgroundColor(white);
    }

    private void Button_Drow(int index){
        switch (index){
            case 1:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(white);
                _wednesday.setBackgroundColor(white);
                _thursday.setBackgroundColor(white);
                _friday.setBackgroundColor(white);
                _saturday.setBackgroundColor(white);
                _monday.setBackgroundColor(blue);
                break;
            case 2:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(blue);
                _wednesday.setBackgroundColor(white);
                _thursday.setBackgroundColor(white);
                _friday.setBackgroundColor(white);
                _saturday.setBackgroundColor(white);
                _monday.setBackgroundColor(white);
                break;
            case 3:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(white);
                _wednesday.setBackgroundColor(blue);
                _thursday.setBackgroundColor(white);
                _friday.setBackgroundColor(white);
                _saturday.setBackgroundColor(white);
                _monday.setBackgroundColor(white);
                break;
            case 4:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(white);
                _wednesday.setBackgroundColor(white);
                _thursday.setBackgroundColor(blue);
                _friday.setBackgroundColor(white);
                _saturday.setBackgroundColor(white);
                _monday.setBackgroundColor(white);
                break;
            case 5:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(white);
                _wednesday.setBackgroundColor(white);
                _thursday.setBackgroundColor(white);
                _friday.setBackgroundColor(blue);
                _saturday.setBackgroundColor(white);
                _monday.setBackgroundColor(white);
                break;
            case 6:
                _monday.setBackgroundColor(white);
                _tuesday.setBackgroundColor(white);
                _wednesday.setBackgroundColor(white);
                _thursday.setBackgroundColor(white);
                _friday.setBackgroundColor(white);
                _saturday.setBackgroundColor(blue);
                _monday.setBackgroundColor(white);
                break;
            default: break;
        }
    }

    private void textColor(int index){
        _tMon.setTextColor(black);
        _tTue.setTextColor(black);
        _tWed.setTextColor(black);
        _tThu.setTextColor(black);
        _tFri.setTextColor(black);
        _tSat.setTextColor(black);

        switch (index){
            case 1:
                _tMon.setTextColor(white);
                _tMon.setBackgroundColor(blue);
                break;
            case 2:
                _tTue.setTextColor(white);
                _tTue.setBackgroundColor(blue);
                break;
            case 3:
                _tWed.setTextColor(white);
                _tWed.setBackgroundColor(blue);
                break;
            case 4:
                _tThu.setTextColor(white);
                _tThu.setBackgroundColor(blue);
                break;
            case 5:
                _tFri.setTextColor(white);
                _tFri.setBackgroundColor(blue);
                break;
            case 6:
                _tSat.setTextColor(white);
                _tSat.setBackgroundColor(blue);
                break;
            default:break;
        }

    }
    public void onClick(int index){
        Drow_Bcg();
        Button_Drow(index);
        textColor(index);
    }
}
