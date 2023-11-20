package ca.georgebrown.com.comp3074.final_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fastFoodButton = findViewById(R.id.buttonFastFood);
        Button fineDiningButton = findViewById(R.id.buttonFineDining);
        Button barsButton = findViewById(R.id.buttonBars);
        Button worldCuisineButton = findViewById(R.id.buttonWorldCuisine);

        fastFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FastFoodActivity.class));
            }
        });

        fineDiningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FineDiningActivity.class);
                startActivity(intent);
            }
        });

        barsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BarsActivity.class));
            }
        });

        worldCuisineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WorldCuisineActivity.class));
            }
        });
    }
}