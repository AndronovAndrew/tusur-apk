package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.HalfFloat;
import androidx.annotation.RequiresApi;

import com.example.tusurmobile.db.TimeTableOperation;

public class dayRunFriday {
    TimeTableOperation tO;

    public dayRunFriday(Context context){
        tO = new TimeTableOperation(context);
    }
    private class MyRunnableFriday implements Runnable {
        int index;
        Context context;
        Handler handler;

        public MyRunnableFriday(int index, Context context,Handler handler) {
            this.index = index;
            this.context = context;
            this.handler = handler;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            Parser.Insert5(index, tO,handler);
        }
    }

    public void init(Context context,Handler handler) {
        MyRunnableFriday myRunnable1 = new MyRunnableFriday(6,context,handler);
        Thread _secThread1 = new Thread(myRunnable1);
        _secThread1.start();
    }
}
