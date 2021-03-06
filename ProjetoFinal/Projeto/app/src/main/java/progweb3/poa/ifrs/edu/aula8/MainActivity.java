package progweb3.poa.ifrs.edu.aula8;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ShareActionProvider mShareActionProvider;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Cria o menu lateral
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // Localiza MenuItem com ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_share);

        // Busca e armazena o ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_settings) {
            return true;
        }
        if (id == R.id.menu_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, "Teste de compartilhamento de texto via Android");
            mShareActionProvider.setShareIntent(i);
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Dentro do menu lateral, chama cada intenção
     * @param item Item selecionado do menu
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        System.out.println(id);
        if (id == R.id.nav_lista) {
            // Listar todos os buracos
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            ListaFragment fragment = new ListaFragment();
            transaction.replace(R.id.fragmento, fragment);
            transaction.commit();
        } else if (id == R.id.nav_edit_foto) {
            // Editar Seus Buraquinho
            Intent intent = new Intent(MainActivity.this, EditarBuraquinhoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cad_foto) {
            // Entra direto no formulario
            Intent intent = new Intent(MainActivity.this, BuracoFormularioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cad_tipos) {
            // Carrega JSON
            Intent intent = new Intent(MainActivity.this, TiposBuracosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_picasso) {
            // Carrega imagem do Picasso
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            PicassoFragment fragment = new PicassoFragment();
            transaction.replace(R.id.fragmento, fragment);
            transaction.commit();
        } else if (id == R.id.nav_gmap) {
            // Carrega mapa do GMaps
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_signout) {
            // Mata a MainActivity e volta pro Login
            finish();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
