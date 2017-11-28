package com.magicsu.android.photogallery.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magicsu.android.photogallery.FlickrFetchr;
import com.magicsu.android.photogallery.R;

import java.io.IOException;

/**
 * Created by admin on 2017/11/28.
 */

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView mPhotoRecyclerView;

    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }

    /**
     * override methods
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        new FetchItemsTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        mPhotoRecyclerView = view.findViewById(R.id.fragment_photo_gallery_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        return view;
    }

    /**
     * custom class
     */
    private class FetchItemsTask extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "PhotoGalleryFragment";

        @Override
        protected Void doInBackground(Void... voids) {
            new FlickrFetchr().fetchItems();
            return null;
        }
    }
}
