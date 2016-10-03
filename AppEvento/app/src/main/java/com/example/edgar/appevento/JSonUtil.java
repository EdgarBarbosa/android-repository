package com.example.edgar.appevento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edgar on 02/10/2016.
 * classe que converte JSOn em objeto Item video
 */

public class JSonUtil {

    // metodo que retorna lista de item video vinda via http via JSON

    public static List<ItemVideo> fromJson(String json) throws JSONException {

        // cria lista que retornará do metodo
        List<ItemVideo> lista = new ArrayList<>();
        // cria objeto do tipo JSonArray
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            String titulo = (String) object.get("titulo");
            String data = (String) object.get("data");
            String url = (String) object.get("url");
            lista.add(new ItemVideo(titulo,data,url));
        }

        return lista;
    }
}
