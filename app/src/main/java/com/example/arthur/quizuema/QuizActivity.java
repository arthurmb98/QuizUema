package com.example.arthur.quizuema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.arthur.quizuema.DAO.PerguntaDAO;
import com.example.arthur.quizuema.model.Pergunta;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<Pergunta> perguntas;

    RadioGroup rgRespostas;
    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    RadioButton resposta;
    String respostaCerta;
    int pontos, aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        pergunta = (TextView)findViewById(R.id.pergunta);
        rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton)findViewById(R.id.rbResposta4);

        perguntas = new PerguntaDAO(getApplicationContext()).listar();
    }

    public void btnResponderOnClick(View v){
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);
        if(rgRespostas.getCheckedRadioButtonId() == R.id.rbResposta1) {
            intent.putExtra("acertou", true);
            pontos++;
        }
        else intent.putExtra("acertou", false);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
        rb.setChecked(false);
    }

    private void carregarQuestao(){
        if(perguntas.size() > 0) {
            Pergunta p = perguntas.remove(0);
            rbResposta1.setText(p.getAlternativa_A());
            rbResposta2.setText(p.getAlternativa_B());
            rbResposta3.setText(p.getAlternativa_C());
            rbResposta4.setText(p.getAlternativa_D());
            respostaCerta = p.getAlternativa_Correta();
            rgRespostas.setSelected(false);
        }
        else{ //acabaram as questões
            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }
    }
}
