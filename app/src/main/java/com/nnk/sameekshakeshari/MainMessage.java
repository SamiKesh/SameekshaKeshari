package com.nnk.sameekshakeshari;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainMessage extends AppCompatActivity {
   // TextView t1,t2,t3;
    DatabaseReference fff;
    int i=1;
  LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_message);
       // t1=findViewById(R.id.t1);
     //   t2=findViewById(R.id.t2);
        //t3=findViewById(R.id.t3);



        ll=findViewById(R.id.l1);
        if(savedInstanceState!=null)
        {
            i=savedInstanceState.getInt("k1");

        }
        Intent intent=getIntent();
        Bundle b =intent.getExtras();
        if(b!=null) {
            if (b.getInt("k1") >= 1) {
                i = b.getInt("k1");
            }
        }


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!haveNetwork()) {
                    Intent intent1 = new Intent(MainMessage.this, MainActivity.class);
                    intent1.putExtra("k1", i);
                    startActivity(intent1);
                } else {


                    fff = FirebaseDatabase.getInstance().getReference().child("Message");
                    fff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (i <= 51) {
                                String d = Integer.toString(i);
                                if (i % 2 != 0) {

                                    String m1 = dataSnapshot.child(d).getValue().toString();

                                    TextView textView = new TextView(MainMessage.this);
                                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    textView.setLayoutParams(params);
                                    params.setMargins(20, 40, 450, 40);

                                    textView.setPadding(30, 30, 30, 30);
                                    textView.setGravity(10);
                                    textView.setTextColor(Color.WHITE);
                                    textView.setVisibility(View.VISIBLE);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                                        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    }

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        textView.setBackground(getResources().getDrawable(R.drawable.message));


                                    } else {
                                        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.message));
                                    }


                                    textView.setText(m1);
                                    ll.addView(textView);
                                    if(i==7)
                                    {
                                        ImageView imageView=new ImageView(MainMessage.this);
                                        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                        imageView.setLayoutParams(params1);
                                        params.setMargins(20, 40, 450, 40);
                                        imageView.setImageResource(R.drawable.weather);
                                        ll.addView(imageView);

                                    }
                                } else if(i%2==0 && i!=18) {

                                    TextView textView = new TextView(MainMessage.this);
                                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                    params.setMargins(450, 40, 20, 40);
                                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                                    textView.setLayoutParams(params);



                                    String m2 = dataSnapshot.child(d).getValue().toString();
                                    textView.setPadding(30, 30, 30, 30);
                                    textView.setGravity(10);

                                    textView.setTextColor(Color.WHITE);
                                    textView.setVisibility(View.VISIBLE);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                                        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    }

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        textView.setBackground(getResources().getDrawable(R.drawable.message2));


                                    } else {
                                        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.message2));
                                    }


                                    textView.setText(m2);
                                    ll.addView(textView);


                                    // setContentView(ll);
                                    //t2.setText(m2);
                                }
                                else if(i==18)
                                {
                                    TextView textView = new TextView(MainMessage.this);
                                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    textView.setLayoutParams(params);
                                    params.setMargins(340, 40, 300, 40);

                                    textView.setPadding(30, 30, 30, 30);
                                    textView.setGravity(10);

                                    textView.setTextColor(Color.WHITE);
                                    textView.setVisibility(View.VISIBLE);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                                        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    }

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        textView.setBackground(getResources().getDrawable(R.drawable.message3));


                                    } else {
                                        textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.message3));
                                    }


                                    textView.setText("2 Hours Later");
                                    ll.addView(textView);
                                }
                            } else {
                                if(i==52) {
                                    ImageView imageView = new ImageView(MainMessage.this);
                                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    imageView.setLayoutParams(params);
                                    params.setMargins(20, 40, 450, 40);
                                    imageView.setImageResource(R.drawable.hearts);
                                    ll.addView(imageView);
                                }


                                Toast.makeText(MainMessage.this, "Story Ends", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    i++;
                }
            }
        });

    }
    private  boolean haveNetwork()
    {
        boolean have_WIFI=false;
        boolean have_MobileData=false;

        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
        for (NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI=true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if(info.isConnected())
                    have_MobileData=true;
        }
        return have_MobileData||have_WIFI;
    }
    public void onSaveInstanceState(Bundle bundle)
    {

        super.onSaveInstanceState(bundle);
        bundle.putInt("k1",i);
    }
}
