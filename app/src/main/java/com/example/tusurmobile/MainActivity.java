package com.example.tusurmobile;
import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Observable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.example.tusurmobile.db.DataBaseFriday;
import com.example.tusurmobile.db.DataBaseMonday;
import com.example.tusurmobile.db.DataBaseSaturday;
import com.example.tusurmobile.db.DataBaseThursday;
import com.example.tusurmobile.db.DataBaseTuesday;
import com.example.tusurmobile.db.DataBaseWednesday;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button _monday;
    Button _tuesday;
    Button _wednesday;
    Button _thursday;
    Button _friday;
    Button _saturday;
    ProgressBar _progressBar;
    private int latch = 0;
    @SuppressLint({"WrongThread", "StaticFieldLeak", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) { // Инициализация формы
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDate();
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
        _progressBar = (ProgressBar)findViewById(R.id.progressBar);
        _progressBar.setAlpha(0);
            init_monday();
            init_tuesday();
            init_wednesday();
            init_thursday();
            init_friday();
            init_Saturday();
    }

    private boolean isNetworkAvailable(Context c){
        ConnectivityManager connectivityManager = ((ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() !=null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
    private boolean isInternetAvailable(){
        try{
            InetAddress id = InetAddress.getByName("www.google.com");
            return !id.equals("");
        }catch (Exception ex)
        {
            return false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Currentday(){
        int Green = R.color.tusur_green;
        int back = ContextCompat.getColor(this,Green);
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        if(dayOfWeek==DayOfWeek.MONDAY){
            _monday.setBackgroundColor(back);
            GetMonday();
        }
        if(dayOfWeek==DayOfWeek.TUESDAY){
            _tuesday.setBackgroundColor(back);
            GetTuesday();
        }
        if(dayOfWeek==DayOfWeek.WEDNESDAY){
            _wednesday.setBackgroundColor(back);
            GetWednesday();
        }
        if(dayOfWeek==DayOfWeek.THURSDAY){
            _thursday.setBackgroundColor(back);
            GetThursday();
        }
        if(dayOfWeek==DayOfWeek.FRIDAY){
            _friday.setBackgroundColor(back);
            GetFriday();
        }
        if(dayOfWeek==DayOfWeek.SATURDAY){
            _saturday.setBackgroundColor(back);
            GetSaturday();
        }
    }
    public class MyRunnableMonday implements Runnable {
       @RequiresApi(api = Build.VERSION_CODES.O)
       @Override
        public void run(){
           Insert_To_Monday();
       }
    }
    public class MyRunnableTuesday implements Runnable {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run(){
            Insert_To_Tuesday();
        }
    }
    public class MyRunnableWednesday implements Runnable {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run(){
            Insert_To_Wednesday();
        }
    }
    public class MyRunnableThursday implements Runnable {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run(){
            Insert_To_Thursday();
        }
    }
    public class MyRunnableFriday implements Runnable {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run(){
            Insert_To_Friday();
        }
    }
    public class MyRunnableSaturday implements Runnable {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run(){
            Insert_To_Saturday();
        }
    }
    private void init_monday(){
        MyRunnableMonday myRunnable = new MyRunnableMonday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void init_tuesday(){
        MyRunnableTuesday myRunnable = new MyRunnableTuesday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void init_wednesday(){
        MyRunnableWednesday myRunnable = new MyRunnableWednesday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void init_thursday(){
        MyRunnableThursday myRunnable = new MyRunnableThursday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void init_friday(){
        MyRunnableFriday myRunnable = new MyRunnableFriday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void init_Saturday(){
        MyRunnableSaturday myRunnable = new MyRunnableSaturday();
        Thread _secThread = new Thread(myRunnable);
        _secThread.start();
    }
    private void Btn_Vis(){
        _monday.setClickable(true);
        _tuesday.setClickable(true);
        _wednesday.setClickable(true);
        _thursday.setClickable(true);
        _friday.setClickable(true);
        _saturday.setClickable(true);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Monday(){
        _monday.setClickable(false);
        _tuesday.setClickable(false);
        _wednesday.setClickable(false);
        _thursday.setClickable(false);
        _friday.setClickable(false);
        _saturday.setClickable(false);
        DataBaseMonday mon = new DataBaseMonday(this);
        if(mon.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
            mon.insertPairs(GetWebLessons(2));
            latch++;
        }else{

            }
        }
        else    {Currentday();Btn_Vis();}
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Tuesday(){
        DataBaseTuesday tue = new DataBaseTuesday(this);
        if(tue.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
        tue.insertPairs(GetWebLessons(3));
        latch++;
        }
        }
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Wednesday(){
        DataBaseWednesday wed = new DataBaseWednesday(this);
        if(wed.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
        wed.insertPairs(GetWebLessons(4));
        latch++;
        }
            }
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Thursday(){
        DataBaseThursday wed = new DataBaseThursday(this);
        if(wed.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
            wed.insertPairs(GetWebLessons(5));
            latch++;
        }}
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Friday(){
        DataBaseFriday wed = new DataBaseFriday(this);
        if(wed.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
            wed.insertPairs(GetWebLessons(6));
            latch++;
        }}
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void Insert_To_Saturday(){
        DataBaseSaturday thu = new DataBaseSaturday(this);
        if(thu.hasData()==false){
            if(isInternetAvailable()&&isNetworkAvailable(this)){
            _progressBar.setAlpha(1);
            thu.insertPairs(GetWebLessons(7));
            latch++;
        }}
        if (latch>5) {Currentday();_progressBar.onVisibilityAggregated(false);_progressBar.setAlpha(0);Btn_Vis();}
    }

    private String[] GetWebLessons(int day){
        String[] strings = new String[8];
        strings[0] = "";
        try {
            Document _doc = Jsoup.connect("https://timetable.tusur.ru/faculties/fb/groups/711-1").get();
            Elements tbodyes = _doc.getElementsByTag("tbody");
            for (int i = 1; i < 8; i++) {
                try{
                    Element tbody = tbodyes.get(day); // со 2 по 7 индекс дни недели
                    Elements elements_tbody = tbody.children();
                    Element element_tbody = elements_tbody.get(i);// lesson 1 c 1 индекса до 7
                    Elements lessons_tbody = element_tbody.children();
                    Element lesson_tbody = lessons_tbody.get(1); // 0 время(пары) 1 пара
                    Elements pairs = lesson_tbody.children();
                    Element pair = pairs.get(0);
                    Elements lesson_cell_days = pair.children();
                    Element lesson_cell_day = lesson_cell_days.get(0);
                    Elements lessons_wrappers = lesson_cell_day.children();
                    Element lessons_wrapper = lessons_wrappers.get(0);
                    Elements lesson_cells = lessons_wrapper.children();
                    String str = "";
                    if (!Objects.equals(lesson_cells.get(1).text(), "")) {
                        str += lesson_cells.get(1).text();
                        str += '\n';
                    }
                    str += lesson_cells.get(2).text();
                    str += '\n';
                    str += lesson_cells.get(3).text();
                    str += '\n';
                    str += lesson_cells.get(4).text();
                    str += '\n';
                    try {
                        if (lesson_cells.get(5).text() != null) {
                            str += lesson_cells.get(5).text();
                            str += '\n';
                        }
                    } catch (Exception ignored) {
                    }
                    strings[i] = str;
                }catch (Exception ignored){}
            }
            return strings;
        }
        catch (IOException e) {
        }
        return null;
    }
    @SuppressLint("SetTextI18n")
    private void GetDate(){
        Button monday = findViewById(R.id.Monday);
        Button tuesday = findViewById(R.id.Tuesday);
        Button wednesday = findViewById(R.id.Wednesday);
        Button thursday = findViewById(R.id.Thursday);
        Button friday = findViewById(R.id.Friday);
        Button saturday = findViewById(R.id.Saturday);
        monday.setText("Пн");
        tuesday.setText("Вт");
        wednesday.setText("Ср");
        thursday.setText("Чт");
        friday.setText("Пт");
        saturday.setText("Сб");
    }

    @Override
    public void onClick(View view) {
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _monday.setBackgroundColor(back_green);
        GetMonday();
    }

    public void tuesday(View view){
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back_green);
        GetTuesday();
    }
    public void wednesday(View view){
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back_green);
        GetWednesday();
    }
    public void thursday(View view){
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back_green);
        GetThursday();
    }
    public void friday(View view){
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _friday.setBackgroundColor(back_green);
        GetFriday();
    }
    public void saturday(View view){
        int Green = R.color.tusur_green;
        int Blue = R.color.tusur_blue;
        int back = ContextCompat.getColor(this,Blue);
        int back_green = ContextCompat.getColor(this,Green);
        _monday.setBackgroundColor(back);
        _tuesday.setBackgroundColor(back);
        _wednesday.setBackgroundColor(back);
        _thursday.setBackgroundColor(back);
        _friday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back);
        _saturday.setBackgroundColor(back_green);
        GetSaturday();
    }

    public void get_color(TextView tv) {
        int Red = R.color.red;
        int Blue = R.color.tusur_blue2;
        int Pink = R.color.pink;
        int Green = R.color.tusur_green;
        int Grey = R.color.tusur_grey;
        int Purple = R.color.tusur_purple;
        String text = (String)tv.getText();
        if(text.contains("Лекция")){
            int back = ContextCompat.getColor(this,Green);
            tv.setBackgroundColor(back);
        }
        else if(text.contains("Практика")){
            int back = ContextCompat.getColor(this,Blue);
            tv.setBackgroundColor(back);
        }
        else if(text.contains("Лабораторная работа")){
            int back = ContextCompat.getColor(this,Purple);
            tv.setBackgroundColor(back);
        }
        else if(text.contains("Занятие отстутствует")){
            int back = ContextCompat.getColor(this,Grey);
            tv.setBackgroundColor(back);
        }
        else if(text.contains("Курсовая работа")){
            int back = ContextCompat.getColor(this,Pink);
            tv.setBackgroundColor(back);
        }
        else{
            int back = ContextCompat.getColor(this,Red);
            tv.setBackgroundColor(back);
        }
    }
    private void GetTuesday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseTuesday dbHelper = new DataBaseTuesday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
    private void GetMonday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseMonday dbHelper = new DataBaseMonday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
    private void GetWednesday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseWednesday dbHelper = new DataBaseWednesday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
    private void GetThursday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseThursday dbHelper = new DataBaseThursday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
    private void GetFriday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseFriday dbHelper = new DataBaseFriday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
    private void GetSaturday(){
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);
        TextView t6 = findViewById(R.id.t6);
        TextView t7 = findViewById(R.id.t7);
        DataBaseSaturday dbHelper = new DataBaseSaturday(this);
        String _nopar = "Занятие отстутствует";
        if(!Objects.equals(dbHelper.getPairById(2), null))
        {
            t1.setText(String.valueOf(dbHelper.getPairById(2)));
        }
        else
        {
            t1.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(3), null))
        {
            t2.setText(String.valueOf(dbHelper.getPairById(3)));
        }
        else
        {
            t2.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(4), null))
        {
            t3.setText(String.valueOf(dbHelper.getPairById(4)));
        }
        else
        {
            t3.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(5), null))
        {
            t4.setText(String.valueOf(dbHelper.getPairById(5)));
        }
        else
        {
            t4.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(6), null))
        {
            t5.setText(String.valueOf(dbHelper.getPairById(6)));
        }
        else
        {
            t5.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(7), null))
        {
            t6.setText(String.valueOf(dbHelper.getPairById(7)));
        }
        else
        {
            t6.setText(_nopar);
        }
        if(!Objects.equals(dbHelper.getPairById(8), null))
        {
            t7.setText(String.valueOf(dbHelper.getPairById(8)));
        }
        else
        {
            t7.setText(_nopar);
        }
        get_color(t1);
        get_color(t2);
        get_color(t3);
        get_color(t4);
        get_color(t5);
        get_color(t6);
        get_color(t7);
    }
//    Disposable disposable = Observable.create(new ObservableOnSubscribe<String>()){
//
//    }
}