package mx.edu.utng.orders.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.orders.R;
import mx.edu.utng.orders.model.English;


/**
 * Created by axeljovanny on 23/02/17.
 */

public class EnglishAdapter extends RecyclerView.Adapter <EnglishAdapter.EnglishViewHolder>
        implements View.OnClickListener {

    List<English> englishes;
    View.OnClickListener listener;
    //Constructor
    public EnglishAdapter(List<English> englishes){
        this.englishes=englishes;
    }




    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @Override
    public EnglishAdapter.EnglishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_english_layout,parent,false);
        EnglishViewHolder holder = new EnglishViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EnglishAdapter.EnglishViewHolder holder, int position) {
        holder.tvEnglishValue.setText(englishes.get(position).getValue());
        holder.tvEnglishAbbreviation.setText(englishes.get(position).getAbbreviation());
        holder.tvEnglishSpelling.setText(englishes.get(position).getSpelling());
        holder.iv_English.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return englishes.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class EnglishViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvEnglish;
        TextView tvEnglishValue;
        TextView tvEnglishAbbreviation;
        TextView tvEnglishSpelling;
        ImageView iv_English;
        ImageButton btEditEnglish;
        ImageButton btDeleteEnglish;
        View.OnClickListener listener;




        public EnglishViewHolder(View itemView) {
            super(itemView);
            cvEnglish=(CardView)itemView.findViewById(R.id.cv_english);
            iv_English=(ImageView)itemView.findViewById(R.id.iv_english);
            tvEnglishValue=(TextView)itemView.findViewById(R.id.tv_english_value);
            tvEnglishAbbreviation=(TextView)itemView.findViewById(R.id.tv_english_abbreviation);
            tvEnglishSpelling=(TextView)itemView.findViewById(R.id.tv_english_spelling);
            btEditEnglish=(ImageButton) itemView.findViewById(R.id.bt_edit_english);
            btDeleteEnglish=(ImageButton) itemView.findViewById(R.id.bt_delete_english);
            btEditEnglish.setOnClickListener(this);
            btDeleteEnglish.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }


}
