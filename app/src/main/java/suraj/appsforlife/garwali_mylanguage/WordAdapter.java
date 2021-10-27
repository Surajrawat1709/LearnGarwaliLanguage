package suraj.appsforlife.garwali_mylanguage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Activity context, ArrayList<Word> words) {

        super(context,0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        TextView garwaliTextView = (TextView) listItemView.findViewById(R.id.garwali_text);

        garwaliTextView.setText(currentWord.getGarwaliTranslation());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text);

        defaultTextView.setText(currentWord.getDefaultTranslation());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);

        if (currentWord.hasImage()) {

            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else{
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }

}
