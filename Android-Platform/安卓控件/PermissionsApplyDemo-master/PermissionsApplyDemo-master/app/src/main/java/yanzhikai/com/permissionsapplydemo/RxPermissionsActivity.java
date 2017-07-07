package yanzhikai.com.permissionsapplydemo;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RxPermissionsActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_check, btn_getSingle, btn_getMulti, btn_getMultiEach;
    private TextView tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_permission);

        btn_check = (Button) findViewById(R.id.btn_check);
        btn_getSingle = (Button) findViewById(R.id.btn_getSingle);
        btn_getMulti = (Button) findViewById(R.id.btn_getMulti);
        btn_getMultiEach = (Button) findViewById(R.id.btn_getMultiEach);
        tv_log = (TextView) findViewById(R.id.tv_log);

        btn_check.setOnClickListener(this);
        btn_getSingle.setOnClickListener(this);
        btn_getMulti.setOnClickListener(this);
        btn_getMultiEach.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_check:
                String str = PermissionsLogUtils.checkPermissions(this,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                tv_log.setText(str);
                break;
            case R.id.btn_getSingle:
                break;
            case R.id.btn_getMulti:
                break;
            case R.id.btn_getMultiEach:
                break;
        }
    }


}
