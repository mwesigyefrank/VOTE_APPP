package com.example.amustvote;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    Context context;
    String[] positions;
    int[] image;
    LayoutInflater inflater;

    public Adapter(Context context, int[] image, String[] positions){
        this.context = context;
        this.image = image;
        this.positions = positions;
    }

    @Override
    public int getCount() {
        return positions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtemp;
        ImageView imgflag;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.nominate_custom_layout,parent,false);

        txtemp = itemView.findViewById(R.id.text);
        imgflag = itemView.findViewById(R.id.image);
        txtemp.setText(positions[position]);
        imgflag.setImageResource(image[position]);

        return itemView;
    }
}
