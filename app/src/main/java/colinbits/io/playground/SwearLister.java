package colinbits.io.playground;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SwearLister extends ListActivity {

    static final ArrayList<String> names = new ArrayList<String>(
            Arrays.asList("fuck", "shit", "bitch"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_words_list);

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, R.layout.user_item, names);
        setListAdapter(namesAdapter);

        CharSequence title = "Phrase Lister";
        this.setTitle(title);

        TextView addWord = (TextView) findViewById(R.id.addWord);
        addWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == KeyEvent.KEYCODE_ENTER) {
                    names.add(textView.getText().toString());
                    textView.clearAnimation();
                }

                return false;
            }
        });

    }

    // Clear all the words in the list
    public void clearWords(View view) {
        names.clear();
        ArrayAdapter adapter = (ArrayAdapter) getListView().getAdapter();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Cleared Words", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Object text = names.get(position);
        Intent wordViewIntent = new Intent(getApplicationContext(), WordView.class);
        wordViewIntent.putExtra("stringPhrase", (String) text);
        startActivity(wordViewIntent);
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

}
