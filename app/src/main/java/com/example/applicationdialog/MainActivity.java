package com.example.applicationdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button dialegButton;
    private Button advancedDialegButton;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);

        dialegButton = (Button) findViewById(R.id.dialeg);
        dialegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basicDialog();
            }
        });

        advancedDialegButton = (Button) findViewById(R.id.dialeg2);
        advancedDialegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advancedDialog();
            }
        });

    }
    private void basicDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hello");
        builder.setMessage("Missatge alerta");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text.setText("Has pitjat OK");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text.setText("Has pitjat Cancel");
            }
        });
        builder.show();
    }
    private void advancedDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.advanced_button_layout,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        EditText editText = (EditText) view.findViewById(R.id.entryText);

        Button cancel = (Button) view.findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("No text entered");
                dialog.dismiss();
            }
        });
        Button ok = (Button) view.findViewById(R.id.okButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(editText.getText().toString());
                dialog.dismiss();
            }
        });

    }
}