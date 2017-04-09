package arduino.crane;


import android.bluetooth.BluetoothSocket;

import java.io.BufferedInputStream;
import java.io.IOException;

public class MessageReciver implements Runnable {
    public static abstract class MessageListener {
        public abstract void onMessegerecived(String message);
    }

    private boolean isListening = true;
    private char limit;
    private boolean isReciving = false;
    private MessageListener messageListener;
    private String message;
    private BufferedInputStream bufferedInputStream;

    @Override
    public void run() {
        try {
            while (isListening) {

                while (bufferedInputStream.available() > 0) {
                    char b = (char) bufferedInputStream.read();
                    if (b == limit) {
                        if (isReciving) {
                            messageListener.onMessegerecived(message);
                            message = "";
                            isReciving = false;
                        } else {
                            isReciving = true;
                        }
                    } else if (isReciving) {
                        message += b;
                    }
                }
                Thread.sleep(100);


            }
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public MessageReciver(char limit, BluetoothSocket btSocket, MessageListener messageListener) {
        this.limit = limit;
        this.messageListener = messageListener;
        try {
            bufferedInputStream = new BufferedInputStream(btSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    public void shutDown() {
        isListening = false;
    }
}
