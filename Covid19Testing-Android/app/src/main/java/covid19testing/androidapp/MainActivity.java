package covid19testing.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


// App <- http request ->  Backend <- -> [DB (store patients requests), hospital (mock)]
// 1) minimum number of web requests, send in batches
// 2) App only talk to backend

public class MainActivity extends AppCompatActivity {
    private static String TAG = "CovidTestingTag";
    private static String backendEndpoint = "https://covid19testing-backend-001.herokuapp.com/";
    private static final int CONNECTION_TIMEOUT = 5;
    // add method paths here.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.submitPatient);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL url = null;
                try {
                    url = new URL(backendEndpoint);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    // timeouts is important
                    connection.setConnectTimeout(CONNECTION_TIMEOUT);
                    String data = "{ \"PatientName\":\"John\"}";

                    // setting the content properties
                    connection.setRequestProperty("Content-type", "application/json");
                    connection.setRequestProperty("Content-length", Integer.toString(data.getBytes().length));
                    connection.setRequestMethod("POST");

                    OutputStream requestStream = connection.getOutputStream();
                    requestStream.write(data.getBytes());
                    requestStream.close();

                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        // handle the error.
                        Log.d(TAG, "" + responseCode);
                    }

                    BufferedReader responseStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String response = "";
                    String oneLine;
                    while ((oneLine = responseStream.readLine()) != null) {
                        response += oneLine;
                    }
                    Log.d(TAG, response);
                    // do whatever with the response.
                    JSONObject jsonResponse = null;
                    try {
                        jsonResponse = new JSONObject(response);
                    } catch (JSONException e) {
                    }
                    if (jsonResponse != null) {
                        jsonResponse.getJSONObject("menu").getJSONArray("id");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, e.getMessage());
                }
            }
        });

    }
}