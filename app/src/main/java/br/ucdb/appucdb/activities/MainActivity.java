package br.ucdb.appucdb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ucdb.appucdb.R;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_TELA2 =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Carrega o Layout
        setContentView(R.layout.activity_main);

        //Acessa o botao
        final Button btnOK =  (Button) findViewById(R.id.btn_ok);
        final Button btnIrTela2 = (Button) findViewById(R.id.btn_ir_tela_2);

        //Acessa o campo de texto
       final EditText edNome = (EditText) findViewById(R.id.ed_nome);

        //Trata o click no botao
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String texto = edNome.getText().toString();
                Toast.makeText(MainActivity.this, "Clique CURTO:" + texto, Toast.LENGTH_SHORT).show();
            }
        });

        //Trata clique longo no botão
        btnOK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                String texto = edNome.getText().toString();
                Toast.makeText(MainActivity.this, "Clique LONGO:" + texto, Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        btnIrTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Carregando tela 2
                Intent irParaTela2 = new Intent(MainActivity.this, Activity2.class);
                //Lendo texto do componente EditText
                String texto = edNome.getText().toString();

                //Criando um "bando" de parametros
                Bundle parametrosExtras = new Bundle();
                parametrosExtras.putString("nome", texto);

                irParaTela2.putExtras(parametrosExtras);

               // startActivity(irParaTela2);

                startActivityForResult(irParaTela2, REQUEST_TELA2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Se a resposta for do REQUEST_TELA2 e deu tudo certo
        if(requestCode== REQUEST_TELA2 && resultCode==RESULT_OK){
           Bundle parametrosExtrasResult = data.getExtras();
           String nome =  parametrosExtrasResult.getString("nome");
            final EditText edNome = (EditText) findViewById(R.id.ed_nome);
            edNome.setText(nome);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Acessa o campo de texto
        //final EditText edNome = (EditText) findViewById(R.id.ed_nome);
        //edNome.setText("");

    }
}

