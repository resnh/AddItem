package com.example.additem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AddItemForm extends AppCompatActivity {

//members
    Button btn_Add;
    EditText name , type , location ,price;
    DataBaseHelper dataBaseHelper;
    private ImageView objectImageView;
    private EditText imageDetailsET;

private static final int PICK_IMAGE_REQUEST=100;
private Uri imageFilePath;
private Bitmap imageToStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_form);

        try{
            objectImageView=findViewById(R.id.imageView2);
            imageDetailsET=findViewById(R.id.image1);
            dataBaseHelper=new DataBaseHelper(AddItemForm.this);

        }
        catch (Exception e){

        }

        btn_Add=findViewById(R.id.btn_Add);
        name=(EditText) findViewById(R.id.Sname);
        type=(EditText) findViewById(R.id.SportType);
        location=(EditText) findViewById(R.id.loc);
        price=(EditText) findViewById(R.id.price);



        //do you add the list view declaration here ?
        //no

        dataBaseHelper=new DataBaseHelper(AddItemForm.this);


        btn_Add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create model
                ItemModel itemMod;
                try {
                    if(!imageDetailsET.getText().toString().isEmpty() && objectImageView.getDrawable() !=null ) {
                        itemMod = new ItemModel(name.getText().toString(), -1, type.getText().toString(), location.getText().toString(), Integer.parseInt(price.getText().toString()),imageDetailsET.getText().toString(),imageToStore);
                        Toast.makeText(AddItemForm.this, itemMod.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else
                        throw new Exception();
                } catch (Exception e) {
                    Toast.makeText(AddItemForm.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    itemMod = new ItemModel("error", -1,"error","error", 0,"error",null);;
                }

                dataBaseHelper = new DataBaseHelper(AddItemForm.this);
                boolean b = dataBaseHelper.addOne(itemMod);
                if(b){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);}





            }
        });


    }

    public void chooseImages(View objectView){
        try{
            Intent objIntent= new Intent();
            objIntent.setType("image/*");
            objIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objIntent,PICK_IMAGE_REQUEST);

        }
        catch(Exception e){
         Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode, @Nullable Intent data){
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data !=null && data.getData() != null){
              imageFilePath=data.getData();
                imageToStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
                objectImageView.setImageBitmap(imageToStore);
            }
        }
        catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    }






