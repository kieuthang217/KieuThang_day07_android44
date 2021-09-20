package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.AddFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddFragment extends Fragment {

    //TextView tvAddFragment;
    AddFragmentBinding binding;
    String[] strings = {"Work","Family","Friend"};

    public static AddFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddFragment fragment = new AddFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  View view = inflater.inflate(R.layout.add_fragment,container,false);
        binding = DataBindingUtil.inflate(inflater,R.layout.add_fragment,container,false);
       // tvAddFragment=view.findViewById(R.id.tvAddfragment);
        Spinner spinner =binding.spntype ;

        ArrayAdapter adap = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,strings);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adap);

        //binding.tvAddfragment.setText("ABC");
        binding.tvIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings={"Family","GAme","Android","VTC","Friend"};
                boolean[] booleans ={false,true,false,false,false};
                final List<String> list = Arrays.asList(strings);
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("thông báo")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                binding.tvIT.setText("");
                                for (int i = 0; i<booleans.length; i++){
                                    boolean checked = booleans[i];
                                    if (checked) {
                                        binding.tvIT.setText(binding.tvIT.getText()+ list.get(i) + ", ");
                                    }
                                }
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "Click cancle", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();


            }
        });

        binding.tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                boolean[] booleans ={false,true,false,false,false};
                final List<String> list = Arrays.asList(strings);
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Choose tags:")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                binding.tvWeeks.setText("");
                                for (int i = 0; i<booleans.length; i++){
                                    boolean checked = booleans[i];
                                    if (checked) {
                                        binding.tvWeeks.setText(binding.tvWeeks.getText()+ list.get(i) + ", ");
                                    }
                                }
                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "Click cancle", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();


            }
        });

        binding.btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings={"Nexus Tune","Winphone Tune","Peep Tune","Nokia Tune","Etc"};
                final String[] selec = {""};
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("thông báo")
                        .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),strings[i],Toast.LENGTH_LONG).show();
                                selec[0] = strings[i];
                            }
                        })

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Toast.makeText(getContext(),"Click Ok",Toast.LENGTH_LONG).show();
                                Toast.makeText(getContext(),selec[0],Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();


            }
        });


        return binding.getRoot();
    }
}
