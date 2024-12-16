package jimenez.fernandez.manueljesus.pmdmtarea2;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import jimenez.fernandez.manueljesus.pmdmtarea2.databinding.GameDetailFragmentBinding;

public class GameDetailFragment extends Fragment {

    private GameDetailFragmentBinding binding;

    /**
     * Crea y devuelve la vista jerárquica asociada con este fragmento.
     *
     * @param inflater  El {@link LayoutInflater} que se utiliza para inflar el layout del fragmento.
     * @param container El contenedor al que se añadirá la vista del fragmento. Puede ser {@code null}.
     * @param savedInstanceState Si el fragmento está siendo recreado desde un estado anterior, este es el estado guardado.
     * @return La vista raíz inflada para el fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = GameDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método llamado inmediatamente después de que la vista haya sido creada.
     *
     * Este método obtiene los datos pasados a través de los argumentos y los asigna a los componentes de la interfaz,
     * como la imagen, el nombre, la descripción y las habilidades del personaje.
     *
     * @param view               La vista retornada por {@link #onCreateView}.
     * @param savedInstanceState Si el fragmento está siendo recreado a partir de un estado anterior, este es el estado guardado.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            String image = getArguments().getString("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String platforms = getArguments().getString("abilities");

            // Asignar los datos a los componentes
            Picasso.get()
                    .load(image)
                    .into(binding.image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.abilities.setText(platforms);

            // Mostrar Toast al abrir los detalles
            Toast.makeText(getContext(), "Se ha seleccionado el personaje " + name, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Método llamado cuando el fragmento se vuelve visible para el usuario.
     *
     * Este método actualiza el título del ActionBar para mostrar el título relacionado con los detalles del personaje.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalles_personaje);
        }
    }
}