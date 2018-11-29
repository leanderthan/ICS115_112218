package com.example.cisco.nov22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("grades");
    ArrayList<String> keylist;
    EditText fname,lname,grade;
    int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.etFname);
        lname = findViewById(R.id.etLname);
        grade = findViewById(R.id.etScore);

        keylist = new ArrayList<String>();
    }

    @Override
    public void onStart() {
        super.onStart();
root.setValue("Leania");

        /*root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ss : dataSnapshot.getChildren()){
                    keylist.add(ss.getKey());
                }
                Toast.makeText(MainActivity.this, keylist.get(0),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); */
    }

    public void addRecord(View v){
        String fn = fname.getText().toString();
        String ln = lname.getText().toString();
        String sc = grade.getText().toString();
        Long g = Long.parseLong(sc);
       Grade gr = new Grade(fn,ln,g);
       String key = root.getKey();
        //root.child("fname").setValuede();(fn);
      // root.child("lname").setValue(ln);
       //root.child("score").setValue(g);
       root.child(key).child("fname").setValue(gr.getFname());
        root.child(key).child("lname").setValue(gr.getLname());
        root.child(key).child("score").setValue(gr.getGrade());
        Toast.makeText(this,"INSERTED",Toast.LENGTH_LONG).show();
    }
}
