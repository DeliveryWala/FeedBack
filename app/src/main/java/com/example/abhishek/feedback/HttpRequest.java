package com.example.abhishek.feedback;

/**
 * Created by Abhishek on 21-05-2016.
 */

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.io.PrintWriter;
    import java.io.UnsupportedEncodingException;
    import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.SocketTimeoutException;
    import java.net.URL;
    import java.net.URLConnection;

    import org.apache.http.HttpResponse;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.client.params.ClientPNames;
    import org.apache.http.client.params.CookiePolicy;
    import org.apache.http.entity.StringEntity;
    import org.apache.http.impl.client.DefaultHttpClient;
    import org.apache.http.params.BasicHttpParams;
    import org.apache.http.params.HttpConnectionParams;
    import org.apache.http.params.HttpParams;
    import org.apache.http.protocol.BasicHttpContext;
    import org.apache.http.protocol.HttpContext;
    import org.apache.http.util.EntityUtils;
    import org.json.JSONObject;

    import android.content.Context;
    import android.content.Intent;
    import android.util.Log;

/*
 * This helper class was created by StackOverflow user: MattC http://stackoverflow.com/users/21126/mattc
 * IT was posted as an Answer to this question: http://stackoverflow.com/questions/2253061/secure-http-post-in-android
 */

    public class HttpRequest{

        DefaultHttpClient httpClient;
        HttpContext localContext;
        private String ret;
Context mcontext;
        HttpResponse response = null;
        HttpPost httpPost = null;
        HttpGet httpGet = null;

        public void HttpRequest(){
            HttpParams myParams = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(myParams, 10000);
            HttpConnectionParams.setSoTimeout(myParams, 10000);
            httpClient = new DefaultHttpClient(myParams);
            localContext = new BasicHttpContext();
        }

        public void clearCookies() {
            httpClient.getCookieStore().clear();
        }

        public void abort() {
            try {
                if (httpClient != null) {
                    System.out.println("Abort.");
                    httpPost.abort();
                }
            } catch (Exception e) {
                System.out.println("Your App Name Here" + e);
            }
        }

        public String sendPost(String url, String data,Context context) {
            mcontext=context;
            return sendPost(url, data, null,mcontext);
        }

        public String sendJSONPost(String url, JSONObject data) {
            return sendPost(url, data.toString(), "application/json",mcontext);
        }

        public String sendPost(final String url,final String data, String contentType, final Context context) {
           Thread thread=new Thread(new Runnable() {
               @Override
               public void run() {
                   String text = "";
                   BufferedReader reader = null;
                   HttpURLConnection conn=null;

                   // Send data
                   try {

                       // Defined URL  where to send data
                       URL url1 = new URL(url);

                       // Send POST data request

                       conn = (HttpURLConnection) url1.openConnection();
                       if (data != null) {
                           conn.setDoOutput(true);
                           conn.setRequestMethod("POST");
                           conn.setFixedLengthStreamingMode(
                                   data.getBytes().length);
                           conn.setRequestProperty("Content-Type",
                                   "application/x-www-form-urlencoded");
                           PrintWriter out = new PrintWriter(conn.getOutputStream());
                           out.print(data);

                           out.close();
                           ((MainActivity2) context).runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Intent i = new Intent(context, SplashScreenActivity.class);
                                   context.startActivity(i);

                               }
                           });
                       }
                       // Get the server response


                       int statusCode = conn.getResponseCode();
                       if (statusCode != HttpURLConnection.HTTP_OK) {
                           // throw some exception
                       }
                   } catch (MalformedURLException e) {
                       // handle invalid URL
                   } catch (SocketTimeoutException e) {
                       // hadle timeout
                   } catch (IOException e) {
                       // handle I/0
                   } finally {
                       if (conn != null) {
                           conn.disconnect();
                       }
                   }

               }
           });
            thread.start();
            /*
            String text = "";
            BufferedReader reader = null;
            HttpURLConnection conn=null;
            // Send data
            try {

                // Defined URL  where to send data
                URL url1 = new URL(url);

                // Send POST data request

                 conn = (HttpURLConnection) url1.openConnection();
                if (data != null) {
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setFixedLengthStreamingMode(
                            data.getBytes().length);
                    conn.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    PrintWriter out = new PrintWriter(conn.getOutputStream());
                    out.print(data);
                    out.close();
                }
                // Get the server response


                int statusCode = conn.getResponseCode();
                if (statusCode != HttpURLConnection.HTTP_OK) {
                    // throw some exception
                }
            } catch (MalformedURLException e) {
                // handle invalid URL
            } catch (SocketTimeoutException e) {
                // hadle timeout
            } catch (IOException e) {
                // handle I/0
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }*/
            return null;
        }

        }







