package android.sampleproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.info){
            // go to info page
            NavHostFragment nav = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
            assert nav != null;
            NavController controller = nav.getNavController();
            controller.navigate(R.id.action_global_infoFragment);
        } else if (id == R.id.uninstall) {
            // uninstall
            Intent delete = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + getPackageName()));
            startActivity(delete);
        }
        return super.onOptionsItemSelected(item);
    }
}