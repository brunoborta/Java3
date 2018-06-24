package progweb3.poa.ifrs.edu.aula8;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class TiposBuracosActivity extends AppCompatActivity {

    private TiposBuracoTask tiposBuracos;
    ListView listaTipos;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_buracos);

        // Cria a lista principal e aplica ela
        listaTipos = (ListView) findViewById(R.id.lista_tipos);

        if (tiposBuracos == null) {
            if (TipoBuraquinhoHttpJSON.isOnLine(this)) {
                iniciarDownload();
            } else {
                Log.d("OnCreate", "Not Online!!!");
            }
        } else if (tiposBuracos.getStatus() == AsyncTask.Status.RUNNING) {
            Log.d("OnCreate", "Rodando o Async");
        }
    }

    public void iniciarDownload() {
        if (tiposBuracos == null ||  tiposBuracos.getStatus() != AsyncTask.Status.RUNNING) {
            tiposBuracos = new TiposBuracoTask();
            tiposBuracos.execute();
        }
    }

    class TiposBuracoTask extends AsyncTask<Void, Void, List<String>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected List<String> doInBackground(Void... strings) {
            return TipoBuraquinhoHttpJSON.loadTiposJson();
        }
        @Override
        protected void onPostExecute(List<String> tiposBuracos) {
            super.onPostExecute(tiposBuracos);
            Log.d("onPostExecute", tiposBuracos.toString());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(TiposBuracosActivity.this, android.R.layout.simple_list_item_1, tiposBuracos);
            listaTipos.setAdapter(adapter);
        }
    }

}
