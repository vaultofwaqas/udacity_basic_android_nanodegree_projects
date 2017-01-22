package com.waqkz.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Waqas on 8/24/2016.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> book) {
        super(context, 0, book);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_textview);
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_textview);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textview);

        Book currentBook = getItem(position);

        titleTextView.setText(currentBook.getTitle());
        authorTextView.setText(currentBook.getAuthor());
        dateTextView.setText(currentBook.getDate());

        return listItemView;
    }
}
