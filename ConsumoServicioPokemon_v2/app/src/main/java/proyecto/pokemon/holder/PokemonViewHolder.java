package proyecto.pokemon.holder;

import proyecto.pokemon.R;
import proyecto.pokemon.activity_interface.RecyclerViewClickListener;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static RecyclerViewClickListener mListener;
    protected CardView cv;
    protected ImageView thumbnail;
    protected TextView title;
    protected TextView type;

    public CardView getCv() {
        return cv;
    }

    public void setCv(CardView cv) {
        this.cv = cv;
    }

    public ImageView getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageView thumbnail) {
        this.thumbnail = thumbnail;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getType() {
        return type;
    }

    public void setType(TextView type) {
        this.type = type;
    }

    public PokemonViewHolder (View view) {
        super(view);
        this.cv = (CardView) view.findViewById(R.id.card_pokemon);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail_pokemon);
        this.title = (TextView) view.findViewById(R.id.nombre_pokemon);
        this.type = (TextView) view.findViewById(R.id.tipo_pokemon);

        this.cv.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        System.out.println("click en vista adapter pokemon");
        Toast.makeText(v.getContext(), "Nombre: "+this.title.getText().toString()+" Tipo: "+this.type.getText().toString(), Toast.LENGTH_SHORT).show();

    }

}