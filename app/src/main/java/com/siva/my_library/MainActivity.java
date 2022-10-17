package com.siva.my_library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siva.my_library.AllBooksActivity;
import com.siva.my_library.AlreadyReadBookActivity;
import com.siva.my_library.CurrentlyReadingActivity;
import com.siva.my_library.FavoriteActivity;
import com.siva.my_library.Utils;
import com.siva.my_library.WantToReadActivity;
import com.siva.my_library.WebsiteActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;  //Initializing UI Elements

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(); // initializing button inside the onCreate method.

        btnAllBooks.setOnClickListener(new View.OnClickListener() {  // on Clicking this button, user will be taken to new activity
            @Override
            public void onClick(View view) {
                //logic to navigate the user to the other page
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class); // Intent is the simple Java class. Navigating from "MainActivity.this", to  "AllBooksActivity.class"
                startActivity(intent); // startActivity is an Inner Method
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and Developed with Love by Sivapriya at sivapriya.org\n" +
                        "Check my website for more awesome applications:");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Show the website
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra("url", "https://google.com/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });

        Utils.getInstance(this);
    }

    private void initView() {

        //initializing Buttons
        btnAllBooks = (Button) findViewById(R.id.btnAllBooks);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = (Button) findViewById(R.id.btnCurrentlyReading);
        btnFavorite = (Button) findViewById(R.id.btnFavorite);
        btnAbout = (Button) findViewById(R.id.btnAbout);

    }
}