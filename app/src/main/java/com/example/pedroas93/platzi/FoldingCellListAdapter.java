package com.example.pedroas93.platzi;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.price = (TextView) cell.findViewById(R.id.title_price);
            viewHolder.cod = (TextView) cell.findViewById(R.id.codigoContent);
            viewHolder.time = (TextView) cell.findViewById(R.id.title_time_label);
            viewHolder.date = (TextView) cell.findViewById(R.id.title_date_label);
            viewHolder.fromAddress = (TextView) cell.findViewById(R.id.title_from_address);
            viewHolder.toAddress = (TextView) cell.findViewById(R.id.title_to_address);
            viewHolder.requestsCount = (TextView) cell.findViewById(R.id.title_requests_count);
            viewHolder.pledgePrice = (TextView) cell.findViewById(R.id.title_pledge);
            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            viewHolder.valorGuiaContent = (TextView) cell.findViewById(R.id.valorGuiaContent);
            viewHolder.tipoCarta = (TextView) cell.findViewById(R.id.tipo);
            viewHolder.mercancia = (TextView) cell.findViewById(R.id.mercancia);
            viewHolder.valorFacturaContent = (TextView) cell.findViewById(R.id.valorFacturaContent);
            viewHolder.valorBultosContent = (TextView) cell.findViewById(R.id.valorBultosContent);
            viewHolder.valorTasaContent = (TextView) cell.findViewById(R.id.valorTasaContent);
            viewHolder.vv = (TextView) cell.findViewById(R.id.valorValorContent);
            viewHolder.progressBar=(ProgressBar) cell.findViewById(R.id.progressBar);

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
        viewHolder.price.setText(item.getPrice());
        viewHolder.cod.setText(item.getCod());
        viewHolder.time.setText(item.getTime());
        viewHolder.date.setText(item.getDate());
        viewHolder.fromAddress.setText(item.getFromAddress());
        viewHolder.toAddress.setText(item.getToAddress());
        viewHolder.pledgePrice.setText(Float.toString(item.getPledgePrice())+"%");
        viewHolder.valorGuiaContent.setText(item.getGuia());
        viewHolder.tipoCarta.setText(item.getTime());
        viewHolder.mercancia.setText(item.getFromAddress());
        viewHolder.valorFacturaContent.setText(item.getValorFacturaContent());
        viewHolder.valorBultosContent.setText(item.getValorBultosContent());
        viewHolder.valorTasaContent.setText("$"+item.getTasaCambio()+" COP");
        viewHolder.vv.setText(item.getValorValorContent());
        viewHolder.progressBar.setProgress(Math.round(item.getPledgePrice()));
        viewHolder.progressBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(249,163,0)));

// set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
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
        TextView price;
        TextView contentRequestBtn;
        TextView cod;
        TextView pledgePrice;
        TextView fromAddress;
        TextView toAddress;
        TextView requestsCount;
        TextView date;
        TextView time;
        TextView valorGuiaContent;
        TextView tipoCarta;
        TextView mercancia;
        TextView valorFacturaContent;
        TextView valorBultosContent;
        TextView valorTasaContent;
        TextView vv;
        ProgressBar progressBar;
        TextView arribo;
        RelativeLayout resource;
        RelativeLayout resource2;

    }
}