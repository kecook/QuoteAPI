package com.example.quoteapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {

    public QuoteData parseQuoteAPIData(String jsonQuotesString){
        QuoteData quoteData = new QuoteData();
        try{
            JSONArray jsonArray = new JSONArray(jsonQuotesString);
            JSONObject jsonQuoteObject = jsonArray.getJSONObject(0);
            String q = jsonQuoteObject.getString("q");
            String a = jsonQuoteObject.getString("a");
            quoteData = new QuoteData(q,a);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quoteData;
    }

}
