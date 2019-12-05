package com.example.final_2due;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.widget.*;
import android.view.*;
import android.util.Log;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.content.*;

import com.example.final_2due.db.*;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public TaskDbHelper mHelper;
    public ListView mTaskListView;
    ArrayList<AdapterItem> adapterItems;
    private static CustomAdapter adapter;
    private static MainActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        mHelper = new TaskDbHelper(this);
        mTaskListView = (ListView) findViewById(R.id.list_todo);
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE, TaskContract.TaskEntry.COL_TASK_DATE},
                null, null, null, null, null);
        while(cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            Log.d(TAG, "Task: " + cursor.getString(idx));
        }
        cursor.close();
        db.close();
        updateUI();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                final Context context = dialog.getContext();
                final LayoutInflater inflater = LayoutInflater.from(context);
                final View view = inflater.inflate(R.layout.add_task, null);

                dialog
                        .setView(R.layout.add_task)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Dialog f = (Dialog) dialog;
                                EditText taskTitle =  f.findViewById(R.id.task_title);
                                 DatePicker dueDate =  f.findViewById(R.id.due_date);
                                    String task = String.valueOf(taskTitle.getText());
                                    int day = dueDate.getDayOfMonth();
                                    int month = dueDate.getMonth()+1;
                                    int year = dueDate.getYear();
                                    String due_Date= day+"-"+month+"-"+year;
                                    Log.d(TAG, "Task Due: " + due_Date);
                                    Log.d(TAG, "Task to add: " + task);
                                    SQLiteDatabase db = mHelper.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
                                    values.put(TaskContract.TaskEntry.COL_TASK_DATE, due_Date);
                                    db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                                            null,
                                            values,
                                            SQLiteDatabase.CONFLICT_REPLACE);
                                    db.close();
                                    updateUI();
                                }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void updateUI() {
        adapterItems = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE, TaskContract.TaskEntry.COL_TASK_DATE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int taskx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            int datex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_DATE);
            adapterItems.add(new AdapterItem(cursor.getString(taskx), cursor.getString(datex)));
        }

        if (adapter == null) {
            adapter = new CustomAdapter(adapterItems, getApplicationContext());

            mTaskListView.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(adapterItems);
            adapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.TABLE,
                TaskContract.TaskEntry.COL_TASK_TITLE + " = ?",
                new String[]{task});
        db.close();
        updateUI();
    }
}
