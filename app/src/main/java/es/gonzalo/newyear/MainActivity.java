package es.gonzalo.newyear;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout felizanio;
    private TextView tuHeroe;
    private ImageView spidey;
    private ImageView gon;
    private ImageView gorro;
    private TextView feliz_anio_actual;

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
        /*Typeface letra1 = Typeface.createFromAsset(getAssets(), "Comic Kings.ttf");
        felizanio.setTypeface(letra1);*/
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
        Animation opacidad = AnimationUtils.loadAnimation(this, R.anim.opacidad_setuheroe);
        tuHeroe.startAnimation(opacidad);
        /////////////////////////////////////////////
        Animation gifAnimation = AnimationUtils.loadAnimation(this, R.anim.spiderman_aparece);
        spidey.startAnimation(gifAnimation);
        ////////////////////////////////////////////////
        Animation traslateGon = AnimationUtils.loadAnimation(this, R.anim.traslate_izq_firma);
        gon.startAnimation(traslateGon);
    }

    public void initComponentes() {
        felizanio = (RelativeLayout) findViewById(R.id.felizanio);
        tuHeroe = (TextView) findViewById(R.id.seTuHeroe);
        spidey = (ImageView) findViewById(R.id.spidey);
        gon = (ImageView) findViewById(R.id.gonTitulo);
        gorro = (ImageView) findViewById(R.id.gorro);
        ///////////////////////////////////////////////////
        feliz_anio_actual = (TextView) findViewById(R.id.feliz_anio_txt);
        feliz_anio_actual.setText("FELIZ " + anioActual());
    }

    public void setSonido() {
        MediaPlayer player = MediaPlayer.create(this, R.raw.marvel);
        player.start();
    }

    //////AÑO ACTUAL////////////////
    public String anioActual() {
        String anioStr = "";
        Calendar anio = Calendar.getInstance();
        int diadelanio = anio.get(Calendar.DAY_OF_YEAR);
        if (diadelanio >= 359) {
            int anioNUM = anio.get(Calendar.YEAR) + 1;
            anioStr = String.valueOf(anioNUM);
        } else {
            int anioNUM = anio.get(Calendar.YEAR);
            anioStr = String.valueOf(anioNUM);
        }
        return anioStr;
    }

}