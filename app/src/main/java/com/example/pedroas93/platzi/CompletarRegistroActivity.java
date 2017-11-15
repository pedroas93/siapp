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
import android.widget.Toast;

import data.remote.APIService;
import data.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.PUT;

import static com.example.pedroas93.platzi.R.id.name;




public class CompletarRegistroActivity extends AppCompatActivity {



    private APIService mAPIServiceP;

    public static LoginActivity getLogin() {
        return login;
    }

    public static void setLogin(LoginActivity login) {
        CompletarRegistroActivity.login = login;
    }

    private static LoginActivity login = new LoginActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completar_registro);

        mAPIServiceP = ApiUtils.getAPIService();


        final EditText nombre = (EditText) findViewById(name);
        final EditText cedula = (EditText) findViewById(R.id.cedula);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText contraseña = (EditText) findViewById(R.id.contraseña);
        final EditText cContraseña = (EditText) findViewById(R.id.confirmarConstraseña);
        final EditText numero = (EditText) findViewById(R.id.numero);
        final EditText direccion = (EditText) findViewById(R.id.direccion);
        Button submitBtn = (Button) findViewById(R.id.ingresar);




        Log.i("Toker", getIntent().getExtras().getString("parametro"));
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreS = nombre.getText().toString().trim();
                String cedulaS = cedula.getText().toString().trim();
                String emailS = email.getText().toString().trim();
                String contraseñaS = contraseña.getText().toString().trim();
                String cContraseñaS = cContraseña.getText().toString().trim();
                String numeroS = numero.getText().toString().trim();
                String direccionS = direccion.getText().toString().trim();

                Log.i("OnClick", "Entro al onClick"+nombreS);
                Log.i("nombreS", "Entro al onClick"+cedulaS);
                Log.i("cedulaS", "Entro al onClick"+emailS);
                Log.i("emailS", "Entro al onClick"+contraseñaS);
                Log.i("contraseñaS", "Entro al onClick"+cContraseñaS);
                Log.i("cContraseñaS", "Entro al onClick"+numeroS);
                Log.i("numeroS", "Entro al onClick"+direccionS);

                if (!TextUtils.isEmpty(nombreS) && !TextUtils.isEmpty(cedulaS)
                        && !TextUtils.isEmpty(emailS)&& !TextUtils.isEmpty(contraseñaS)
                        && !TextUtils.isEmpty(cContraseñaS)&& !TextUtils.isEmpty(numeroS)
                        && !TextUtils.isEmpty(direccionS)) {

                    if(cContraseñaS.equals(contraseñaS)) {
                        Log.i("OnClick  IFF  ", "Entro al onClick IFF");
                        sendPutUser(getIntent().getExtras().getString("parametro"), nombreS, cedulaS, emailS, contraseñaS, cContraseñaS, numeroS, direccionS);
                    }else{

                        Toast.makeText(getApplicationContext(),"Las Contraseñas deben ser las mismas",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }




    public void sendPutUser(final String token, final String nombreS, final String cedulaS, final String emailS, final String contraseñaS, final String cContraseñaS, final String numeroS, final String direccionS) {

        Log.i("Entro sendPutUser==","Entro");
        mAPIServiceP.updateUser(token, nombreS, numeroS, direccionS, contraseñaS, true).enqueue(new Callback<PUT>() {

            @Override
            public void onResponse(Call<PUT> call, Response<PUT> response) {
                if (response.isSuccessful()) {
                    Log.i("NENTRO SENDPUTUSER==","ENTRO");
                    Intent irAVistaMenuActivity = new Intent(getApplicationContext(), Proccess.class);
                    startActivity(irAVistaMenuActivity);
                } else {

                    Log.i("NOENTRO SENDPUTUSER==","NOENTRO");

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
            public void onFailure(Call<PUT> call, Throwable t) {
                Intent irAVistaMenuActivity = new Intent(getApplicationContext(), Proccess.class);
                startActivity(irAVistaMenuActivity);
            }
        });




    }




}

