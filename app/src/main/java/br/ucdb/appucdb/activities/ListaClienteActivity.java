package br.ucdb.appucdb.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.ucdb.appucdb.R;
import br.ucdb.appucdb.api.ApiWeb;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Virmerson on 16/09/15.
 */
public class ListaClienteActivity extends AppCompatActivity {

    @Bind(R.id.lista_cliente)
    ListView listaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout
        setContentView(R.layout.listacliente);
        ButterKnife.bind(this);

        ApiWeb.getRotas().listaClientes(new Callback<List<Cliente>>() {
            @Override
            public void success(List<Cliente> clientes, Response response) {
                //Carrengando no ListView
                ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(ListaClienteActivity.this, android.R.layout.simple_list_item_1, clientes);
                listaCliente.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        //List<String> nomes = Arrays.asList("Jão","Zé","Maria");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, nomes);

        //listaCliente.setAdapter(adapter);
    }
}
