package com.example.additem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.sql.DriverPropertyInfo;
import java.util.List;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    ArrayAdapter stadiumArrayAdapter;
    ListView listAll;

   Button AddStadium;
Button ViewAll;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        AddStadium=findViewById(R.id.AddStadium);
        ViewAll=findViewById(R.id.ViewAll);
        listAll=findViewById(R.id.ListView);


        AddStadium.setOnClickListener( new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(getApplicationContext(), AddItemForm.class);
                                            startActivity(intent);
                                        }
                                    });
        ViewAll.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 dataBaseHelper=new DataBaseHelper(MainActivity.this);
                ShowStadiumsOnListView(dataBaseHelper);
                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });

       listAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ItemModel clickedItem= (ItemModel) parent.getItemAtPosition(position);
                    dataBaseHelper=new DataBaseHelper(MainActivity.this);
                   dataBaseHelper.deleteOne(clickedItem);
                   ShowStadiumsOnListView(dataBaseHelper);
                   Toast.makeText(MainActivity.this,"Deleted"+ clickedItem.toString(), Toast.LENGTH_SHORT).show();

           }//end ontiemclick
       }); //Added By Reema













        }///////////


    private void ShowStadiumsOnListView(DataBaseHelper dataBaseHelper) {
        stadiumArrayAdapter  = new ArrayAdapter<ItemModel>(MainActivity.this , android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
        listAll.setAdapter(stadiumArrayAdapter);
    }


}//end class