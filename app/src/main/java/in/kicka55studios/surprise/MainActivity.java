package in.kicka55studios.surprise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText passInput;
    private Toolbar toolbar;
    public final static String EXTRA_MESSAGE = "in.kicka55studios.surprise.MESSAGE";
    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        passInput = (EditText) findViewById(R.id.passInput);
    }

    public void launchSurprise(View view) {
        String pass = passInput.getText().toString().toLowerCase().trim();
        passInput.setText("");
        Intent i = new Intent(this, Surprise.class);
        if (pass.equals("alpha") || pass.equals("beta")) {
            i.putExtra(EXTRA_MESSAGE, pass);
            Toast.makeText(this, "Surprise!!!", Toast.LENGTH_SHORT).show();
            startActivity(i);
        } else {
            Toast.makeText(this, "OOPS!!! Wrong Passcode. Try Again.", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.about) {
            startActivity(new Intent(this, About.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
