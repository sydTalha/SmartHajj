package app.simulator.com.smarthajj;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText visaNo;
    private EditText groupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visaNo=findViewById(R.id.edtVisaNo);
        groupID=findViewById(R.id.edtGroupID);
    }


    public void btnSubmitClicked(View view) {

        String visa=visaNo.getText().toString();
        String group=groupID.getText().toString();
        String macAddress=getDeviceMACAddress();
        //send to web API
        Toast.makeText(MainActivity.this, getDeviceMACAddress()+"", Toast.LENGTH_LONG).show();
    }

    private String getDeviceMACAddress(){
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        String address = info.getMacAddress();
        return address;
    }
}
