package com.example.administrator.mdmd.Acitvity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mdmd.Animation.AnimationButton;
import com.example.administrator.mdmd.Model.News;
import com.example.administrator.mdmd.R;

import org.litepal.crud.DataSupport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/24.
 */

public class TextInputLayoutActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    private AnimationButton animationButton;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_ac_coordinator);

        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final EditText editText1 = (EditText) findViewById(R.id.edit_text_email);
        final EditText editText2 = (EditText) findViewById(R.id.edit_text_password);
//        Button btn = (Button) findViewById(R.id.btn);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.CoordinatorLayout);
        animationButton = (AnimationButton) findViewById(R.id.animation_btn);
        animationButton.setAnimationButtonListener(new AnimationButton.AnimationButtonListener() {
            @Override
            public void onClickListener() {
                hideKeyboard();

                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();
                News news = DataSupport.find(News.class, 11);
                Log.e("NEWS",news.toString());

                if (!validateEmail(username)) {
                    usernameWrapper.setError("输入正确邮箱地址!");
                } else if (!validatePassword(password)) {
                    passwordWrapper.setError("输入正确密码!");
                } else {
                    usernameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                    animationButton.start();
                }
            }

            @Override
            public void animationFinish() {
                Toast.makeText(TextInputLayoutActivity.this, "over", Toast.LENGTH_LONG).show();
            }
        });

        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }

    private class MyUndoListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // Code to undo the user's last action
            Toast.makeText(getApplicationContext(), "OK! LoginSuccess", Toast.LENGTH_SHORT).show();
        }
    }

    public void doLogin() {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.CoordinatorLayout), "OK! LoginSuccess", Snackbar.LENGTH_LONG);
        mySnackbar.setAction("ok", new MyUndoListener());
        mySnackbar.show();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
