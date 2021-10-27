package suraj.appsforlife.garwali_mylanguage;

public class Word {
    private String mDefaultTranslation;
    private String mGarhwaliTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String garhwaliTranslation, int imageResourceId, int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mGarhwaliTranslation = garhwaliTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId=audioResourceId;

    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getGarwaliTranslation() {

        return mGarhwaliTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }

}
