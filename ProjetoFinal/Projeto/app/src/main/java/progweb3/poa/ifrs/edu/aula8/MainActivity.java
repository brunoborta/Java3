package progweb3.poa.ifrs.edu.aula8;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import progweb3.poa.ifrs.edu.aula8.DAO.BuraquinhoDAO;
import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ShareActionProvider mShareActionProvider;
    private ListView listaBuracos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria a lista principal e aplica ela
        listaBuracos = (ListView) findViewById(R.id.lista_buraquinho);

        listaBuracos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Buraquinho buraquinhoSelecionado = (Buraquinho) listaBuracos.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                intent.putExtra("buraquinho", buraquinhoSelecionado);
                startActivity(intent);
            }
        });
//        Moto moto = (Moto) listaMotos.getItemAtPosition(info.position);
//        Intent intent = new Intent(ListaMoto.this, FormularioCadastroMoto.class);
//        intent.putExtra("moto", moto);
//        startActivity(intent);

//        final ListView listaBuracos = (ListView) findViewById(R.id.lista_buraquinho);
//        // Cria o listener de click
//        listaBuracos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String posicaoEndereco;
//                posicaoEndereco = (String)listaBuracos.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, "Clicando no endereco: " + posicaoEndereco, Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        String[] listaPrincipal = {"Rua lalala", "Av. lalala", "Travessa lalala"};
//        ArrayAdapter<String> adapterLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPrincipal);
//        listaBuracos.setAdapter(adapterLista);



        // Cria o menu lateral
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Cria o botão flutuante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, BuracoFormularioActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregaListaBuraquinhos();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            // Handle the camera action
            Intent i = new Intent(MainActivity.this, ListaCard.class);
            startActivity(i);
        } else if (id == R.id.nav_edit_cad) {

        } else if (id == R.id.nav_edit_foto) {
            Intent intent = new Intent(MainActivity.this, EditarBuraquinhoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cad_foto) {
            Intent intent = new Intent(MainActivity.this, BuracoFormularioActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void carregaListaBuraquinhos() {
        BuraquinhoDAO dao = new BuraquinhoDAO(this);
        List<Buraquinho> buraquinhos = dao.listaTodos();
        dao.close();
        ArrayAdapter<Buraquinho> adapter = new ArrayAdapter<Buraquinho>(this, android.R.layout.simple_list_item_1, buraquinhos);
        listaBuracos.setAdapter(adapter);
    }
}
