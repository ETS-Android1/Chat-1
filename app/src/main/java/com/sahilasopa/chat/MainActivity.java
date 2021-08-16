package com.sahilasopa.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.sahilasopa.chat.Adapters.VpAdapter;
import com.sahilasopa.chat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseDatabase database; // Firebase Database
    FirebaseAuth auth;
    Intent login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        login = new Intent(this, LoginActivity.class);
        if ((auth.getCurrentUser() == null)) {
            startActivity(login);
            finish();
        } // If User is Not logged in switch to login page
        ViewPager viewPager = binding.viewPager;
        TabLayout tabLayout = binding.tabLayout;
        tabLayout.setupWithViewPager(viewPager);
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new ChatsFragment(), "CHATS");
        vpAdapter.addFragment(new UsersFragment(), "USERS");
        viewPager.setAdapter(vpAdapter);
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            // Todo create settings/profile page
            Toast.makeText(getApplicationContext(), "Setting TODO", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.logout) {
            auth.signOut();
            startActivity(login);
            finish();
        } else if (item.getItemId() == R.id.profile) {
            Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profile);
        }
        return super.onOptionsItemSelected(item);
    }
}