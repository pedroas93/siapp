package com.example.pedroas93.platzi;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import data.model.Process.ArriboDeMercancia;
import data.model.Process.LiberacionDeDocDeTransporte;
import data.model.Process.Preinspeccion;
import data.model.Process.Process;
import data.model.Process.VistosBueno;

/**
 * Created by pedroas93 on 29/11/17.
 */

public class ItemE extends AppCompatActivity {
    private String time;
    private String descripcion;
    private String arribo;
    private String liberado;
    private String arriboStatus;
    private static String vBS,vBS1,vBS2,vBS3,vBSN,vBSN1,vBSN2,vBSN3;
    private static String v,v1,v2,v3,v4;
    public static float unitario=0, total=0, completado;

    private  static String recepcionDoc, recepcionValor;
    public static int indice=0, primero=0;
    private String color;

    public static VistosBueno vistoBueno = new VistosBueno();

    public static ArrayList<ItemE> itemE = new ArrayList<>();

    public static float getUnitario() {
        return unitario;
    }

    public static void setUnitario(float unitario) {
        ItemE.unitario = unitario;
    }

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        ItemE.total = total;
    }

    public static float getCompletado() {
        return completado;
    }

    public static void setCompletado(float completado) {
        ItemE.completado = completado;
    }

    public static Process process = new Process();


    public static ArriboDeMercancia arriboDeMercancia = new ArriboDeMercancia();


    public static LiberacionDeDocDeTransporte liberacionDeDocDeTransporte = new LiberacionDeDocDeTransporte();

    public static Preinspeccion preinspeccion = new Preinspeccion();



    private View.OnClickListener requestBtnClickListener;



    public ItemE() {

    }


        public ItemE(String arribo, String arriboStatus, String descripcion,String color) {

        this.arribo = arribo;
        this.arriboStatus = arriboStatus;
        this.descripcion = descripcion;
        this.color = color;

    }

    public void setGenerarVBStatus(String vistosBuenos) {
        vBS=vistosBuenos;
    }

    public void setGenerarVBNombre(String vistosBuenos) {
        vBSN=vistosBuenos;
    }

    public void setGenerarVBStatus1(String vistosBuenos) {
        vBS1=vistosBuenos;
    }

    public void setGenerarVBNombre1(String vistosBuenos) {
        vBSN1=vistosBuenos;;
    }
    public void setGenerarVBStatus2(String vistosBuenos) {
        vBS2=vistosBuenos;
    }

    public void setGenerarVBNombre2(String vistosBuenos) {
        vBSN2=vistosBuenos;
    }
    public void setGenerarVBStatus3(String vistosBuenos) {
        vBS3 = vistosBuenos;
    }


    public void setGenerarV(String vistosBuenos) {
        v=vistosBuenos;
    }
    public void setGenerarV1(String vistosBuenos) {
        v1=vistosBuenos;
    }
    public void setGenerarV2(String vistosBuenos) {
        v2=vistosBuenos;
    }
    public void setGenerarV3(String vistosBuenos) {
        v3=vistosBuenos;
    }
    public void setGenerarV4(String vistosBuenos) {
        v4=vistosBuenos;
    }


    public void setGenerarVBNombre3(String vistosBuenos) {
        vBSN3=vistosBuenos;
    }


    public void setRecepcionDoc(String recepcionDoc) {
        this.recepcionDoc = recepcionDoc;
    }

    public void setRecepcionDocValor(String valor) {
        this.recepcionValor = valor;
    }


    public void setProcess(String pedido) {
        this.process.setPedido(pedido);
    }


    public String getMercancia() {

        return arribo;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public String getColor() {

        return color;
    }


    public String getStatus() {

        return arriboStatus;

    }





    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {

        Log.i("SETREQUEST","ENTRO AL SET");
        this.requestBtnClickListener = requestBtnClickListener;
    }

    public  static ArrayList<ItemE> getTestingList() {



        String validacion="";
        if(primero==0) {
            primero=1;
        }else {

            String color = "";
            if (indice == 0) {

                setUnitario(getUnitario()+1);

                if (recepcionDoc.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + recepcionDoc);
                    color = "#E6E6E6";

                }
                if( recepcionDoc.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + recepcionDoc);
                    color = "#F9A300";

                }
                if ( recepcionDoc.equals("recibido")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + recepcionDoc);
                    color = "#408000";
                    completado++;

                }

                itemE.add(0, new ItemE(recepcionValor, recepcionDoc, "Recepción de documentos", color));

                indice++;
            }


            if (indice == 1) {

                setUnitario(getUnitario()+1);

                if (vBS.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS);
                    color = "#E6E6E6";

                }
                if( vBS.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS);
                    color = "#F9A300";

                }
                if ( vBS.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + vBS);
                    color = "#408000";
                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(1, new ItemE(vBSN, vBS, "Generación de vistos buenos", color));
                indice++;
            }



            if (indice == 2) {

                setUnitario(getUnitario()+1);

                if (vBS1.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS1);
                    color = "#E6E6E6";

                }
                if( vBS1.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS1);
                    color = "#F9A300";

                }
                if ( vBS1.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + vBS1);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(2, new ItemE(vBSN1, vBS1, "Generación de vistos buenos", color));
                indice++;
            }


            if (indice == 3) {

                setUnitario(getUnitario()+1);

                if (vBS2.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS2);
                    color = "#E6E6E6";

                }
                if( vBS2.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS2);
                    color = "#F9A300";

                }
                if ( vBS2.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + vBS2);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(3, new ItemE(vBSN2, vBS2, "Generación de vistos buenos", color));
                indice++;
            }

            if (indice == 4) {


                setUnitario(getUnitario()+1);

                if (vBS3.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS3);
                    color = "#E6E6E6";

                }
                if( vBS3.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + vBS3);
                    color = "#F9A300";

                }
                if ( vBS3.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + vBS3);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(4, new ItemE(vBSN3, vBS3, "Generación de vistos buenos", color));
                indice++;
            }


            if (indice == 5) {

                setUnitario(getUnitario()+1);

                if (v.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v);
                    color = "#E6E6E6";

                }
                if( v.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v);
                    color = "#F9A300";

                }
                if ( v.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + v);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(5, new ItemE("", v, "Elaboracion de documento de exportacion", color));
                indice++;
            }

            if (indice == 6) {

                setUnitario(getUnitario()+1);

                if (v1.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v1);
                    color = "#E6E6E6";

                }
                if( v1.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v1);
                    color = "#F9A300";

                }
                if ( v1.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + v1);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(6, new ItemE("", v1, "Solicitud de selectividas de documentos", color));
                indice++;
            }

            if (indice == 7) {

                setUnitario(getUnitario()+1);
                if (v2.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v2);
                    color = "#E6E6E6";

                }
                if( v2.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v2);
                    color = "#F9A300";

                }
                if ( v2.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + v2);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(7, new ItemE("", v2, "Entrega en Aerolinea/Puerto", color));
                indice++;
            }

            if (indice == 8) {

                setUnitario(getUnitario()+1);

                if (v3.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v3);
                    color = "#E6E6E6";

                }
                if( v3.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v3);
                    color = "#F9A300";

                }
                if ( v3.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + v3);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(8, new ItemE("", v3, "Salida de mercancia", color));
                indice++;
            }

            if (indice == 9) {

                setUnitario(getUnitario()+1);

                if (v4.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v4);
                    color = "#E6E6E6";

                }
                if( v4.equals("en proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + v4);
                    color = "#F9A300";

                }
                if ( v4.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + v4);
                    color = "#408000";

                    completado++;
                }

                Log.i("vistoBueno.getStatus()","VISTOSSSS BUENOSSSSSSS"+vistoBueno.getStatus());

                itemE.add(9, new ItemE("", v4, "Entrega de Documentos", color));
                indice++;
            }



            Log.i("Indice", "EL INDICE ES for" + indice);


        }





        return itemE;
    }







}