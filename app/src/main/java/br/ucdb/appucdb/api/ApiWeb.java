package br.ucdb.appucdb.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.ucdb.appucdb.activities.Cliente;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Virmerson on 02/09/15.
 */

public class ApiWeb {

    public static final String BASE_URL = "http://192.168.43.232:8082/crudangular/ws";

    public static Rotas rotasApi;

    public static Rotas getRotas() {
        if (rotasApi == null) {

            //Serializador Client  Json
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();

            //Inicializa o Rest Client
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new GsonConverter(gson))
                    .setEndpoint(String.format("%s", BASE_URL))
                    .build();

            //Objeto rest
            rotasApi = restAdapter.create(Rotas.class);
        }

        return rotasApi;
    }
    //Mapeamento das Requisições
    public interface Rotas{

        @POST("/cliente/salvar")
        public void salvarCliente(@Body Cliente cliente, Callback<Response> callback);
        //Adicinar mais rotas aqui

        @GET("/cliente/lista")
        public void listaClientes(Callback<List<Cliente>> callback);
    }

}
