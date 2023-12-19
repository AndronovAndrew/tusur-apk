package com.example.tusurmobile;
import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;


import com.example.tusurmobile.db.TimeTableDatabaseHelper;
import com.example.tusurmobile.db.TimeTableOperation;
import com.example.tusurmobile.timeTable.Available;
import com.example.tusurmobile.timeTable.Drow;
import com.example.tusurmobile.timeTable.GetParamsForUrl;
import com.example.tusurmobile.timeTable.Pair;
import com.example.tusurmobile.timeTable.Points;
import com.example.tusurmobile.timeTable.dayRunFriday;
import com.example.tusurmobile.timeTable.dayRunMonday;
import com.example.tusurmobile.timeTable.dayRunSaturday;
import com.example.tusurmobile.timeTable.dayRunThursday;
import com.example.tusurmobile.timeTable.dayRunTuesday;
import com.example.tusurmobile.timeTable.dayRunWednesday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private GestureDetector gestureDetector;
    // Создание GestureDetector
    Button _monday;
    Button _tuesday;
    Button _wednesday;
    Button _thursday;
    Button _friday;
    Button _saturday;
    TextView tvNoPar;
    TextView _tl;
    TextView _tr;

    TextView tm1;
    TextView tm2;
    TextView tm3;
    TextView tm4;
    TextView tm5;
    TextView tm6;
    TextView tm7;
    TextView tm8;
    TextView tm9;
    TextView tm10;
    TextView tm11;
    TextView tm12;
    TextView tm13;
    TextView tm14;
    TextView tm15;
    TextView tm16;
    TextView tm17;
    TextView tm18;
    TextView tm19;
    TextView tm20;
    TextView tm21;
    TextView tm22;
    TextView tm23;
    TextView tm24;
    TextView tm25;
    TextView tm26;
    TextView tm27;
    TextView tm28;
    TextView tm29;
    TextView tm30;
    TextView tm31;
    TextView tm32;
    TextView tm33;
    TextView tm34;
    TextView tm35;
    TextView tm36;
    TextView tm37;
    TextView tm38;
    TextView tm39;
    TextView tm40;
    TextView tm41;
    TextView tm42;
    int Blue;
    int White;
    int Black;
    int back;
    int back_blue;

    int black;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;

    Drow drow;
    dayRunMonday dR1;
    dayRunTuesday dR2;
    dayRunWednesday dR3;
    dayRunThursday dR4;
    dayRunFriday dR5;
    dayRunSaturday dR6;
    String tableNameMonday = "TableMonday";
    String tableNameTuesday = "TableTuesday";
    String tableNameWednesday = "TableWednesday";
    String tableNameThursday = "TableThursday";
    String tableNameFriday = "TableFriday";
    String tableNameSaturday = "TableSaturday";
    String timeTextLesson1 = "08:50 - 10:25";
    String timeTextLesson2 = "10:40 - 12:15";
    String timeTextLesson3 = "13:15 - 14:50";
    String timeTextLesson4 = "15:00 - 16:35";
    String timeTextLesson5 = "16:45 - 18:20";
    String timeTextLesson6 = "18:30 - 20:05";
    String timeTextLesson7 = "20:15 - 21:50";
    Context context;
    Handler handler;
    int count;
    TextView time1;
    TextView time2;
    TextView time3;
    TextView time4;
    TextView time5;
    TextView time6;
    TextView time7;
    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;
    CardView cv5;
    CardView cv6;
    CardView cv7;
    ConstraintLayout cl1;
    ConstraintLayout cl2;
    ConstraintLayout cl3;
    ConstraintLayout cl4;
    ConstraintLayout cl5;
    ConstraintLayout cl6;
    ConstraintLayout cl7;
    TextView t1pair1;
    TextView t1pair2;
    TextView t1pair3;
    TextView t1pair4;
    TextView t1pair5;
    TextView t1pair6;
    TextView t1pair7;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView t1p1;
    TextView t1p2;
    TextView t1p3;
    TextView t1p4;
    TextView t1p5;
    TextView t1p6;
    TextView t1p7;
    TextView t1t1;
    TextView t1t2;
    TextView t1t3;
    TextView t1t4;
    TextView t1t5;
    TextView t1t6;
    TextView t1t7;
    TextView t1c1;
    TextView t1c2;
    TextView t1c3;
    TextView t1c4;
    TextView t1c5;
    TextView t1c6;
    TextView t1c7;
    int countLessons = 0;

    TextView tvTimeMonday;
    TextView tvTimeTuesday;
    TextView tvTimeWednesday;
    TextView tvTimeThursday;
    TextView tvTimeFriday;
    TextView tvTimeSaturday;

    TextView TextView15;

    ScrollView ScrollView;

    ImageView person1;
    ImageView person2;
    ImageView person3;
    ImageView person4;
    ImageView person5;
    ImageView person6;
    ImageView person7;


    int _currentIndexBtn;
    TextView textViewTittle;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Инициализация формы
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTittle = (TextView)findViewById(R.id.textViewTittle);
        gestureDetector = new GestureDetector(this, new MyTouchListener());
        View view = findViewById(R.id.SV);
        textViewTittle.setText("Группа " + GetParamsForUrl.groupTittle);
        // Установка слушателя касаний для вашего View
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


        ScrollView = (ScrollView)findViewById(R.id.SV);
        _monday = (Button)findViewById(R.id.Monday);
        _monday.setOnClickListener(MainActivity.this);
        _tuesday = (Button)findViewById(R.id.Tuesday);
        _tuesday.setOnClickListener(this::tuesday);
        _wednesday = (Button)findViewById(R.id.Wednesday);
        _wednesday.setOnClickListener(this::wednesday);
        _thursday = (Button)findViewById(R.id.Thursday);
        _thursday.setOnClickListener(this::thursday);
        _friday = (Button)findViewById(R.id.Friday);
        _friday.setOnClickListener(this::friday);
        _saturday = (Button)findViewById(R.id.Saturday);
        _saturday.setOnClickListener(this::saturday);
        _currentIndexBtn = 0;
        tvNoPar = (TextView)findViewById(R.id.tvMoPar);

        person1 = (ImageView)findViewById(R.id.person1);
        person2 = (ImageView)findViewById(R.id.person2);
        person3 = (ImageView)findViewById(R.id.person3);
        person4 = (ImageView)findViewById(R.id.person4);
        person5 = (ImageView)findViewById(R.id.person5);
        person6 = (ImageView)findViewById(R.id.person6);
        person7 = (ImageView)findViewById(R.id.person7);

        _tl = (TextView)findViewById(R.id.textView16);
        _tr = (TextView)findViewById(R.id.textView18);
        _tl.setText("<");
        _tr.setText(">");
        t1p1 = (TextView)findViewById(R.id.t1p1);
        t1p2 = (TextView)findViewById(R.id.t1p2);
        t1p3 = (TextView)findViewById(R.id.t1p3);
        t1p4 = (TextView)findViewById(R.id.t1p4);
        t1p5 = (TextView)findViewById(R.id.t1p5);
        t1p6 = (TextView)findViewById(R.id.t1p6);
        t1p7 = (TextView)findViewById(R.id.t1p7);

        t1t1 = (TextView)findViewById(R.id.t1t1);
        t1t2 = (TextView)findViewById(R.id.t1t2);
        t1t3 = (TextView)findViewById(R.id.t1t3);
        t1t4 = (TextView)findViewById(R.id.t1t4);
        t1t5 = (TextView)findViewById(R.id.t1t5);
        t1t6 = (TextView)findViewById(R.id.t1t6);
        t1t7 = (TextView)findViewById(R.id.t1t7);

        t1c1 = (TextView)findViewById(R.id.t1c1);
        t1c2 = (TextView)findViewById(R.id.t1c2);
        t1c3 = (TextView)findViewById(R.id.t1c3);
        t1c4 = (TextView)findViewById(R.id.t1c4);
        t1c5 = (TextView)findViewById(R.id.t1c5);
        t1c6 = (TextView)findViewById(R.id.t1c6);
        t1c7 = (TextView)findViewById(R.id.t1c7);

        tm1 = (TextView)findViewById(R.id.tm1);
        tm2 = (TextView)findViewById(R.id.tm2);
        tm3 = (TextView)findViewById(R.id.tm3);
        tm4 = (TextView)findViewById(R.id.tm4);
        tm5 = (TextView)findViewById(R.id.tm5);
        tm6 = (TextView)findViewById(R.id.tm6);
        tm7 = (TextView)findViewById(R.id.tm7);
        tm8= (TextView)findViewById(R.id.tm8);
        tm9 = (TextView)findViewById(R.id.tm9);
        tm10= (TextView)findViewById(R.id.tm10);
        tm11 = (TextView)findViewById(R.id.tm11);
        tm12 = (TextView)findViewById(R.id.tm12);
        tm13 = (TextView)findViewById(R.id.tm13);
        tm14 = (TextView)findViewById(R.id.tm14);
        tm15 = (TextView)findViewById(R.id.tm15);
        tm16 = (TextView)findViewById(R.id.tm16);
        tm17 = (TextView)findViewById(R.id.tm17);
        tm18 = (TextView)findViewById(R.id.tm18);
        tm19 = (TextView)findViewById(R.id.tm19);
        tm20 = (TextView)findViewById(R.id.tm20);
        tm21 = (TextView)findViewById(R.id.tm21);
        tm22 = (TextView)findViewById(R.id.tm22);
        tm23 = (TextView)findViewById(R.id.tm23);
        tm24 = (TextView)findViewById(R.id.tm24);
        tm25 = (TextView)findViewById(R.id.tm25);
        tm26 = (TextView)findViewById(R.id.tm26);
        tm27 = (TextView)findViewById(R.id.tm27);
        tm28 = (TextView)findViewById(R.id.tm28);
        tm29 = (TextView)findViewById(R.id.tm29);
        tm30 = (TextView)findViewById(R.id.tm30);
        tm31 = (TextView)findViewById(R.id.tm31);
        tm32 = (TextView)findViewById(R.id.tm32);
        tm33 = (TextView)findViewById(R.id.tm33);
        tm34 = (TextView)findViewById(R.id.tm34);
        tm35 = (TextView)findViewById(R.id.tm35);
        tm36 = (TextView)findViewById(R.id.tm36);
        tm37 = (TextView)findViewById(R.id.tm37);
        tm38 = (TextView)findViewById(R.id.tm38);
        tm39 = (TextView)findViewById(R.id.tm39);
        tm40 = (TextView)findViewById(R.id.tm40);
        tm41 = (TextView)findViewById(R.id.tm41);
        tm42 = (TextView)findViewById(R.id.tm42);

        tvTimeMonday = (TextView)findViewById(R.id.tvTimeMonday);
        tvTimeTuesday = (TextView)findViewById(R.id.tvTimeTuesday);
        tvTimeWednesday = (TextView)findViewById(R.id.tvTimeWednesday);
        tvTimeThursday = (TextView)findViewById(R.id.tvTimeThursday);
        tvTimeFriday = (TextView)findViewById(R.id.tvTimeFriday);
        tvTimeSaturday = (TextView)findViewById(R.id.tvTimeSaturday);

        TextView15 = (TextView)findViewById(R.id.textViewMonth);

        cl1 = (ConstraintLayout)findViewById(R.id.constraintLayout1);
        cl2 = (ConstraintLayout)findViewById(R.id.constraintLayout2);
        cl3 = (ConstraintLayout)findViewById(R.id.constraintLayout3);
        cl4 = (ConstraintLayout)findViewById(R.id.constraintLayout4);
        cl5 = (ConstraintLayout)findViewById(R.id.constraintLayout5);
        cl6 = (ConstraintLayout)findViewById(R.id.constraintLayout6);
        cl7 = (ConstraintLayout)findViewById(R.id.constraintLayout7);
        cv1 = (CardView)findViewById(R.id.Cv1);
        cv2 = (CardView)findViewById(R.id.Cv2);
        cv3 = (CardView)findViewById(R.id.Cv3);
        cv4 = (CardView)findViewById(R.id.Cv4);
        cv5 = (CardView)findViewById(R.id.Cv5);
        cv6 = (CardView)findViewById(R.id.Cv6);
        cv7 = (CardView)findViewById(R.id.Cv7);
        Blue = R.color.tusur_blue2;
        White = R.color.white;
        Black = R.color.black;
        back = ContextCompat.getColor(this,White);
        back_blue = ContextCompat.getColor(this,Blue);
        black = ContextCompat.getColor(this,Black);
        t1 = (TextView)findViewById(R.id.tvTimeMonday);
        t2 = (TextView)findViewById(R.id.tvTimeTuesday);
        t3 = (TextView)findViewById(R.id.tvTimeWednesday);
        t4 = (TextView)findViewById(R.id.tvTimeThursday);
        t5 = (TextView)findViewById(R.id.tvTimeFriday);
        t6 = (TextView)findViewById(R.id.tvTimeSaturday);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);
        time1 = (TextView)findViewById(R.id.time1);
        time2 = (TextView)findViewById(R.id.time2);
        time3 = (TextView)findViewById(R.id.time3);
        time4 = (TextView)findViewById(R.id.time4);
        time5 = (TextView)findViewById(R.id.time5);
        time6 = (TextView)findViewById(R.id.time6);
        time7 = (TextView)findViewById(R.id.time7);
        t1pair1 = (TextView)findViewById(R.id.t1pair1);
        t1pair2 = (TextView)findViewById(R.id.t1pair2);
        t1pair3 = (TextView)findViewById(R.id.t1pair3);
        t1pair4 = (TextView)findViewById(R.id.t1pair4);
        t1pair5 = (TextView)findViewById(R.id.t1pair5);
        t1pair6 = (TextView)findViewById(R.id.t1pair6);
        t1pair7 = (TextView)findViewById(R.id.t1pair7);
        tvNoPar.setVisibility(View.GONE);
        ScrollView.setVisibility(View.GONE);
        drow = new Drow(back_blue,back,black,t1,t2,t3,t4,t5,t6,_monday,_tuesday,_wednesday,_thursday,_friday,_saturday);
