package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Waqas on 7/30/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mMiwokColorResourceID;

    public WordAdapter(Context context,  ArrayList<Word> words, int miwokColorResourceID) {
        super(context, 0, words);

        mMiwokColorResourceID = miwokColorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_numbers);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_numbers);
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.image);
        LinearLayout miwokLinearLayoutColor = (LinearLayout) listItemView.findViewById(R.id.linearLayoutColor);

        Word currentWords = getItem(position);

        int color = ContextCompat.getColor(getContext(), mMiwokColorResourceID);

        miwokLinearLayoutColor.setBackgroundColor(color);

        miwokTextView.setText(currentWords.getMiwokTranslation());
        defaultTextView.setText(currentWords.getDefaultTranslation());

        if (currentWords.hasImage() != -1) {
            miwokImageView.setImageResource(currentWords.getMiwokImageResourceID());

        } else {

            miwokImageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
