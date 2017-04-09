package arduino.crane;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class OpeningScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void start(View v) {
        View checkBoxView = View.inflate(this, R.layout.dont_ask_me_again, null);
        final CheckBox checkBox = (CheckBox) checkBoxView.findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("checked", checkBox.isChecked());
                editor.commit();
            }
        });
        checkBox.setText("Don't ask me again");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("First Time User?");
        builder.setMessage("you should reed the manual first")
                .setView(checkBoxView)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(OpeningScreen.this, Manual.class));
                    }
                })
                .setNegativeButton("I used the app before", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(OpeningScreen.this, Devices.class));
                    }
                });
        if (!sharedPreferences.getBoolean("checked", false))
            builder.create().show();
        else
            startActivity(new Intent(OpeningScreen.this, Devices.class));
    }

    public void about(View v) {
        startActivity(new Intent(OpeningScreen.this, About.class));
    }

    public void manual(View v) {
        startActivity(new Intent(OpeningScreen.this, Manual.class));
    }

    public void exit(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}
