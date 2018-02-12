package mx.edu.ittepic.tam_tabla_multiplicar_vicentemz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tabla, progreso;
    Button cal;
    SeekBar see;
    int pro=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        see=findViewById(R.id.seekBar);
        cal=findViewById(R.id.button);
        progreso=findViewById(R.id.textView3);
        tabla=findViewById(R.id.textView2);

        progreso.setText(""+pro);

        see.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                progreso.setText(""+progressChangedValue);
                pro=progressChangedValue;
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pro > 0){
                    String salida;
                    int result;
                    tabla.setText("");
                    for (int i = 1; i <= 15; i++) {
                        result = pro * i;
                        String alpa = ""+pro;
                        salida = alpa + "x" + i + "=" + result;
                        tabla.append("\n" + salida);
                    }
                } else{
                    Toast.makeText(MainActivity.this,"No ingreso valor",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
