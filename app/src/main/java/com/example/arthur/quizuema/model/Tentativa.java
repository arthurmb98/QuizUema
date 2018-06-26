package com.example.arthur.quizuema.model;

public class Tentativa {
    private int id_tentativa;
    private int id_pergunta;
    private int alternativa_selecionada;

    public Tentativa(int id_tentativa, int id_pergunta, int alternativa_selecionada){
        setId_tentativa(id_tentativa);
        setId_pergunta(id_pergunta);
        setAlternativa_selecionada(alternativa_selecionada);
    }


    public int getId_tentativa() {
        return id_tentativa;
    }

    public void setId_tentativa(int id_tentativa) {
        this.id_tentativa = id_tentativa;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public int getAlternativa_selecionada() {
        return alternativa_selecionada;
    }

    public void setAlternativa_selecionada(int alternativa_selecionada) {
        this.alternativa_selecionada = alternativa_selecionada;
    }
}
