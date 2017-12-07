package com.example.pedroas93.platzi;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import data.model.Process.ArriboDeMercancia;
import data.model.Process.LiberacionDeDocDeTransporte;
import data.model.Process.Preinspeccion;
import data.model.Process.Process;
import data.model.Process.Steps;
import data.model.Process.ValidacionVistosBueno;

/**
 * Simple POJO model for example
 */


/**
 * Simple POJO model for example
 */
public class ItemS extends AppCompatActivity {

    private String time;
    private String cod;
    private String guia;
    private String valorFacturaContent;
    private String bulto;
    private int valor;
    private String descripcion;
    private String arribo;
    private String liberado;
    private String arriboStatus;
    private String color;
    private  static String validacionv,validacionv1,validacionv2;
    private  static String validacionDoc,validacionDoc1,validacionDoc2;
    private  static String validacionNombreDoc,validacionNombreDoc1,validacionNombreDoc2;
    private  static String validacionvNombre,validacionvNombre1,validacionvNombre2;
    private  static String elaboracion,elaboracion1;
    private  static String solicitud;
    private  static String levante;
    private  static String pagoTributos;
    private  static String retiro;
    private  static String recepcionDoc, recepcionValor;
    private  static String elaboracionNombre,elaboracionNombre1;
    public static int indice=0, primero=0,indice2=0, primero2=0;
    public static float unitario=0,total=0;

    public static ArrayList<ItemS> items = new ArrayList<>();


    public static  int tamaño;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public static Process process = new Process();

    public static Steps steps = new Steps();

    public static ArriboDeMercancia arriboDeMercancia = new ArriboDeMercancia();

    public static ValidacionVistosBueno validacionVistosBueno = new ValidacionVistosBueno();

    public static ValidacionVistosBueno validacionVistosBueno2 = new ValidacionVistosBueno();

    public static LiberacionDeDocDeTransporte liberacionDeDocDeTransporte = new LiberacionDeDocDeTransporte();

    public static Preinspeccion preinspeccion = new Preinspeccion();



    private View.OnClickListener requestBtnClickListener;

    public ItemS() {
    }

    public ItemS(String arribo, String arriboStatus, String descripcion,String color) {

        this.arribo = arribo;
        this.arriboStatus = arriboStatus;
        this.descripcion = descripcion;
        this.color = color;

    }

    public static float getUnitario() {
        return unitario;
    }

