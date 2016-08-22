package apps.crevion.com.eventbusrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import apps.crevion.com.eventbusrx.event.RxBus;
import apps.crevion.com.eventbusrx.event.TextInputAddedEvent;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText inputText = (EditText) findViewById(R.id.input_txt);
        Button inputButton = (Button) findViewById(R.id.input_btn);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputText.getText().toString().isEmpty()){
                    RxBus.getInstance().post(new TextInputAddedEvent(inputText.getText().toString()));
                    finish();
                }
            }
        });
    }
}
