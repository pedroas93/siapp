package com.example.pedroas93.platzi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import data.model.Process.Get;
import data.remote.APIService;
import data.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.PUT;

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
public class Proccess extends AppCompatActivity {

    private APIService mAPIService3, mAPIServicePush;
    public static ArrayList<Item> items ;
    public static String a, tipo="";

    public int poss=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i("INDICE","EL INDICE ES ENTRO1");
        mAPIService3 = ApiUtils.getAPIService();
        mAPIServicePush = ApiUtils.getAPIService();
        Log.i("INDICE","EL INDICE ES ENTRO2");


        Log.i("INDICE","EL INDICE ES ENTRO4");
        String nuevoTexto = null;
        BufferedReader output	=	null;
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
        Log.i("LLego a PRocesses","EntroProcesses"+nuevoTexto);
        items = Item.getTestingList( );
        //PROSECESSES GET LLAMADO AL SERVICIO
        mAPIService3.processes(nuevoTexto).enqueue(new Callback<Get>() {

            @Override
            public void onResponse(Call<Get> call, Response<Get> response3) {
                if (response3.isSuccessful()) {

                    Log.i("INDICE","EL INDICE ES ENTRO56");
                    Log.i("AntesDelIf--PPPPPPPP==","EntroProcesses"+response3.body().toString());

                    Item item = new Item();
                    ItemS items = new ItemS();
                    ItemE itemE = new ItemE();

                    Log.i("setProcess",""+response3.body().getData().getObjectData().getProcess().get(1).getSteps().toString());

                    //for indicamos la variable indice en 0 para recorrer toda la lista, de inicio a fin al final de cada iteracion el indice se incrementa en uno
                    int total =0;

                    total =response3.body().getData().getObjectData().getProcess().size()-2;

                    if(response3.body().getData().getObjectData().getProcess().size()==0){

                        Intent noProceso = new Intent(getApplicationContext(), NoProceso.class);
                        startActivity(noProceso);

                    }

                    for(int indice = response3.body().getData().getObjectData().getProcess().size()-1;indice>=0;indice--)
                    {



                        Log.i("INDICEEEEEEE"," EL INDICE ES: "+ response3.body().getData().getObjectData().getProcess().size());
                        response3.body().getData().getObjectData().getProcess().size();
                        item.setProcess(response3.body().getData().getObjectData().getProcess().get(indice).getPedido());
                        item.setType(response3.body().getData().getObjectData().getProcess().get(indice).getType());
                        Log.i("pedido","  "+response3.body().getData().getObjectData().getProcess().get(indice).getType());
                        item.setProcessId(response3.body().getData().getObjectData().getProcess().get(indice).getProcessId());
                        item.setGuiaPedido(response3.body().getData().getObjectData().getProcess().get(indice).getGuiaAereaMaritima());
                        item.setValorFacturaContent(response3.body().getData().getObjectData().getProcess().get(indice).getFactura());
                        item.setValorBultosContent(Integer.toString(response3.body().getData().getObjectData().getProcess().get(indice).getBultos()));
                        Log.i("FECHA ARRIBO",""+response3.body().getData().getObjectData().getProcess().get(indice).getValor());
                        item.setValorValorContent(Integer.toString(response3.body().getData().getObjectData().getProcess().get(indice).getValor()));
                        item.setTasaCambio(Integer.toString(response3.body().getData().getObjectData().getProcess().get(indice).getTipoDeCambio()));
                        Log.i("FECHA ARRIBO",""+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia());





                        if(response3.body().getData().getObjectData().getProcess().get(indice).getType().equals("exportacion") ) {




                            ////////////////////////////////////////////////////////////////////////////////////////////


                            itemE.setGenerarV4(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getEntregaDeDocumentos().getStatus());

                            itemE.setGenerarV3(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getFechaSalidaMercancia().getStatus());


                            itemE.setGenerarV2(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getEntregaAerolinea().getStatus());


                            itemE.setGenerarV1(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getSolicitudSelectividadDocTransporte().getStatus());

                            itemE.setGenerarV(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getElaboracionDocExportacion().getStatus());

                            for(int indice1 = 0;indice1<response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getGeneracionVistosBuenos().size();indice1++) {

                                if(indice1==0) {
                                    itemE.setGenerarVBStatus3(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getStatus());
                                    itemE.setGenerarVBNombre3(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getName());


                                 }
                                if(indice1==1) {
                                    itemE.setGenerarVBStatus2(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getStatus());
                                    itemE.setGenerarVBNombre2(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getName());


                                 }
                                if(indice1==2) {

                                    itemE.setGenerarVBStatus1(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getStatus());
                                    itemE.setGenerarVBNombre1(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getName());

                                }
                                if(indice1==3) {
                                    itemE.setGenerarVBStatus(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getStatus());
                                    itemE.setGenerarVBNombre(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getGeneracionVistosBuenos().get(indice1).getName());
                                }

                            }

                             itemE.setRecepcionDocValor(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getRecepcionDeDocumentos().getValue());
                             itemE.setRecepcionDoc(response3.body().getData().getObjectData().getProcess().get(0).getSteps().getRecepcionDeDocumentos().getStatus().toString());

                            ////////////////////////////////////////////////////////////////////////////////////////////






                            itemE.itemE = ItemE.getTestingList();



                        }else{


                            tipo=response3.body().getData().getObjectData().getProcess().get(indice).getType();
                            Log.i("CUAL","Cual es --"+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia().getValue().toString());
                            Log.i("CUAL","Cual es --"+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia().getStatus());
                            items.setArriboMercancia(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia().getValue().toString());
                            items.setArriboMercanciaStatus(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia().getStatus());

                            items.setPreinspeccion(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getPreinspeccion().getStatus());

                            items.setLiberado(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getLiberacionDeDocDeTransporte().getStatus());



                            for(int indice1 = response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().size()-1;indice1>=0;indice1--) {
                                Log.i("FOR","en la posicion indice1 --"+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getName());

                                if(indice1==0) {
                                    items.setValidacionv(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getName());
                                    items.setValidacionvNombre(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getStatus());

                                }

                                if(indice1==1){
                                    items.setValidacionv1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getName());
                                    items.setValidacionvNombre1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getStatus());
                                }

                                if(indice1==2){
                                    items.setValidacionv2(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getName());
                                    items.setValidacionvNombre2(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionVistosBuenos().get(indice1).getStatus());

                                }
                            }

                            for(int indice1 = 0;indice1<response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().size();indice1++) {

                                if(indice1==0) {
                                    items.setValidacionDoc(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getName());
                                    items.setValidacionNombreDoc(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getStatus());
                                }

                                if(indice1==1) {
                                    items.setValidacionDoc1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getName());
                                    items.setValidacionNombreDoc1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getStatus());
                                }

                                if(indice1==2) {
                                    items.setValidacionDoc2(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getName());
                                    items.setValidacionNombreDoc2(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getValidacionDocumentos().get(indice1).getStatus());
                                }

                            }

                            for(int indice1 = 0;indice1<response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getElaboracionDeDocDeImportacion().size();indice1++) {

                                if(indice1==0) {
                                    items.setValidacionElaboracion(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getElaboracionDeDocDeImportacion().get(indice1).getName());
                                    items.setValidacionNombreElaboracion(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getElaboracionDeDocDeImportacion().get(indice1).getStatus());
                                }

                                if(indice1==1) {
                                    items.setValidacionElaboracion1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getElaboracionDeDocDeImportacion().get(indice1).getName());
                                    items.setValidacionNombreElaboracion1(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getElaboracionDeDocDeImportacion().get(indice1).getStatus());

                                }


                            }

                            items.setSolicitud(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getAnticipoAGirar().getStatus());
                            items.setPagoTributos(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getPagoDeTributos().getStatus());
                            items.setLevante(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getLevante().getStatus());
                            items.setRetiroMercancia(response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getRetiroDeMercancias().getStatus());



                            /////////////////////////////////////////////////////////////////////EXPORTACIÓN////////////////////////////////////////////////////////////////////////////

                            items.items = ItemS.getTestingList();



                        }


