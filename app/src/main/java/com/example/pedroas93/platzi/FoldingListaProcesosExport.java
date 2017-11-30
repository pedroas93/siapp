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
 * Created by pedroas93 on 29/11/17.
 */

public class FoldingListaProcesosExport extends ArrayAdapter<ItemE> {



    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public static int arriboA = 0, arriboL= 0,indice =0;;


    public FoldingListaProcesosExport(Context context, List<ItemE> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // get item for selected view
        ItemE itemE = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        FoldingListaProcesosExport.ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new FoldingListaProcesosExport.ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell_lista, parent, false);
            // binding view parts to view holder



            Log.i("ARRIBO "," ENTRA"+ arriboA);

            Log.i("ARRIBO "," ENTRA");

            viewHolder.arribo = (TextView) cell.findViewById(R.id.TituloList);
            viewHolder.arriboStatus = (TextView) cell.findViewById(R.id.contenidoListAbajo);
            viewHolder.arriboTitulo = (TextView) cell.findViewById(R.id.contenidoListArriba);
            viewHolder.colorArribo = (TextView) cell.findViewById(R.id.TituloList);


            arriboA++;

            //}


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
            viewHolder = (FoldingListaProcesosExport.ViewHolder) cell.getTag();
        }


        // bind data from selected element to view through view holder

        viewHolder.arribo.setText(itemE.getStatus());

        viewHolder.arriboStatus.setText(itemE.getMercancia());
        viewHolder.arriboTitulo.setText(itemE.getDescripcion());
        viewHolder.colorArribo.setBackgroundColor(Color.parseColor(itemE.getColor()));

        //viewHolder.libreTitulo.setText("Liberación de documento de transporte");
        //viewHolder.colorLibre.setBackgroundColor(Color.parseColor("#057905"));




        if (itemE.getRequestBtnClickListener() == null) {
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

