package com.sahilasopa.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sahilasopa.chat.Models.User;
import com.sahilasopa.chat.databinding.ActivityProfileBinding;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    FirebaseDatabase database; // Firebase Database
    FirebaseAuth auth; // Auth
    Intent login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        login = new Intent(this, LoginActivity.class);
        if ((auth.getCurrentUser() == null)) {
            startActivity(login);
            finish();
        } // If User is logged in switch to home page
        database.getReference("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                    assert user != null;
                    if (auth.getCurrentUser().getUid().equals(user.getId())) {
                        binding.username.setText(user.getUsername());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Pass
            }
        });
        binding.update.setOnClickListener(view -> {
            if (binding.username.getText().toString().isEmpty()) {
                binding.username.setError("This Field Is Required");
                binding.username.requestFocus();
                return;
            }
            Map<String, Object> name = new HashMap<>();
            name.put("username", binding.username.getText().toString());
            database.getReference("Users").child(auth.getCurrentUser().getUid()).updateChildren(name);
            Toast.makeText(this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.profile);
        item.setTitle("Home");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            // Todo create settings page
            Toast.makeText(getApplicationContext(), "Setting TODO", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.logout) {
            auth.signOut();
            startActivity(login);
            finish();
        } else if (item.getItemId() == R.id.profile) {
            Intent home = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(home);
        }
        return super.onOptionsItemSelected(item);
    }

}