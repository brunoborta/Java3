package progweb3.poa.ifrs.edu.aula8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import progweb3.poa.ifrs.edu.aula8.DAO.BuraquinhoDAO;
import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class DetalheActivity extends AppCompatActivity {

    private BuraquinhoHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);


        // Pega a intenção para poder setar os valores
        Intent intent = getIntent();
        Buraquinho buraquinhoSelecionado = (Buraquinho) intent.getSerializableExtra("buraquinho");

        // Preenche os textos do detalhe de buraquinho
        helper = new BuraquinhoHelper(this);
        helper.preencheDetalhe(buraquinhoSelecionado);

        final Button button = findViewById(R.id.btnDetalheImportancia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetalheActivity.this, "Voce deu importancia para esse buraquinho!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
