package com.example.amu.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amu.R;
import com.example.amu.model.Sale;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListaSalesAdapter extends RecyclerView.Adapter<ListaSalesAdapter.SaleViewHolder> {

    ArrayList<Sale> sales;

    public ListaSalesAdapter(ArrayList<Sale> sales){
        this.sales =sales;
    }

    @NonNull
    @NotNull
    @Override
    public SaleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_compras,null,false);
        return new SaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SaleViewHolder holder, int position) {
        holder.viewDescripcion.setText("Descripcion: " + sales.get(position).getDescripcion());
        holder.viewFecha.setText("Fecha de Registro: " + sales.get(position).getFecha().toString());
        holder.viewPrecio.setText("Precio: " + Double.toString(sales.get(position).getTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return sales.size();
    }

    public class SaleViewHolder extends RecyclerView.ViewHolder {

        TextView viewFecha,viewDescripcion,viewPrecio;

        public SaleViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            viewDescripcion = itemView.findViewById(R.id.txtDescription1);
            viewFecha = itemView.findViewById(R.id.txtDate);
            viewPrecio = itemView.findViewById(R.id.txtPrice);
        }
    }
}
