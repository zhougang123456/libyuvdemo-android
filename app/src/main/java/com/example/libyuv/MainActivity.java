package com.example.libyuv;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int data[] = new int[100 * 100];
        ImageView imageView = findViewById(R.id.image);
        Bitmap bitmap = Bitmap.createBitmap(data, 100, 100, Bitmap.Config.ARGB_8888);
        if (bitmap == null){
            Log.d("zhou", "create bitmap failed!");
        }
        imageView.setImageBitmap(bitmap);
        RGBAToBGAR(bitmap, 100, 100);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void  RGBAToBGAR(Bitmap bitmap, int width, int height);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native");
    }
}
