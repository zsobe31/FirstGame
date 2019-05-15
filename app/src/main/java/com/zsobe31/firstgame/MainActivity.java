package com.zsobe31.firstgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // a gameview megkeresese
        final GameView gameView = findViewById(R.id.gameView);

        // gombesemeny kezelo letrehozasa
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // a torlo fuggveny meghivasa
                gameView.clearGameView();
            }
        });

    }
}
