package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.API.ApiClient;
import com.example.assignment.API.ApiInterface;
import com.example.assignment.Model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

        EditText etusername, etpassword;
        Button btnsignin;
        private List<Contact> contactList;
        private ApiInterface apiInterface;
        Call<List<Contact>> call;
        private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnsignin = findViewById(R.id.button);

        if (sharedPreferenceConfig.ReadLoginStatus()){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        call = apiInterface.getContacts();
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.clone().enqueue(new Callback<List<Contact>>() {
                    @Override
                    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                        contactList = response.body();
                        for (Contact c:contactList){
                            if (c.getUsername().equals(etusername.getText().toString()) && c.getPassword().equals(etpassword.getText().toString())){
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                sharedPreferenceConfig.WriteLoginStatus(true);
                                finish();
                                return;
                            }
                        }
                        Toast.makeText(LoginActivity.this,"Invalid User info",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<Contact>> call, Throwable t) {

                    }
                });
            }
        });

    }
}
