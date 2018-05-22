
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        words.add(new Word("one","Ek",R.drawable.number_one,R.raw.song));
        words.add(new Word("two","Do",R.drawable.number_two,R.raw.song));
        words.add(new Word("three","Teen",R.drawable.number_three,R.raw.song));
        words.add(new Word("four","Chaar",R.drawable.number_four,R.raw.song));
        words.add(new Word("five","Paanch",R.drawable.number_five,R.raw.song));
        words.add(new Word("six","Chae",R.drawable.number_six,R.raw.song));
        words.add(new Word("seven","Saat",R.drawable.number_seven,R.raw.song));
        words.add(new Word("eight","Aath",R.drawable.number_eight,R.raw.song));
        words.add(new Word("nine","Nau",R.drawable.number_nine,R.raw.song));
        words.add(new Word("ten","Dus",R.drawable.number_ten,R.raw.song));

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

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);

        final ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();


                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
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
