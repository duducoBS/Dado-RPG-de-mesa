//Tela10lado.java
package com.example.rpgdadoeficha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Tela10lados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10lados);
        // Cria um objeto Bundle para passar dados para o fragmento
        Bundle bundle = new Bundle();
        bundle.putInt("valor_dado", 10);

        // Inicia uma transação de fragmento
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                // Adiciona o fragmento DadoFragment ao layout com o ID dado_frag
                .add(R.id.dado_frag, DadoFragment.class, bundle)
                .commit();
    }
}