//MainActivity

package com.example.rpgdadoeficha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Oculta a barra de ação na parte superior da atividade
        getSupportActionBar().hide();
    }

    // Método para o botão "proxima4"
    public void proxima4(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela4lados
        Intent it = new Intent(getApplicationContext(), Tela4lados.class);
        // Inicia a atividade Tela4lados
        startActivity(it);
    }

    // Método para o botão "proxima6"
    public void proxima6(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela6lados
        Intent it = new Intent(getApplicationContext(), Tela6lados.class);
        // Inicia a atividade Tela6lados
        startActivity(it);
    }

    // Método para o botão "proxima8"
    public void proxima8(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela8lados
        Intent it = new Intent(getApplicationContext(), Tela8lados.class);
        // Inicia a atividade Tela8lados
        startActivity(it);
    }

    // Método para o botão "proxima10"
    public void proxima10(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela10lados
        Intent it = new Intent(getApplicationContext(), Tela10lados.class);
        // Inicia a atividade Tela10lados
        startActivity(it);
    }

    // Método para o botão "proxima12"
    public void proxima12(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela12lados
        Intent it = new Intent(getApplicationContext(), Tela12lados.class);
        // Inicia a atividade Tela12lados
        startActivity(it);
    }

    // Método para o botão "proxima20"
    public void proxima20(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela20lados
        Intent it = new Intent(getApplicationContext(), Tela20lados.class);
        // Inicia a atividade Tela20lados
        startActivity(it);
    }

    // Método para o botão "proxima100"
    public void proxima100(View view) {
        // Cria um objeto Intent para iniciar a atividade Tela100lados
        Intent it = new Intent(getApplicationContext(), Tela100lados.class);
        // Inicia a atividade Tela100lados
        startActivity(it);
    }
}
