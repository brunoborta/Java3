package progweb3.poa.ifrs.edu.aula8;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import progweb3.poa.ifrs.edu.aula8.DAO.BuraquinhoDAO;
import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class ListaFragment extends DialogFragment {

    private ListView listaBuracos;
    public ListaFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Dialog);
        setCancelable(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // A view que eu quero apresentar
        View view = inflater.inflate(R.layout.content_main, container, false);

        // Cria a lista principal e aplica ela
        listaBuracos = (ListView) view.findViewById(R.id.lista_buraquinho);
        carregaListaBuraquinhos();

        // Adiciona o listener para o detalhe do buraco
        listaBuracos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Buraquinho buraquinhoSelecionado = (Buraquinho) listaBuracos.getItemAtPosition(position);
                Intent intent = new Intent((MainActivity) getActivity(), DetalheActivity.class);
                intent.putExtra("buraquinho", buraquinhoSelecionado);
                startActivity(intent);
            }
        });

        // Cria o botão flutuante
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabFragment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent((MainActivity) getActivity(), BuracoFormularioActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void carregaListaBuraquinhos() {
        BuraquinhoDAO dao = new BuraquinhoDAO(getActivity());
        List<Buraquinho> buraquinhos = dao.listaTodos();
        dao.close();
        ArrayAdapter<Buraquinho> adapter = new ArrayAdapter<Buraquinho>((MainActivity) getActivity(), android.R.layout.simple_list_item_1, buraquinhos);
        listaBuracos.setAdapter(adapter);
    }

    @Override
    // Sera chamado no onResume da atividade principal
    public void onResume() {
        super.onResume();
        carregaListaBuraquinhos();
    }
}
