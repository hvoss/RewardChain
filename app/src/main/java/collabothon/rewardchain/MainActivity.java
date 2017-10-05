package collabothon.rewardchain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        CreateOfferFragment.OnFragmentInteractionListener,
        AvailableOffersFragment.OnFragmentInteractionListener,
        StatisticsFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener {

    public static final String IN_NAME = "name";
    public static final String IN_PASSWORD = "password";
    private BigInteger balance;

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    if (scanResult != null) {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        View view = fab.getRootView();
        Snackbar.make(view, "Replace with your own action  " + scanResult.toString() , Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ändern des Titels der Activity
        setTitle("Home");


        //Web3j web3 = Web3jFactory.build(new HttpService("http://52.166.117.131:8545"));
        Web3j web3 = Web3jFactory.build(new HttpService("http://13.95.159.138:8545"));

        String name = getIntent().getStringExtra(IN_NAME);
        String password = getIntent().getStringExtra(IN_PASSWORD);

        String adress = "0x0085A7f13B649D9f89eB63f6f819ac0EF562c88D";

        name = "rewardchaindbadmin";
        password = "rewarddb123!";

        try {
            EthAccounts accounts = web3.ethAccounts().sendAsync().get();
            for (String acc : accounts.getAccounts()) {
                Log.v("RewardChain", acc);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            EthGetBalance ethGetBalance = web3.ethGetBalance(adress, DefaultBlockParameterName.LATEST).sendAsync().get();
            balance = ethGetBalance.getBalance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.v("RewardChain", "coins: " + balance);

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




        Fragment fragment = MainFragment.newInstance("sdf", "df");
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
        } else if (id == R.id.nav_statistic) {
            fragment = StatisticsFragment.newInstance("sdsd", "sdfsdf");
        } else if (id == R.id.nav_start) {
            fragment = MainFragment.newInstance("sdsd", "sdfsdf");
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

    }
}
