package jimenez.fernandez.manueljesus.pmdmtarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import jimenez.fernandez.manueljesus.pmdmtarea2.databinding.GameCardviewBinding;
import android.view.View;

public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameViewHolder> {

    private final ArrayList<GameData> games;
    private final Context context;

    public GameRecyclerViewAdapter (ArrayList<GameData> games, Context context){
        this.games = games;
        this.context = context;
    }

    /**
     * Método que crea un nuevo ViewHolder cuando el RecyclerView lo necesita.
     *
     * @param parent   El {@link ViewGroup} en el cual se inflará la nueva vista.
     * @param viewType El tipo de vista de la nueva vista.
     * @return Un nuevo {@link GameViewHolder} que contiene la vista inflada.
     */
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GameCardviewBinding binding = GameCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new GameViewHolder(binding);
    }

    /**
     * Método que enlaza los datos con un ViewHolder en una posición específica.
     *
     * @param holder   El {@link GameViewHolder} que debe ser actualizado con los datos.
     * @param position La posición del elemento en la lista de datos.
     */
    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        GameData currentGame = this.games.get(position);
        holder.bind(currentGame);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentGame, view));
    }

    /**
     * Devuelve el número total de elementos en la lista de juegos.
     *
     * @return El tamaño de la lista de juegos.
     */
    @Override
    public int getItemCount() {

        return games.size();
    }

    /**
     * Método privado que maneja el evento de clic en un elemento del RecyclerView.
     *
     * @param currentGame El objeto {@link GameData} asociado al elemento clicado.
     * @param view        La vista que fue clicada.
     */
    private void itemClicked(GameData currentGame, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).gameClicked(currentGame, view);
    }
}

