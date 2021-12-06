package com.example.quoteapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NetworkingService.NetworkingListener {
    TextView textView;
    ImageView imageView;
    NetworkingService networkingService;
    JsonService jsonService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.quote);
        imageView = findViewById(R.id.photo);

        networkingService = ((myApp)getApplication()).getNetworkingService();
       jsonService = ((myApp)getApplication()).getJsonService();
        networkingService.connect();//send request to api
        networkingService.listener = this;

    }

    @Override
    public void APINetworkListener(String jsonString) {
        Log.d("tag", jsonString);
        jsonService.parseQuoteAPIData(jsonString);
//       textView.setText(.get.quoteData.q);


    }
}