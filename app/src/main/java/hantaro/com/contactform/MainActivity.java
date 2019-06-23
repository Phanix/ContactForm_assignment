package hantaro.com.contactform;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTvBirthDate;
    int mMonth = 1;
    int mDay = 1;
    int mYear = 1970;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvBirthDate = findViewById(R.id.birthDateText);
        ImageView imageView = findViewById(R.id.birthDate);


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
    }


    public String formatDateText(int month, int day, int year){
        return month + "/" + day + "/" + year;
    }
}
