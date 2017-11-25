package thacks.employmint;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class homeLogin extends AppCompatActivity {
    ImageView logoFade, leafLogo;
    Animation animFadeOut, animFadeIn;
    EditText user, pass;
    TextView slogan;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_login);
        //handling component instances
        //imageviews
        logoFade=(ImageView)findViewById(R.id.logo);
        leafLogo=(ImageView)findViewById(R.id.leafLogo);
        //editexts
        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        //set Fonts
        Typeface customfont=Typeface.createFromAsset(getAssets(),"fonts/arca.otf");
        user.setTypeface(customfont);
        pass.setTypeface(customfont);
        //textviews
        slogan=(TextView)findViewById(R.id.slogan);
        slogan.setTypeface(customfont);
        //buttons
        login=(Button)findViewById(R.id.login);
        login.setTypeface(customfont);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreens();
            }
        });


        //set Animations from XML
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadebuttonout1);
        animFadeIn= AnimationUtils.loadAnimation((getApplicationContext()),R.anim.fadein);

        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //manage memory
                logoFade.setImageResource(0);
                startLoginFade();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        CountDownTimer stall=new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startLogoAnim();
            }
        };
        stall.start();

    }

    private void startLogoAnim(){
        //assign animations
        logoFade.startAnimation(animFadeOut);
        slogan.startAnimation(animFadeOut);
    }

    private void startLoginFade(){
        user.setAnimation(animFadeIn);
        pass.setAnimation(animFadeIn);
        leafLogo.setAnimation(animFadeIn);
        login.setAnimation(animFadeIn);

        leafLogo.setEnabled(true);
        user.setEnabled(true);
        pass.setEnabled(true);
        login.setEnabled(true);

        leafLogo.setVisibility(View.VISIBLE);
        user.setVisibility(View.VISIBLE);
        pass.setVisibility(View.VISIBLE);
        login.setVisibility(View.VISIBLE);

        animFadeIn.start();
    }

    private void switchScreens(){
        if (user.getText().toString().equals("shreyas23") && pass.getText().toString().equals("jobsarecool")){
            Intent intent=new Intent (homeLogin.this, jobsearch.class);
            startActivity(intent);
            Toast.makeText(this,"Welcome Shreyas",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
        }
    }
}
