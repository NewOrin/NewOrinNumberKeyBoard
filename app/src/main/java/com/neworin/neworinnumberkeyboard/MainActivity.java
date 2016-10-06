package com.neworin.neworinnumberkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NumberKeyBoardView.ITextClickListener {

    private NumberKeyBoardView mNumberKeyBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberKeyBoardView = (NumberKeyBoardView) findViewById(R.id.numberkeyboardview);
        mNumberKeyBoardView.setiTextClickListener(this);
    }

    @Override
    public void onTextClick(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
