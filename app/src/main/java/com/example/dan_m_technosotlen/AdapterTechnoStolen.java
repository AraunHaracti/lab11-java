package com.example.dan_m_technosotlen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;

import java.util.List;

public class AdapterTechnoStolen extends ArrayAdapter<TechnoStolen> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<TechnoStolen> technoStolens;

    public AdapterTechnoStolen(Context context, int resource, List<TechnoStolen> technoStolens) {
        super(context, resource, technoStolens);

        this.technoStolens = technoStolens;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TechnoStolen technoStolen = technoStolens.get(position);

        viewHolder.name.setText(technoStolen.getTs_name());

        return convertView;
    }

    private class ViewHolder {
        final TextView name;
        ViewHolder(View view){
            name = view.findViewById(R.id.name);
        }
    }
}
