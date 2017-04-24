package com.vaidu.shahinvai.ViewContacs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vaidu.shahinvai.R;

import java.util.List;

/**
 * Created by Guitorio on 4/23/2017.
 */
public class StudentAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Student> studentList;
    //private Context  activity;

    public StudentAdapter(Activity activity, List<Student> studentList) {
        this.activity = activity;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        Student st = studentList.get(position); //new Student(id,name);

        TextView id = (TextView) convertView.findViewById(R.id.txtId);
        TextView name = (TextView) convertView.findViewById(R.id.txtName);

        id.setText(st.getId());
        name.setText(st.getName());

        return convertView;
    }
}

