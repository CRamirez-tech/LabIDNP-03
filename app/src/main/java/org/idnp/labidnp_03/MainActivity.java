package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ArrayList<Usuario> list = new ArrayList<>();

        Button btnNuevo = findViewById(R.id.btnNuevo);
        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnNuevo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });

        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });

    }
}