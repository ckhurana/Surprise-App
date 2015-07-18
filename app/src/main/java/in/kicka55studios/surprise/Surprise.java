package in.kicka55studios.surprise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Surprise extends AppCompatActivity {

    TextView wishing;
    ImageView bdayImage;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise);

        wishing = (TextView) findViewById(R.id.wishing);
        bdayImage = (ImageView) findViewById(R.id.bdayImage);

        name = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

        if (name.equals("alpha")) {
            bdayImage.setImageResource(R.drawable.alpha);
            wishing.setText("Happy Birthday " + name + "!!!\nHave A Long and Awesome Life.");
        }

        if (name.equals("beta")) {
            bdayImage.setImageResource(R.drawable.beta);
            wishing.setText("Happy Birthday " + name + "!!!\nYou are already awesome. What more could I wish you.\n I love you.");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_surprise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
