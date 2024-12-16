package jimenez.fernandez.manueljesus.pmdmtarea2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import jimenez.fernandez.manueljesus.pmdmtarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;

    /**
     * Método llamado cuando la actividad es creada por primera vez.
     *
     * Se encarga de configurar la interfaz de usuario, incluyendo el {@link Toolbar},
     * la navegación mediante {@link NavController}, la configuración del ActionBar
     * con la navegación y el menú lateral {@link DrawerLayout}.
     *
     * @param savedInstanceState Si la actividad se está recreando a partir de un estado guardado,
     *                           este es el estado guardado anterior.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Configurar View Binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Acceder al DrawerLayout
        drawerLayout = binding.drawerLayout;

        // Configurar Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Configurar el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Configurar AppBarConfiguration para gestionar DrawerLayout y opciones de navegación
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_settings, R.id.nav_language) // IDs de las opciones del menú
                .setOpenableLayout(drawerLayout)
                .build();

        // Vincular el Toolbar con el NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        // Vincular el NavigationView con el NavController
        NavigationView navigationView = binding.navView;
        NavigationUI.setupWithNavController(navigationView, navController);

        // Manejar clics en las opciones del menú lateral
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                navController.navigate(R.id.nav_home);
            } else if (id == R.id.nav_settings) {
                navController.navigate(R.id.nav_settings);
            } else if (id == R.id.nav_language) {
                toggleLanguage();
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }

    /**
     * Cambia el idioma de la aplicación entre inglés y español.
     */
    private void toggleLanguage() {
        // Implementar lógica para cambiar idioma
    }

    /**
     * Método que maneja el clic en un personaje de la lista.
     *
     * Al hacer clic en un elemento, se crea un {@link Bundle} con los detalles del personaje
     * (nombre, imagen, descripción y habilidades) y se navega al {@code GameDetailFragment}.
     *
     * @param game El objeto {@link GameData} que contiene la información del personaje clicado.
     * @param view La vista que fue clicada, utilizada para encontrar el {@link NavController}.
     */
    public void gameClicked(GameData game, View view) {
        // Crear un Bundle para pasar los datos al GameDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("name", game.getName()); // Pasa el nombre del personaje
        bundle.putString("image", game.getImage()); // Pasa la imagen del juego
        bundle.putString("description", game.getDescription()); // Pasa la descripción o más datos que necesites
        bundle.putString("abilities", game.getAbilities()); // Pasa las habilidades

        // Navegar al GameDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.gameDetailFragment, bundle);
    }

    /**
     * Maneja la navegación hacia atrás cuando se utiliza la navegación de componentes.
     *
     * @return {@code true} si la navegación hacia arriba fue manejada correctamente,
     *         o {@code false} si debe delegarse al comportamiento predeterminado.
     */
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    /**
     * Crea las opciones del menú en el ActionBar.
     *
     * @param menu El menú en el que se inflarán los elementos.
     * @return {@code true} si el menú debe mostrarse, de lo contrario {@code false}.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja la selección de elementos en el menú de opciones.
     *
     * Si se selecciona la opción "Acerca de...", se muestra un diálogo con información sobre la aplicación.
     *
     * @param item El {@link MenuItem} seleccionado.
     * @return {@code true} si el evento fue manejado, de lo contrario {@code false}.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un diálogo de información "Acerca de..." con detalles sobre la aplicación.
     */
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_explain)
                .setIcon(R.mipmap.ic_launcher) // Usa el icono de la app
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
