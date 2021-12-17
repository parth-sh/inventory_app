package com.example.inventory_app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class CatalogActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButtonScan;

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
        result -> {
            if(result.getContents() == null) {
                Toast.makeText(CatalogActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                intent.putExtra("SCANNED_CODE",result.getContents());
                startActivity(intent);
            }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        floatingActionButtonScan = findViewById(R.id.floatingActionButton_scan);
        floatingActionButtonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcodeLauncher.launch(new ScanOptions()
//                        .setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES)
                        .setPrompt("Scan a barcode")
                        .setCameraId(0)
                        .setBeepEnabled(false)
                        .setBarcodeImageEnabled(true)
                );
            }
        });
    }
}