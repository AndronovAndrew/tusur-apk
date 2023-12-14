package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.tusurmobile.MainActivity;
import com.example.tusurmobile.db.TimeTableOperation;

public class dayRunMonday {
    TimeTableOperation tO;

    public dayRunMonday(Context context){
        tO = new TimeTableOperation(context);
    }
    private class MyRunnable implements Runnable {
        int index;
        Context context;
        Handler handler;

        public MyRunnable(int index, Context context, Handler handler) {
            this.index = index;
            this.context = context;
            this.handler = handler;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            Parser parser = new Parser();
            parser.Insert1(2,tO,handler);
        }
    }
    public void init(Context context, Handler handler) {
        MyRunnable myRunnable1 = new MyRunnable(2, context,handler);
        Thread _secThread1 = new Thread(myRunnable1);
        _secThread1.start();
    }
}
