package com.example.pedroas93.platzi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import data.model.Me.Get;
import data.model.Post;
import data.remote.APIService;
import data.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    Button btnlogin, btnCloseSession;
    //EditText usr, pwd;
    TextView txtWelcome, txtNombUser;
    Integer userId;
    //LoginService loginService;

    EditText etUsuario, etContra;
    Button btnIngresar;
    JSONArray ja;

    private TextView mResponseTv;
    private APIService mAPIService;
    private APIService mAPIService2;
    private APIService mAPIService3;

    private Boolean entro=false;
    private int cont = 0;
    private int logeado = 0;

    public CompletarRegistroActivity getCompletarRegistroActivity() {
        return completarRegistroActivity;
    }

    private final CompletarRegistroActivity completarRegistroActivity = new CompletarRegistroActivity();


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token;



    public int getLogeado() {
        return logeado;
    }

    public void setLogeado(int logeado) {
        this.logeado = logeado;
    }
    //public static final String MIXPANEL_TOKEN = "df18039a6bd3854eaef7b015db29d002";
    //MixpanelAPI mixpanel = MixpanelAPI.getInstance(LoginActivity.this, "MIXPANEL_TOKEN");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        final EditText titleEt = (EditText) findViewById(R.id.username);
        final EditText bodyEt = (EditText) findViewById(R.id.password);
        Button submitBtn = (Button) findViewById(R.id.login);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();
        mAPIService2 = ApiUtils.getAPIService();
        mAPIService3 = ApiUtils.getAPIService();




        Log.i("inicio", "llego antes del submit");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("OnClick", "Entro al onClick");
                String email = titleEt.getText().toString().trim();
                String password = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    Log.i("Password", "Entro al if de arriba  "+ email+ "----"+ password);
                    sendPostPassword(email, password);
                }
                cont++;
                Log.i("ElValorEntro==","Entro"+entro+"El cont es"+cont);


            }
        });


        //setContentView(R.layout.activity_login);
        //btnlogin = (Button) findViewById(login);
        //usr = (EditText) findViewById(R.id.username);
        //pwd=(EditText) findViewById(R.id.password);
        //btnlogin.setOnClickListener(this);

        //etUsuario = (EditText)findViewById(R.id.username);
        //etContra = (EditText)findViewById(R.id.password);
        //btnIngresar = (Button)findViewById(R.id.login);
