package jimenez.fernandez.manueljesus.pmdmtarea2;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import jimenez.fernandez.manueljesus.pmdmtarea2.databinding.GameCardviewBinding;

public class GameViewHolder extends RecyclerView.ViewHolder {

    private final GameCardviewBinding binding;

    /**
     * Constructor para el ViewHolder que inicializa el enlace de la vista.
     *
     * @param binding El objeto {@link GameCardviewBinding} que enlaza la vista con sus componentes.
     */
    public GameViewHolder(GameCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Enlaza los datos del juego con los componentes de la interfaz de usuario.
     *
     * Este método utiliza la biblioteca Picasso para cargar la imagen del juego en el componente de imagen
     * y asigna los valores del nombre y la descripción a los correspondientes elementos de texto.
     *
     * @param game El objeto {@link GameData} que contiene la información del juego a mostrar.
     */
    public void bind (GameData game){
        Picasso.get()
                .load(game.getImage())
                .into(binding.image);
        binding.name.setText(game.getName());
        //binding.releaseYear.setText(String.valueOf(game.getDescription()));
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}
