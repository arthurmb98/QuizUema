package com.example.arthur.quizuema.model;

public class Jogador {
    private int id_jogador;
    private String nome;
    private int idade;
    private int Score;

    /*public Jogador(int id_jogador, String nome, int idade, int Score){
        setId_jogador(id_jogador);
        setNome(nome);
        setIdade(idade);
        setScore(Score);
    }*/

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
