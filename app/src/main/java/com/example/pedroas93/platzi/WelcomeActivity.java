package com.example.pedroas93.platzi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import io.fabric.sdk.android.Fabric;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private PrefManager prefManager;
    private long TInicio, TFin, tiempo;
    private int entro = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {






        InputStreamReader flujo=null;
        BufferedReader lector=null;
        String nuevoTexto = "null";


        BufferedReader  output	=	null;
        String	filename=	"locations.json";
        try	{
            File file	=	new	File(getBaseContext().getExternalFilesDir(null),	filename);
            Log.i("LOCATION",	"Ubicacion de	archivo:	"+file);
            output	=	new BufferedReader(new FileReader(file));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = output.readLine()) != null ) {
                stringBuilder.append(receiveString);
            }

            nuevoTexto = stringBuilder.toString();


            output.read();
            output.close();
        }	catch	(Exception	e)	{
            Toast.makeText(getBaseContext(),	e.getMessage(),	Toast.LENGTH_LONG).show();
        }


        Log.i("ELVALORDELOGEADOES=","VAlor=="+output);
        Log.i("ELVALORDELOGEADOES=","VAlor=="+nuevoTexto);
        if(nuevoTexto.equals("null")){

            Log.i("ENTRO","VAlor=="+nuevoTexto);
            String projectTokenAppabierta =  "df18039a6bd3854eaef7b015db29d002"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
            MixpanelAPI mixpanelInicio = MixpanelAPI.getInstance(this, projectTokenAppabierta);
            Boolean logueado = false;

            try {
                mixpanelInicio.identify("59bb23e55b45294370f2843c");
                mixpanelInicio.getPeople().identify("59bb23e55b45294370f2843c");
                mixpanelInicio.alias("59bb23e55b45294370f2843c", null);
                mixpanelInicio.getPeople().identify(mixpanelInicio.getDistinctId());
                JSONObject props = new JSONObject();
                props.put("Logueado",logueado );
                mixpanelInicio.track("App abierta", props);
                Log.i("mixpannel","mixpannel");
            } catch (JSONException e) {
                Log.e("MYAPP", "Unable to add properties to JSONObject", e);
                Log.i("NoEntromixpannel","mixpannel no entro");
            }


            TInicio = System.currentTimeMillis();
            super.onCreate(savedInstanceState);
            Fabric.with(this, new Crashlytics());

            // Checking for first time launch - before calling setContentView()
            //prefManager = new PrefManager(this);
            //if (!prefManager.isFirstTimeLaunch()) {
            //    launchHomeScreen();
            //    finish();
            //}

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }


            String projectToken =  "df18039a6bd3854eaef7b015db29d002"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this, projectToken);

            try {
                mixpanel.identify("59bb23e55b45294370f2843c");
                mixpanel.getPeople().identify("59bb23e55b45294370f2843c");
                mixpanel.alias("59bb23e55b45294370f2843c", null);
                mixpanel.getPeople().identify(mixpanel.getDistinctId());
                JSONObject props = new JSONObject();
                props.put("ID", "59bb23e55b45294370f2843c");//No se usa
                mixpanel.track("Pantalla onboarding", null);
                Log.i("mixpannel","mixpannel");
            } catch (JSONException e) {
                Log.e("MYAPP", "Unable to add properties to JSONObject", e);
                Log.i("NoEntromixpannel","mixpannel no entro");
            }
            setContentView(R.layout.activity_welcome);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSkip = (Button) findViewById(R.id.btn_skip);
            btnNext = (Button) findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.welcome_slide1,
                    R.layout.welcome_slide2,
                    R.layout.welcome_slide3,
                    R.layout.welcome_slide4};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    }
                }
            });
        }else{

            super.onCreate(savedInstanceState);
            Intent irAVistaMenuActivity = new Intent(getApplicationContext(), Proccess.class);
            startActivity(irAVistaMenuActivity);

        }

    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    //	viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            TFin = System.currentTimeMillis();
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("Onclick", "Entro al Onclick de GOT IT");
                        Intent irAVistaLogin = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(irAVistaLogin);
                    }
                });
            } else {
                // still pages are left
                String projectToken =  "df18039a6bd3854eaef7b015db29d002"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
                MixpanelAPI mixpanel = MixpanelAPI.getInstance(WelcomeActivity.this, projectToken);

                try {
                    mixpanel.identify("59bb23e55b45294370f2843c");
                    mixpanel.getPeople().identify("59bb23e55b45294370f2843c");
                    mixpanel.alias("59bb23e55b45294370f2843c", null);
                    mixpanel.getPeople().identify(mixpanel.getDistinctId());
                    JSONObject pag = new JSONObject();
                    pag.put("Pagina", position);
                    tiempo = TFin/1000 - TInicio/1000;
                    pag.put("Tiempo en pagina",tiempo);
                    mixpanel.track("Deslizar onboarding", pag);
                    Log.i("mixpannel","mixpannel");
                } catch (JSONException e) {
                    Log.e("MYAPP", "Unable to add properties to JSONObject", e);
                    Log.i("NoEntromixpannel","mixpannel no entro");
                }
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    public void goLogin(View view){
        Intent irLogin = new Intent(this, LoginActivity.class);
        startActivity(irLogin);
    }


    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}