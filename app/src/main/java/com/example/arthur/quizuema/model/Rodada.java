package com.example.arthur.quizuema.model;

public class Rodada {
    private int id_rodada;
    private int id_partida;
    private int id_jogador;
    private int id_tentativa;
    private int Apuracao;

    public Rodada(int id_partida, int id_jogador, int id_tentativa, int Apuracao){
        setId_partida(id_partida);
        setId_jogador(id_jogador);
        setId_tentativa(id_tentativa);
        setApuracao(Apuracao);
    }


    public int getId_rodada() {
        return id_rodada;
    }

    public void setId_rodada(int id_rodada) {
        this.id_rodada = id_rodada;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public int getId_tentativa() {
        return id_tentativa;
    }
    public void setId_tentativa(int id_tentativa) {
        this.id_tentativa = id_tentativa;
    }

    public int getApuracao() {
        return Apuracao;
    }

    public void setApuracao(int apuracao) {
        Apuracao = apuracao;
    }
}
