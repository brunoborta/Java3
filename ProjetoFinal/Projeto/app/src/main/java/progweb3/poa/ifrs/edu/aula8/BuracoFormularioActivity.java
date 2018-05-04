package progweb3.poa.ifrs.edu.aula8;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import progweb3.poa.ifrs.edu.aula8.DAO.BuraquinhoDAO;
import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

public class BuracoFormularioActivity extends AppCompatActivity {

    private BuraquinhoHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buraco_formulario);

        helper = new BuraquinhoHelper(this);
        // Botao que vai salvar no banco
        final Button button = findViewById(R.id.editButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buraquinho buraquinho = helper.getBuraquinho();
                BuraquinhoDAO dao = new BuraquinhoDAO(BuracoFormularioActivity.this);
                dao.insert(buraquinho);
                dao.close();
                Toast.makeText(BuracoFormularioActivity.this, "Seu Buraquinho foi salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
