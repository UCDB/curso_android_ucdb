package br.ucdb.appucdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Virmerson on 05/08/15.
 */
public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btnVoltar = (Button) findViewById(R.id.btn_voltar);
        //TextView tvNome = (TextView) findViewById(R.id.tv_nome);
       final EditText edNomeTela2 = (EditText) findViewById(R.id.ed_nome_tela2);

        //Acessando a intent que chamou esta Activity
        Intent it = getIntent();
        //Acessando os parametros extras
        Bundle parametrosExtras = it.getExtras();
        String nome = parametrosExtras.getString("nome");
        //Preenchendo o componente EditText com o nome vindo no parametro
        edNomeTela2.setText(nome);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("nome", edNomeTela2.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
