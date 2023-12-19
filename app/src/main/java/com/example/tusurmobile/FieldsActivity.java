package com.example.tusurmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.tusurmobile.db.TimeTableDatabaseHelper;
import com.example.tusurmobile.timeTable.GetParamsForUrl;
import com.example.tusurmobile.timeTable.Parser;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class FieldsActivity extends AppCompatActivity {

    List<String> _faculties;
    private Spinner spinner;
    private TextInputEditText text;
    Button btnOK;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);
        text = (TextInputEditText)findViewById(R.id.group);
        btnOK = (Button)findViewById(R.id.btnOk);
        _faculties = new ArrayList<>();
        _faculties.add("РТФ");
        _faculties.add("РКФ");
        _faculties.add("ФВС");
        _faculties.add("ФСУ");
        _faculties.add("ФЭТ");
        _faculties.add("ФИТ");
        _faculties.add("ЭФ");
        _faculties.add("ГФ");
        _faculties.add("ЮФ");
        _faculties.add("ФБ");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,_faculties);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner)findViewById(R.id.spinnerFaculties);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String)adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP){
                    btnOK.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void Select(View view){
        if (text.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"Заполните все поля",Toast.LENGTH_LONG).show();
        }
        else{
            GetParamsForUrl.groupTittle = text.getText().toString();
            GetParamsForUrl.facultyTittle = spinner.getSelectedItem().toString();
            GetParamsForUrl.faculty = getUrlFaculty();
            GetParamsForUrl.group = Convert(text.getText().toString()).trim();
            Parser parser = new Parser();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
    public String getUrlFaculty(){
        String selectedItem = spinner.getSelectedItem().toString();
        switch (selectedItem){
            case "РТФ":
                return "rtf";
            case "РКФ":
                return "rkf";
            case "ФВС":
                return "fvs";
            case "ФСУ":
                return "fsu";
            case "ФЭТ":
                return "fet";
            case "ФИТ":
                return "fit";
            case "ЭФ":
                return "ef";
            case "ГФ":
                return "gf";
            case "ЮФ":
                return "yuf";
            case "ФБ":
                return "fb";
            default:
                return null;
        }
    }
            private static final Map<Character, String> transliterationMap = new HashMap<>();

            static {
                transliterationMap.put('а', "a");
                transliterationMap.put('б', "b");
                transliterationMap.put('в', "v");
                transliterationMap.put('г', "g");
                transliterationMap.put('д', "d");
                transliterationMap.put('е', "e");
                transliterationMap.put('ё', "yo");
                transliterationMap.put('ж', "zh");
                transliterationMap.put('з', "z");
                transliterationMap.put('и', "i");
                transliterationMap.put('й', "y");
                transliterationMap.put('к', "k");
                transliterationMap.put('л', "l");
                transliterationMap.put('м', "m");
                transliterationMap.put('н', "n");
                transliterationMap.put('о', "o");
                transliterationMap.put('п', "p");
                transliterationMap.put('р', "r");
                transliterationMap.put('с', "s");
                transliterationMap.put('т', "t");
                transliterationMap.put('у', "u");
                transliterationMap.put('ф', "f");
                transliterationMap.put('х', "kh");
                transliterationMap.put('ц', "ts");
                transliterationMap.put('ч', "ch");
                transliterationMap.put('ш', "sh");
                transliterationMap.put('щ', "shch");
                transliterationMap.put('ъ', "'");
                transliterationMap.put('ы', "y");
                transliterationMap.put('ь', "'");
                transliterationMap.put('э', "e");
                transliterationMap.put('ю', "yu");
                transliterationMap.put('я', "ya");
            }

            public static String transliterate(String input) {
                StringBuilder output = new StringBuilder();

                for (int i = 0; i < input.length(); i++) {
                    char c = Character.toLowerCase(input.charAt(i));

                    if (transliterationMap.containsKey(c)) {
                        output.append(transliterationMap.get(c));
                    } else {
                        output.append(c);
                    }
                }

                return output.toString();
            }

            public String Convert(String input) {
                char[] chars = input.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    if (Character.isUpperCase(c)) {
                        chars[i] = Character.toLowerCase(c);
                    } else if (Character.isLowerCase(c)) {
                        chars[i] = Character.toUpperCase(c);
                    }
                }
                input = new String(chars);
                String result = transliterate(input);
                return result;
            }
            public void Error(){
                Toast.makeText(getApplicationContext(),"Нет соеденения с интернетом или такой группы не существует",Toast.LENGTH_LONG).show();
            }
    }