    public static void setUnitario(float unitario) {
        ItemS.unitario = unitario;
    }

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        ItemS.total = total;
    }

    public void setValidacionv(String validacionv) {
        this.validacionv = validacionv;
    }

    public void setValidacionv1(String validacionv1) {
        this.validacionv1 = validacionv1;
    }
    public void setValidacionv2(String validacionv2) {
        this.validacionv2 = validacionv2;
    }


    public void setValidacionDoc(String validacionDoc) {
        this.validacionDoc = validacionDoc;
    }

    public void setValidacionDoc1(String validacionDoc1) {
        this.validacionDoc1 = validacionDoc1;
    }
    public void setValidacionDoc2(String validacionDoc2) {
        this.validacionDoc2 = validacionDoc2;
    }

    public void setValidacionElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public void setValidacionElaboracion1(String elaboracion) {
        this.elaboracion1 = elaboracion;
    }

    public String getValidacionvNombre() {
        return validacionvNombre;
    }

    public void setValidacionvNombre(String validacionv) {
        this.validacionvNombre = validacionv;
    }

    public void setValidacionvNombre1(String validacionv1) {
        this.validacionvNombre1 = validacionv1;
    }
    public void setValidacionvNombre2(String validacionv2) {
        this.validacionvNombre2 = validacionv2;
    }

    public void setValidacionNombreDoc(String validacion) {
        this.validacionNombreDoc = validacion;
    }

    public void setValidacionNombreDoc1(String validacion) {
        this.validacionNombreDoc1 = validacion;
    }
    public void setValidacionNombreDoc2(String validacion) {
        this.validacionNombreDoc2 = validacion;
    }

    public void setValidacionNombreElaboracion(String elaboracion) {
        this.elaboracionNombre = elaboracion;
    }

    public void setValidacionNombreElaboracion1(String elaboracion) {
        this.elaboracionNombre1 = elaboracion;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public void setPagoTributos(String pagoTributos) {
        this.pagoTributos = pagoTributos;
    }

    public void setLevante(String levante) {
        this.levante = levante;
    }

    public void setRetiroMercancia(String retiro) {
        this.retiro = retiro;
    }



    public void setProcess(String pedido) {
        this.process.setPedido(pedido);
    }

    //ARRIBOValune

    public void setArriboMercancia(String arriboMercancia) {

        this.arriboDeMercancia.setValue(arriboMercancia);
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



    //ARRIBOStatus
    public void setArriboMercanciaStatus(String arriboMercanciaStatus) {

        this.arriboDeMercancia.setStatus(arriboMercanciaStatus);
    }
    public String getStatus() {

        return arriboStatus;

    }

    //Liberado
    public void setLiberado(String liberado) {

        Log.i("ARRIBO MERCANCIA", "ASI LELGO  "+liberado);
        this.liberacionDeDocDeTransporte.setStatus(liberado);
    }
    public String getLiberado() {

        return this.liberacionDeDocDeTransporte.getStatus();
    }

    //pre-Inspeccion
    public void setPreinspeccion(String preinspeccion) {

        this.preinspeccion.setStatus(preinspeccion);
    }
    public String getPreinspeccion() {

        return this.preinspeccion.getStatus();
    }




    //ARRIBO




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

    public  static ArrayList<ItemS> getTestingList() {




        String validacion="";
        if(primero==0) {
            primero=1;
        }else {
            Log.i("pedido", "EL INDICE ES if " + process.getPedido() + " jummm " + process.getId());
            String color = "";
            if (indice == 0) {

                setTotal(getTotal()+1);

                validacion = arriboDeMercancia.getValue();

                if (arriboDeMercancia.getStatus().equals("pendiente")) {

                    color = "#F9A300";

                } else {

                    setUnitario(getUnitario()+1);

                    color = "#408000";

                }

                items.add(0, new ItemS(validacion, "Fecha de Llegada", "Llegada de mercancia", color));
                Log.i("pedido", "value es    " + validacion + " status es  " + arriboDeMercancia.getStatus());

                indice++;
            }
            if (indice == 1) {


                setTotal(getTotal()+1);
                if (liberacionDeDocDeTransporte.getStatus().equals("pendiente") || liberacionDeDocDeTransporte.getStatus().equals("en Proceso")) {

                    color = "#F9A300";

                } else {

                    setUnitario(getUnitario()+1);
                    color = "#408000";

                }


                validacion = liberacionDeDocDeTransporte.getStatus();
                items.add(1, new ItemS("", validacion, "Liberación de documento de transporte", color));
                indice++;
            }

            if (indice == 2) {

                setTotal(getTotal()+1);
                if (preinspeccion.getStatus().equals("pendiente") || preinspeccion.getStatus().equals("en Tramite")) {

                    color = "#F9A300";

                } else {

                    setUnitario(getUnitario()+1);
                    color = "#408000";

                }


                validacion = preinspeccion.getStatus();
                items.add(2, new ItemS("", validacion, "Preinspección", color));

                indice++;
            }

            if (indice == 3) {

                setTotal(getTotal()+1);
                if (validacionvNombre.equals("pendiente") || validacionvNombre.equals("en tramite")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionvNombre);
                    color = "#F9A300";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionvNombre);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionvNombre.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionvNombre);
                    color = "#800000";

                }

                items.add(3, new ItemS(validacionv, validacionvNombre, "Validación de vistos Buenos", color));

                indice++;
            }


            if (indice == 4) {

                setTotal(getTotal()+1);
                if (validacionvNombre1.equals("pendiente") || validacionvNombre1.equals("enTramite")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionvNombre1);
                    color = "#F9A300";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionvNombre1);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionvNombre1.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionvNombre1);
                    color = "#800000";

                }


                items.add(4, new ItemS(validacionv1, validacionvNombre1, "Validación de vistos Buenos", color));


                indice++;
            }

            if (indice == 5) {

                setTotal(getTotal()+1);
                String color2 = "";
                if (validacionvNombre2.equals("pendiente") || validacionvNombre2.equals("en Tramite")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionvNombre2);
                    color = "#F9A300";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionvNombre2);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionvNombre2.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionvNombre2);
                    color = "#800000";

                }


                items.add(5, new ItemS(validacionv2, validacionvNombre2, "Validación de vistos Buenos", color));


                indice++;
            }


            if (indice == 6) {

                setTotal(getTotal()+1);
                if (validacionNombreDoc.equals("pendiente") || validacionNombreDoc.equals("validando")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionNombreDoc);
                    color = "#F9A300";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionNombreDoc);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionNombreDoc.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionNombreDoc);
                    color = "#800000";

                }


                items.add(6, new ItemS(validacionDoc, validacionNombreDoc, "Validación de documentos", color));


                indice++;
            }


            if (indice == 7) {

                setTotal(getTotal()+1);
                if (validacionNombreDoc1.equals("pendiente") || validacionNombreDoc1.equals("validando")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionNombreDoc1);
                    color = "#F9A300";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionNombreDoc1);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionNombreDoc1.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionNombreDoc1);
                    color = "#800000";

                }


                items.add(7, new ItemS(validacionDoc1, validacionNombreDoc1, "Validación de documentos", color));


                indice++;
            }


            if (indice == 8) {

                setTotal(getTotal()+1);
                if (validacionNombreDoc2.equals("pendiente") || validacionNombreDoc2.equals("validando")) {

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + validacionNombreDoc2);
                    color = "#E6E6E6";

                } else {
                    Log.i("validacionvNombre2VERDE", "igual a ==" + validacionNombreDoc2);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                if (validacionNombreDoc2.equals("rechazado")) {
                    Log.i("validacionvNombre2ROJO", "igual a ==" + validacionNombreDoc2);
                    color = "#800000";

                }


                items.add(8, new ItemS(validacionDoc2, validacionNombreDoc2, "Validación de documentos", color));


                indice++;
            }


            if (indice == 9) {

                setTotal(getTotal()+1);
                if (elaboracionNombre.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + elaboracionNombre);
                    color = "#E6E6E6";

                }
                if( elaboracionNombre.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + elaboracionNombre);
                    color = "#F9A300";

                }
                if ( elaboracionNombre.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + elaboracionNombre);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }


                items.add(9, new ItemS(elaboracion, elaboracionNombre, "Elaboración de documento de importación", color));


                indice++;
            }

            if (indice == 10) {

                setTotal(getTotal()+1);
                if (elaboracionNombre1.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + elaboracionNombre1);
                    color = "#E6E6E6";

                }
                if( elaboracionNombre1.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + elaboracionNombre1);
                    color = "#F9A300";

                }
                if ( elaboracionNombre1.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + elaboracionNombre1);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(10, new ItemS(elaboracion1, elaboracionNombre1, "Elaboración de documento de importación", color));

                indice++;
            }


            if (indice == 11) {

                setTotal(getTotal()+1);

                if (solicitud.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + solicitud);
                    color = "#E6E6E6";

                }
                if( solicitud.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + solicitud);
                    color = "#F9A300";

                }
                if ( solicitud.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + solicitud);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(11, new ItemS("", solicitud, "Solicitud de giro de anticipo", color));

                indice++;
            }


            if (indice == 12) {

                setTotal(getTotal()+1);
                if (pagoTributos.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + pagoTributos);
                    color = "#E6E6E6";

                }
                if( pagoTributos.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + pagoTributos);
                    color = "#F9A300";

                }
                if ( pagoTributos.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + pagoTributos);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(12, new ItemS("", pagoTributos, "Pago de atributos", color));

                indice++;
            }


            if (indice == 13) {

                setTotal(getTotal()+1);
                if (levante.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + levante);
                    color = "#E6E6E6";

                }
                if( levante.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + levante);
                    color = "#F9A300";

                }
                if ( levante.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + levante);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(13, new ItemS("", levante, "Levante", color));

                indice++;
            }

            if (indice == 14) {

                setTotal(getTotal()+1);
                if (retiro.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#E6E6E6";

                }
                if( retiro.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#F9A300";

                }
                if ( retiro.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + retiro);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(14, new ItemS("", retiro, "Retiro de mercancia", color));

                indice++;
            }


            if (indice == 15) {

                setTotal(getTotal()+1);
                if (retiro.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#E6E6E6";

                }
                if( retiro.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#F9A300";

                }
                if ( retiro.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + retiro);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(15, new ItemS("", retiro, "Entrega de mercancia", color));

                indice++;
            }

            if (indice == 16) {

                setTotal(getTotal()+1);
                if (retiro.equals("pendiente")){

                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#E6E6E6";

                }
                if( retiro.equals("en Proceso")) {
                    Log.i("validacionvNombre2", "ANARANJADOigual a ==" + retiro);
                    color = "#F9A300";

                }
                if ( retiro.equals("generado")){
                    Log.i("validacionvNombre2VERDE", "igual a ==" + retiro);
                    color = "#408000";
                    setUnitario(getUnitario()+1);
                }

                items.add(16, new ItemS("", retiro, "Entrega de documentos", color));

                indice++;
            }





            Log.i("Indice", "EL INDICE ES for" + indice);


        }


        return items;
    }



}