package com.main.edgeviewer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.main.edgeviewer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Load native library
    static {
        System.loadLibrary("edgeviewer");
    }

    private ActivityMainBinding binding;

    // Native method declaration
    public native String testOpenCV();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Call OpenCV test function
        TextView tv = binding.sampleText;
        tv.setText(testOpenCV());
    }
}
