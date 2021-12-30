package es.gonzalo.newyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView felizanio;
    private TextView tuHeroe;
    private ImageView spidey;
    private ImageView gon;
    private ImageView gorro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        /////////////////////////////
        setSonido();
        /////////////////////////////
        initComponentes();
        /////////////////////////////
        cambiarLetra();
        //////////////////////
        setAnimacion();
    }

    public void cambiarLetra() {
        Typeface letra1 = Typeface.createFromAsset(getAssets(), "Comic Kings.ttf");
        felizanio.setTypeface(letra1);
        ///////////////////////////////////////////
        Typeface letra2 = Typeface.createFromAsset(getAssets(), "DAYPBL__.TTF");
        tuHeroe.setTypeface(letra2);
    }

    public void setAnimacion() {
        /////////////////////////////////////////////
        Animation traslacionHaciaArriba = AnimationUtils.loadAnimation(this, R.anim.translate_felizanio);
        felizanio.startAnimation(traslacionHaciaArriba);
        gorro.startAnimation(traslacionHaciaArriba);
        ///////////////////////////////////////////////////
        Animation opacidad=AnimationUtils.loadAnimation(this,R.anim.opacidad_setuheroe);
        tuHeroe.startAnimation(opacidad);
        /////////////////////////////////////////////
        Animation gifAnimation = AnimationUtils.loadAnimation(this,R.anim.spiderman_aparece);
        spidey.startAnimation(gifAnimation);
        ////////////////////////////////////////////////
        Animation traslateGon = AnimationUtils.loadAnimation(this,R.anim.traslate_izq_firma);
        gon.startAnimation(traslateGon);
    }

    public void initComponentes(){
        felizanio = (TextView) findViewById(R.id.felizanio);
        tuHeroe=(TextView) findViewById(R.id.seTuHeroe);
        spidey=(ImageView) findViewById(R.id.spidey);
        gon=(ImageView) findViewById(R.id.gonTitulo);
        gorro=(ImageView) findViewById(R.id.gorro);
    }

    public void setSonido(){
        MediaPlayer player = MediaPlayer.create(this,R.raw.marvel);
        player.start();
    }

}