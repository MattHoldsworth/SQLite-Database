package com.example.matt.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    EditText mattysInput;
    TextView mattysText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mattysInput = findViewById(R.id.mattysInput);
        mattysText = findViewById(R.id.mattysText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        Product product = new Product(mattysInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete a product from the database
    public void deleteButtonClicked(View view) {
        String inputText = mattysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        mattysText.setText(dbString);
        mattysInput.setText("");
    }
}
