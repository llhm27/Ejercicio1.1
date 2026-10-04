package com.ucenm.ejercicio1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends Activity {
    private EditText numero1;
    private EditText numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        configurarBoton(R.id.botonSuma, "Suma");
        configurarBoton(R.id.botonResta, "Resta");
        configurarBoton(R.id.botonDivision, "División");
        configurarBoton(R.id.botonMultiplicacion, "Multiplicación");
        Button botonSalir = findViewById(R.id.botonSalir);
        botonSalir.setOnClickListener(v -> finishAffinity());
    }

    private void configurarBoton(int id, String operacion) {
        Button boton = findViewById(id);
        boton.setOnClickListener(v -> calcularYMostrar(operacion));
    }

    private void calcularYMostrar(String operacion) {
        String texto1 = numero1.getText().toString().trim();
        String texto2 = numero2.getText().toString().trim();
        if (texto1.isEmpty() || texto2.isEmpty()) {
            Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double a = Double.parseDouble(texto1);
            double b = Double.parseDouble(texto2);
            double resultado;
            switch (operacion) {
                case "Suma": resultado = OperacionesMatematicas.sumar(a, b); break;
                case "Resta": resultado = OperacionesMatematicas.restar(a, b); break;
                case "Multiplicación": resultado = OperacionesMatematicas.multiplicar(a, b); break;
                case "División": resultado = OperacionesMatematicas.dividir(a, b); break;
                default: throw new IllegalArgumentException("Operación desconocida");
            }
            Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
            intent.putExtra(SegundaActivity.EXTRA_OPERACION, operacion);
            intent.putExtra(SegundaActivity.EXTRA_RESULTADO, resultado);
            startActivity(intent);
        } catch (ArithmeticException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
