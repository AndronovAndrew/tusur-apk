package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import com.example.tusurmobile.db.TimeTableOperation;

public class dayRunSaturday {
    TimeTableOperation tO;

    public dayRunSaturday(Context context){
        tO = new TimeTableOperation(context);
    }
    private class MyRunnableSaturday implements Runnable {
        int index;
        Context context;
        Handler handler;

        public MyRunnableSaturday(int index, Context context, Handler handler) {
            this.index = index;
            this.context = context;
            this.handler = handler;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            Parser.Insert6(index, tO,handler);
        }
    }

    public void init(Context context, Handler handler) {
        MyRunnableSaturday myRunnable1 = new MyRunnableSaturday(7,context,handler);
        Thread _secThread1 = new Thread(myRunnable1);
        _secThread1.start();
    }
}
