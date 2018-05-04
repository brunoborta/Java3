package progweb3.poa.ifrs.edu.aula8;

import android.widget.ArrayAdapter;
import android.widget.EditText;

import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

/**
 * Created by brunobortagaray on 01/05/18.
 */

public class BuraquinhoHelper {
    private final EditText editEndereco;
    private final EditText editNumero;
    private final EditText editLon;
    private final EditText editLat;
    private final EditText editDescricao;
    private Buraquinho buraquinho;

    public BuraquinhoHelper(BuracoFormularioActivity activity) {
        editEndereco = (EditText) activity.findViewById(R.id.editEndereco);
        editNumero = (EditText) activity.findViewById(R.id.editNumero);
        editLon = (EditText) activity.findViewById(R.id.editLon);
        editLat = (EditText) activity.findViewById(R.id.editLat);
        editDescricao = (EditText) activity.findViewById(R.id.editDescricao);
        buraquinho = new Buraquinho();
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
        editEndereco.setText(String.valueOf(buraquinho.getNumero()));
        editLon.setText(buraquinho.getLon());
        editLat.setText(buraquinho.getLat());
        editDescricao.setText(buraquinho.getDescricao());
        this.buraquinho = buraquinho;
    }
}
