package suraj.appsforlife.garwali_mylanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText edittext1,edittext2;
    Button button;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);
        edittext1=findViewById(R.id.edit1);
        edittext2=findViewById(R.id.edit2);
        button=findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();

        button.setOnClickListener(v -> {
            String txtEmail= edittext1.getText().toString();
            String txtPass=edittext2.getText().toString();

            if (TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPass)){
                Toast.makeText(RegisterActivity.this, "Please fill the details", Toast.LENGTH_SHORT).show();
            }else if(txtPass.length()<6)
            {
                Toast.makeText(RegisterActivity.this, "Password length should be atleast 6", Toast.LENGTH_SHORT).show();
            }
            else{
                registerUser(txtEmail,txtPass);
            }
        });

    }

    private void registerUser(String txtEmail, String txtPass) {

        auth.createUserWithEmailAndPassword(txtEmail,txtPass).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            else{
                Toast.makeText(RegisterActivity.this, "Register Again or already Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }

}