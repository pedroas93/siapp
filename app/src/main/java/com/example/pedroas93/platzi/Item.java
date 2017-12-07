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
public class Item extends AppCompatActivity {

    private String price;
    private int pledgePrice;
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
    private String vv;
    private String arribo;
    private String arriboStatus;
    private String validacionv,resource,resource2;
    public static int indice=0, primero=0,indice2=0, primero2=0;

    public static ArrayList<Item> items = new ArrayList<>();


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

    public static ItemE item = new ItemE();
    public static ItemS itemss = new ItemS();



    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String price, float pledgePrice, String fromAddress, String toAddress, String date,
                String time, String cod, String guia, String factura,String bultos ,String v, String valorTasaContent,String resource, String resource2) {
        this.price = price;
        this.pledgePrice = (int)pledgePrice;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.time = time;
        this.cod = cod;
        this.guia = guia;
        this.valorFacturaContent = factura;
        this.bulto = bultos;
        this.vv = v;
        this.tipoCambio = valorTasaContent;
        this.resource = resource;
        this.resource2 = resource2;
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
    public String getType(){ return this.process.getType();}
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
    public String getValorValorContent() {

        return vv;
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


    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResource2() {
        return resource2;
    }

    public void setResource2(String resource2) {
        this.resource2 = resource2;
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

    public int getPledgePrice() {
        return pledgePrice;
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

        this.requestBtnClickListener = requestBtnClickListener;
    }

    public  static ArrayList<Item> getTestingList() {






        Log.i("UNITARIOOOOOOOOOOOOO"," valorrrrrrrrrrrrr"+ item.getUnitario());
        Log.i("UNcompletaOOOOOOOOOO", ""+item.getCompletado());
        Log.i("UNssssssssssssssssss"," valorrrrrrrrrrrrr"+ itemss.getUnitario());
        Log.i("UNsssnnnnnnnnnnnnnnnn", ""+itemss.getTotal());


        if(primero==0) {
                primero=1;
        }else{



                if (process.getType().equals("exportacion")) {
                    if(item.getUnitario()!=0 ) {
                        items.add(indice, new Item("DO", (item.getCompletado() / item.getUnitario()) * 100, process.getPedido(), "Progreso", process.getId(), process.getType(), process.getId(),
                                process.getGuiaAereaMaritima(), process.getFactura(), String.valueOf(process.getBultos()), String.valueOf(process.getValor()), String.valueOf(process.getTipoDeCambio()), "@drawable/resource", "resource3"));
                    }
                    } else {

                    if(itemss.getTotal()!=0) {
                        items.add(indice, new Item("DO", (itemss.getUnitario() / itemss.getTotal()) * 100, process.getPedido(), "Progreso", process.getId(), process.getType(), process.getId(),
                                process.getGuiaAereaMaritima(), process.getFactura(), String.valueOf(process.getBultos()), String.valueOf(process.getValor()), String.valueOf(process.getTipoDeCambio()),"resource5", "resource6"));
                    }
                }

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