/*
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ConsultaPass("http://siapp4973.cloudapp.net:6000/api/v1/users?user="+etUsuario.getText().toString());

            }
        });
*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }
/*
    private void ConsultaPass(String URL) {
        Log.i("url",""+URL);
        RequestQueue queue = Volley.newRequestQueue(this);
        Log.i("1",""+"LLego al queue");
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i("2",""+"onResponse");
                try {
                    Log.i("3",""+"try");
                    ja = new JSONArray(response);
                    String phone = ja.getString(0);
                    Log.i("4",""+"phone");
                    if(phone.equals(etUsuario.getText().toString())){
                        Log.i("Entro",""+"Entro al if");
                        Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(getApplicationContext(),"verifique su contraseña",Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(),"El usuario no existe en la base de datos",Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);



    }

*/

    //Rest para crear un usuario



    //Rest para loggear un usuario
    public void sendPostPassword(final String email, final String password) {


        mAPIService.login(email, password, true).enqueue(new Callback<Post>() {

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {



                    setLogeado(1);
                    entro = true;
                    cont++;
                    Log.i("ElValorEntro==","Entro"+entro);
                    Log.i("ImprimePassword", response.body().toString());

                    //showResponse(response.body().toString());

                    writeJSONObject(response.body().getData().getObjectData().getToken());

                    setToken(response.body().getData().getObjectData().getToken());
                    Log.i("TOKEN","EL TOKEN ES"+response.body().getData().getObjectData().getToken());
                    mAPIService2.me(response.body().getData().getObjectData().getToken()).enqueue(new Callback<Get>() {

                        @Override
                        public void onResponse(Call<Get> call, Response<Get> response2) {
                            if (response2.isSuccessful()) {
                                Log.i("AntesDelIf--PPPPPPPP==","EntroGetME"+response2.body().toString());
                                Log.i("AntesDelIf--GETME==","EntroGetME");
                                //showResponse(response2.body().toString());

                                String projectToken =  "df18039a6bd3854eaef7b015db29d002";

                                MixpanelAPI mixpanel = MixpanelAPI.getInstance(getApplicationContext(), projectToken);

                                try {
                                    mixpanel.identify(response2.body().getData().getObjectData().getUser().getId());
                                    mixpanel.getPeople().identify(response2.body().getData().getObjectData().getUser().getId());
                                    mixpanel.alias(response2.body().getData().getObjectData().getUser().getId(), null);
                                    mixpanel.getPeople().identify(mixpanel.getDistinctId());
                                    JSONObject props = new JSONObject();
                                    props.put("ID", response2.body().getData().getObjectData().getUser().getId());
                                    props.put("$name", response2.body().getData().getObjectData().getUser().getName());
                                    props.put("$email",response2.body().getData().getObjectData().getUser().getEmail());
                                    props.put("Telefono", response2.body().getData().getObjectData().getUser().getPhone());
                                    mixpanel.track("Log in", null);
                                    mixpanel.getPeople().set(props);
                                    Log.i("mixpannel","mixpannel");
                                } catch (JSONException e) {
                                    Log.e("MYAPP", "Unable to add properties to JSONObject", e);
                                }


                                Log.i("CREATE","Acount   client   "+response2.body().getData().getObjectData().getUser().getRole()+
                                        "    false   "+response2.body().getData().getObjectData().getUser().getCreated()
                                +"    active   "+response2.body().getData().getObjectData().getUser().getStatus());
                                boolean entra = false;
                                if(response2.body().getData().getObjectData().getUser().getRole().equals("client") &&
                                    response2.body().getData().getObjectData().getUser().getCreated().equals(entra) &&
                                        response2.body().getData().getObjectData().getUser().getStatus().equals("active")
                                        ){
                                    Log.i("CREATE","Acount --- Entro");
                                    Intent irAVistaCreate = new Intent(getApplicationContext(), CompletarRegistroActivity.class);
                                    irAVistaCreate.putExtra("parametro",getToken());
                                    startActivity(irAVistaCreate);
                                }
                            }else{
                                Log.i("AntesDelIf--Processes==",response2.errorBody().toString());
/*
                                                                JSONObject jsonObject = null;
                                                                try {
                                                                    jsonObject = (new JSONObject(String.valueOf(response2))).getJSONObject("");
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                try {
                                                                    Log.i("AntesDelIf--Processes==","Hash"+jsonObject.toString(2));
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                */
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
                        public void onFailure(Call<Get> call, Throwable t) {
                            Log.e("TAG", "Unable to submit post to API.");
                        }
                    });





                    entro = true;
                    Intent irAVistaMenuActivity = new Intent(getApplicationContext(), Proccess.class);
                    startActivity(irAVistaMenuActivity);
                    Log.i("TAG", "post submitted to API." + response.body().toString());
//------------------Guardar Datos en una variable
                    //--Init
                    int myvar = 12;


//--SAVE Data
                    //SharedPreferences preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                    //SharedPreferences.Editor editor = preferences.edit();
                    //editor.putInt("var1", myvar);
                    //editor.commit();




//--READ data
                    //myvar = preferences.getInt("var1", 0);

                    //Log.i("El dato guardado","El dato guardado es"+myvar);

                }else{

                    String projectToken =  "df18039a6bd3854eaef7b015db29d002";
                    MixpanelAPI mixpanel = MixpanelAPI.getInstance(LoginActivity.this, projectToken);

                    try {
                        mixpanel.identify("59bb23e55b45294370f2843c");
                        mixpanel.getPeople().identify("59bb23e55b45294370f2843c");
                        mixpanel.alias("59bb23e55b45294370f2843c", null);
                        mixpanel.getPeople().identify(mixpanel.getDistinctId());
                        JSONObject props = new JSONObject();
                        props.put("Servicio", "Log in");
                        props.put("Mensaje", "servicio fallo");
                        mixpanel.track("Error en servicio", props);
                        mixpanel.getPeople().set(props);
                        Log.i("mixpannel","mixpannel");
                    } catch (JSONException e) {
                        Log.e("MYAPP", "Unable to add properties to JSONObject", e);
                        Log.i("NoEntromixpannel","mixpannel no entro");
                    }

                    entro = false;
                    setLogeado(0);
                    Toast.makeText(getApplicationContext(),"Correo o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                    Log.i("No entro", "No quiso entrar");
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
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API.");
            }
        });
    }




    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
            Log.i("text","LLEGO AL TEXT");
        }
        mResponseTv.setText(response);
    }




/*

    @Override
    public void onClick (View v){
        switch (v.getId()){
            case login:
                String txtusr = usr.getText().toString();
                String txtpwd = pwd.getText().toString();

                if(!txtusr.equals("")&&!txtpwd.equals("")){

                    loginService = new LoginService();
                    loginService.execute(txtusr,txtpwd);

                }else{
                    Log.i("MyInfoTag","55555555555");
                    Toast.makeText(this,"Debe introducir usuario y contraseña", Toast.LENGTH_LONG ).show();
                }

                break;
            default:
                break;
        }
    }

    private class LoginService extends AsyncTask<String,String,Boolean>{

        JSONObject responseJSON;
        @Override
        protected Boolean doInBackground(String... params) {
            Log.i("MyInfoTag","11111111111111111111");
            boolean result = true;
            HttpClient htTpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://siapp4973.cloudapp.net:6000/api/v1/users/login");
            post.setHeader("content-type","application/json");
            Log.i("MyInfoTag","222222222222222222222222");
            //Construir el objeto

            JSONObject dato = new JSONObject();
            try {
                Log.i("MyTAg","3333333333333333333");
                dato.put("user",params[0]);
                dato.put("pass",params[1]);
                StringEntity entity = new StringEntity(dato.toString());
                post.setEntity(entity);
                Log.i("MyInfoTag","666666666666666666666");
                HttpResponse resp= htTpClient.execute(post);
                Log.i("MyInfoTag","777777777777777777777777777777777777");
                String respStr = EntityUtils.toString(resp.getEntity());
                Log.i("MyInfoTag","88888888888888888888888888888888");
                JSONObject respJSON = new JSONObject(respStr);
                Log.i("MyTAg","444444444444444444444444444444");
                if(!respJSON.getBoolean("Exito")){
                    Log.d("MyTAg","Entro al NO respJson");
                    result=false;
                }else{
                    Log.d("MyTAg","Entro al respJson");
                    responseJSON =respJSON;
                }


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        protected void onPostExecute(Boolean result){

            if(result ){

                try {
                    Log.i("MyInfoTag","999999999999999999999999999999999");
                    JSONObject datos = responseJSON.getJSONObject("Datos");
                    txtWelcome.setAlpha(1.0f);
                    txtNombUser.setText(datos.getString("Nombre"));
                    userId = datos.getInt("UserId");
                    btnCloseSession.setAlpha(1.0f);
                    usr.setAlpha(1.0f);
                    pwd.setAlpha(1.0f);
                    btnlogin.setAlpha(1.0f);

                    LoginActivity entrar = new LoginActivity();
                    entrar.goMenu(btnlogin);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }



*/

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
