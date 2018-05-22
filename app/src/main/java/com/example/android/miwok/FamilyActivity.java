
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Daughter","Beti",R.drawable.family_daughter,R.raw.song));
        words.add(new Word("Father","Baap",R.drawable.family_father,R.raw.song));
        words.add(new Word("Grandfather","Dadaji",R.drawable.family_grandfather,R.raw.song));
        words.add(new Word("Grandmother","Dadiji",R.drawable.family_grandmother,R.raw.song));
        words.add(new Word("Mother","Bhagwan",R.drawable.family_mother,R.raw.song));
        words.add(new Word("Elder Brother","Dusht",R.drawable.family_older_brother,R.raw.song));
        words.add(new Word("Elder Sister","Chugalkhor",R.drawable.family_older_sister,R.raw.song));
        words.add(new Word("Younger Brother","Naukar",R.drawable.family_younger_brother,R.raw.song));
        words.add(new Word("Younger Sister","Naukrani",R.drawable.family_younger_sister,R.raw.song));
        words.add(new Word("Son","Beta",R.drawable.family_son,R.raw.song));


//        LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);
//
//        int index=0;
//        while(index<words.size()) {
//            TextView wordView=new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//            index++;
//
//        }
//

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null)
        {
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
}
