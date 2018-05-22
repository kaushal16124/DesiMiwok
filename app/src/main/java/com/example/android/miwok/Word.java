
package com.example.android.miwok;

/**
 * Created by LENOVO on 21-05-2018.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE;
    private int mAudioResourceId;

    private static final int NO_IMAGE = -1;



    public Word(String defaultTranslation, String miwokTranslation,int audioResourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=audioResourceId;
    }


    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId=audioResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }


    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }


//    public void setDefaultTranslation(String defaultTranslation)
//    {
//        mDefaultTranslation=defaultTranslation;
//    }
//
//
//    public void setMiwokTranslation(String miwokTranslation)
//    {
//        mDefaultTranslation=miwokTranslation;
//    }
}

