package com.whitelightstudios.fortuneteller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
public class MainActivity extends AppCompatActivity {
    String fortuneList[] = {"Don’t count on it","Ask again later","You may rely on it","Without a doubt","Outlook not so good","It's decidedly so","Signs point to yes","Yes definitely","Yes","My sources say NO"};

    TextView mFortuneText;
    Button mGenerateFortuneButton;
    ImageView mFortuneBallImage;
    ImageButton mFortuneBall2Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1:
        super.onCreate(savedInstanceState);
        // 2:
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 3:
        mFortuneText = (TextView) findViewById(R.id.fortuneText);
        mFortuneBallImage = (ImageView) findViewById(R.id.fortunateImage);
        mFortuneBall2Image = (ImageButton) findViewById(R.id.fortunateImage2);

        mFortuneBall2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = new Random().nextInt(fortuneList.length);
                mFortuneText.setText(fortuneList[index]);
                // 6:
                YoYo.with(Techniques.Swing)
                        .duration(500)
                        // 7:        .playOn(mFortuneBallImage);
                        .playOn(mFortuneBall2Image);
            }
        });

        mGenerateFortuneButton = (Button) findViewById(R.id.fortuneButton);
        // 4:
        mGenerateFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5:
                int index = new Random().nextInt(fortuneList.length);
                mFortuneText.setText(fortuneList[index]);
                // 6:
                YoYo.with(Techniques.Swing)
                        .duration(500)
                // 7:        .playOn(mFortuneBallImage);
                        .playOn(mFortuneBall2Image);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {

            Intent intent = new Intent(this, AboutActivity.class);
            intent.putExtra("Message","version 1.2");
            startActivity(intent);
            return true;
        }

        if (id == R.id.implicit_share) {

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String stringToShare="Have you seen the future?";
            sharingIntent.putExtra(Intent.EXTRA_TEXT, stringToShare);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
