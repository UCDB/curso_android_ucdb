package br.ucdb.appucdb.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.ucdb.appucdb.R;
import br.ucdb.appucdb.api.ApiWeb;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by Virmerson on 02/09/15.
 */
public class CadastroClienteActivity extends AppCompatActivity {


    @Bind(R.id.txt_nome)
    EditText txtNome;


    @Bind(R.id.txt_email)
    EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cadastrocliente);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_salvar_cliente)
    public void salvar() {
        Cliente c = new Cliente();
        c.setNome(txtNome.getText().toString());
        c.setEmail(txtEmail.getText().toString());

        ApiWeb.getRotas().salvarCliente(c, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

                Toast.makeText(CadastroClienteActivity.this, "Salvo com Sucesso!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(CadastroClienteActivity.this, "Falha ao Salvar", Toast.LENGTH_SHORT).show();
            }
        });


        Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_listar_cliente)
    public void listarCliente(){

        ApiWeb.getRotas().listaClientes(new Callback<List<Cliente>>() {
            @Override
            public void success(List<Cliente> clientes, Response response) {
                Toast.makeText(CadastroClienteActivity.this, clientes.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(CadastroClienteActivity.this, "Falha ao Salvar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
