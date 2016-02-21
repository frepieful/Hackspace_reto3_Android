package proyecto.pokemon.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import proyecto.pokemon.R;
import proyecto.pokemon.activity_interface.RecyclerViewClickListener;
import proyecto.pokemon.entity.PokemonEntity;
import proyecto.pokemon.holder.PokemonViewHolder;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    public PokemonViewHolder pokemonHolder;
    private ArrayList<PokemonEntity> PokemonEntityList;

    private Context mContext;

    public PokemonAdapter(Context context, ArrayList<PokemonEntity> PokemonEntityList) {
        this.PokemonEntityList = PokemonEntityList;
        this.mContext = context;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);
        PokemonViewHolder mh = new PokemonViewHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder (PokemonViewHolder PokemonViewHolder, int i) {
        PokemonEntity PokemonEntity = PokemonEntityList.get(i);

        Picasso.with(mContext).load(PokemonEntity.getImagen())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(PokemonViewHolder.getThumbnail());

        PokemonViewHolder.getTitle().setText(Html.fromHtml(PokemonEntity.getNombre()));
        PokemonViewHolder.getType().setText(Html.fromHtml(PokemonEntity.getTipo()));
/*
        //Handle click event on both title and image click
        pokemonHolder.getTitle().setOnClickListener(clickListener);
        pokemonHolder.getThumbnail().setOnClickListener(clickListener);

        pokemonHolder.getTitle().setTag(pokemonHolder);
        pokemonHolder.getThumbnail().setTag(pokemonHolder);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PokemonViewHolder holder = (PokemonViewHolder) view.getTag();
                int position = holder.getPosition();

                PokemonEntity feedItem = feedItemList.get(position);
                Toast.makeText(mContext, feedItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        };
        */

    }

    @Override
    public int getItemCount() {
        return (null != PokemonEntityList ? PokemonEntityList.size() : 0);
    }


}
