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

public class FamilyActivity extends AppCompatActivity {
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
        final ArrayList<Word> words=new ArrayList<Word>();

        words.add(new Word("Boy (लड़का)","नौनु (Naunu)",R.drawable.family_younger_brother,R.raw.naunu));
        words.add(new Word("Girl (लड़की)","नौनी (Nauni)",R.drawable.family_younger_brother,R.raw.nauni));
        words.add(new Word("Daughter (बेटी)","ब्येटी (Beti)",R.drawable.family_daughter,R.raw.beti));
        words.add(new Word("Son (बेटा)","ब्येटा (Beta)",R.drawable.family_son,R.raw.beta));
        words.add(new Word("Father (पापा)","बाबा (Baba)",R.drawable.family_father,R.raw.baba));
        words.add(new Word("Mother (माँ)","ब्वे (bai)",R.drawable.family_mother,R.raw.bae));
        words.add(new Word("Younger Sister (छोटी बहिन)","भुल्ली (Bhuli)",R.drawable.family_younger_brother,R.raw.buli));
        words.add(new Word("Younger Brother (छोटा भाई)","भुल्ला (Bhula)",R.drawable.family_younger_sister,R.raw.bula));
        words.add(new Word("Older Brother (बड़ा भाई)","भैजी (Beji)",R.drawable.family_older_brother,R.raw.beji));
        words.add(new Word("Older Sister (बड़ी बहिन)","दीदी (Didi)",R.drawable.family_older_sister,R.raw.didi));
        words.add(new Word("Uncle (ताऊ)","बोड़ा (Bauda)",R.drawable.family_grandfather,R.raw.bada));
        words.add(new Word("Aunt (ताई)","बोडि (Baudi)",R.drawable.family_grandmother,R.raw.badi));
        words.add(new Word("Husband (पति)","जवें (Jawai)",R.drawable.family_father,R.raw.jawai));
        words.add(new Word("Wife (पत्नी)","ब्वारि (bawari)",R.drawable.family_mother,R.raw.bawri));


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



                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
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