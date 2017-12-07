package com.example.pedroas93.platzi;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */


public class FoldingListaProcesos extends ArrayAdapter<ItemS> {


    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public static int arriboA = 0, arriboL= 0,indice =0;;


    public FoldingListaProcesos(Context context, List<ItemS> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // get item for selected view
        ItemS items = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new FoldingListaProcesos.ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell_lista, parent, false);
            // binding view parts to view holder



            Log.i("ARRIBO "," ENTRA"+ arriboA);

            // if(items.getArriboMercanciaStatus()!="fechaLlegada" ) {

            Log.i("ARRIBO "," ENTRA");

            viewHolder.arribo = (TextView) cell.findViewById(R.id.TituloList);
            viewHolder.arriboStatus = (TextView) cell.findViewById(R.id.contenidoListAbajo);
            viewHolder.arriboTitulo = (TextView) cell.findViewById(R.id.contenidoListArriba);
            viewHolder.colorArribo = (TextView) cell.findViewById(R.id.TituloList);


            arriboA++;

            //}

            //if(items.getLiberado()!="liberado" ) {



            arriboA++;
            //}


            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }


        // bind data from selected element to view through view holder

        viewHolder.arribo.setText(items.getStatus());

        viewHolder.arriboStatus.setText(items.getMercancia());
        viewHolder.arriboTitulo.setText(items.getDescripcion());
        viewHolder.colorArribo.setBackgroundColor(Color.parseColor(items.getColor()));

        //viewHolder.libreTitulo.setText("Liberación de documento de transporte");
        //viewHolder.colorLibre.setBackgroundColor(Color.parseColor("#057905"));




        if (items.getRequestBtnClickListener() == null) {
//          viewHolder.contentRequestBtn.setOnClickListener(items.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
        }




        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }



    // View lookup cache
    private static class ViewHolder {


        //Arribo
        TextView arribo;
        TextView arriboStatus;
        TextView arriboTitulo;

        TextView colorArribo;

    }
}


/*
public class FoldingListaProcesos extends ArrayAdapter<ItemS> {


    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public static int arriboA = 0, arriboL= 0;


    public FoldingListaProcesos(Context context, List<ItemS> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // get item for selected view
        ItemS items = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new FoldingListaProcesos.ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell_lista, parent, false);
            // binding view parts to view holder


            Log.i("ARRIBO "," ENTRA"+items.getArriboMercanciaStatus());
            Log.i("ARRIBO "," ENTRA"+ arriboA);

           // if(items.getArriboMercanciaStatus()!="fechaLlegada" ) {

                Log.i("ARRIBO "," ENTRA");

                viewHolder.arribo = (TextView) cell.findViewById(R.id.TituloList);
                viewHolder.arriboStatus = (TextView) cell.findViewById(R.id.contenidoListAbajo);
                viewHolder.arriboTitulo = (TextView) cell.findViewById(R.id.contenidoListArriba);
                viewHolder.colorArribo = (TextView) cell.findViewById(R.id.TituloList);


                arriboA++;

            //}

            //if(items.getLiberado()!="liberado" ) {

                Log.i("Libre "," ENTRA");

                viewHolder.libre = (TextView) cell.findViewById(R.id.TituloList);
                viewHolder.libreTitulo = (TextView) cell.findViewById(R.id.contenidoListArriba);
                viewHolder.colorLibre= (TextView) cell.findViewById(R.id.TituloList);


                arriboA++;
            //}


            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // bind data from selected element to view through view holder
        viewHolder.arribo.setText("Fecha Llegada");
        viewHolder.arriboStatus.setText(items.getArriboMercancia());
        viewHolder.arriboTitulo.setText("Llegada de mercancía");
        viewHolder.colorArribo.setBackgroundColor(Color.parseColor("#057905"));


        viewHolder.libre.setText("Liberado");
        viewHolder.libreTitulo.setText("Liberación de documento de transporte");
        viewHolder.colorLibre.setBackgroundColor(Color.parseColor("#057905"));




        if (items.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(items.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
        }




        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }



    // View lookup cache
    private static class ViewHolder {


        //Arribo
        TextView arribo;
        TextView arriboStatus;
        TextView arriboTitulo;

        TextView colorArribo;

        //Libre
        TextView libre;
        TextView libreStatus;
        TextView libreTitulo;

        TextView colorLibre;


        TextView contentRequestBtn;
        TextView llegada;
        TextView llegada2;
        TextView vv2;
        TextView TituloList;
    }
}

*/