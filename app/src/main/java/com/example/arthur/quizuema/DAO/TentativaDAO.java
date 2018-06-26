package com.example.arthur.quizuema.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthur.quizuema.model.Tentativa;

public class TentativaDAO {
    private CriarBD banco;
    private SQLiteDatabase bd;

    public TentativaDAO(Context context) {
        banco = new CriarBD(context);
    }



    public void insere(Tentativa tentativa){
        ContentValues valores = new ContentValues();
        try {
            bd = banco.getWritableDatabase();
            valores.put("alternativaSelecionada",tentativa.getAlternativa_selecionada());
            valores.put("id_pergunta",tentativa.getId_pergunta());

            bd.insert("tentativa", null, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bd.close();
    }
}
