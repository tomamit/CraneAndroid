package arduino.crane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Control extends AppCompatActivity {
    public ImageView down;
    public ImageView left;
    public ImageView right;
    public Button scan;
    public ImageView up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MessageReciver messageReciver = new MessageReciver('|', MainActivity.btSocket,new MessageReciver.MessageListener(){

            @Override
            public void onMessegerecived(String message) {
                Toast.makeText(Control.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        setContentView(R.layout.activity_controll);
        this.scan = ((Button) findViewById(R.id.scan));
        this.left = ((ImageView) findViewById(R.id.left));
        this.right = ((ImageView) findViewById(R.id.right));
        this.up = ((ImageView) findViewById(R.id.up));
        this.down = ((ImageView) findViewById(R.id.down));
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sendMassegeOverBluetooth("scan");
            }
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MainActivity.sendMassegeOverBluetooth("lg");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        MainActivity.sendMassegeOverBluetooth("s");
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MainActivity.sendMassegeOverBluetooth("rg");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        MainActivity.sendMassegeOverBluetooth("s");
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MainActivity.sendMassegeOverBluetooth("ug");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        MainActivity.sendMassegeOverBluetooth("s");
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        MainActivity.sendMassegeOverBluetooth("dg");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        MainActivity.sendMassegeOverBluetooth("s");
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });
    }
}
