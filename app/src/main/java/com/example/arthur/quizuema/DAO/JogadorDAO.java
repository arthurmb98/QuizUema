package com.example.arthur.quizuema.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthur.quizuema.model.Jogador;

import java.util.List;

public class JogadorDAO{
    private CriarBD banco;
    private SQLiteDatabase bd;

    public JogadorDAO(Context context) {
        banco = new CriarBD(context);
    }

    public void insere(Jogador jogador){
        ContentValues valores = new ContentValues();
        try {
            banco.abrirBD(bd);
            bd = banco.getWritableDatabase();
            valores.put("nome",jogador.getNome());
            valores.put("idade",jogador.getIdade());
            valores.put("score",jogador.getScore());
            bd.insert("jogador", null, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bd.close();
    }

    public List<Jogador> listar(){
        List<Jogador> jogadores = null;
        Jogador jogador;

        banco.abrirBD(bd);
        String query = "SELECT * FROM jogador";

        try{
            Cursor cursor = bd.rawQuery(query, null);

            if(cursor.moveToFirst()){
                do{
                    jogador = new Jogador();
                    jogador.setId_jogador(cursor.getInt(0));
                    jogador.setNome(cursor.getString(1));
                    jogador.setIdade(cursor.getInt(2));
                    jogador.setScore(cursor.getInt(3));
                    //
                    jogadores.add(jogador);

                }while (cursor.moveToNext());
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return jogadores;
    }
}

