package jimenez.fernandez.manueljesus.pmdmtarea2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import jimenez.fernandez.manueljesus.pmdmtarea2.databinding.GameListFragmentBinding;

import java.util.ArrayList;

public class GameListFragment extends Fragment {

    private GameListFragmentBinding binding; // Binding para el layout
    private ArrayList<GameData> games; // Lista de juegos
    private GameRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    /**
     * Crea y devuelve la jerarquía de vistas asociada con el fragmento.
     *
     * @param inflater  El objeto {@link LayoutInflater} que se utiliza para inflar cualquier vista en el fragmento.
     * @param container El contenedor al que se añadirá la vista del fragmento. Puede ser {@code null}.
     * @param savedInstanceState Si el fragmento está siendo recreado a partir de un estado anterior, este es el estado.
     * @return La raíz de la vista inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = GameListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se llama inmediatamente después de que la vista haya sido creada.
     *
     * @param view               La vista que fue retornada por {@link #onCreateView}.
     * @param savedInstanceState Si el fragmento está siendo recreado a partir de un estado anterior, este es el estado.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de juegos
        loadGames(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new GameRecyclerViewAdapter(games, getActivity());
        binding.gamesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.gamesRecyclerview.setAdapter(adapter);

        // Mostrar Snackbar al cargar la lista
        Snackbar.make(view, "Bienvenidos al mundo de Mario", Snackbar.LENGTH_LONG).show();

    }

    /**
     * Método para cargar una lista de videojuegos.
     *
     * Este método inicializa la lista de juegos y la llena con datos predefinidos,
     * incluyendo imágenes, nombres, descripciones y habilidades de personajes.
     */
    private void loadGames() {
        games = new ArrayList<GameData>();
        // Llenar la lista con datos de videojuegos
        games.add(new GameData(
                "https://upload.wikimedia.org/wikipedia/en/5/5c/Mario_by_Shigehisa_Nakaue.png", // Reemplaza con la ruta de la imagen
                "Mario",
                getString(R.string.descripcion_mario),
                getString(R.string.abilities_mario)
        ));

        games.add(new GameData(
                "https://upload.wikimedia.org/wikipedia/en/b/be/Luigi_by_Shigehisa_Nakaue.png", // Reemplaza con la ruta de la imagen
                "Luigi",
                getString(R.string.descripcion_luigi),
                getString(R.string.abilities_luigi)
        ));

        games.add(new GameData(
                "https://upload.wikimedia.org/wikipedia/en/1/16/Princess_Peach_Stock_Art.png", // Reemplaza con la ruta de la imagen
                "Peach",
                getString(R.string.descripcion_peach),
                getString(R.string.abilities_peach)
        ));

        games.add(new GameData(
                "https://upload.wikimedia.org/wikipedia/en/b/b9/Toad_by_Shigehisa_Nakaue.png", // Reemplaza con la ruta de la imagen
                "Toad",
                getString(R.string.descripcion_toad),
                getString(R.string.abilities_toad)
        ));
    }

    /**
     * Método llamado cuando el fragmento se vuelve visible para el usuario.
     *
     * Este método cambia el título del ActionBar al título de la lista de personajes.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_personajes);
        }
    }
}