package com.example.arthur.quizuema.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthur.quizuema.model.Rodada;

public class RodadaDAO {
    private CriarBD banco;
    private SQLiteDatabase bd;

    public RodadaDAO(Context context) {
        banco = new CriarBD(context);
    }



    public void insere(Rodada rodada){
        ContentValues valores = new ContentValues();
        try {
            bd = banco.getWritableDatabase();
            valores.put("id_partida",rodada.getId_partida());
            valores.put("id_jogador",rodada.getId_jogador());
            valores.put("id_tentativa",rodada.getId_tentativa());
            valores.put("apuracao",rodada.getApuracao());

            bd.insert("rodada", null, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bd.close();
    }
}
