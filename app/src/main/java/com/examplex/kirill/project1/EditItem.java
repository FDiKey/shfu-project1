package com.examplex.kirill.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditItem extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView tv;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item_layout);
        tv = (TextView) findViewById(R.id.edit_v);
        editText= (EditText) findViewById(R.id.edit_name);
        btn= (Button) findViewById(R.id.edit_btn);
        btn.setOnClickListener(this);





    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("res_name", editText.getText().toString() + "");
        setResult(RESULT_OK,intent);
        tv.setText(editText.getText().toString());
        finish();
    }
}