//        TimeTableDatabaseHelper.dropDb(this);
        context = this;
        TimeTableOperation tO = new TimeTableOperation(this);
        Available available = new Available();
        if (!tO.checkData(GetParamsForUrl.groupTittle,GetParamsForUrl.facultyTittle,"TableMonday") &&
                available.isNetworkAvailable(context)) {
            Log.d("Logcat","Интернет");
            tvNoPar.setVisibility(View.GONE);
            ScrollView.setVisibility(View.GONE);
            tvTimeMonday.setTextColor(R.color.white);
            tvTimeTuesday.setTextColor(R.color.white);
            tvTimeWednesday.setTextColor(R.color.white);
            tvTimeThursday.setTextColor(R.color.white);
            tvTimeFriday.setTextColor(R.color.white);
            tvTimeSaturday.setTextColor(R.color.white);
            isGoneCards();
            Thread firstThread = new Thread(new FirstRunnable());
            firstThread.start();
        }
        else{
            if(tO.checkData(GetParamsForUrl.groupTittle,GetParamsForUrl.facultyTittle,"TableMonday")) {
                Log.d("Logcat","Интернета нет");
                Drow_Points();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tvNoPar.setVisibility(View.GONE);
                    Currentday();
                    ScrollView.setVisibility(View.VISIBLE);
                    dropImages();
                }
            }
            else{
                Intent intent = new Intent(this,FieldsActivity.class);
                startActivity(intent);
            }
        }
        handler = new Handler(){
            @SuppressLint("HandlerLeak")
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 2)
                {
                    Intent intent = new Intent(context,FieldsActivity.class);
                    startActivity(intent);
                }
                count++;
                if (count == 6) {
                    tvNoPar.setVisibility(View.GONE);
                    tvTimeMonday.setTextColor(R.color.black);
                    tvTimeTuesday.setTextColor(R.color.black);
                    tvTimeWednesday.setTextColor(R.color.black);
                    tvTimeThursday.setTextColor(R.color.black);
                    tvTimeFriday.setTextColor(R.color.black);
                    tvTimeSaturday.setTextColor(R.color.black);
                    isNotGoneCards();
                    Drow_Points();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Currentday();
                    }
                    ScrollView.setVisibility(View.VISIBLE);
                    dropImages();
                }

            }
        };
    }
    class MyTouchListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();

            if (Math.abs(distanceX) > Math.abs(distanceY) &&
                    Math.abs(distanceX) > SWIPE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {

                if (distanceX > 0) {
                    if(_currentIndexBtn != 1) {
                        switch (_currentIndexBtn){
                            case 2:
                                onClick(_monday);
                                break;
                            case 3:
                                tuesday(_tuesday);
                                break;
                            case 4:
                                wednesday(_wednesday);
                                break;
                            case 5:
                                thursday(_thursday);
                                break;
                            case 6:
                                friday(_friday);
                                break;
                        }
                    }
                    else
                    {
                        onClick(_monday);
                    }
                }

                if (distanceX < 0) {
                    if(_currentIndexBtn != 6) {
                        switch (_currentIndexBtn){
                            case 2:
                                wednesday(_wednesday);
                                break;
                            case 3:
                                thursday(_thursday);
                                break;
                            case 4:
                                friday(_friday);
                                break;
                            case 5:
                                saturday(_saturday);
                                break;
                            case 1:
                                tuesday(_tuesday);
                                break;
                        }
                    }
                    else
                    {
                        saturday(_saturday);
                    }
                }

            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    public void dropImages(){
        setVisibleImages();
        if(t1t1.getText() == ""){
            person1.setVisibility(View.GONE);
        }
        if(t1t2.getText() == ""){
            person2.setVisibility(View.GONE);
        }
        if(t1t3.getText() == ""){
            person3.setVisibility(View.GONE);
        }
        if(t1t4.getText() == ""){
            person4.setVisibility(View.GONE);
        }
        if(t1t5.getText() == ""){
            person5.setVisibility(View.GONE);
        }
        if(t1t6.getText() == ""){
            person6.setVisibility(View.GONE);
        }
        if(t1t7.getText() == ""){
            person7.setVisibility(View.GONE);
        }
    }
    public void setVisibleImages(){
        person1.setVisibility(View.VISIBLE);
        person2.setVisibility(View.VISIBLE);
        person3.setVisibility(View.VISIBLE);
        person4.setVisibility(View.VISIBLE);
        person5.setVisibility(View.VISIBLE);
        person6.setVisibility(View.VISIBLE);
        person7.setVisibility(View.VISIBLE);
    }

    public int[] GetDateForTextView(){
        LocalDate localDate = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            localDate = LocalDate.now();
        }
        LocalDate monday = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            monday = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        }

        int[] weekOnDays = new int[6];
        for(int i = 0; i<weekOnDays.length;i++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                weekOnDays[i] = monday.plusDays(i).getDayOfMonth();
            }
        }
        return weekOnDays;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Currentday(){
        int [] dates = GetDateForTextView();
        tvTimeMonday.setText(Integer.toString(dates[0]));
        tvTimeTuesday.setText(Integer.toString(dates[1]));
        tvTimeWednesday.setText(Integer.toString(dates[2]));
        tvTimeThursday.setText(Integer.toString(dates[3]));
        tvTimeFriday.setText(Integer.toString(dates[4]));
        tvTimeSaturday.setText(Integer.toString(dates[5]));
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        Calendar calendar = Calendar.getInstance();
        int monthIndex = calendar.get(Calendar.MONTH);
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        String month = months[monthIndex];

        TextView15.setText(month);
        if(dayOfWeek==DayOfWeek.MONDAY){
            drow.onClick(1);
            FinalDrowForOnClick(tableNameMonday,tm1,tm2,tm3,tm4,tm5,tm6,tm7);
            _currentIndexBtn = 1;
        }
        if(dayOfWeek==DayOfWeek.TUESDAY){
            drow.onClick(2);
            FinalDrowForOnClick(tableNameTuesday,tm8,tm9,tm10,tm11,tm12,tm13,tm14);
            _currentIndexBtn = 2;
        }
        if(dayOfWeek==DayOfWeek.WEDNESDAY){
            drow.onClick(3);
            FinalDrowForOnClick(tableNameWednesday,tm15,tm16,tm17,tm18,tm19,tm20,tm21);
            _currentIndexBtn = 3;
        }
        if(dayOfWeek==DayOfWeek.THURSDAY){
            drow.onClick(4);
            FinalDrowForOnClick(tableNameThursday,tm22,tm23,tm24,tm25,tm26,tm27,tm28);
            _currentIndexBtn = 4;
        }
        if(dayOfWeek==DayOfWeek.FRIDAY){
            drow.onClick(5);
            FinalDrowForOnClick(tableNameFriday,tm29,tm30,tm31,tm32,tm33,tm34,tm35);
            _currentIndexBtn = 5;
        }
        if(dayOfWeek==DayOfWeek.SATURDAY){
            drow.onClick(6);
            FinalDrowForOnClick(tableNameSaturday,tm36,tm37,tm38,tm39,tm40,tm41,tm42);
            _currentIndexBtn = 6;
        }
    }

    public void FinalDrowForOnClick(String TableName, TextView tm1,TextView tm2,TextView tm3,
                                    TextView tm4,TextView tm5,TextView tm6,TextView tm7){
        String[] types = new String[7];
        types = Drow_Type(TableName);
        countLessons = count_isNotNull(types);
        Drow_Day(countLessons);
        TimeTableOperation tO = new TimeTableOperation(context);
        tO.open();
        String Lessons = tO.fetchData(TableName,GetParamsForUrl.groupTittle,GetParamsForUrl.facultyTittle);
        FinalDrow(Lessons,tm1,tm2,tm3,tm4,tm5,tm6,tm7,TableName);
        tO.close();
        WritePartsLessons(  tv1,tv2,tv3,tv4,tv5,tv6,tv7,
                t1p1,t1p2,t1p3,t1p4,t1p5,t1p6,t1p7,
                t1t1,t1t2,t1t3,t1t4,t1t5,t1t6,t1t7,
                t1c1,t1c2,t1c3,t1c4,t1c5,t1c6,t1c7,
                TableName,countLessons);
    }
    public void FinalDrow(String Lessons,TextView t1,TextView t2,TextView t3,
                          TextView t4,TextView t5,TextView t6,TextView t7, String TableName){
        Pair pair = new Pair();
        String[] ArrLessons = pair.splitPairs(Lessons);
        boolean[] isLessons = GetBoolsTimeOfLessons(ArrLessons);
        WriteTime(isLessons,countLessons,t1,t2,t3,t4,t5,t6,t7,TableName);
    }

    public void WritePartsLessons(TextView tv1,TextView tv2,TextView tv3,TextView tv4,TextView tv5,TextView tv6,TextView tv7,
                                  TextView t1p1,TextView t1p2,TextView t1p3,TextView t1p4,TextView t1p5,TextView t1p6,TextView t1p7,
                                  TextView t1t1,TextView t1t2,TextView t1t3,TextView t1t4,TextView t1t5,TextView t1t6,TextView t1t7,
                                  TextView t1c1,TextView t1c2,TextView t1c3,TextView t1c4,TextView t1c5,TextView t1c6,TextView t1c7,
                                  String TableName, int countLessons){
        switch (countLessons){
            case 0:
                tvNoPar.setVisibility(View.VISIBLE);
                break;
            case 1:
                String[] notNulltypesOfLessons1 = new String[1];
                notNulltypesOfLessons1 = getTypesArrayStringForTextView(1,TableName,1);
                tv7.setText(notNulltypesOfLessons1[0]);

                String[] notNullnamesOfLessons1 = new String[1];
                notNullnamesOfLessons1 = getTypesArrayStringForTextView(1,TableName,0);
                t1p7.setText(notNullnamesOfLessons1[0]);

                String[] notNullcabsOfLessons1 = new String[1];
                notNullcabsOfLessons1 = getTypesArrayStringForTextView(1,TableName,2);
                t1c7.setText(notNullcabsOfLessons1[0]);

                String[] notNullteachersOfLessons1 = new String[1];
                notNullteachersOfLessons1 = getTypesArrayStringForTextView(1,TableName,3);
                t1t7.setText(notNullteachersOfLessons1[0]);
                break;
            case 2:
                String[] notNulltypesOfLessons2 = new String[2];
                notNulltypesOfLessons2 = getTypesArrayStringForTextView(2,TableName,1);
                tv6.setText(notNulltypesOfLessons2[0]);
                tv7.setText(notNulltypesOfLessons2[1]);

                String[] notNullnamesOfLessons2 = new String[2];
                notNullnamesOfLessons2 = getTypesArrayStringForTextView(2,TableName,0);
                t1p6.setText(notNullnamesOfLessons2[0]);
                t1p7.setText(notNullnamesOfLessons2[1]);

                String[] notNullcabsOfLessons2 = new String[2];
                notNullcabsOfLessons2 = getTypesArrayStringForTextView(2,TableName,2);
                t1c6.setText(notNullcabsOfLessons2[0]);
                t1c7.setText(notNullcabsOfLessons2[1]);

                String[] notNullteachersOfLessons2 = new String[2];
                notNullteachersOfLessons2 = getTypesArrayStringForTextView(2,TableName,3);
                t1t6.setText(notNullteachersOfLessons2[0]);
                t1t7.setText(notNullteachersOfLessons2[1]);
                break;
            case 3:
                String[] notNulltypesOfLessons3 = new String[3];
                notNulltypesOfLessons3 = getTypesArrayStringForTextView(3,TableName,1);
                tv5.setText(notNulltypesOfLessons3[0]);
                tv6.setText(notNulltypesOfLessons3[1]);
                tv7.setText(notNulltypesOfLessons3[2]);

                String[] notNullnamesOfLessons3 = new String[3];
                notNullnamesOfLessons3 = getTypesArrayStringForTextView(3,TableName,0);
                t1p5.setText(notNullnamesOfLessons3[0]);
                t1p6.setText(notNullnamesOfLessons3[1]);
                t1p7.setText(notNullnamesOfLessons3[2]);

                String[] notNullcabsOfLessons3 = new String[3];
                notNullcabsOfLessons3 = getTypesArrayStringForTextView(3,TableName,2);
                t1c5.setText(notNullcabsOfLessons3[0]);
                t1c6.setText(notNullcabsOfLessons3[1]);
                t1c7.setText(notNullcabsOfLessons3[2]);

                String[] notNullteachersOfLessons3 = new String[3];
                notNullteachersOfLessons3 = getTypesArrayStringForTextView(3,TableName,3);
                t1t5.setText(notNullteachersOfLessons3[0]);
                t1t6.setText(notNullteachersOfLessons3[1]);
                t1t7.setText(notNullteachersOfLessons3[2]);
                break;
            case 4:
                String[] notNulltypesOfLessons4 = new String[4];
                notNulltypesOfLessons4 = getTypesArrayStringForTextView(4,TableName,1);
                tv4.setText(notNulltypesOfLessons4[0]);
                tv5.setText(notNulltypesOfLessons4[1]);
                tv6.setText(notNulltypesOfLessons4[2]);
                tv7.setText(notNulltypesOfLessons4[3]);

                String[] notNullnamesOfLessons4 = new String[4];
                notNullnamesOfLessons4 = getTypesArrayStringForTextView(4,TableName,0);
                t1p4.setText(notNullnamesOfLessons4[0]);
                t1p5.setText(notNullnamesOfLessons4[1]);
                t1p6.setText(notNullnamesOfLessons4[2]);
                t1p7.setText(notNullnamesOfLessons4[3]);

                String[] notNullcabsOfLessons4 = new String[4];
                notNullcabsOfLessons4 = getTypesArrayStringForTextView(4,TableName,2);
                t1c4.setText(notNullcabsOfLessons4[0]);
                t1c5.setText(notNullcabsOfLessons4[1]);
                t1c6.setText(notNullcabsOfLessons4[2]);
                t1c7.setText(notNullcabsOfLessons4[3]);

                String[] notNullteachersOfLessons4 = new String[4];
                notNullteachersOfLessons4 = getTypesArrayStringForTextView(4,TableName,3);
                t1t4.setText(notNullteachersOfLessons4[0]);
                t1t5.setText(notNullteachersOfLessons4[1]);
                t1t6.setText(notNullteachersOfLessons4[2]);
                t1t7.setText(notNullteachersOfLessons4[3]);
                break;
            case 5:
                String[] notNulltypesOfLessons5 = new String[5];
                notNulltypesOfLessons5 = getTypesArrayStringForTextView(5,TableName,1);
                tv3.setText(notNulltypesOfLessons5[0]);
                tv4.setText(notNulltypesOfLessons5[1]);
                tv5.setText(notNulltypesOfLessons5[2]);
                tv6.setText(notNulltypesOfLessons5[3]);
                tv7.setText(notNulltypesOfLessons5[4]);

                String[] notNullnamesOfLessons5 = new String[5];
                notNullnamesOfLessons5 = getTypesArrayStringForTextView(5,TableName,0);
                t1p3.setText(notNullnamesOfLessons5[0]);
                t1p4.setText(notNullnamesOfLessons5[1]);
                t1p5.setText(notNullnamesOfLessons5[2]);
                t1p6.setText(notNullnamesOfLessons5[3]);
                t1p7.setText(notNullnamesOfLessons5[4]);

                String[] notNullcabsOfLessons5 = new String[5];
                notNullcabsOfLessons5 = getTypesArrayStringForTextView(5,TableName,2);
                t1c3.setText(notNullcabsOfLessons5[0]);
                t1c4.setText(notNullcabsOfLessons5[1]);
                t1c5.setText(notNullcabsOfLessons5[2]);
                t1c6.setText(notNullcabsOfLessons5[3]);
                t1c7.setText(notNullcabsOfLessons5[4]);

                String[] notNullteachersOfLessons5 = new String[5];
                notNullteachersOfLessons5 = getTypesArrayStringForTextView(5,TableName,3);
                t1t3.setText(notNullteachersOfLessons5[0]);
                t1t4.setText(notNullteachersOfLessons5[1]);
                t1t5.setText(notNullteachersOfLessons5[2]);
                t1t6.setText(notNullteachersOfLessons5[3]);
                t1t7.setText(notNullteachersOfLessons5[4]);
                break;
            case 6:
                String[] notNulltypesOfLessons6 = new String[6];
                notNulltypesOfLessons6 = getTypesArrayStringForTextView(6,TableName,1);
                tv2.setText(notNulltypesOfLessons6[0]);
                tv3.setText(notNulltypesOfLessons6[1]);
                tv4.setText(notNulltypesOfLessons6[2]);
                tv5.setText(notNulltypesOfLessons6[3]);
                tv6.setText(notNulltypesOfLessons6[4]);
                tv7.setText(notNulltypesOfLessons6[5]);

                String[] notNullnamesOfLessons6 = new String[6];
                notNullnamesOfLessons6 = getTypesArrayStringForTextView(6,TableName,0);
                t1p2.setText(notNullnamesOfLessons6[0]);
                t1p3.setText(notNullnamesOfLessons6[1]);
                t1p4.setText(notNullnamesOfLessons6[2]);
                t1p5.setText(notNullnamesOfLessons6[3]);
                t1p6.setText(notNullnamesOfLessons6[4]);
                t1p7.setText(notNullnamesOfLessons6[5]);

                String[] notNullcabsOfLessons6 = new String[6];
                notNullcabsOfLessons6 = getTypesArrayStringForTextView(6,TableName,2);
                t1c2.setText(notNullcabsOfLessons6[0]);
                t1c3.setText(notNullcabsOfLessons6[1]);
                t1c4.setText(notNullcabsOfLessons6[2]);
                t1c5.setText(notNullcabsOfLessons6[3]);
                t1c6.setText(notNullcabsOfLessons6[4]);
                t1c7.setText(notNullcabsOfLessons6[5]);

                String[] notNullteachersOfLessons6 = new String[6];
                notNullteachersOfLessons6 = getTypesArrayStringForTextView(6,TableName,3);
                t1t2.setText(notNullteachersOfLessons6[0]);
                t1t3.setText(notNullteachersOfLessons6[1]);
                t1t4.setText(notNullteachersOfLessons6[2]);
                t1t5.setText(notNullteachersOfLessons6[3]);
                t1t6.setText(notNullteachersOfLessons6[4]);
                t1t7.setText(notNullteachersOfLessons6[5]);
                break;
            case 7:
                String[] notNulltypesOfLessons7 = new String[7];
                notNulltypesOfLessons7 = getTypesArrayStringForTextView(7,TableName,1);
                tv1.setText(notNulltypesOfLessons7[0]);
                tv2.setText(notNulltypesOfLessons7[1]);
                tv3.setText(notNulltypesOfLessons7[2]);
                tv4.setText(notNulltypesOfLessons7[3]);
                tv5.setText(notNulltypesOfLessons7[4]);
                tv6.setText(notNulltypesOfLessons7[5]);
                tv7.setText(notNulltypesOfLessons7[6]);

                String[] notNullnamesOfLessons7 = new String[7];
                notNullnamesOfLessons7 = getTypesArrayStringForTextView(7,TableName,0);
                t1p1.setText(notNullnamesOfLessons7[0]);
                t1p2.setText(notNullnamesOfLessons7[1]);
                t1p3.setText(notNullnamesOfLessons7[2]);
                t1p4.setText(notNullnamesOfLessons7[3]);
                t1p5.setText(notNullnamesOfLessons7[4]);
                t1p6.setText(notNullnamesOfLessons7[5]);
                t1p7.setText(notNullnamesOfLessons7[6]);

                String[] notNullcabsOfLessons7 = new String[7];
                notNullcabsOfLessons7 = getTypesArrayStringForTextView(7,TableName,2);
                t1c1.setText(notNullcabsOfLessons7[0]);
                t1c2.setText(notNullcabsOfLessons7[1]);
                t1c3.setText(notNullcabsOfLessons7[2]);
                t1c4.setText(notNullcabsOfLessons7[3]);
                t1c5.setText(notNullcabsOfLessons7[4]);
                t1c6.setText(notNullcabsOfLessons7[5]);
                t1c7.setText(notNullcabsOfLessons7[6]);

                String[] notNullteachersOfLessons7 = new String[7];
                notNullteachersOfLessons7 = getTypesArrayStringForTextView(7,TableName,3);
                t1t1.setText(notNullteachersOfLessons7[0]);
                t1t2.setText(notNullteachersOfLessons7[1]);
                t1t3.setText(notNullteachersOfLessons7[2]);
                t1t4.setText(notNullteachersOfLessons7[3]);
                t1t5.setText(notNullteachersOfLessons7[4]);
                t1t6.setText(notNullteachersOfLessons7[5]);
                t1t7.setText(notNullteachersOfLessons7[6]);
                break;
            default:
                break;
        }
    }

    public String[] getTypesArrayStringForTextView(int len,String TableName,int part){
        int count = 0;
        String[] notNulltypesOfLessons = new String[len];
        String[] types_lessons = (Part(TableName,part));
        for(int i = 0; i < types_lessons.length;i++){
            if(types_lessons[i]!=null)
            {
                notNulltypesOfLessons[count] = types_lessons[i];
                count++;
            }
        }
        return notNulltypesOfLessons;
    }

    public void WriteTime(boolean[] isLessons, int countLessons,TextView t1,TextView t2,TextView t3,
                          TextView t4,TextView t5,TextView t6,TextView t7,String TableName){
        int j = 0;
        switch (countLessons){
            case 0:
                tvNoPar.setVisibility(View.VISIBLE);
                break;
            case 1:
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        time7.setText(switchTimeText(i));
                        t1pair7.setText("  "+Integer.toString((i+1)));
                        tv7.setBackgroundColor(t4.getCurrentTextColor());
                    }
                }
                int count1 = 0;
                String[] notNulltypesOfLessons1 = new String[1];
                String[] types_lessons1 = (Part(TableName,1));
                for(int i = 0; i< types_lessons1.length;i++){
                    if(types_lessons1[i]!=null){
                        notNulltypesOfLessons1[count1] = types_lessons1[i];
                        count1++;
                    }
                }
                tv7.setText(notNulltypesOfLessons1[0]);
                break;
            case 2:
                int[] indexes2 = new int[2];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes2[j] = i;
                        j++;
                    }
                }
                tv6.setBackgroundColor(t3.getCurrentTextColor());
                tv7.setBackgroundColor(t4.getCurrentTextColor());
                time6.setText(switchTimeText(indexes2[0]));
                time7.setText(switchTimeText(indexes2[1]));
                t1pair6.setText("  "+Integer.toString(indexes2[0]+1));
                t1pair7.setText("  "+Integer.toString(indexes2[1]+1));
                int count2 = 0;
                String[] notNulltypesOfLessons2 = new String[2];
                String[] types_lessons2 = (Part(TableName,1));
                for(int i = 0; i< types_lessons2.length;i++){
                    if(types_lessons2[i]!=null){
                        notNulltypesOfLessons2[count2] = types_lessons2[i];
                        count2++;
                    }
                }
                tv6.setText(notNulltypesOfLessons2[0]);
                tv7.setText(notNulltypesOfLessons2[1]);
                break;
            case 3:
                int[] indexes3 = new int[3];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes3[j] = i;
                        j++;
                    }
                }
                tv5.setBackgroundColor(t3.getCurrentTextColor());
                tv6.setBackgroundColor(t4.getCurrentTextColor());
                tv7.setBackgroundColor(t5.getCurrentTextColor());
                t1pair5.setText("  "+Integer.toString(indexes3[0]+1));
                t1pair6.setText("  "+Integer.toString(indexes3[1]+1));
                t1pair7.setText("  "+Integer.toString(indexes3[2]+1));
                time5.setText(switchTimeText(indexes3[0]));
                time6.setText(switchTimeText(indexes3[1]));
                time7.setText(switchTimeText(indexes3[2]));
                int count3 = 0;
                String[] notNulltypesOfLessons3 = new String[3];
                String[] types_lessons3 = (Part(TableName,1));
                for(int i = 0; i< types_lessons3.length;i++){
                    if(types_lessons3[i]!=null){
                        notNulltypesOfLessons3[count3] = types_lessons3[i];
                        count3++;
                    }
                }
                tv5.setText(notNulltypesOfLessons3[0]);
                tv6.setText(notNulltypesOfLessons3[1]);
                tv7.setText(notNulltypesOfLessons3[2]);
                break;
            case 4:
                int[] indexes4 = new int[4];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes4[j] = i;
                        j++;
                    }
                }
                tv4.setBackgroundColor(t3.getCurrentTextColor());
                tv5.setBackgroundColor(t4.getCurrentTextColor());
                tv6.setBackgroundColor(t5.getCurrentTextColor());
                tv7.setBackgroundColor(t6.getCurrentTextColor());
                t1pair4.setText("  "+Integer.toString(indexes4[0]+1));
                t1pair5.setText("  "+Integer.toString(indexes4[1]+1));
                t1pair6.setText("  "+Integer.toString(indexes4[2]+1));
                t1pair7.setText("  "+Integer.toString(indexes4[3]+1));
                time4.setText(switchTimeText(indexes4[0]));
                time5.setText(switchTimeText(indexes4[1]));
                time6.setText(switchTimeText(indexes4[2]));
                time7.setText(switchTimeText(indexes4[3]));
                int count4 = 0;
                String[] notNulltypesOfLessons4 = new String[4];
                String[] types_lessons4 = (Part(TableName,1));
                for(int i = 0; i< types_lessons4.length;i++){
                    if(types_lessons4[i]!=null){
                        notNulltypesOfLessons4[count4] = types_lessons4[i];
                        count4++;
                    }
                }
                tv4.setText(notNulltypesOfLessons4[0]);
                tv5.setText(notNulltypesOfLessons4[1]);
                tv6.setText(notNulltypesOfLessons4[2]);
                tv7.setText(notNulltypesOfLessons4[3]);
                break;
            case 5:
                int[] indexes5 = new int[5];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes5[j] = i;
                        j++;
                    }
                }
                tv3.setBackgroundColor(t2.getCurrentTextColor());
                tv4.setBackgroundColor(t3.getCurrentTextColor());
                tv5.setBackgroundColor(t4.getCurrentTextColor());
                tv6.setBackgroundColor(t5.getCurrentTextColor());
                tv7.setBackgroundColor(t6.getCurrentTextColor());
                t1pair3.setText("  "+Integer.toString(indexes5[0]+1));
                t1pair4.setText("  "+Integer.toString(indexes5[1]+1));
                t1pair5.setText("  "+Integer.toString(indexes5[2]+1));
                t1pair6.setText("  "+Integer.toString(indexes5[3]+1));
                t1pair7.setText("  "+Integer.toString(indexes5[4]+1));
                time3.setText(switchTimeText(indexes5[0]));
                time4.setText(switchTimeText(indexes5[1]));
                time5.setText(switchTimeText(indexes5[2]));
                time6.setText(switchTimeText(indexes5[3]));
                time7.setText(switchTimeText(indexes5[4]));
                int count5 = 0;
                String[] notNulltypesOfLessons5 = new String[5];
                String[] types_lessons5 = (Part(TableName,1));
                for(int i = 0; i< types_lessons5.length;i++){
                    if(types_lessons5[i]!=null){
                        notNulltypesOfLessons5[count5] = types_lessons5[i];
                        count5++;
                    }
                }
                tv3.setText(notNulltypesOfLessons5[0]);
                tv4.setText(notNulltypesOfLessons5[1]);
                tv5.setText(notNulltypesOfLessons5[2]);
                tv6.setText(notNulltypesOfLessons5[3]);
                tv7.setText(notNulltypesOfLessons5[4]);
                break;
            case 6:
                int[] indexes6 = new int[6];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes6[j] = i;
                        j++;
                    }
                }
                tv2.setBackgroundColor(t2.getCurrentTextColor());
                tv3.setBackgroundColor(t3.getCurrentTextColor());
                tv4.setBackgroundColor(t4.getCurrentTextColor());
                tv5.setBackgroundColor(t5.getCurrentTextColor());
                tv6.setBackgroundColor(t6.getCurrentTextColor());
                tv7.setBackgroundColor(t7.getCurrentTextColor());
                t1pair2.setText("  "+Integer.toString(indexes6[0]+1));
                t1pair3.setText("  "+Integer.toString(indexes6[1]+1));
                t1pair4.setText("  "+Integer.toString(indexes6[2]+1));
                t1pair5.setText("  "+Integer.toString(indexes6[3]+1));
                t1pair6.setText("  "+Integer.toString(indexes6[4]+1));
                t1pair7.setText("  "+Integer.toString(indexes6[5]+1));
                time2.setText(switchTimeText(indexes6[0]));
                time3.setText(switchTimeText(indexes6[1]));
                time4.setText(switchTimeText(indexes6[2]));
                time5.setText(switchTimeText(indexes6[3]));
                time6.setText(switchTimeText(indexes6[4]));
                time7.setText(switchTimeText(indexes6[5]));
                int count6 = 0;
                String[] notNulltypesOfLessons6 = new String[6];
                String[] types_lessons6 = (Part(TableName,1));
                for(int i = 0; i< types_lessons6.length;i++){
                    if(types_lessons6[i]!=null){
                        notNulltypesOfLessons6[count6] = types_lessons6[i];
                        count6++;
                    }
                }
                tv2.setText(notNulltypesOfLessons6[0]);
                tv3.setText(notNulltypesOfLessons6[1]);
                tv4.setText(notNulltypesOfLessons6[2]);
                tv5.setText(notNulltypesOfLessons6[3]);
                tv6.setText(notNulltypesOfLessons6[4]);
                tv7.setText(notNulltypesOfLessons6[5]);
                break;
            case 7:
                int[] indexes7 = new int[7];
                for(int i=0 ; i<isLessons.length; i++){
                    if(isLessons[i] == true){
                        indexes7[j] = i;
                        j++;
                    }
                }
                tv1.setBackgroundColor(t1.getCurrentTextColor());
                tv2.setBackgroundColor(t2.getCurrentTextColor());
                tv3.setBackgroundColor(t3.getCurrentTextColor());
                tv4.setBackgroundColor(t4.getCurrentTextColor());
                tv5.setBackgroundColor(t5.getCurrentTextColor());
                tv6.setBackgroundColor(t6.getCurrentTextColor());
                tv7.setBackgroundColor(t7.getCurrentTextColor());
                t1pair1.setText("  "+Integer.toString(indexes7[0]+1));
                t1pair2.setText("  "+Integer.toString(indexes7[1]+1));
                t1pair3.setText("  "+Integer.toString(indexes7[2]+1));
                t1pair4.setText("  "+Integer.toString(indexes7[3]+1));
                t1pair5.setText("  "+Integer.toString(indexes7[4]+1));
                t1pair6.setText("  "+Integer.toString(indexes7[5]+1));
                t1pair7.setText("  "+Integer.toString(indexes7[6]+1));
                time1.setText(switchTimeText(indexes7[0]));
                time2.setText(switchTimeText(indexes7[1]));
                time3.setText(switchTimeText(indexes7[2]));
                time4.setText(switchTimeText(indexes7[3]));
                time5.setText(switchTimeText(indexes7[4]));
                time6.setText(switchTimeText(indexes7[5]));
                time7.setText(switchTimeText(indexes7[6]));
                int count7 = 0;
                String[] notNulltypesOfLessons7 = new String[7];
                String[] types_lessons7 = (Part(TableName,1));
                for(int i = 0; i< types_lessons7.length;i++){
                    if(types_lessons7[i]!=null){
                        notNulltypesOfLessons7[count7] = types_lessons7[i];
                        count7++;
                    }
                }
                tv1.setText(notNulltypesOfLessons7[0]);
                tv2.setText(notNulltypesOfLessons7[1]);
                tv3.setText(notNulltypesOfLessons7[2]);
                tv4.setText(notNulltypesOfLessons7[3]);
                tv5.setText(notNulltypesOfLessons7[4]);
                tv6.setText(notNulltypesOfLessons7[5]);
                tv7.setText(notNulltypesOfLessons7[6]);
                break;
            default:
                break;
        }
    }

    public String switchTimeText(int index){
        switch (index){
            case 0:
                return timeTextLesson1;
            case 1:
                return timeTextLesson2;
            case 2:
                return timeTextLesson3;
            case 3:
                return timeTextLesson4;
            case 4:
                return timeTextLesson5;
            case 5:
                return timeTextLesson6;
            case 6:
                return timeTextLesson7;
            default: return null;
        }
    }
    public boolean[] GetBoolsTimeOfLessons(String[] lessons){
        boolean[] booleans = new boolean[7];
        for (int i = 1; i<lessons.length;i++){
            if(lessons[i].contains("\n")){
                booleans[i-1] = true;
            }
            else
            {
                booleans[i-1] = false;
            }
        }
        return booleans;
    }
    class FirstRunnable implements Runnable{

        @Override
        public void run() {
            Log.d("Logcat","1");
            dR1 = new dayRunMonday(context);
            dR1.init(context,handler);
            dR2 = new dayRunTuesday(context);
            dR2.init(context,handler);
            dR3 = new dayRunWednesday(context);
            dR3.init(context,handler);
            dR4= new dayRunThursday(context);
            dR4.init(context,handler);
            dR5 = new dayRunFriday(context);
            dR5.init(context,handler);
            dR6 = new dayRunSaturday(context);
            dR6.init(context,handler);

        }
    }
    public void Drow_Points(){
        Log.d("Logcat","2");
        String[] tMonday = Type(tableNameMonday,1);
        String[] tTuesday= Type(tableNameTuesday,1);
        String[] tWednesday = Type(tableNameWednesday,1);
        String[] tThursday = Type(tableNameThursday,1);
        String[] tFriday = Type(tableNameFriday,1);
        String[] tSaturday = Type(tableNameSaturday,1);
        Points points = new Points();
        points.Drow_point(tMonday,tm1,tm2,tm3,tm4,tm5,tm6,tm7);
        points.Drow_point(tTuesday,tm8,tm9,tm10,tm11,tm12,tm13,tm14);
        points.Drow_point(tWednesday,tm15,tm16,tm17,tm18,tm19,tm20,tm21);
        points.Drow_point(tThursday,tm22,tm23,tm24,tm25,tm26,tm27,tm28);
        points.Drow_point(tFriday,tm29,tm30,tm31,tm32,tm33,tm34,tm35);
        points.Drow_point(tSaturday,tm36,tm37,tm38,tm39,tm40,tm41,tm42);
    }
    public String[] Drow_Type(String tablename){
        String[] type_pairs = Type(tablename, 1);
        return type_pairs;
    }
    public String[] Part(String tablename, int part){
        String[] type_pairs = Type(tablename, part);
        return type_pairs;
    }

    public int count_isNotNull(String[] strings){
        int count = 0;
        for(int i = 0; i<strings.length;i++){
            if(strings[i] != null){
                count++;
            }
        }
        return count;
    }

    public void Drow_Day(int count){
        switch (count){
            case 0:
                cv7.setVisibility(View.GONE);
                cv6.setVisibility(View.GONE);
                cv5.setVisibility(View.GONE);
                cv4.setVisibility(View.GONE);
                cv3.setVisibility(View.GONE);
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl7.setVisibility(View.GONE);
                cl6.setVisibility(View.GONE);
                cl5.setVisibility(View.GONE);
                cl4.setVisibility(View.GONE);
                cl3.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 1:
                cv6.setVisibility(View.GONE);
                cv5.setVisibility(View.GONE);
                cv4.setVisibility(View.GONE);
                cv3.setVisibility(View.GONE);
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl6.setVisibility(View.GONE);
                cl5.setVisibility(View.GONE);
                cl4.setVisibility(View.GONE);
                cl3.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 2:
                cv5.setVisibility(View.GONE);
                cv4.setVisibility(View.GONE);
                cv3.setVisibility(View.GONE);
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl5.setVisibility(View.GONE);
                cl4.setVisibility(View.GONE);
                cl3.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 3:
                cv4.setVisibility(View.GONE);
                cv3.setVisibility(View.GONE);
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl4.setVisibility(View.GONE);
                cl3.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 4:
                cv3.setVisibility(View.GONE);
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl3.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);

                break;
            case 5:
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.GONE);
                cl2.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 6:
                cv1.setVisibility(View.GONE);
                cl1.setVisibility(View.GONE);
                break;
            case 7:
                break;
        }
    }

    public String[] Type(String tableName, int part){
        String[] type = new String[7];
        TimeTableOperation tO = new TimeTableOperation(this);
        tO.open();
        String data = tO.fetchData(tableName,GetParamsForUrl.groupTittle,GetParamsForUrl.facultyTittle);
        for(int i=1, j = 0; i<8;i++){
            if(GetPart(i,1,data) != "")
                type[j] = GetPart(i,part,data);
            j++;
        }
        tO.close();
        return type;
    }

    private String GetPart(int indexPair, int part, String data){
        Pair pair = new Pair();
        String[] dataDay = pair.splitPairs(data);
        String types = pair.getType(dataDay,indexPair,part);
        String type = pair.splitPair(types)[0];
        return type;
    }
    public void isNotGoneCards(){
        cv7.setVisibility(View.VISIBLE);
        cv6.setVisibility(View.VISIBLE);
        cv5.setVisibility(View.VISIBLE);
        cv4.setVisibility(View.VISIBLE);
        cv3.setVisibility(View.VISIBLE);
        cv2.setVisibility(View.VISIBLE);
        cv1.setVisibility(View.VISIBLE);
        cl7.setVisibility(View.VISIBLE);
        cl6.setVisibility(View.VISIBLE);
        cl5.setVisibility(View.VISIBLE);
        cl4.setVisibility(View.VISIBLE);
        cl3.setVisibility(View.VISIBLE);
        cl2.setVisibility(View.VISIBLE);
        cl1.setVisibility(View.VISIBLE);
    }
    public void isGoneCards(){
        cv7.setVisibility(View.GONE);
        cv6.setVisibility(View.GONE);
        cv5.setVisibility(View.GONE);
        cv4.setVisibility(View.GONE);
        cv3.setVisibility(View.GONE);
        cv2.setVisibility(View.GONE);
        cv1.setVisibility(View.GONE);
        cl7.setVisibility(View.GONE);
        cl6.setVisibility(View.GONE);
        cl5.setVisibility(View.GONE);
        cl4.setVisibility(View.GONE);
        cl3.setVisibility(View.GONE);
        cl2.setVisibility(View.GONE);
        cl1.setVisibility(View.GONE);
    }
    @Override
    public void onClick(View view) {
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(1);
        FinalDrowForOnClick(tableNameMonday,tm1,tm2,tm3,tm4,tm5,tm6,tm7);
        dropImages();
        _currentIndexBtn = 1;
    }

    public void tuesday(View view){
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(2);
        FinalDrowForOnClick(tableNameTuesday,tm8,tm9,tm10,tm11,tm12,tm13,tm14);
        dropImages();
        _currentIndexBtn = 2;
    }
    public void wednesday(View view){
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(3);
        FinalDrowForOnClick(tableNameWednesday,tm15,tm16,tm17,tm18,tm19,tm20,tm21);
        dropImages();
        _currentIndexBtn = 3;
    }
    public void thursday(View view){
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(4);
        FinalDrowForOnClick(tableNameThursday,tm22,tm23,tm24,tm25,tm26,tm27,tm28);
        dropImages();
        _currentIndexBtn = 4;
    }
    public void friday(View view){
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(5);
        FinalDrowForOnClick(tableNameFriday,tm29,tm30,tm31,tm32,tm33,tm34,tm35);
        dropImages();
        _currentIndexBtn = 5;
    }
    public void saturday(View view){
        tvNoPar.setVisibility(View.GONE);
        setVisibleImages();
        isNotGoneCards();
        drow.onClick(6);
        FinalDrowForOnClick(tableNameSaturday,tm36,tm37,tm38,tm39,tm40,tm41,tm42);
        dropImages();
        _currentIndexBtn = 6;
    }
}