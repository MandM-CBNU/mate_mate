package com.example.meetandmeet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.meetandmeet.databinding.ActivityLoginBinding;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (oAuthToken != null) {
                    // TBD
                }
                if (throwable != null) {
                    // TBD
                    Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
                }

                LoginActivity.this.updateKakaoLoginUi();
                return null;
            }
        };

        binding.login.setOnClickListener(view -> {
            if (LoginClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                LoginClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
            } else {
                LoginClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
            }
        });

        binding.logout.setOnClickListener(view -> UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
            @Override
            public Unit invoke(Throwable throwable) {
                updateKakaoLoginUi();
                return null;
            }
        }));
        updateKakaoLoginUi();
    }

    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                if (user != null) {
                    Log.i(TAG, "invoke: id=" + user.getId());
                    Log.i(TAG, "invoke: email=" + user.getKakaoAccount().getEmail());
                    Log.i(TAG, "invoke: nickname=" + user.getKakaoAccount().getProfile().getNickname());
                    Log.i(TAG, "invoke: gender=" + user.getKakaoAccount().getGender());
                    Log.i(TAG, "invoke: age=" + user.getKakaoAccount().getAgeRange());
                    binding.nickname.setText(user.getKakaoAccount().getProfile().getNickname());
                    Glide.with(binding.profile).load(user.getKakaoAccount().getProfile().getThumbnailImageUrl()).circleCrop().into(binding.profile);
                    binding.login.setVisibility(View.GONE);
                    binding.logout.setVisibility(View.VISIBLE);
                } else {
                    binding.nickname.setText(null);
                    binding.profile.setImageBitmap(null);
                    binding.login.setVisibility(View.VISIBLE);
                    binding.logout.setVisibility(View.GONE);
                }
                if (throwable != null) {
                    Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
                }
                return null;
            }
        });
    }
}
