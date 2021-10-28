 package suraj.appsforlife.garwali_mylanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.widget.ImageView;


public class SplashScreen extends AppCompatActivity {
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        image=findViewById(R.id.image);


        Thread thread =new Thread(){

            public void run(){
                try {
                sleep(3000);
                }
                catch(Exception e){
                   e.printStackTrace();
                }finally {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
                }
            }
        };thread.start();
    }
}

/*
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/sign"
        android:text="Register Here"
        android:textColor="@color/white"
        android:textSize="35dp"
        android:textStyle="bold"
        android:layout_margin="50dp"
        android:gravity="center"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/edittext1"
        android:layout_below="@id/sign"
        android:background="#30ffffff"
        android:hint="Email"
        android:textColorHint="@color/white"
        android:textColor="@color/white"
        android:layout_margin="10dp"
        android:padding="20dp"
        android:drawableLeft="@drawable/ic_baseline_person_outline_24"
        android:drawablePadding="20dp"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/edittext2"
        android:layout_below="@id/edittext1"
        android:background="#30ffffff"
        android:hint="Password"
        android:textColorHint="@color/white"
        android:textColor="@color/white"
        android:layout_margin="10dp"
        android:padding="20dp"
        android:drawableLeft="@drawable/ic_baseline_info_24"
        android:drawablePadding="20dp"
        android:inputType="textPassword"/>

    <com.google.android.material.button.MaterialButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/button"
        android:layout_below="@id/edittext2"
        android:text="REGISTER"
        android:backgroundTint="@color/design_default_color_secondary"
        android:layout_centerHorizontal="true"
        android:layout_margin="20dp" />


</RelativeLayout>
 */