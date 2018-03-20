package fr.wcs.flappycrash;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boutonValidation = findViewById(R.id.button_validation);

        boutonValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nbSeconds = findViewById(R.id.editText_nombre);
                String stringSeconds = nbSeconds.getText().toString();
                final int seconds = Integer.parseInt(stringSeconds);
                final TextView message = findViewById(R.id.textView_final);


                if (stringSeconds.equals("")){
                    Toast.makeText(MainActivity.this, "Hey cousin, t'as rien mis !", Toast.LENGTH_SHORT).show();
                }

                else {
                    final TextView timer = findViewById(R.id.textView_timer);


                    Thread myThread = new Thread(){
                        @Override
                        public void run() {
                            try {
                                sleep(1000*seconds);


                                message.setText("Ok, je vais planter dans " + seconds + "sec... A plus");



                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    myThread.start();
                    message.setVisibility(View.VISIBLE);
                    message.setText("Ok, je vais planter dans " + seconds + "sec... A plus");

                }



            }
        });






    }
}
