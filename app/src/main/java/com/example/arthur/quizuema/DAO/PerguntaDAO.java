package com.example.arthur.quizuema.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthur.quizuema.model.Pergunta;

import java.util.List;

public class PerguntaDAO {
    private CriarBD banco;
    private SQLiteDatabase bd;

    public PerguntaDAO(Context context) {
        banco = new CriarBD(context);
    }



    public void insere(Pergunta pergunta){
        ContentValues valores = new ContentValues();
        try {
            bd = banco.getWritableDatabase();
            valores.put("texto",pergunta.getTexto());
            valores.put("alternativaA",pergunta.getAlternativa_A());
            valores.put("alternativaB",pergunta.getAlternativa_B());
            valores.put("alternativaC",pergunta.getAlternativa_C());
            valores.put("alternativaD",pergunta.getAlternativa_D());
            valores.put("alternativaCorreta",pergunta.getAlternativa_Correta());

            bd.insert("pergunta", null, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bd.close();
    }

    public List<Pergunta> listar(){
        List<Pergunta> perguntas = null;
        Pergunta pergunta;

        banco.abrirBD(bd);
        String query = "SELECT * FROM pergunta";

        try{
            Cursor cursor = bd.rawQuery(query, null);

            if(cursor.moveToFirst()){
                do{
                    pergunta = new Pergunta();
                    pergunta.setId_pergunta(cursor.getInt(0));
                    pergunta.setTexto(cursor.getString(1));
                    pergunta.setAlternativa_A(cursor.getString(2));
                    pergunta.setAlternativa_B(cursor.getString(3));
                    pergunta.setAlternativa_C(cursor.getString(4));
                    pergunta.setAlternativa_D(cursor.getString(5));
                    pergunta.setAlternativa_Correta(cursor.getString(6));
                    //
                    perguntas.add(pergunta);

                }while (cursor.moveToNext());
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return perguntas;
    }

}
