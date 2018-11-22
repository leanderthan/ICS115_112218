package com.example.cisco.nov22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference root;
   // List<String> keylist;
    EditText fname,lname,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        root = db.getReference("grade");
        fname = findViewById(R.id.etFname);
        lname = findViewById(R.id.etLname);
        s = findViewById(R.id.etScore);

      //  keylist = new ArrayList<String>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        root.child("value1").setValue("leania");

    }

    public void addRecord(View v){
        String fn = fname.getText().toString();
        String ln = lname.getText().toString();
        String sc = s.getText().toString();
        Long g = Long.parseLong(sc);
        Grade gr = new Grade(fn,ln,g);
       // String key = root.push().getKey();
       // root.child(key).setValue(gr);
     root.push().setValue(gr);
    }
}
