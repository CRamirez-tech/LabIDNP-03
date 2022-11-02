package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private ArrayList<Usuario> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinfo);

        list = getIntent().getParcelableArrayListExtra("lista");

        EditText editBuscarDni = findViewById(R.id.editBuscarDni);
        Button btnBuscar = findViewById(R.id.btnBuscar);

        EditText editDni = findViewById(R.id.editDni);
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editApellidos = findViewById(R.id.editApellidos);
        EditText editBirthDate = findViewById(R.id.editBirthday);
        EditText editColegio = findViewById(R.id.editColegio);
        EditText editCarrera = findViewById(R.id.editCarrera);

        editDni.setEnabled(false);
        editNombres.setEnabled(false);
        editApellidos.setEnabled(false);
        editBirthDate.setEnabled(false);
        editColegio.setEnabled(false);
        editCarrera.setEnabled(false);

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(8);
        editBuscarDni.setFilters(FilterArray);

        btnBuscar.setOnClickListener(view -> {

            int valueToFind = Integer.parseInt(editBuscarDni.getText().toString());

            Usuario user_match=null;
            for (Usuario user: list) {
                Log.d("Dni",user.getDni()+"");
                if (valueToFind==user.getDni()){
                    editDni.setText(user_match.getDni());
                    editNombres.setText(user_match.getNames());
                    editApellidos.setText(user_match.getLastnames());
                    editBirthDate.setText(user_match.getBirthday());
                    editColegio.setText(user_match.getCollege());
                    editCarrera.setText(user_match.getCarreer());
                    break;
                }
            }
        });

    }
}