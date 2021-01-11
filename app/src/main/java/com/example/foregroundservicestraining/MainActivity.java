package com.example.foregroundservicestraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text_input);
    }

    public void startService(View view) {
        String input = editText.getText().toString();
        Intent serviceIntent = new Intent(this, MyService.class);
        serviceIntent.putExtra("inputExtra", input);
        ContextCompat.startForegroundService(this,serviceIntent);
    }

    public void stopServices(View view) {
        Intent serviceIntent = new Intent(this, MyService.class);
        stopService(serviceIntent);
    }
}