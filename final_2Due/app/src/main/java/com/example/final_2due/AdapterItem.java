package com.example.final_2due;

import android.view.View;
import android.widget.Button;

public class AdapterItem {

    String task;
    String date;



    public AdapterItem(String task, String date) {
        this.task = task;
        this.date = date;

    }

    public String getTask() {
        return task;
    }
    public String getDate() {
        return date;
    }




}