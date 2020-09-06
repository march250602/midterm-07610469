package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clearButton =findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText timeText =findViewById(R.id.time);
                EditText disEditText = findViewById(R.id.distance);
                TextView t1=findViewById(R.id.ans);
                timeText.setText("");
                disEditText.setText("");
                t1.setText("");
            }
        });
        Button calButton=findViewById(R.id.calculate);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t1=findViewById(R.id.ans);
                EditText timeText =findViewById(R.id.time);
                String tmp=timeText.getText().toString();
                EditText disEditText = findViewById(R.id.distance);
                String tmp2=disEditText.getText().toString();
                if(tmp.length()<1||tmp2.length()<1){
                    Toast t= Toast.makeText(MainActivity.this, R.string.reqiure,Toast.LENGTH_LONG);
                    t.show();
                }else {
                    double distance = Double.parseDouble(tmp2);
                    double time = Double.parseDouble(tmp);
                    if(time==0){
                        Toast t= Toast.makeText(MainActivity.this, R.string.zero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else{
                        double a=distance/1000,b=time/3600;
                        double ans=a/b;
                        if(ans>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEEDCALCULATOR");
                            dialog.setPositiveButton("OK",null);
                            dialog.setMessage(R.string.over);
                            dialog.show();
                            String str = String.format(
                                    Locale.getDefault(), "%.2f", ans
                            );

                            t1.setText(str);
                        }
                        else{String str = String.format(
                                Locale.getDefault(), "%.2f", ans
                        );

                            t1.setText(str);}
                    }
                }
            }
        });


    }

}