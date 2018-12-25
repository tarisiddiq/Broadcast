package ayit5902.gmail.com.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver batteryinfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            //mengkoneksikan kelas java dengan activity progressbar2
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
            progressBar.setProgress(level);
            TextView textView = (TextView) findViewById(R.id.textstatus);
            //mengubah progress bar ditampilkan di textview
            textView.setText("Level Baterry :"+Integer.toString(level) +"%");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //daftarkan/register receiver dengan membuat intent dan mengambil Action_battery-changed
        registerReceiver(batteryinfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
