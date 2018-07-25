package com.example.admin1.oyorooms;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        final TextView oyoTextView = (TextView)findViewById(R.id.oyo_text_view);
        final TextView wifiTextView = (TextView)findViewById(R.id.wifi_text_view);
        final TextView roomsTextView = (TextView)findViewById(R.id.rooms_text_view);
        final TextView bookNowTextView = (TextView)findViewById(R.id.book_now_text_view);
        final TextView cleanTextView = (TextView)findViewById(R.id.clean_text_view);
        final TextView getMoneyTextView = (TextView)findViewById(R.id.get_money_text_view);
        final Button getStartedButton = (Button)findViewById(R.id.get_started_button);

        final Animation headingAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.heading);
        final Animation wifiAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.otheranimation);
        final Animation roomsAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.otheranimation);
        final Animation bookNowAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.otheranimation);
        final Animation cleanAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.otheranimation);
        final Animation getMoneyAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom);
        final Animation getStartedAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom);

        oyoTextView.startAnimation(headingAnimation);
        headingAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //oyoTextView.startAnimation(headingAnimation);
                wifiTextView.setVisibility(View.VISIBLE);
                wifiTextView.startAnimation(wifiAnimation);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wifiAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                roomsTextView.setVisibility(View.VISIBLE);
                roomsTextView.startAnimation(roomsAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        roomsAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bookNowTextView.setVisibility(View.VISIBLE);
                bookNowTextView.startAnimation(bookNowAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bookNowAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cleanTextView.setVisibility(View.VISIBLE);
                cleanTextView.startAnimation(cleanAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cleanAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getMoneyTextView.setVisibility(View.VISIBLE);
                getMoneyTextView.startAnimation(getMoneyAnimation);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        getMoneyAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getStartedButton.setVisibility(View.VISIBLE);
                getStartedButton.startAnimation(getStartedAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    public void toHomeScreen(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
