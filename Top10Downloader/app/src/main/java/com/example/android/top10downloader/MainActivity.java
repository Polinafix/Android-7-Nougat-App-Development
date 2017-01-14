package com.example.android.top10downloader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: starting AsyncTask");
        //create an instance of the DownloadData class
        DownloadData downloadData = new DownloadData();
        downloadData.execute("URL goes here");
        Log.d(TAG, "onCreate: done");
    }
   // we create the inner class, because it's not going to be used anywhere else
    private class DownloadData extends AsyncTask<String,Void,String>{//the info provided(URL), progress, result
       //we need to add methods to override them, so that we can add specific functionality
       //we will add 2 methods
       private static final String TAG = "DownloadData";

//that's how we tell the Android what code we want to run in the background
       @Override
       protected String doInBackground(String... params) {
           Log.d(TAG, "doInBackground: starts with " + params[0]);
           String rssFeed = downloadXML(params[0]);
           if(rssFeed == null){
               Log.e(TAG, "doInBackground: error downloading");//Send an ERROR log message.
           }
           return rssFeed;
       }
//as we want to get the data back when the task completes, android will call this method when the job is done
       @Override
       protected void onPostExecute(String s) {
           Log.d(TAG, "onPostExecute: parameter is "+s);
           super.onPostExecute(s);
       }
   }

}
