package es.gonzalo.newyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {

    private GifImageButton escudo;
    private GifImageView ironmanIzq;
    private GifImageView ironmanDer;
    private ImageView logoMarvel;
    private ImageView gorroSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        /////////////////////////////////////////////////////////
        initComponents();
        //////////////////////
        setAnimaciones();
        ////////////////////////////
        Button b = (Button) findViewById(R.id.botonNext);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camino = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(camino);
                finish();
            }
        });
        escudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation despegue = AnimationUtils.loadAnimation(getBaseContext(),R.anim.anim_ironman);
                despegue.setFillAfter(true);
                ironmanDer.startAnimation(despegue);
                ironmanIzq.startAnimation(despegue);
                ///////////////////////////////////////////
                Animation parpadeo = AnimationUtils.loadAnimation(getBaseContext(),R.anim.parpadeo);
                logoMarvel.startAnimation(parpadeo);
                gorroSplash.startAnimation(parpadeo);
            }
        });

    }

    public void initComponents(){
        escudo=(GifImageButton) findViewById(R.id.escudo);
        ironmanDer=(GifImageView) findViewById(R.id.ironmanDer);
        ironmanIzq=(GifImageView) findViewById(R.id.ironmanIzq);
        logoMarvel=(ImageView) findViewById(R.id.logoMarvel);
        gorroSplash=(ImageView) findViewById(R.id.gorroSplash);
    }

    public void setAnimaciones (){
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        escudo.startAnimation(rotate);
    }
}