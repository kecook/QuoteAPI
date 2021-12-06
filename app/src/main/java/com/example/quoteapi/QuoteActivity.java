package com.example.quoteapi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class QuoteActivity extends AppCompatActivity implements NetworkingService.NetworkingListener {
    NetworkingService networkingService;
    JsonService jsonService;
    TextView quoteText;
@Override
protected void onCreate(Bundle savedInstancesState){
    super.onCreate(savedInstancesState);
    networkingService = ((myApp)getApplication()).getNetworkingService();
    jsonService = ((myApp)getApplication()).getJsonService();
    networkingService.listener = this;
    quoteText.findViewById(R.id.quote);


    }


    @Override
    public void APINetworkListener(String jsonString) {
    QuoteData quoteData = jsonService.parseQuoteAPIData(jsonString);
    quoteText.setText(quoteData.q + quoteData.a);


    }
}
