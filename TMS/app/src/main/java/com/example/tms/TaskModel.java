package com.example.tms;

import java.util.Calendar;

public class TaskModel{
    private  String name;
    private int year, month, date, hr, mint;

    public TaskModel(String name, int year, int month, int date, int hr, int mint) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.date = date;
        this.hr = hr;
        this.mint = mint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMint() {
        return mint;
    }

    public void setMint(int mint) {
        this.mint = mint;
    }
}
