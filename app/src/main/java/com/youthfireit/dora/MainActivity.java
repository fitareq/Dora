package com.youthfireit.dora;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.youthfireit.dora.databinding.ActivityMainBinding;
import com.youthfireit.dora.fragments.AccountFragment;
import com.youthfireit.dora.fragments.CartFragment;
import com.youthfireit.dora.fragments.CategoryWiseProductsFragment;
import com.youthfireit.dora.fragments.HomeFragment;
import com.youthfireit.dora.fragments.LoginFragment;
import com.youthfireit.dora.fragments.MessageFragment;
import com.youthfireit.dora.fragments.ProductDetailsFragment;
import com.youthfireit.dora.fragments.RegistrationFragment;

import java.util.ArrayDeque;
import java.util.Deque;


public class MainActivity extends AppCompatActivity
        implements HomeFragment.homeFragmentClickListener,
        ProductDetailsFragment.productDetailsClickListener,
        CategoryWiseProductsFragment.CategoryWiseProductsFragmentClickListener,
        RegistrationFragment.registrationEventListener,
        AccountFragment.accountEventListener {


    private ActivityMainBinding binding;
    private Deque<Fragment> deque = new ArrayDeque<>();
    private Fragment current, previous;

    private HomeFragment homeFragment = new HomeFragment(this);
    private CartFragment cartFragment = new CartFragment();
    private MessageFragment messageFragment = new MessageFragment();
    private AccountFragment accountFragment = new AccountFragment(this);
    private LoginFragment loginFragment = new LoginFragment();
    private RegistrationFragment registrationFragment = new RegistrationFragment(this);

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
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //setSupportActionBar(binding.homeToolbar);
        binding.homeToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        current = homeFragment;
        deque.add(current);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // getSupportFragmentManager().beginTransaction().show(current).commit();
        /*getSupportFragmentManager().beginTransaction().add(R.id.main_container, cartFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, messageFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, accountFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(accountFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,loginFragment);
        getSupportFragmentManager().beginTransaction().hide(loginFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,registrationFragment);
        getSupportFragmentManager().beginTransaction().hide(registrationFragment).commit();*/
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, homeFragment).addToBackStack(null).commit();


        binding.bottomNav.getOrCreateBadge(R.id.bottom_nav_message).setNumber(5);
        binding.bottomNav.setOnNavigationItemSelectedListener(item -> {


            switch (item.getItemId()) {
                case NAV_HOME:

                    if (!deque.contains(homeFragment)) {
                        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).addToBackStack(null).commit();
                        deque.push(homeFragment);
                    }

                    if (!current.equals(homeFragment)) {
                        getSupportFragmentManager().beginTransaction().hide(current).commit();
                        current = homeFragment;
                        getSupportFragmentManager().beginTransaction().show(current).commit();

                        //getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                        //getSupportFragmentManager().beginTransaction().hide(cartFragment).commit();
                    }
                    break;
                case NAV_CART:

                    if (!deque.contains(cartFragment)) {
                        getSupportFragmentManager().beginTransaction().add(R.id.main_container, cartFragment).addToBackStack(null).commit();
                        deque.push(cartFragment);
                    }
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
                    if (!deque.contains(messageFragment)) {
                        getSupportFragmentManager().beginTransaction().add(R.id.main_container, messageFragment).addToBackStack(null).commit();
                        deque.push(messageFragment);
                    }
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
                    if (!deque.contains(accountFragment)) {
                        getSupportFragmentManager().beginTransaction().add(R.id.main_container, accountFragment).addToBackStack(null).commit();
                        deque.push(accountFragment);
                    }
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
    public void categoriesClickListener(String id, String title) {

        binding.bottomNav.setVisibility(View.VISIBLE);
        binding.toolbarLayout.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().hide(current).commit();
        current = new CategoryWiseProductsFragment(id, title, this);
        deque.push(current);
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
    public void onRelatedProductClickListener(String id) {

        getSupportFragmentManager().beginTransaction().remove(current).commit();
        current = new ProductDetailsFragment(id, this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, current)
                .commit();
    }


    @Override
    public void categoryWiseProductClickListener(String id) {

        productClickListener(id);
    }


    @Override
    public void onCWBackBtnClick() {
        getSupportFragmentManager().beginTransaction().remove(current).commit();
        current = homeFragment;
        getSupportFragmentManager().beginTransaction().show(current).commit();
    }


    @Override
    public void onRegistrationSuccess() {
        getSupportFragmentManager().beginTransaction().hide(current).commit();
        current = loginFragment;
        getSupportFragmentManager().beginTransaction().show(current);

    }


    @Override
    public void onUserNotLoggedInListener() {
        onRegistrationSuccess();
    }


    @Override
    public void onBackPressed() {

        current = deque.peek();
        if (current == homeFragment)
            finish();
        else {
            getSupportFragmentManager().beginTransaction().hide(current).commit();
            getSupportFragmentManager().beginTransaction().remove(current).commit();
            deque.pop();
            current = deque.peek();
            getSupportFragmentManager().beginTransaction().show(current).commit();
            if (current==homeFragment)
                binding.bottomNav.setSelectedItemId(NAV_HOME);
            else if (current==cartFragment)
                binding.bottomNav.setSelectedItemId(NAV_CART);
            else if (current==messageFragment)
                binding.bottomNav.setSelectedItemId(NAV_MESSAGE);
            else if (current==accountFragment)
                binding.bottomNav.setSelectedItemId(NAV_ACCOUNT);
        }


        //super.onBackPressed();
    }
}