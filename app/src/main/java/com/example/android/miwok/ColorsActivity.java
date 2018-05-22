
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

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
        words.add(new Word("Black","Kaala",R.drawable.color_black,R.raw.song));
        words.add(new Word("Brown","Bhoora",R.drawable.color_brown,R.raw.song));
        words.add(new Word("Dusty Yellow","Halka Peela",R.drawable.color_dusty_yellow,R.raw.song));
        words.add(new Word("Gray","Pata Nahi",R.drawable.color_gray,R.raw.song));
        words.add(new Word("Green","Hara",R.drawable.color_green,R.raw.song));
        words.add(new Word("Mustard Yellow","Peela",R.drawable.color_mustard_yellow,R.raw.song));
        words.add(new Word("Red","Laal",R.drawable.color_red,R.raw.song));
        words.add(new Word("White","Safed",R.drawable.color_white,R.raw.song));


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

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
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
