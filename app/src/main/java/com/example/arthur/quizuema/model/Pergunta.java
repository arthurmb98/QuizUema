package com.example.arthur.quizuema.model;

public class Pergunta {
    private int id_pergunta;
    private String texto;
    private String alternativa_A;
    private String alternativa_B;
    private String alternativa_C;
    private String alternativa_D;
    private String alternativa_Correta;

    /*public Pergunta(String texto, String alternativa_A, String alternativa_B, String alternativa_C, String alternativa_D, String alternativa_Correta){
        setTexto(texto);
        setAlternativa_A(alternativa_A);
        setAlternativa_B(alternativa_B);
        setAlternativa_C(alternativa_C);
        setAlternativa_D(alternativa_D);
        setAlternativa_Correta(alternativa_Correta);
    }*/

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlternativa_A() {
        return alternativa_A;
    }

    public void setAlternativa_A(String alternativa_A) {
        this.alternativa_A = alternativa_A;
    }

    public String getAlternativa_B() {
        return alternativa_B;
    }

    public void setAlternativa_B(String alternativa_B) {
        this.alternativa_B = alternativa_B;
    }

    public String getAlternativa_C() {
        return alternativa_C;
    }

    public void setAlternativa_C(String alternativa_C) {
        this.alternativa_C = alternativa_C;
    }

    public String getAlternativa_D() {
        return alternativa_D;
    }

    public void setAlternativa_D(String alternativa_D) {
        this.alternativa_D = alternativa_D;
    }

    public String getAlternativa_Correta() {
        return alternativa_Correta;
    }

    public void setAlternativa_Correta(String alternativa_Correta) {
        this.alternativa_Correta = alternativa_Correta;
    }
}
