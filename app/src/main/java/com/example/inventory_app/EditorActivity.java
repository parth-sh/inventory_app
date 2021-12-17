package com.example.inventory_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditorActivity extends AppCompatActivity {
    TextView textViewScannedCode;
    EditText editTextItemName;
    EditText editTextItemDescription;
    EditText editTextItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        String scanned_code = getIntent().getStringExtra("SCANNED_CODE");

        textViewScannedCode = findViewById(R.id.textViewScannedCode);
        editTextItemName = findViewById(R.id.edit_item_name);
        editTextItemDescription = findViewById(R.id.edit_item_description);
        editTextItemCount = findViewById(R.id.edit_item_count);

        textViewScannedCode.setText(scanned_code);
        textViewScannedCode.setTextSize(getResources().getDimension(R.dimen.text_size));
    }
}