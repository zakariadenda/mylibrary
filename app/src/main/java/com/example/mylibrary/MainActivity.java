package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etname;
    private DatabaseHelper dbHelper;
    private TextView tvnames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        tvnames = (TextView) findViewById(R.id.tvnames);
        etname = (EditText) findViewById(R.id.etname);
    }


    public void inputdata(View view){
        String name = etname.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_FIRSTNAME, name);
        long id = db.insert(DatabaseHelper.TABLE_STUDENTS, null, values);
        Log.d("DATABASE", "Id data: " + id);
        Toast.makeText(MainActivity.this, "Stored Succesfully!", Toast.LENGTH_LONG).show();

    }

    public void readdata(View view){
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_STUDENTS;
        Cursor c = db.rawQuery(query, null);
        while(c.moveToNext()){
            data.add(c.getString(c.getColumnIndex(DatabaseHelper.KEY_FIRSTNAME)));
        }
        c.close();

        String hasil = "";
        for(int i=0; i<data.size(); i++){
            Log.d("DATABASE", i + " " + data.get(i));
        }
        tvnames.setText(hasil);
    }
}