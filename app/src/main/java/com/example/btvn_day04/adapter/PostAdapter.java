package com.example.btvn_day04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btvn_day04.R;
import com.example.btvn_day04.models.Post;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ArrayList<Post> mListPost;
    private IPostItemClickListener callback;
    private Context mContext;
    public PostAdapter(ArrayList<Post> listPost) {
        //this.callback = callback;
        this.mListPost = listPost;
    }

    public void setCallback(IPostItemClickListener callback) {
        this.callback = callback;
    }
    public void editPost(int position, String newCaption) {
        Post post = mListPost.get(position);
        post.setCaption(newCaption);
        mListPost.set(position, post);
        notifyItemChanged(position);
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = mListPost.get(position);
        if (mContext != null) {
            Glide.with(mContext).load(post.getAvatar()).into(holder.shapeableImageView);
            Glide.with(mContext).load(post.getPicture()).into(holder.picture);
        }
        holder.tvName.setText(post.getName());
        holder.tvDay.setText(post.getDay());
        holder.tvCaption.setText(post.getCaption());
        holder.tvNumReact.setText(String.valueOf(post.getNumReact()));
        holder.tvNumCmt.setText(String.valueOf(post.getNumCmt()));
        holder.tvNumShare.setText(String.valueOf(post.getNumShare()));
    }

    @Override
    public int getItemCount() {
        return mListPost != null ? mListPost.size():0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ShapeableImageView shapeableImageView;
        TextView tvName, tvDay, tvCaption, tvNumReact, tvNumCmt, tvNumShare;
        ImageButton xButton, settingButton;
        ImageView picture;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.avt);
            picture = itemView.findViewById(R.id.picture);
            tvName = itemView.findViewById(R.id.name);
            tvDay = itemView.findViewById(R.id.day);
            tvCaption = itemView.findViewById(R.id.caption);
            tvNumReact = itemView.findViewById(R.id.num_react);
            tvNumCmt = itemView.findViewById(R.id.num_cmt);
            tvNumShare = itemView.findViewById(R.id.num_share);
            xButton = itemView.findViewById(R.id.x_button);
            settingButton = itemView.findViewById(R.id.three_dots);
            xButton.setOnClickListener(this);
            settingButton.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.x_button){
                if(callback != null){
                    callback.onDeletePost(getAdapterPosition());
                }
            }
            if(v.getId() == R.id.three_dots){
                if(callback != null){
                    callback.onEditPost(getAdapterPosition(), mListPost.get(getAdapterPosition()).getCaption());
                }
            }
        }
    }
    public interface IPostItemClickListener{
        void onDeletePost(int pos);
        void onEditPost(int pos, String caption);
    }
//    private ArrayList<Post> mListPost;
//    private IOnclick callback;
//    public PostAdapter(ArrayList<Post> listPost, IOnclick callback) {
//        this.callback = callback;
//        this.mListPost = listPost;
//    }
//
//    @Override
//    public int getCount() {
//        return mListPost.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mListPost.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view;
//        if(convertView == null){
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
//        }else {
//            view = convertView;
//        }
//        Post post = (Post) getItem(position);
//        ImageView imgAvatar = view.findViewById(R.id.avt);
//        ImageView imgPicture = view.findViewById(R.id.picture);
//        TextView tvName = view.findViewById(R.id.name);
//        TextView tvDay = view.findViewById(R.id.day);
//        TextView tvCaption = view.findViewById(R.id.caption);
//        TextView tvNumReact = view.findViewById(R.id.num_react);
//        TextView tvNumCmt = view.findViewById(R.id.num_cmt);
//        TextView tvNumShare = view.findViewById(R.id.num_share);
//
//        tvName.setText(post.getName());
//        tvDay.setText(post.getDay());
//        tvCaption.setText(post.getCaption());
//        tvNumReact.setText(String.valueOf(post.getNumReact()));
//        tvNumCmt.setText(String.valueOf(post.getNumCmt()));
//        tvNumShare.setText(String.valueOf(post.getNumShare()));
//        Glide.with(parent.getContext()).load(post.getAvatar()).into(imgAvatar);
//        Glide.with(parent.getContext()).load(post.getPicture()).into(imgPicture);
//        imgAvatar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (callback != null) {
//                    callback.onAvtClick(position);
//                }
//            }
//        });
//        tvName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (callback != null) {
//                    callback.onTvNameClick(position);
//                }
//            }
//        });
//        ImageButton xButton = view.findViewById(R.id.x_button);
//        xButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (callback != null) {
//                    callback.onXButtonClick(position);
//                }
//            }
//        });
//        return view;
//    }


}