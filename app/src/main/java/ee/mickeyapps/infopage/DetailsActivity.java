package ee.mickeyapps.infopage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String extra = getIntent().getExtras().getString("KEY");
        TextView view = findViewById(R.id.details_text);
        view.setText(extra);

    }
}
