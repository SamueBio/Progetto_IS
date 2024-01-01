package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.model.Review;
import java.util.ArrayList;


public class ReviewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Review> reviewList;

    public ReviewAdapter(Context context, ArrayList<Review> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    @Override
    public int getCount() {
        return reviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.recensione, parent, false);
        }

        Review review = reviewList.get(position);

        TextView nome = convertView.findViewById(R.id.nome);
        TextView recensione = convertView.findViewById(R.id.recensione);
        TextView data = convertView.findViewById(R.id.data);
        nome.setText(review.getUsername());
        recensione.setText(review.getReview());
        data.setText(""+review.getData().getDate()+"/"+review.getData().getMonth()+"/"+review.getData().getYear());

        ImageView star1 = convertView.findViewById(R.id.star1);
        ImageView star2 = convertView.findViewById(R.id.star2);
        ImageView star3 = convertView.findViewById(R.id.star3);
        ImageView star4 = convertView.findViewById(R.id.star4);
        ImageView star5 = convertView.findViewById(R.id.star5);

        if(review.getStars()==1){
            star1.setImageResource(R.drawable.star_si);
        }else if(review.getStars()==2){
            star1.setImageResource(R.drawable.star_si);
            star2.setImageResource(R.drawable.star_si);
        }
        else if(review.getStars()==3){
            star1.setImageResource(R.drawable.star_si);
            star2.setImageResource(R.drawable.star_si);
            star3.setImageResource(R.drawable.star_si);
        }
        else if(review.getStars()==4){
            star1.setImageResource(R.drawable.star_si);
            star2.setImageResource(R.drawable.star_si);
            star3.setImageResource(R.drawable.star_si);
            star4.setImageResource(R.drawable.star_si);
        }
        else if(review.getStars()==5){
            star1.setImageResource(R.drawable.star_si);
            star2.setImageResource(R.drawable.star_si);
            star3.setImageResource(R.drawable.star_si);
            star4.setImageResource(R.drawable.star_si);
            star5.setImageResource(R.drawable.star_si);
        }



        return convertView;
    }
}

