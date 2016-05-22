package com.example.abhishek.feedback;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String rateValue;
    RatingBar mBar1;
    RatingBar mBar2;
    RatingBar mBar3;
    RatingBar mBar4;
    RatingBar mBar5;
    RatingBar mBar6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBar1 = (RatingBar) findViewById(R.id.ratingBar1);
         mBar2 = (RatingBar) findViewById(R.id.ratingBar2);
         mBar3 = (RatingBar) findViewById(R.id.ratingBar3);
         mBar4 = (RatingBar) findViewById(R.id.ratingBar4);
         mBar5 = (RatingBar) findViewById(R.id.ratingBar5);
         mBar6 = (RatingBar) findViewById(R.id.ratingBar6);
        addListenerOnButton();

    }

    private void addListenerOnButton() {
        final Context context=this;
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent("android.intent.action.MainActivity2");
                                          startActivity(intent);

                                      }
                                  }
        );


    }
    public float[]  getRatingBarValues1(final Context mcontext1)
    {
        float[] i =new float[]{ mBar1.getRating()};

        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext1, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext1, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return i;
    }
    public float[]  getRatingBarValues2(final  Context mcontext2)
    {
        float[] j =  new float[]{mBar2.getRating()};
        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext2, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext2, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return j;
    } public float[]  getRatingBarValues3(final Context mcontext3)
    {
        float[] k =  new float[]{mBar3.getRating()};
        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext3, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext3, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return k;
    } public float[]  getRatingBarValues4(final Context mcontext4)
    {
        float[] l = new float[]{mBar4.getRating()};
        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext4, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext4, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return l;
    }
    public float[]  getRatingBarValues5(final Context mcontext5)
    {
        float[] m = new float[]{mBar5.getRating()};
        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext5, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext5, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return m;
    } public float[]  getRatingBarValues6(final Context mcontext6)
    {
        float[] n =  new float[]{mBar6.getRating()};
        mBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(mcontext6, mBar1.getRating() + "", Toast.LENGTH_LONG);
                toast.show();

            }

        });
        Toast toast = Toast.makeText(mcontext6, mBar1.getRating() + "", Toast.LENGTH_LONG);
        toast.show();

        return n;
    }
}
