package com.alvarenga.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.sharebutton) {
            String info = "Nombre: " + getResources().getText(R.string.name) + "\n" +
                "Carrera: " + getResources().getText(R.string.career_name) + "\n" +
                "Github: " + getResources().getText(R.string.github_name) + "\n" +
                "Correo: " + getResources().getText(R.string.email) + "\n" +
                "Twitter: " + getResources().getText(R.string.tw_name) + "\n" +
                "Telefono : " + getResources().getText(R.string.phone) + "\n";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, ("About me \n" + info) );
            final File photoFile = new File(getFilesDir(), "aboutmee.jpg");
            sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
            sendIntent.setType("*/*");
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send)));
        }

        return super.onOptionsItemSelected(item);
    }
}
