package progweb3.poa.ifrs.edu.aula8;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

/**
 * Created by brunobortagaray on 01/05/18.
 */

public class BuraquinhoHelper {

    // Campos Formulario
    private EditText editEndereco;
    private EditText editNumero;
    private EditText editLon;
    private EditText editLat;
    private EditText editDescricao;

    // Campos Descricao
    private TextView textEndereco;
    private TextView textLatitude;
    private TextView textLongitude;
    private TextView textDescricao;
    private Buraquinho buraquinho;

    BuraquinhoHelper(BuracoFormularioActivity activity) {
        editEndereco = (EditText) activity.findViewById(R.id.editEndereco);
        editNumero = (EditText) activity.findViewById(R.id.editNumero);
        editLon = (EditText) activity.findViewById(R.id.editLon);
        editLat = (EditText) activity.findViewById(R.id.editLat);
        editDescricao = (EditText) activity.findViewById(R.id.editDescricao);
        buraquinho = new Buraquinho();
    }

    BuraquinhoHelper(DetalheActivity activity) {
        textEndereco = (TextView) activity.findViewById(R.id.textEndereco);
        textLatitude = (TextView) activity.findViewById(R.id.textLatitude);
        textLongitude = (TextView) activity.findViewById(R.id.textLongitude);
        textDescricao = (TextView) activity.findViewById(R.id.textDescricao);
    }

    Buraquinho getBuraquinho() {
        buraquinho.setEndereco(editEndereco.getText().toString());
        buraquinho.setNumero(Integer.parseInt(editNumero.getText().toString()));
        buraquinho.setLon(editLon.getText().toString());
        buraquinho.setLat(editLat.getText().toString());
        buraquinho.setDescricao(editDescricao.getText().toString());
        buraquinho.toFullString();
        return buraquinho;
    }

    public void preencheFormulario(Buraquinho buraquinho) {
        editEndereco.setText(buraquinho.getEndereco());
        editNumero.setText(String.valueOf(buraquinho.getNumero()));
        editLon.setText(buraquinho.getLon());
        editLat.setText(buraquinho.getLat());
        editDescricao.setText(buraquinho.getDescricao());
        this.buraquinho = buraquinho;
    }

    public void preencheDetalhe(Buraquinho buraquinho) {
        textEndereco.setText(buraquinho.toString());
        textLatitude.setText(buraquinho.getLat());
        textLongitude.setText(buraquinho.getLon());
        textDescricao.setText(buraquinho.getDescricao());
    }
}
