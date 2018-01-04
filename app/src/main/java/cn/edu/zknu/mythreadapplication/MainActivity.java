package cn.edu.zknu.mythreadapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvShowMsg;
    private Button btnHandler;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShowMsg=(TextView)findViewById(R.id.tv_showMsg);
        btnHandler=(Button)findViewById(R.id.btn_handler);
        handler=new Handler(){
            int i=3;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tvShowMsg.setText(String.valueOf(i--));
                if(i==0){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);

                }
            }
        };
        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            handler.sendEmptyMessage(1);
                            SystemClock.sleep(1000);
                        }
                    }
                }).start();
            }
        });

    }
}
