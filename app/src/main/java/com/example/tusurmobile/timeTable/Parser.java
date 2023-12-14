package com.example.tusurmobile.timeTable;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.tusurmobile.MainActivity;
import com.example.tusurmobile.R;
import com.example.tusurmobile.db.TimeTableDatabaseHelper;
import com.example.tusurmobile.db.TimeTableOperation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Parser {
    public String[] GetWebLessons(int day){
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
                    String teacher = null;
                    teacher = lesson_cells.get(4).text();
                    boolean isChar = teacher.indexOf(',') != -1;
                    if (isChar){
                        teacher = teacher.substring(0 ,teacher.indexOf(','));
                        str += teacher;
                    }
                    else{
                        str += teacher;
                    }
                    str+="\n";
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
    Points points = new Points();
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Insert1(int index, TimeTableOperation tO, Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Insert2(int index,TimeTableOperation tO,Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }
    public void Insert3(int index,TimeTableOperation tO,Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }
    public void Insert4(int index,TimeTableOperation tO,Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }
    public void Insert5(int index,TimeTableOperation tO,Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }
    public void Insert6(int index,TimeTableOperation tO,Handler handler) {
        String[] pairsOnDay = GetWebLessons(index);
        String tableName = switchDay(index);
            tO.open();
            String pairs = Arrays.toString(pairsOnDay);
            tO.insertData(tableName,pairs);
            handler.sendEmptyMessage(1);
        tO.close();
    }

    private String switchDay(int index){
        String tableName = null;
        switch (index){
            case 2:
                tableName = "TableMonday";
                break;
            case 3:
                tableName = "TableTuesday";
                break;
            case 4:
                tableName = "TableWednesday";
                break;
            case 5:
                tableName = "TableThursday";
                break;
            case 6:
                tableName = "TableFriday";
                break;
            case 7:
                tableName = "TableSaturday";
                break;
            default:
                break;
        }
        return tableName;
    }
}
