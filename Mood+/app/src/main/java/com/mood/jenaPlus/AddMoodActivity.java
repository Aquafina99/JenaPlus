package com.mood.jenaPlus;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



/**
 * Created by carrotji on 2017-02-25.
 */

public class AddMoodActivity extends AppCompatActivity implements MPView<MoodPlus> {

    private static final String TAG = "ERROR" ;
    ImageView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    int idNum;
    int colorNum;
    String socialSituation;
    String trigger;
    String idString;
    String colorString;

    private Button addButton;
    private EditText message;
    private Button socialPopup;
    private GridView gridview;
    private ImageView image;
    final static int MAX_SIZE = 65536;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_mood_interface);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        MoodPlus moodPlus = MoodPlusApplication.getMoodPlus();
        moodPlus.addView(this);

        message = (EditText) findViewById(R.id.message);
        //socialPopup = (Button) findViewById(R.id.socialPopup);
        addButton = (Button) findViewById(R.id.AddButton);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        image = (ImageView) findViewById(R.id.selected_image);

        gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new MoodIconAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MoodIcon mi = new MoodIcon();

                idNum = colorNum = position;
                idString = mi.getMood(idNum);
                colorString = mi.getColor(colorNum);
                Toast.makeText(AddMoodActivity.this, "Feeling " + idString ,Toast.LENGTH_SHORT).show();

            }
        });

/*
        t1 = (ImageView) findViewById(R.id.surprised);
        t2 = (ImageView) findViewById(R.id.disgust);
        t3 = (ImageView) findViewById(R.id.fear);
        t4 = (ImageView) findViewById(R.id.confused);
        t5 = (ImageView) findViewById(R.id.happy);
        t6 = (ImageView)findViewById(R.id.angry);
        t7 = (ImageView) findViewById(R.id.sad);
        t8 = (ImageView) findViewById(R.id.shame);
        t9 = (ImageView) findViewById(R.id.annoyed);

        t1.setClickable(true);
        t2.setClickable(true);
        t3.setClickable(true);
        t4.setClickable(true);
        t5.setClickable(true);
        t6.setClickable(true);
        t7.setClickable(true);
        t8.setClickable(true);
        t9.setClickable(true);

        t1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 0;
                Toast.makeText(getBaseContext(), "Feeling surprised",
                        Toast.LENGTH_SHORT).show();

                t1.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }

        });

        t2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 1;

                Toast.makeText(getBaseContext(), "Feeling disgusted",
                        Toast.LENGTH_SHORT).show();
                t2.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = 2;
                Toast.makeText(getBaseContext(), "Feeling fearful",
                        Toast.LENGTH_SHORT).show();
                t3.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 3;
                Toast.makeText(getBaseContext(), "Feeling confused",
                        Toast.LENGTH_SHORT).show();
                t4.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = 4;
                Toast.makeText(getBaseContext(), "Feeling happy",
                        Toast.LENGTH_SHORT).show();
                t5.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 5;
                Toast.makeText(getBaseContext(), "Feeling angry",
                        Toast.LENGTH_SHORT).show();
                t6.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 6;
                Toast.makeText(getBaseContext(), "Feeling sad",
                        Toast.LENGTH_SHORT).show();
                t7.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 7;
                Toast.makeText(getBaseContext(), "Shame",
                        Toast.LENGTH_SHORT).show();
                t8.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                idNum = colorNum = 8;
                Toast.makeText(getBaseContext(), "Feeling annoyed",
                        Toast.LENGTH_SHORT).show();
                t9.setBackgroundColor(getResources().getColor(R.color.gridBack3));
            }
        });*/

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_camera:
                                System.out.println("do camera");
                                galleryIntent();
                                break;
                            case R.id.socialPopup:
                                // Taken from http://stackoverflow.com/questions/21329132/android-custom-dropdown-popup-menu
                                // 04-03-2015 01:16
                                View menuItemView = findViewById(R.id.socialPopup);
                                PopupMenu popup = new PopupMenu(AddMoodActivity.this, menuItemView );
                                //Inflating the Popup using xml file
                                popup.getMenuInflater()
                                        .inflate(R.menu.social_popup, popup.getMenu());

                                //registering popup with OnMenuItemClickListener
                                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    public boolean onMenuItemClick(MenuItem item) {
                                        Toast.makeText(
                                                AddMoodActivity.this,
                                                "Social Situation : " + item.getTitle(),
                                                Toast.LENGTH_SHORT
                                        ).show();
                                        socialSituation = (String) item.getTitle();
                                        return true;
                                    }
                                });

                                popup.show(); //showing popup menu
                                break;

                            case R.id.action_navigation:
                                System.out.println("do navigation");

                                Intent intent = new Intent(AddMoodActivity.this, MapActivity.class);
                                startActivity(intent);

                                break;
                        }
                        return true;
                    }
                }
        );

        addButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                trigger = message.getText().toString();

                Mood newMood = new Mood();
                newMood.setText(trigger);
                Intent intent = new Intent(AddMoodActivity.this, MoodPlusActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void galleryIntent(){
        // Taken from http://stackoverflow.com/questions/5309190/android-pick-images-from-gallery
        // 2017-03-10 5:32
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Uri selectedImage = data.getData();

                if (getDropboxIMGSize(selectedImage))
                    image.setImageURI(selectedImage);
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(AddMoodActivity.this).create();
                    alertDialog.setTitle("Adding Image");
                    alertDialog.setMessage("Image is too large");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        }
    }


    private boolean getDropboxIMGSize(Uri uri){
        // Taken from http://stackoverflow.com/questions/16440863/can-i-get-image-file-width-and-height-from-uri-in-android
        // 2017-03-11 8:30
        boolean size = false;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(uri.getPath()).getAbsolutePath(), options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;

        int totalPixels;
        totalPixels = imageHeight*imageWidth;
        if (totalPixels < MAX_SIZE/3){
            size = true;
        }

        return size;

    }

    public int getID() {
        return idNum;
    }

    public int getColorNum() { return colorNum; }
    public EditText getMessage() { return message; }
    public String getSocialSituation() { return socialSituation; }



    public void update(MoodPlus moodPlus){
        // TODO implements update method

    }

    protected void generateRecord(){
        Intent intent = new Intent();
        setResult(MoodPlusActivity.RESULT_OK, intent);
        finish();

    }

}

