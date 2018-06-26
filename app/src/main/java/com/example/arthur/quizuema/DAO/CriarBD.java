package com.example.arthur.quizuema.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.arthur.quizuema.model.Pergunta;

public class CriarBD extends SQLiteOpenHelper {

    public static final String nomeBD = "Quiz";
    public static final int versaoBD = 1;
    private static final String tabelaJogador = "jogador";
    private static final String tabelaPergunta = "pergunta";
    private static final String tabelaPartida = "partida";
    private static final String tabelaRodada = "rodada";
    private static final String tabelaTentativa = "tentativa";
    private static final String caminho = "/data/user/0/DAO/databases/nomeBD";
    private Context context;
    private SQLiteDatabase bd;


    public CriarBD(Context context) {
        super(context, nomeBD, null, versaoBD);
        this.context = context;
        bd = getWritableDatabase();
    }

    public void AlimentaBanco(){
        abrirBD(bd);
        criarTabelaJogador();
        criarTabelaPartida();
        criarTabelaPergunta();
        criarTabelaRodada();
        criarTabelaTentativa();
        fecharBD(bd);

        PerguntaDAO perguntas = new PerguntaDAO(this.context);
        Pergunta pergunta;

        //#1
        pergunta = new Pergunta();
        pergunta.setTexto("Os raios solares UVA e UVB chegam até a superfície da Terra por meio de um mecanismo de transferência de calor denominado");
        pergunta.setAlternativa_A("compressão");
        pergunta.setAlternativa_B("convecção");
        pergunta.setAlternativa_C("irradiação");
        pergunta.setAlternativa_D("condução");
        pergunta.setAlternativa_Correta("irradiação");
        perguntas.insere(pergunta);

        /*//#2
        pergunta = new Pergunta();
        pergunta.setTexto("");
        pergunta.setAlternativa_A("");
        pergunta.setAlternativa_B("");
        pergunta.setAlternativa_C("");
        pergunta.setAlternativa_D("");
        pergunta.setAlternativa_Correta("");
        p.insere(pergunta);

        //#3
        pergunta = new Pergunta();
        pergunta.setTexto("");
        pergunta.setAlternativa_A("");
        pergunta.setAlternativa_B("");
        pergunta.setAlternativa_C("");
        pergunta.setAlternativa_D("");
        pergunta.setAlternativa_Correta("");
        p.insere(pergunta);

        //#4
        pergunta = new Pergunta();
        pergunta.setTexto("");
        pergunta.setAlternativa_A("");
        pergunta.setAlternativa_B("");
        pergunta.setAlternativa_C("");
        pergunta.setAlternativa_D("");
        pergunta.setAlternativa_Correta("");
        p.insere(pergunta);*/
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrirBD(SQLiteDatabase bd) {
        if (!bd.isOpen()) {
            bd = context.openOrCreateDatabase(caminho, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

    public void fecharBD(SQLiteDatabase bd) {
        if (bd.isOpen()) {
            bd.close();
        }
    }


    public boolean createTable(String query) {
        try {
            bd.execSQL(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean criarTabelaJogador(){
        String query = "create table if not exists " + tabelaJogador + " ("
                + "id_jogador integer,"
                + "nome text,"
                + "idade integer,"
                + "score integer)";
        return createTable(query);
    }

    public boolean criarTabelaPergunta (){
        String query = "create table if not exists " + tabelaPergunta + " ("
                + "id_pergunta integer,"
                + "texto text,"
                + "alternativaA text,"
                + "alternativaB text,"
                + "alternativaC text,"
                + "alternativaD text,"
                + "alternativaCorreta text)";
        return createTable(query);
    }

    public boolean criarTabelaPartida(){
        String query = "create table if not exists " + tabelaPartida + " ("
                + "id_partida integer,"
                + "id_jogador integer,"
                + "pontuacao integer)";
        return createTable(query);
    }

    public boolean criarTabelaTentativa(){
        String query = "create table if not exists " + tabelaTentativa + " ("
                + "id_tentativa integer,"
                + "id_pergunta integer,"
                + "alternativaSelecionada text)";

        return createTable(query);
    }

    public boolean criarTabelaRodada(){
        String query = "create table if not exists " + tabelaRodada + " ("
                + "id_rodada integer,"
                + "id_partida integer,"
                + "id_jogador integer,"
                + "id_tentativa integer,"
                + "apuracao integer)";

        return createTable(query);
    }

}
