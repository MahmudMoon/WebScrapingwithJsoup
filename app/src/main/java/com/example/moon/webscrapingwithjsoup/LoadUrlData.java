package com.example.moon.webscrapingwithjsoup;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoadUrlData extends AsyncTask<String,Void,String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String TAG = "MyTag";
        try {
            Document document = Jsoup.connect(url).get();
            Elements h1 = document.select("div[id=siteinfo]").select("a[href]");
            for (Element h:h1) {
               // Log.i(TAG, "doInBackground: "+h.attr("href"));
            }

            Elements a_s = document.select("a");
            for (Element a: a_s) {
               // Log.i(TAG, "doInBackground: "+a.text());
               // Log.i(TAG, "doInBackground: "+ a.attr("href"));

            }

            Elements h_s = document.select("div[class=post-right]").select("h2[class=post-title entry-title]");
            for (Element h:h_s) {
                Log.i(TAG, "doInBackground: "+h.text());
            }


            return document.title();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
