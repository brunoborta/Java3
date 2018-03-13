package bruno.cafeteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBebida(View view) {
        Categoria categoria = new Categoria();
        Spinner selecao = (Spinner) findViewById(R.id.spnCategorias);
        categoria.setDescricao(String.valueOf(selecao.getSelectedItem()));
        List<String> categorias = categoria.getItensCategoria();
        StringBuilder categoriasFormatadas = new StringBuilder();
        for(String e : categorias) {
            categoriasFormatadas.append(e).append("\n");
        }
        TextView selecionado = (TextView) findViewById(R.id.txtSelecionado);
        selecionado.setText(categoriasFormatadas);
    }
}
