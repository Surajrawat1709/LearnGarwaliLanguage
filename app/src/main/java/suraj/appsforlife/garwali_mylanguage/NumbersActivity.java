package suraj.appsforlife.garwali_mylanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
MediaPlayer mMediaPlayer;
   private AudioManager mAudioManager;

   AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=
           new AudioManager.OnAudioFocusChangeListener() {
               @Override
               public void onAudioFocusChange(int focusChange) {
                   if (focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                           || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                       mMediaPlayer.pause();
                       mMediaPlayer.seekTo(0);
                   }
                   else if (focusChange==AudioManager.AUDIOFOCUS_GAIN){
                       mMediaPlayer.start();
                   }else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                     releaseMediaPlayer();
                   }
               }
           };




 private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);

       final ArrayList<Word>  words=new ArrayList<Word>();

        words.add(new Word("One","hjgjh",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two","hjgjh",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Three","hjgjh",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Four","hjgjh",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Five","hjgjh",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Six","hjgjh",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Seven","hjgjh",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Eight","hjgjh",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Nine","hjgjh",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Ten","hjgjh",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter=new WordAdapter(this,words);

        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();


                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {



                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}