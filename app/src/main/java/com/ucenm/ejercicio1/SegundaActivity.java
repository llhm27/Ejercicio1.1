package com.ucenm.ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.text.DecimalFormat;

public class SegundaActivity extends Activity {
    public static final String EXTRA_OPERACION = "com.ucenm.ejercicio1.OPERACION";
    public static final String EXTRA_RESULTADO = "com.ucenm.ejercicio1.RESULTADO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        String operacion = getIntent().getStringExtra(EXTRA_OPERACION);
        double resultado = getIntent().getDoubleExtra(EXTRA_RESULTADO, Double.NaN);
        TextView textoOperacion = findViewById(R.id.textoOperacion);
        TextView textoResultado = findViewById(R.id.textoResultado);
        textoOperacion.setText(operacion == null ? "Resultado" : operacion);
        textoResultado.setText(new DecimalFormat("0.##########").format(resultado));
        Button botonVolver = findViewById(R.id.botonVolver);
        botonVolver.setOnClickListener(v -> finish());
    }
}
