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

/**
 * Created by pedroas93 on 29/11/17.
 */

public class ListaProcesosExport extends AppCompatActivity {


    public static ArrayList<ItemE> itemE ;
    public static String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_procesoext);


        ListView theListView = (ListView) findViewById(R.id.ListaProcesoext);

        // prepare elements to display
        final ArrayList<ItemE> itemE = ItemE.getTestingList();



        // add custom btn handler to first list item



        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingListaProcesosExport adapter = new FoldingListaProcesosExport(this, itemE);

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
        Log.i("ITEMS","Items esta asi ="+itemE.toString());

        // add custom btn handler to first list item
        itemE.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Ver mas","ENTRO A VER MAS");
                Intent irListaP = new Intent(getApplicationContext(), ListaProcesos.class);
                startActivity(irListaP);
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingListaProcesosExport adapter = new FoldingListaProcesosExport(this, itemE);

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
