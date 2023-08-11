//DadoFragment.java
// Importações das classes e pacotes necessários
package com.example.rpgdadoeficha;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import java.util.Objects;
import static java.lang.Math.sqrt;
import java.util.Random;

public class DadoFragment extends Fragment {

    // Constante usada para armazenar o valor do dado
    private static final String ARG_VALOR_DADO = "valor_dado";

    // Variável que armazena o valor atual do dado
    private int mValorDado;

    // Elementos da interface do usuário
    private Button rolarDado;
    private View view;

    // Sensor de acelerômetro para detectar quando o dispositivo é agitado
    private SensorManager sensorManager;
    private float acceleration = 10f;
    private float currentAcceleration = 0f;
    private float lastAcceleration = 0f;

    // Gerador de números aleatórios para simular o lançamento do dado
    private Random random;

    // Método estático para criar uma nova instância do fragmento
    public static DadoFragment newInstance(int valorDado) {
        DadoFragment fragment = new DadoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_VALOR_DADO, valorDado);
        fragment.setArguments(args);
        return fragment;
    }

    // Construtor vazio necessário para o fragmento
    public DadoFragment() {
    }

    // Método chamado quando o fragmento é criado
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Recupera o valor do dado dos argumentos, se houver algum
        Bundle b = getArguments();
        if (b != null) {
            mValorDado = b.getInt(ARG_VALOR_DADO, 4);
        }
    }

    // Método chamado quando a exibição do fragmento é criada
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Infla o layout do fragmento e obtém uma referência aos elementos da interface do usuário
        view = inflater.inflate(R.layout.fragment_dado, container, false);
        rolarDado = view.findViewById(R.id.rolarDado);

        // Configura o texto do TextView para exibir o valor atual do dado
        TextView meuTextView = view.findViewById(R.id.meuTextView);
        meuTextView.setText("Dado de " + mValorDado + " lados");

        // Esconde o cabeçalho da atividade principal
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        // Cria um gerador de números aleatórios
        random = new Random();

        // Configura o listener de clique do botão para rolar o dado
        setRandom();
        rolarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandom();
                vibrate();
            }
        });

        // Configura o listener de acelerômetro para detectar quando o dispositivo é agitado
        sensorManager = (SensorManager) view.getContext().getSystemService(view.getContext().SENSOR_SERVICE);
        Objects.requireNonNull(sensorManager).registerListener(sensorListener,
                Objects.requireNonNull(sensorManager).getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        acceleration = 10f;
        currentAcceleration = SensorManager.GRAVITY_EARTH;
        lastAcceleration = SensorManager.GRAVITY_EARTH;

        return view;
    }

    // Listener para o acelerômetro que detecta mudanças na aceleração do dispositivo
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            lastAcceleration = currentAcceleration;

            // Calcula a aceleração atual com base nos valores dos eixos x, y e z
            currentAcceleration = (float) sqrt((x * x + y * y + z * z));

            // Calcula a diferença entre a aceleração atual e a aceleração anterior
            float delta = currentAcceleration - lastAcceleration;

            // Atualiza a aceleração total considerando a diferença anterior e atual
            acceleration = acceleration * 0.9f + delta;

            // Se a aceleração do dispositivo for grande o suficiente, gera um novo valor aleatório e vibra
            if (acceleration > 12) {
                setRandom();
                vibrate();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Método vazio; não é necessário implementar nesta situação
        }
    };

    // Gera um novo valor aleatório para o botão e atualiza o texto do botão
    private void setRandom() {
        int valor = (random.nextInt(mValorDado) + 1);
        rolarDado.setText(String.valueOf(valor));
    }

    // Vibra o dispositivo por 100ms
    private void vibrate() {
        Context ctx = getContext();
        if (ctx != null) {
            Vibrator vibrator = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null) {
                vibrator.vibrate(100);
            }
        }
    }
}
