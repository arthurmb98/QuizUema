package com.example.arthur.quizuema.model;

public class Partida {
    private int id_partida;
    private int id_jogador;
    private int pontuacao;

    public Partida(int id_jogador, int pontuacao){
        setId_jogador(id_jogador);
        setPontuacao(pontuacao);
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
