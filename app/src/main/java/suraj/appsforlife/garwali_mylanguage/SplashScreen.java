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
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
                }
            }
        };thread.start();
    }
}