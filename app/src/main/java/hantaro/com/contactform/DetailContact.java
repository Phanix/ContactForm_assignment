package hantaro.com.contactform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailContact extends AppCompatActivity {
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String BIRTHDATE_KEY = "birthdate";
    public static final String PHONE_KEY = "phone";
    public static final String DESCRIPTION_KEY = "description";
    String name;
    String email;
    String birthDate;
    String description;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        Bundle bundle = getIntent().getExtras();
         name = bundle.getString(NAME_KEY);
         email = bundle.getString(EMAIL_KEY);
         birthDate = bundle.getString(BIRTHDATE_KEY);
         description = bundle.getString(DESCRIPTION_KEY);
         phone = bundle.getString(PHONE_KEY);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvBirthDate = findViewById(R.id.tv_birth_date);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvPhone = findViewById(R.id.tv_phone_number);
        tvPhone.append(phone);
        tvDescription.append(description);
        tvBirthDate.append(birthDate);
        tvEmail.append(email);
        tvName.append(name);

        Button editButton = findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewAcitivity();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetailContact.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(DetailContact.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void startNewAcitivity(){
        Intent intent = new Intent(DetailContact.this, MainActivity.class);
        intent.putExtra(NAME_KEY, name);
        intent.putExtra(EMAIL_KEY, email);
        intent.putExtra(BIRTHDATE_KEY, birthDate);
        intent.putExtra(DESCRIPTION_KEY, description);
        intent.putExtra(PHONE_KEY, phone);
        startActivity(intent);
        finish();
    }
}
