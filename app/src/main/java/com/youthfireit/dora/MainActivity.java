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
import com.youthfireit.dora.fragments.CategoryWiseProductsFragment;
import com.youthfireit.dora.fragments.HomeFragment;
import com.youthfireit.dora.fragments.MessageFragment;
import com.youthfireit.dora.fragments.ProductDetailsFragment;

import java.util.ArrayDeque;
import java.util.Deque;


public class MainActivity extends AppCompatActivity
        implements HomeFragment.homeFragmentClickListener,
                           ProductDetailsFragment.productDetailsClickListener,
                           CategoryWiseProductsFragment.CategoryWiseProductsFragmentClickListener
{


    private ActivityMainBinding binding;
    private Fragment current, previous;

    private HomeFragment homeFragment = new HomeFragment(this);
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

        setSupportActionBar(binding.homeToolbar);
        binding.homeToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        current = homeFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).commit();
        getSupportFragmentManager().beginTransaction().show(current).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, cartFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, messageFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, accountFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();



        binding.bottomNav.getOrCreateBadge(R.id.bottom_nav_message).setNumber(5);
        binding.bottomNav.setOnNavigationItemSelectedListener(item -> {


            switch (item.getItemId()) {
                case NAV_HOME:

                    if (!current.equals(homeFragment)) {
                        getSupportFragmentManager().beginTransaction().hide(current).commit();
                        current = homeFragment;
                        getSupportFragmentManager().beginTransaction().show(current).commit();

                        //getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                        //getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                    }
                    break;
                case NAV_CART:
                    if (!current.equals(cartFragment)) {

                        getSupportFragmentManager().beginTransaction().hide(current).commit();
                        current = cartFragment;
                        getSupportFragmentManager().beginTransaction().show(current).commit();

                        /*getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                        getSupportFragmentManager().beginTransaction().show(cartFragment).commit();*/
                    }
                    break;
                case NAV_MESSAGE:
                    if (!current.equals(messageFragment)) {
                        getSupportFragmentManager().beginTransaction().hide(current).commit();
                        current = messageFragment;
                        getSupportFragmentManager().beginTransaction().show(current).commit();

                        /*getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                        getSupportFragmentManager().beginTransaction().show(messageFragment).commit();*/
                    }
                    break;
                case NAV_ACCOUNT:
                    if (!current.equals(accountFragment)) {
                        getSupportFragmentManager().beginTransaction().hide(current).commit();
                        current = accountFragment;
                        getSupportFragmentManager().beginTransaction().show(current).commit();

                        /*getSupportFragmentManager().beginTransaction().show(accountFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();*/
                    }
                    break;

            }
            return true;
        });

    }







    @Override
    public void productClickListener(String id) {

        binding.bottomNav.setVisibility(View.GONE);
        binding.toolbarLayout.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().hide(current).commit();
        current = new ProductDetailsFragment(id, this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, current)
                .commit();
    }



    @Override
    public void categoriesClickListener(String id) {
        binding.bottomNav.setVisibility(View.VISIBLE);
        binding.toolbarLayout.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().hide(current).commit();
        current = new CategoryWiseProductsFragment(id,this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, current)
                .commit();
    }



    @Override
    public void onBackButtonClickListener() {

        binding.bottomNav.setVisibility(View.VISIBLE);
        binding.toolbarLayout.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().remove(current).commit();
        current = homeFragment;
        getSupportFragmentManager().beginTransaction()
                .show(current)
                .commit();
    }



    @Override
    public void categoryWiseProductClickListener(String id) {
        productClickListener(id);
    }




}