package com.youthfireit.dora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.youthfireit.dora.databinding.ActivityMainBinding;
import com.youthfireit.dora.fragments.AccountFragment;
import com.youthfireit.dora.fragments.CartFragment;
import com.youthfireit.dora.fragments.HomeFragment;
import com.youthfireit.dora.fragments.MessageFragment;

import java.util.ArrayDeque;
import java.util.Deque;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private Fragment current, previous;

    private HomeFragment homeFragment = new HomeFragment();
    private CartFragment cartFragment = new CartFragment();
    private MessageFragment messageFragment = new MessageFragment();
    private AccountFragment accountFragment = new AccountFragment();

    private final int NAV_HOME = R.id.bottom_nav_home;
    private final int NAV_CART = R.id.bottom_nav_cart;
    private final int NAV_MESSAGE = R.id.bottom_nav_message;
    private final int NAV_ACCOUNT = R.id.bottom_nav_account;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);


        current = homeFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).commit();
        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, cartFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, messageFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, accountFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case NAV_HOME:

                        if (!current.equals(homeFragment)) {
                            current = homeFragment;
                            getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                        }
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case NAV_CART:
                        if (!current.equals(cartFragment)) {
                            current = cartFragment;
                            getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                            getSupportFragmentManager().beginTransaction().show(cartFragment).commit();
                        }
                        Toast.makeText(MainActivity.this, "cart", Toast.LENGTH_SHORT).show();
                        break;
                    case NAV_MESSAGE:
                        if (!current.equals(messageFragment)) {
                            current = messageFragment;
                            getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                            getSupportFragmentManager().beginTransaction().show(messageFragment).commit();
                        }
                        Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();
                        break;
                    case NAV_ACCOUNT:
                        if (!current.equals(accountFragment)) {
                            current = accountFragment;
                            getSupportFragmentManager().beginTransaction().show(accountFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                            getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                        }
                        Toast.makeText(MainActivity.this, "account", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
        
    }



    private boolean loadFragment() {

        if (current != null) {


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, current)
                    .commit();
        } else {
            current = new HomeFragment();
            loadFragment();
        }
        return true;
    }




}