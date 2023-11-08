package com.example.imageview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
    class MainActivity extends Activity {
    private static final int GALLERY_REQUEST_CODE = 100;
    private ImageView imageView;
    private Button selectImageButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        selectImageButton = findViewById(R.id.selectImageButton);

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                Bitmap selectedImageBitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(selectedImageBitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Main {
        private static double result;

        public static double pythagoreanTheorem(double a, double b) {
            result = (Math.sqrt(a * a + b * b));
            return result;
        }
    }
        public class mainactivity extends AppCompatActivity {

            EditText etWeight, etHeight;
            Button btnCalculate;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                connectComponents();
            }

            private void connectComponents() {
                etWeight = findViewById(R.id.etWeightMain);
                etHeight = findViewById(R.id.etHeightMain);
                btnCalculate = findViewById(R.id.btnCalculateMain);
            }

            public void calculate(View view) {

                String weight = etWeight.getText().toString();
                String height = etHeight.getText().toString();

                if (weight.isEmpty() || !TextUtils.isDigitsOnly(weight) || weight.isEmpty() || !TextUtils.isDigitsOnly(weight)) {
                    Toast.makeText(this, "Check data you entered!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double w, h, bmi;
                w = Double.parseDouble(weight);
                h = Double.parseDouble(height);
                bmi = w / (h * h);

                Toast.makeText(this, "Your BMI is:" + bmi, Toast.LENGTH_LONG).show();
            }
        }
    }

