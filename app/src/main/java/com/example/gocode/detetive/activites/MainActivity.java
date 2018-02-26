package com.example.gocode.detetive.activites;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocode.detetive.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final List<String> palavras = new ArrayList<>();

    EditText etJogadores;
    TextView tvPapel;
    Button btPegarPapel;
    Button btEmbaralhar;
    Button btComoJogar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        ActionBar bar = getSupportActionBar();
        bar.hide();

        btEmbaralhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etJogadores.getText().length() == 0) {
                    etJogadores.setError(getResources().getString(R.string.et_setError_number_players));
                } else if (Integer.valueOf(etJogadores.getText().toString()) < 3) {
                    etJogadores.setError(getResources().getString(R.string.et_amount_minimum_players));
                } else {
                    palavras.clear();
                    palavras.add(getResources().getString(R.string.assassino));
                    palavras.add(getResources().getString(R.string.detetive));
                    for (int i = 0; i < Integer.valueOf(etJogadores.getText().toString()) - 2; i++) {
                        palavras.add(getResources().getString(R.string.vitima));
                    }
                    Collections.shuffle(palavras);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.papeis_embaralhados), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btPegarPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etJogadores.getText().length() == 0) {
                    etJogadores.setError(getResources().getString(R.string.et_setError_number_players));
                } else if (Integer.valueOf(etJogadores.getText().toString()) < 3) {
                    etJogadores.setError(getResources().getString(R.string.et_amount_minimum_players));
                } else {
                    for (int i = 0; i < palavras.size(); i++) {
                        String papel = palavras.get(i);
                        Toast.makeText(MainActivity.this, papel, Toast.LENGTH_SHORT).show();
                        palavras.remove(i);
                        break;
                    }
                }
            }
        });

        btComoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ComoJogar.class);
                startActivity(i);
            }
        });
    }

    private void setupViews() {
        etJogadores = (EditText) findViewById(R.id.etJogadores);
        btPegarPapel = (Button) findViewById(R.id.btPegarPapel);
        btEmbaralhar = (Button) findViewById(R.id.btEmbaralhar);
        btComoJogar = (Button) findViewById(R.id.btComoJogar);
    }
}