                        llenarExportacion();

                        Log.i("pedido",""+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia());
                        //Log.i("STEPS",""+response3.body().getData().getObjectData().getProcess().get(indice).getSteps().getArriboDeMercancia().getStatus());


                        item.items = Item.getTestingList( );

                    }

                }else{

                    Log.i("AntesDelIf--NO---",response3.message());

                    try {
                        JSONObject jsonObject = (new JSONObject(String.valueOf(response3))).getJSONObject("");

                        try {
                            Log.i("JSON","Hash"+jsonObject.toString(2));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }


            private SharedPreferences getSharedPreferences(String myPreferences, int modePrivate) {
                int modePrivatee;
                String myPreferencess;
                modePrivatee = modePrivate;
                myPreferencess = myPreferences;
                return null;
            }

            @Override
            public void onFailure(Call<data.model.Process.Get> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API   PROCESS");
            }
        });


        /////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////
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


    private void llenarImportacion(){


        // get our list view
        ListView theListView = (ListView) findViewById(R.id.mainListView);

        // prepare elements to display


        Log.i("IMPORTACION","LLEGO A IMPORTACIONNNNNNNNNNNNNNNNNNNNNNN");


        // add custom btn handler to first list item


        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, items);

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
                adapter.registerToggle(0);
            }
        });

    }



    private void llenarExportacion(){



        Log.i("EXPORTACION","LLEGO A EXPORTACIONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");

        // get our list view
        ListView theListView = (ListView) findViewById(R.id.mainListView);


        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, items);



        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).initialize(1000 , Color.GRAY ,0);
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
                Log.i("POSSSSSSSSSS","POS ES ="+pos);
                poss =pos;
            }
        });



        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("POSSSSLLEGANDO","POSLLEGANDOOOOOOOOOO ES ="+poss);
                if(poss ==0) {
                    Log.i("POSSSSLLEGANDO1","POSLLEGANDOOOOOOOOOO ES ="+poss);
                    Intent irListaP = new Intent(getApplicationContext(), ListaProcesosExport.class);
                    startActivity(irListaP);
                }else{
                    Log.i("POSSSSLLEGANDO2","POSLLEGANDOOOOOOOOOO ES ="+poss);
                    Intent irListaP = new Intent(getApplicationContext(), ListaProcesos.class);
                    startActivity(irListaP);

                }

            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);








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