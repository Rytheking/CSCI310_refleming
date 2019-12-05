package com.example.final_2due;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.TextView;


import com.example.final_2due.db.TaskContract;
import com.example.final_2due.db.TaskDbHelper;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<AdapterItem> {

    private ArrayList<AdapterItem> dataSet;
    Context mContext;

    private static final String TAG = "CustomAdapter";

    // View lookup cache
    private static class ViewHolder {
        TextView txtTask;
        TextView txtDate;
        Button   delete;
    }

    public CustomAdapter(ArrayList<AdapterItem> data, Context context) {
        super(context, R.layout.item_todo, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        AdapterItem adapterItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_todo, parent, false);
            viewHolder.txtTask = (TextView) convertView.findViewById(R.id.task_title);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.dueDate);
            viewHolder.delete = (Button) convertView.findViewById(R.id.task_delete);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtTask.setText(adapterItem.getTask());
        viewHolder.txtDate.setText(adapterItem.getDate());
        viewHolder.delete.setText("Done");
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     //Log.d(TAG, "Task Due: " + v);
                                                     MainActivity.getInstance().deleteTask(v);
                                                 }
                                             });
        // Return the completed view to render on screen
        return convertView;
    }


}