package hantaro.com.contactform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    TextView mTvBirthDate;
    int mMonth = 1;
    int mDay = 1;
    int mYear = 1970;

    EditText mName;
    EditText mEmail;
    EditText mPhoneNumber;
    EditText mContactDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvBirthDate = findViewById(R.id.birthDateText);
        ImageView imageView = findViewById(R.id.birthDate);

        mName = findViewById(R.id.et_name);
        mEmail = findViewById(R.id.et_email);
        mContactDescription = findViewById(R.id.et_description);
        mPhoneNumber = findViewById(R.id.et_phone_number);

        if(getIntent().hasExtra(DetailContact.NAME_KEY)){
            Bundle bundle = getIntent().getExtras();
            mEmail.setText(bundle.getString(DetailContact.EMAIL_KEY));
            mName.setText(bundle.getString(DetailContact.NAME_KEY));
            mPhoneNumber.setText(bundle.getString(DetailContact.PHONE_KEY));
            mContactDescription.setText(bundle.getString(DetailContact.DESCRIPTION_KEY));
            String birthDate =  bundle.getString(DetailContact.BIRTHDATE_KEY);
            mTvBirthDate.setText(birthDate);
            String [] birthDateArray = birthDate.split("/");
            mMonth = Integer.parseInt(birthDateArray[0]);
            mDay   = Integer.parseInt(birthDateArray[1]);
            mYear = Integer.parseInt(birthDateArray[2]);
        }




    imageView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mTvBirthDate.setText(formatDateText(month, dayOfMonth, year));
                mMonth = month;
                mYear = year;
                mDay = dayOfMonth;
            }
        },mYear,mMonth,mDay);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        }
    });

        Button button = findViewById(R.id.bt_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewAcitivity();
            }
        });
    }

    public void startNewAcitivity(){
        Intent intent = new Intent(MainActivity.this, DetailContact.class);
        intent.putExtra(DetailContact.NAME_KEY, mName.getText().toString());
        intent.putExtra(DetailContact.EMAIL_KEY, mEmail.getText().toString());
        intent.putExtra(DetailContact.BIRTHDATE_KEY, mTvBirthDate.getText().toString());
        intent.putExtra(DetailContact.DESCRIPTION_KEY, mContactDescription.getText().toString());
        intent.putExtra(DetailContact.PHONE_KEY, mPhoneNumber.getText().toString());
        startActivity(intent);
        finish();
    }

    public String formatDateText(int month, int day, int year){
        return month + "/" + day + "/" + year;
    }


}
