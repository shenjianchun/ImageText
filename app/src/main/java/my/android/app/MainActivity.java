package my.android.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import my.android.lib.ImageTextLinearLayout;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    ImageTextLinearLayout mNoticeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoticeLayout = (ImageTextLinearLayout) findViewById(R.id.ll_information_notice);
        mNoticeLayout.setOnClickListener(this);
        mNoticeLayout.showBadgeView("2");

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


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_information_notice:
                mNoticeLayout.dismissBadgeView();
                break;

            default:
                break;
        }

    }

}
