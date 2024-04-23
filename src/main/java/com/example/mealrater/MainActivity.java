package com.example.mealrater;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextDishName, editTextRestaurantName;
    TextView textViewRatingValue, textViewDishValue, textViewRestaurantValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDishName = findViewById(R.id.editTextDishName);
        editTextRestaurantName = findViewById(R.id.editTextRestaurantName);

        textViewRatingValue = findViewById(R.id.textViewRatingValue);
        textViewDishValue = findViewById(R.id.textViewDishValue);
        textViewRestaurantValue = findViewById(R.id.textViewRestaurantValue);

        Button buttonRate = findViewById(R.id.buttonRate);
        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog();
            }
        });
    }

    private void showRatingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rate the Meal");

        final String[] ratings = {"1", "2", "3", "4", "5"};

        builder.setItems(ratings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedRating = ratings[which];
                textViewRatingValue.setText(selectedRating);
            }
        });

        builder.show();
    }
}
