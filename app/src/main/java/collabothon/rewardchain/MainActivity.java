package collabothon.rewardchain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        CreateOfferFragment.OnFragmentInteractionListener,
        AvailableOffersFragment.OnFragmentInteractionListener,
        StatisticsFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener,
        AcceptOffer.OnFragmentInteractionListener,
        OfferAccepted.OnFragmentInteractionListener
{

    public static final String IN_NAME = "name";
    public static final String IN_PASSWORD = "password";
    private BigInteger balance;

    private String username;

    private String password;

    private LinearLayout linearLayout;


    private TextView headerCoins;
    private TextView headerName;


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        final IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            final View view = fab.getRootView();


            new Handler().post(new Runnable() {
                public void run() {
                    Fragment fragment = AcceptOffer.newInstance(scanResult.getContents());

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                }
            });
        }
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ändern des Titels der Activity
        setTitle("Home");

        username = getIntent().getStringExtra(IN_NAME);
        password = getIntent().getStringExtra(IN_PASSWORD);

        String c = ChainDAO.retrieveBalance();


        try {
            ChainDAO.setName("", username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.v("Rechain", ChainDAO.retrieveBalance() +" TQs");

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.initiateScan();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        headerCoins = (TextView) navigationView.getHeaderView(0).findViewById(R.id.headerCoins);


        headerName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.headerName);
        if (headerName != null) {
            headerName.setText(username);
        }

        headerCoins.setText(ChainDAO.retrieveBalance() + " TQs");

        Fragment fragment = MainFragment.newInstance(username, c);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_create_offer) {
            fragment = CreateOfferFragment.newInstance("sdsd", "sdfsdf");
        } else if (id == R.id.nav_available_offers) {
            fragment = AvailableOffersFragment.newInstance("sdsd", "sdfsdf");
            //  } else if (id == R.id.nav_statistic) {
            //       fragment = StatisticsFragment.newInstance("sdsd", "sdfsdf");
        } else if (id == R.id.nav_start) {
            String coins = ChainDAO.retrieveBalance().toString();
            fragment = MainFragment.newInstance(username, coins);
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Fragment fragment;
        if (uri.compareTo(Uri.parse("http://offerSelected")) == 0) {
            fragment = AcceptOffer.newInstance("ssadf");
        } else {
            fragment = OfferAccepted.newInstance("", "");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

    }
}
