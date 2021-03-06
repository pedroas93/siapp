package com.example.pedroas93.platzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import data.remote.APIService;
import data.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.PUT;

public class ListaProcesos extends AppCompatActivity {

    private APIService mAPIServicePush;
    public static ArrayList<ItemS> items ;
    public static String a;
    public static float total=0, unitario=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_procesos);

        mAPIServicePush = ApiUtils.getAPIService();

        ListView theListView = (ListView) findViewById(R.id.ListaProcesos);

        // prepare elements to display
        final ArrayList<ItemS> items = ItemS.getTestingList();



        // add custom btn handler to first list item



        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingListaProcesos adapter = new FoldingListaProcesos(this, items);

        // add default btn handler for each request btn on each item if custom handler not found
        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                //((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                //adapter.registerToggle(pos);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id= item.getItemId();



        switch (id){

            case R.id.menu_opcion:

                LoginActivity loginActivity = new LoginActivity();

                writeJSONObject("null");

                ////////////////////////////////////////////////




                String uno = null,dos = null;
                Object object = null;
                Object object1 = null;
                updateUser up= new updateUser("","");
                mAPIServicePush.updateUser(getIntent().getExtras().getString("parametro"),up).enqueue(new Callback<PUT>() {


                    @Override
                    public void onResponse(Call<PUT> call, Response<PUT> response) {
                        Log.i("ANTES DEL PUSH","ENTRO");
                        if (response.isSuccessful()) {
                            Log.i("ENTRO SENDPUSH","ENTRO");


                        } else {

                            Log.i("NOENTRO SENDPUSH","NOENTRO");

                        }
                    }

                    @Override
                    public void onFailure(Call<PUT> call, Throwable t) {
                        Log.i("PUSH","NO ENTRO PUSH PROCESS");
                    }
                });

                //////////////////////////////////////////////



                Intent irAVistaMenuActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(irAVistaMenuActivity);
                return true;


        }
        // if(id == R.id.action_settings)
        //     return true;
        // }



        return super.onOptionsItemSelected(item);
    }

    private void llenar(){


        // get our list view
        ListView theListView = (ListView) findViewById(R.id.mainListView);

        // prepare elements to display


        Log.i("INDICE","EL INDICE ES ENTRO10000");
        Log.i("ITEMS","Items esta asi ="+items.toString());

        // add custom btn handler to first list item
        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Ver mas","ENTRO A VER MAS");
                Intent irListaP = new Intent(getApplicationContext(), ListaProcesos.class);
                startActivity(irListaP);
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingListaProcesos adapter = new FoldingListaProcesos(this, items);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irListaP = new Intent(getApplicationContext(), ListaProcesos.class);
                startActivity(irListaP);
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
    }


    private	void	writeJSONObject(String response){
        Writer output	=	null;
        String	filename=	"locations.json";
        try	{
            File file	=	new	File(getBaseContext().getExternalFilesDir(null),	filename);
            Log.i("LOCATION",	"Ubicacion de	archivo:	"+file);
            output	=	new BufferedWriter(new FileWriter(file));
            output.write(response);
            output.close();
        }	catch	(Exception	e)	{
            Toast.makeText(getBaseContext(),	e.getMessage(),	Toast.LENGTH_LONG).show();
        }
    }

}
