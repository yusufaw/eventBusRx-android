package apps.crevion.com.eventbusrx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import apps.crevion.com.eventbusrx.event.RxBus;
import apps.crevion.com.eventbusrx.event.TextInputAddedEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAction = (Button) findViewById(R.id.action_btn);
        TextView textResult = (TextView) findViewById(R.id.result_txt);

        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InputActivity.class));
            }
        });

        RxBus.getInstance().register(TextInputAddedEvent.class, event->{
            textResult.setText(event.message);
        });
    }
}
