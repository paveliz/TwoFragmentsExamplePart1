/*
 * Author: Pablo Angel Veliz
 *
 * http://about.me/paveliz
 *
 * https://ar.linkedin.com/in/pabloveliz
 *
 * *****************************************************************
 *
 * The main objective of these example is:
 *
 * - Show how two fragments interaction.
 * - Show how to manipulate the "landscape" layout change.
 *
 * I'm not separating the fragments in the portrait version, this is
 * something that I'm going to show in some other example. But, I'm
 * distributing the fragments in portrait or landscape so both
 * can be well shown.
 *
 * You wil find two "activity_main" layouts, one in the default
 * folder called "layout" and a second one with the same name in the
 * "layout-land" folder.
 *
 * I also added the:
 *                  android:configChanges="orientation"
 *
 * In the AndroidManifest.xml so the app can detect the orientation
 * change.
 *
 */

package paveliz.com.twofragmentsexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    MainFragmentDetail fragmentDetail;
    MainFragmentList fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupFragments();
    }

    private void setupFragments() {
        fragmentDetail = new MainFragmentDetail();
        fragmentList = new MainFragmentList();

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_detail, fragmentDetail, "frag_detail");
        transaction.add(R.id.fragment_list, fragmentList, "frag_list");

        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * In case you want to "detect" the landscape change
     * you can use the "onConfigurationChanged" event and
     * Override it to use the "wide_layout".
     *
     * The "wide_layout" it's exactly the same layout on the
     * layout-land folder.
     *
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == 2)
            setContentView(R.layout.wide_layout);
        else
            setContentView(R.layout.activity_main);

        setupFragments();

    }
     */
}
