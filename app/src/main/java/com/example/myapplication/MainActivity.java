package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView btnAddActivity,btnDetailFragment;
   // Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddActivity = findViewById(R.id.btnAddFragment);
        btnDetailFragment = findViewById(R.id.btnDetailFragment);
       // spinner = (Spinner) findViewById(R.id.spntype);

        onFragment(AddFragment.newInstance());

        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(AddFragment.newInstance());
            }
        });
        btnDetailFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(DetailFragment.newInstance());
            }
        });

     //   ArrayList<String> arrayList = new ArrayList<String>();
     //   arrayList.add("Word");
      //  arrayList.add("Friend");
       // arrayList.add("Family");
//
       // ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList);
      //  spinner.setAdapter(arrayAdapter);
    }

    private void onFragment(Fragment fragment){

        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragContainer,fragment)
                    .commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnAddfrag:
                onFragment(AddFragment.newInstance());
                break;
            case  R.id.mnDetailfrag:
                onFragment(DetailFragment.newInstance());
                break;
            default:
                onFragment(AddFragment.newInstance());
        }



        return super.onOptionsItemSelected(item);
    }
}