package com.apps.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void selecionadoPedra(View view){
            this.opcaoSelecionadaMaquina("pedra");
            this.retornaOpcaoUsuario("pedra");
        }

        public void selecionadoPapel(View view){
            this.opcaoSelecionadaMaquina("papel");
            this.retornaOpcaoUsuario("papel");
        }

        public void selecionadoTesoura(View view){
            this.opcaoSelecionadaMaquina("tesoura");
            this.retornaOpcaoUsuario("tesoura");
        }



        public void opcaoSelecionadaMaquina(String escolhaUsuario){

            ImageView imagemResultado = findViewById(R.id.imagemResultado);
            TextView textoResultado = findViewById(R.id.textoResultado);

            int numero = new Random().nextInt(3);
            String[] opcoes = {"pedra", "papel", "tesoura"};
            String opcaoApp = opcoes [numero];

            switch (opcaoApp){
                case "pedra":
                    imagemResultado.setImageResource(R.drawable.pedra);
                    break;

                case "papel":
                    imagemResultado.setImageResource(R.drawable.papel);
                    break;

                case "tesoura":
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    break;
            }

            if (
                (opcaoApp=="pedra" && escolhaUsuario=="tesoura") ||
                (opcaoApp=="papel" && escolhaUsuario=="pedra") ||
                (opcaoApp=="tesoura" && escolhaUsuario=="papel")
            )
            {//App ganhador
                textoResultado.setText("Você perdeu, tente outra vez! ;( ");
            }else if(
                    (escolhaUsuario=="pedra" && opcaoApp=="tesoura") ||
                    (escolhaUsuario=="papel" && opcaoApp=="pedra") ||
                    (escolhaUsuario=="tesoura" && opcaoApp=="papel")
            ){//Usuario ganhador
                textoResultado.setText("Parabéns, você ganhou! :) ");
            }else {//Empate
                textoResultado.setText("Empatamos! Tente outra vez! ");

            }
        }

        public void retornaOpcaoUsuario(String retornaOpcaoUsuario){

            ImageView escolhaUsuario = findViewById(R.id.escolhaUsuario);

            switch (retornaOpcaoUsuario){
                case "pedra":
                    escolhaUsuario.setImageResource(R.drawable.pedra);
                    break;

                case "papel":
                    escolhaUsuario.setImageResource(R.drawable.papel);
                    break;

                case "tesoura":
                    escolhaUsuario.setImageResource(R.drawable.tesoura);
                    break;

            }

            System.out.println(retornaOpcaoUsuario);
        }

}