package progweb3.poa.ifrs.edu.aula8;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import progweb3.poa.ifrs.edu.aula8.DAO.BuraquinhoDAO;
import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class EditarBuraquinhoActivity extends AppCompatActivity {

    private ListView listaBuracos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_buraquinho);

        listaBuracos = (ListView) findViewById(R.id.lista_edit_buraquinho);

        listaBuracos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Buraquinho buraquinhoSelecionado = (Buraquinho) listaBuracos.getItemAtPosition(position);
                Intent intent = new Intent(EditarBuraquinhoActivity.this, BuracoFormularioActivity.class);
                intent.putExtra("buraquinho", buraquinhoSelecionado);
                startActivity(intent);
            }
        });

        // Cria o botão flutuante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_edit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarBuraquinhoActivity.this, BuracoFormularioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaBuraquinhos();
    }

    private void carregaListaBuraquinhos() {
        BuraquinhoDAO dao = new BuraquinhoDAO(this);
        // Depois será trocado pela listagem dos buraquinhos do usuário
        List<Buraquinho> buraquinhos = dao.listaTodos();
        dao.close();
        ArrayAdapter<Buraquinho> adapter = new ArrayAdapter<Buraquinho>(this, android.R.layout.simple_list_item_1, buraquinhos);
        listaBuracos.setAdapter(adapter);
    }
}
