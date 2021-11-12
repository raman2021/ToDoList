/*Simple ToDo list
Name- Ramandeep kaur
Student no. A00244354
In this app i am just creating simple todo list, things can be added with add button and the
done task from list can be cancelled by clicking on that task*/
package com.ramandeepkaur.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//default package and super class
public class MainActivity extends AppCompatActivity {
    // decrlearing some variables
    List<String> todoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    EditText editText;
//using override to recall super class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// adding variable todolist to declare arrays
        todoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout,todoList);
        listView = findViewById(R.id.id_list_view);
//adding method to make button
// working when button is clicked
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //calling super class method in textview
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


            }
        });
        //giving id to find and display it
        editText = findViewById(R.id.id_edit_text);
    }
    //adding method to add item in list when user enter something in keyboard to add
    public void addItemToList(View view){

        todoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");
    }
}