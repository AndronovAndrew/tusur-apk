package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import com.example.tusurmobile.db.TimeTableOperation;

public class dayRunThursday {
    TimeTableOperation tO;

    public dayRunThursday(Context context){
        tO = new TimeTableOperation(context);
    }
    private class MyRunnableThursday implements Runnable {
        int index;
        Context context;
        Handler handler;

        public MyRunnableThursday(int index, Context context,Handler handler) {
            this.index = index;
            this.context = context;
            this.handler = handler;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            Parser parser = new Parser();
            parser.Insert4(index, tO,handler);
        }
    }

    public void init(Context context, Handler handler) {
        MyRunnableThursday myRunnable1 = new MyRunnableThursday(5,context,handler);
        Thread _secThread1 = new Thread(myRunnable1);
        _secThread1.start();
    }
}
