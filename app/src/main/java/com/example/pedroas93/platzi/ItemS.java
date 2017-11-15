package com.example.pedroas93.platzi;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import data.model.Process.ArriboDeMercancia;
import data.model.Process.LiberacionDeDocDeTransporte;
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

    private String price;
    private String pledgePrice;
    private String fromAddress;
    private String toAddress;
    private String date;
    private String time;
    private String cod;
    private String guia;
    private String valorFacturaContent;
    private String bulto;
    private int valor;
    private String tipoCambio;
    private String arribo;
    private String liberado;
    private String arriboStatus;
    private String validacionv;
    public static int indice=0, primero=0,indice2=0, primero2=0;

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



    private View.OnClickListener requestBtnClickListener;

    public ItemS() {
    }

    public ItemS(String arribo, String arriboStatus, String liberado) {

        this.arribo = arribo;
        this.arriboStatus = arriboStatus;
        this.liberado = liberado;

    }


    public void setValorBultosContent(String bultos) {

        Log.i("BULTOS LLEGA ASI", "ASI LELGO"+bultos);

        this.process.setBultos(Integer.parseInt(bultos));
    }
    public void setProcess(String pedido) {
        this.process.setPedido(pedido);
    }
    public void setType(String tipo) {
        this.process.setType(tipo);
    }
    public void setProcessId(String id) {
        this.process.setId(id);
    }

    public void setGuiaPedido(String Guia) {
        this.process.setGuiaAereaMaritima(Guia);
    }

    public void setValorFacturaContent(String valorFacturaContent) {
        this.process.setFactura(valorFacturaContent);
    }

    public void setValorValorContent(String vv) {
        this.process.setValor(Integer.parseInt(vv));
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setTasaCambio(String tipoCambio) {

        Log.i("TASA CAMBIO ", "ASI LELGO  "+tipoCambio);
        this.process.setTipoDeCambio(Integer.parseInt(tipoCambio));
    }
    public String getTasaCambio() {

        return tipoCambio;
    }






    public void setValorv(String vvv) {

        Log.i("ARRIBO MERCANCIA", "ASI LELGO  "+vvv);
        this.validacionVistosBueno.setName(vvv);
    }
    public String getValorv() {

        return this.validacionVistosBueno.getName();
    }

    public void setValorv2(String vvv) {

        Log.i("ARRIBO MERCANCIA", "ASI LELGO  "+vvv);
        this.validacionVistosBueno2.setName(vvv);
    }
    public String getValorv2() {

        return this.validacionVistosBueno2.getName();
    }


    public void setLlegada(String llegada) {

        Log.i("LLEGADA MERCANCIA", "ASI LLEGO  "+llegada);
        this.validacionVistosBueno.setStatus(llegada);
    }
    public String getLlegada() {

        return this.validacionVistosBueno.getStatus();
    }

    public void setLlegadav2(String llegada) {

        Log.i("LLEGADA MERCANCIA", "ASI LLEGO  "+llegada);
        this.validacionVistosBueno2.setStatus(llegada);
    }
    public String getLlegadav2() {

        return this.validacionVistosBueno2.getStatus();
    }


    //ARRIBOValune

    public void setArriboMercancia(String arriboMercancia) {

        this.arriboDeMercancia.setValue(arriboMercancia);
    }
    public String getArriboMercancia() {

        return arribo;
    }
    //ARRIBOStatus
    public void setArriboMercanciaStatus(String arriboMercanciaStatus) {

        this.arriboDeMercancia.setStatus(arriboMercanciaStatus);
    }
    public String getArriboMercanciaStatus() {

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



    //ARRIBO


    public String getValorFacturaContent() {
        return valorFacturaContent;
    }

    public String getValorBultosContent() {
        return bulto;
    }

    public int getValorcontent() {
        return valor;
    }

    public String getPrice() {
        return price;
    }
    public String getGuia() {
        return guia;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public  static ArrayList<ItemS> getTestingList() {




        if(primero==0) {
            primero=1;
        }else{
            Log.i("pedido", "EL INDICE ES if" + process.getPedido()+"jummm"+ process.getId());


            items.add(indice2, new ItemS(arriboDeMercancia.getValue(),arriboDeMercancia.getStatus(),liberacionDeDocDeTransporte.getStatus()));

            indice++;
            Log.i("Indice", "EL INDICE ES for" + indice);


        }


        //items.add(new Item("DO", "52%", process.getPedido(), "Progreso", process.getId(), process.getType(), process.getId(), process.getGuiaAereaMaritima(), process.getFactura()
        //       , String.valueOf(process.getBultos()), String.valueOf(process.getValor()), String.valueOf(process.getTipoDeCambio()), arriboDeMercancia.getValue()));
        //items.add(new Item("$23", "$116", "W 36th St, NY, 10015", "W 114th St, NY, 10037", "10", "TODAY", "11:10 AM", null, null, null, null, null, null));

        /*
        items.add(new Item("$63", "$350", "W 36th St, NY, 10029", "56th Ave, NY, 10041", 0, "TODAY", "07:11 PM"));
        items.add(new Item("$19", "200", "12th Ave, NY, 10012", "W 57th St, NY, 10048", 8, "TODAY", "4:15 AM"));
        items.add(new Item("$5", "$300", "56th Ave, NY, 10041", "W 36th St, NY, 10029", 0, "TODAY", "06:15 PM"));
        */


        return items;
    }



}
/*
public class ItemS extends AppCompatActivity {

    private String arribo;
    private String arriboStatus;
    private String liberado;
    private String validacionv;
    public static int indice=0,indice2=0, primero2=0;

    public static ArrayList<ItemS> items = new ArrayList<>();



    private View.OnClickListener requestBtnClickListener;
    public static ArriboDeMercancia arriboDeMercancia = new ArriboDeMercancia();
    public static LiberacionDeDocDeTransporte liberacionDeDocDeTransporte = new LiberacionDeDocDeTransporte();

    public static ValidacionVistosBueno validacionVistosBueno = new ValidacionVistosBueno();



    public ItemS() {
    }

    public ItemS(String arribo, String arriboStatus, String liberado) {

        this.arribo = arribo;
        this.arriboStatus = arriboStatus;
        this.liberado = liberado;

    }

    //ARRIBOValune

    public void setArriboMercancia(String arriboMercancia) {

        this.arriboDeMercancia.setValue(arriboMercancia);
    }
    public String getArriboMercancia() {

        return arribo;
    }
    //ARRIBOStatus
    public void setArriboMercanciaStatus(String arriboMercanciaStatus) {

        this.arriboDeMercancia.setStatus(arriboMercanciaStatus);
    }
    public String getArriboMercanciaStatus() {

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




    @Override
    public int hashCode() {
        return 10;
    }




    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {

        Log.i("SETREQUEST","ENTRO AL SET");
        this.requestBtnClickListener = requestBtnClickListener;
    }



    public  static ArrayList<ItemS> getTestingList2() {

            items.add(indice2, new ItemS(arriboDeMercancia.getValue(),arriboDeMercancia.getStatus(),liberacionDeDocDeTransporte.getStatus()));



        return items;
    }

}
*/