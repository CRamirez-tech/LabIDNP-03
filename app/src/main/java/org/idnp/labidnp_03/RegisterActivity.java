package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    private ArrayList<Usuario> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteregistro);

        list = getIntent().getParcelableArrayListExtra("lista");

        Button btnRegistro = findViewById(R.id.btnRegistro);
        EditText editDni = findViewById(R.id.editDni);
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editApellidos = findViewById(R.id.editApellidos);
        EditText editBirthDate = findViewById(R.id.editBirthDate);
        Spinner spinnerColegio = findViewById(R.id.spinnerColegio);
        Spinner spinnerCarrera = findViewById(R.id.spinnerCarrera);

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(8);
        editDni.setFilters(FilterArray);


        btnRegistro.setOnClickListener(view -> {
            int dni             = Integer.parseInt(editDni.getText().toString()) ;
            String names        = editNombres.getText().toString();
            String lastnames    = editApellidos.getText().toString();
            String birthday     = editBirthDate.getText().toString();
            String college      = spinnerColegio.getSelectedItem().toString();
            String carreer      = spinnerCarrera.getSelectedItem().toString();
            boolean tempRegister=true;
            Log.i("Definition","dni"+dni);
            Log.i("Definition 2","names"+names);
            Log.i("Definition 3","lastnames"+lastnames);
            Log.i("Definition 4","birthday"+birthday);
            for (Usuario user: list) {
                if (dni==user.getDni()){
                    tempRegister=false;
                    break;
                }
            }
            if (tempRegister){
                Log.i("Errors","User Add");
                list.add(new Usuario(dni,names,lastnames,birthday,college,carreer));
            }
        });
    }
}