package colinbits.io.playground;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WordView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_view);
        TextView wordDisplay = (TextView) findViewById(R.id.phraseDisplay);
        Intent intent = getIntent();
        String phrase = intent.getStringExtra("stringPhrase");
        wordDisplay.setText(phrase);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }



}
