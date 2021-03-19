package com.bookingman.svaratest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bookingman.svaratest.model.Radio;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.RadioViewHolder>{
    private ArrayList<Radio> radioList;

    public RadioAdapter(ArrayList<Radio> radioList){
        this.radioList = radioList;
    }

    @Override
    public RadioViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.radio_view, parent, false);
        return new RadioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RadioViewHolder holder, int position){
        String freq = Double.toString(radioList.get(position).getFrequency());
        String cf = radioList.get(position).getCity() + " " + freq;
        holder.txtNamaRadio.setText(radioList.get(position).getName());
        holder.txtCityFreq.setText(cf);

        holder.txtNamaRadio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int id = radioList.get(position).getId();

//                Intent intent = new Intent(this, RadioActivity.class);
//                intent.putExtra("message_key", id);

//                startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (radioList != null) ? radioList.size() : 0;
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaRadio, txtCityFreq;

        public RadioViewHolder(View itemView){
            super(itemView);
            txtNamaRadio = (TextView) itemView.findViewById(R.id.txt_nama_radio);
            txtCityFreq = (TextView) itemView.findViewById(R.id.txt_city_freq);
        }
    }
}
