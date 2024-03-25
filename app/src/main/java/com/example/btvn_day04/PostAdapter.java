package com.example.btvn_day04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {
    private ArrayList<Post> mListPost;

    public PostAdapter(ArrayList<Post> listPost) {
        this.mListPost = listPost;
    }

    @Override
    public int getCount() {
        return mListPost.size();
    }

    @Override
    public Object getItem(int position) {
        return mListPost.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        }else {
            view = convertView;
        }
        Post post = (Post) getItem(position);
        ImageView imgAvatar = view.findViewById(R.id.avt);
        ImageView imgPicture = view.findViewById(R.id.picture);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvDay = view.findViewById(R.id.day);
        TextView tvCaption = view.findViewById(R.id.caption);
        TextView tvNumReact = view.findViewById(R.id.num_react);
        TextView tvNumCmt = view.findViewById(R.id.num_cmt);
        TextView tvNumShare = view.findViewById(R.id.num_share);

        tvName.setText(post.getName());
        tvDay.setText(post.getDay());
        tvCaption.setText(post.getCaption());
        tvNumReact.setText(String.valueOf(post.getNumReact()));
        tvNumCmt.setText(String.valueOf(post.getNumCmt()));
        tvNumShare.setText(String.valueOf(post.getNumShare()));
        Glide.with(parent.getContext()).load(post.getAvatar()).into(imgAvatar);
        Glide.with(parent.getContext()).load(post.getPicture()).into(imgPicture);
        return view;
    }
}