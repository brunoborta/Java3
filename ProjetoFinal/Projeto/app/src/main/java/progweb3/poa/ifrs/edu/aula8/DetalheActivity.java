package progweb3.poa.ifrs.edu.aula8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        // Pega a intenção para poder setar os valores
        Intent intent = getIntent();
        Buraquinho buraquinhoSelecionado = (Buraquinho) intent.getSerializableExtra("buraquinho");
        Toast.makeText(DetalheActivity.this, buraquinhoSelecionado.toFullString(), Toast.LENGTH_LONG).show();
    }
}
