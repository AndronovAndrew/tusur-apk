package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import com.example.tusurmobile.db.TimeTableOperation;

public class dayRunTuesday {
    TimeTableOperation tO;

    public dayRunTuesday(Context context){
        tO = new TimeTableOperation(context);
    }
    private class MyRunnableTuesday implements Runnable {
        int index;
        Context context;
        Handler handler;

        public MyRunnableTuesday(int index, Context context,Handler handler) {
            this.index = index;
            this.context = context;
            this.handler = handler;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            Parser.Insert2(index, tO, handler);
        }
    }

    public void init(Context context, Handler handler) {
        MyRunnableTuesday myRunnable1 = new MyRunnableTuesday(3,context,handler);
        Thread _secThread1 = new Thread(myRunnable1);
        _secThread1.start();
    }
}
