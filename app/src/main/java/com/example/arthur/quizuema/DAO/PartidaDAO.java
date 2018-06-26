package com.example.arthur.quizuema.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthur.quizuema.model.Partida;

public class PartidaDAO {
    private CriarBD banco;
    private SQLiteDatabase bd;

    public PartidaDAO(Context context) {
        banco = new CriarBD(context);
    }



    public void insere(Partida partida){
        ContentValues valores = new ContentValues();
        try {
            bd = banco.getWritableDatabase();
            valores.put("id_jogador",partida.getId_jogador());
            valores.put("pontuacao",partida.getPontuacao());
            bd.insert("partida", null, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bd.close();
    }
}
