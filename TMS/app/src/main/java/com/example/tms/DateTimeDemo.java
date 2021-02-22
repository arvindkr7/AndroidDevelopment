package com.example.tms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeDemo extends AppCompatActivity {
    TextView dp, tp, tv_output;
    int year, month, monthDay, weekDay, hr, mint;
    boolean is24hr = false;
    CharSequence time, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_demo);
        dp = findViewById(R.id.dpdemo);
        tp = findViewById(R.id.tpdemo);
        tv_output = findViewById(R.id.tv_dateTime);

        // Calendar instance gives the current day and time
        final Calendar c = Calendar.getInstance();

        weekDay = c.get(Calendar.DAY_OF_WEEK);
        monthDay = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);


        date = DateFormat.format("EEE dd MMM", c);
        dp.setText(date);

        hr = c.get(Calendar.HOUR);
        mint = c.get(Calendar.MINUTE);
        c.set(Calendar.AM, 0);
        time =DateFormat.format("hh:mm a",c);
        tp.setText(time);

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                monthDay = c.get(Calendar.DAY_OF_MONTH);



                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeDemo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        datePicker.setMinDate(c.getTimeInMillis());

                         year = i;
                        month= i1;
                        monthDay = i2;

                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(Calendar.YEAR, i);
                        calendar1.set(Calendar.MONTH, i1);
                        calendar1.set(Calendar.DAY_OF_MONTH, i2);

                        CharSequence dateCharSequence = DateFormat.format("EEE dd MMM", calendar1);




                        dp.setText(dateCharSequence);
                        finalOutput();


                    }



                }, year, month, monthDay);
                    datePickerDialog.getDatePicker().setMinDate(new Date().getTime());
                    // date before today is not possible to set any reminder

                datePickerDialog.show();

            }
        });

        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeDemo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        hr = i;
                        mint = i1;



                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.set(Calendar.HOUR, i);
                        calendar2.set(Calendar.MINUTE, i1);
                        calendar2.set(Calendar.AM_PM, 0);

                        CharSequence timeCharSequence = DateFormat.format("hh:mm a",calendar2);

                        tp.setText(timeCharSequence);
                        finalOutput();
                    }
                }, hr, mint, is24hr);
                timePickerDialog.show();


            }

        });

        finalOutput();

    }

    public void finalOutput(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, monthDay);
        calendar.set(Calendar.HOUR, hr);
        calendar.set(Calendar.MINUTE, mint);
        calendar.set(Calendar.AM_PM,0);

        CharSequence finalCharSeq = DateFormat.format("hh: mm a - EEE dd MMM",calendar);
        tv_output.setText(finalCharSeq);

    }
}