package com.example.abhishek.feedback;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Abhishek on 20-05-2016.
 */
public class MainActivity2 extends AppCompatActivity {


    final String myTag = "DocsUpload";

    EditText frequency;
    EditText othercomments;
    EditText name;
    EditText dateofbirth;
    EditText mobileno;
    EditText email;
    EditText anniversary;
    EditText plannername;
    EditText plannernumber;
    Button button2;
    String f;
    String other;
    String n;
    String d;
    String m;
    String e;
    String pn;
    String pm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_info);
        frequency=(EditText)findViewById(R.id.editText1);
        othercomments=(EditText)findViewById(R.id.editText2);
        name=(EditText)findViewById(R.id.editText3);
        dateofbirth=(EditText)findViewById(R.id.editText4);
        anniversary=(EditText)findViewById(R.id.editText5);
        mobileno=(EditText)findViewById(R.id.editText6);
        email=(EditText)findViewById(R.id.editText7);
        plannername=(EditText)findViewById(R.id.editText8);
        plannernumber=(EditText)findViewById(R.id.editText9);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        postData();
                    }
                });
                t.start();
            }
        });

    }

    public void postData() {
/*        f=frequency.getText().toString();
        other=othercomments.getText().toString();
        n=name.getText().toString();
        d=dateofbirth.getText().toString();
        m=mobileno.getText().toString();
        e=email.getText().toString();
        pn=plannername.getText().toString();
        pm=plannernumber.getText().toString();
        MainActivity obj=new MainActivity();
        float[] a=obj.getRatingBarValues1();
        float[] b=obj.getRatingBarValues2();
        float[] c=obj.getRatingBarValues3();
        float[] l=obj.getRatingBarValues4();
        float[] j=obj.getRatingBarValues5();
        float[] p=obj.getRatingBarValues6();

        final String fullUrl = "https://docs.google.com/forms/d/1kgVjyzamlIVSkd-BiW5iA-AHkVLqcNf9IxObyNyygTg/formResponse";
        URL url;
        HttpURLConnection client = null;
        try {
            url = new URL(fullUrl);
            client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setChunkedStreamingMode(0);
            client.setRequestProperty("Guest Name",n);
            String input=n;
            OutputStream out = new BufferedOutputStream(client.getOutputStream());
            out.write(input.getBytes());
            out.flush();
            out.close();

        } catch (MalformedURLException error) {
            //Handles an incorrectly entered URL
        } catch (SocketTimeoutException error) {
//Handles URL access timeout.
        } catch (IOException error) {
//Handles input and output errors
        } finally {
            if (client != null) // Make sure the connection is not null.
                client.disconnect();



        }*/

        String fullUrl = "https://docs.google.com/forms/d/1rwU-iiwfM4Kw5hSk8m1HpMlR3zGK-j56DCDEOZ6Jwm0/formResponse";
        com.example.abhishek.feedback.HttpRequest mReq = new com.example.abhishek.feedback.HttpRequest();
        String col1 = name.getText().toString();
        String col2 = dateofbirth.getText().toString();
        String col3 = anniversary.getText().toString();
        String col4 = mobileno.getText().toString();
        String col5 = email.getText().toString();
        String col6 = plannername.getText().toString();
        String col7 = plannernumber.getText().toString();
        MainActivity obj=new MainActivity();
        float[] a=obj.getRatingBarValues1(MainActivity2.this);
        String col8 = a+"";
        float[] b=obj.getRatingBarValues2(MainActivity2.this);
        String col9 = b+"";
        float[] c=obj.getRatingBarValues3(MainActivity2.this);
        String col10=c+"";
        float[] l=obj.getRatingBarValues4(MainActivity2.this);
        String col11=l+"";

        float[] j=obj.getRatingBarValues5(MainActivity2.this);
        String col12=j+"";

        float[] p=obj.getRatingBarValues6(MainActivity2.this);
        String col13=p+"";
        String col14=frequency.getText().toString();
        String col15=othercomments.getText().toString();


        String data = "i.desc.510021173=" + URLEncoder.encode(col1) + "&" +
                " i.desc.1618590691=" + URLEncoder.encode(col2)+" i.desc.2011346372=" + URLEncoder.encode(col3)+
        "i.desc.2078477800=" + URLEncoder.encode(col4)+
        " i.desc.602127557=" + URLEncoder.encode(col5)+"i.desc.1107844120=" + URLEncoder.encode(col6)+
                " i.desc.1938300800=" + URLEncoder.encode(col7)+
                " i.desc.1419089895=" + URLEncoder.encode(col8)+
                " i.desc.1224927768=" + URLEncoder.encode(col9)+
                " i.desc.307429185=" + URLEncoder.encode(col10)+
                " i.desc.730045534=" + URLEncoder.encode(col11)+
                " i.desc.674729266=" + URLEncoder.encode(col12)+"i.desc.1983685580=" + URLEncoder.encode(col13)+
        "i.desc.1506942585=" + URLEncoder.encode(col14)+"i.desc.217578277=" + URLEncoder.encode(col15)
                ;
        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);

    }
}
