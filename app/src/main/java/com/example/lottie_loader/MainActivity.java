package com.example.lottie_loader;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.OpenableColumns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private Button btnAction;
    private ProgressBar progressBar;
    private LottieAnimationView lottieSuccess;
    private MaterialCardView cardFileInfo;
    private TextView tvFileName, tvFileSize;
    private ViewGroup mainContainer;

    private boolean isFileSelected = false;

    private final ActivityResultLauncher<Intent> filePickerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri uri = result.getData().getData();
                    handleFileSelection(uri);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = findViewById(R.id.btn_action);
        progressBar = findViewById(R.id.progressBar);
        lottieSuccess = findViewById(R.id.lottie_success);
        cardFileInfo = findViewById(R.id.card_file_info);
        tvFileName = findViewById(R.id.tv_filename);
        tvFileSize = findViewById(R.id.tv_filesize);
        mainContainer = findViewById(R.id.main_container);

        if (mainContainer != null && mainContainer.getLayoutTransition() != null) {
            mainContainer.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        }

        btnAction.setOnClickListener(v -> {
            if (!isFileSelected) {
                openFilePicker();
            } else {
                startUploadSimulation();
            }
        });
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        filePickerLauncher.launch(intent);
    }

    private void handleFileSelection(Uri uri) {
        cardFileInfo.setVisibility(View.VISIBLE);
        String name = getFileName(uri);
        tvFileName.setText(name);
        tvFileSize.setText("Ready to upload");
        btnAction.setText("Upload Now");
        isFileSelected = true;
    }

    private void startUploadSimulation() {
        btnAction.setText("");
        btnAction.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            cardFileInfo.setVisibility(View.GONE);
            btnAction.setVisibility(View.GONE);

            lottieSuccess.setVisibility(View.VISIBLE);
            lottieSuccess.playAnimation();

            Toast.makeText(this, "Upload Complete!", Toast.LENGTH_SHORT).show();
        }, 3000);
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if(index >= 0) result = cursor.getString(index);
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}