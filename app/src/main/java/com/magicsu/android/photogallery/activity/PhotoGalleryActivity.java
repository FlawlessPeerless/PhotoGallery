package com.magicsu.android.photogallery.activity;

import android.support.v4.app.Fragment;

import com.magicsu.android.photogallery.fragment.PhotoGalleryFragment;

/**
 * Created by admin on 2017/11/28.
 */

public class PhotoGalleryActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return PhotoGalleryFragment.newInstance();
    }
}
