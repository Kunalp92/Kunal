package com.kunal.kunal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<String> title_list, answer_list;
    ArrayAdapter<String> arrayAdapter;

    Book book1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);


        listView = findViewById(R.id.listView);

        databaseReference = FirebaseDatabase.getInstance().getReference("It_7_Paper");


//        databaseReference.keepSynced(true);

        book1 = new Book();
        title_list = new ArrayList<>();
        answer_list = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.item, title_list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                title_list.clear();
                answer_list.clear();

                for(DataSnapshot d:snapshot.getChildren()){
                    book1=d.getValue(Book.class);
                    if (book1 != null) {
                        title_list.add(book1.getTitle());
                    }
                    if (book1 != null) {
                        answer_list.add(book1.getAnswer());
                    }
                }

                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(EbookActivity.this, Answer.class);
                        String p = answer_list.get(position);
                        intent.putExtra("key", p);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}