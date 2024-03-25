package com.example.btvn_day04;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn_day04.adapter.PostAdapter;
import com.example.btvn_day04.models.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private static final String URL = "https://w.forfun.com/fetch/62/624e27fde335d49e2dd3c6b75c6027a3.jpeg";
    private static final String URL2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDkfP2FemkWOqisNf945D5FLjFKcqbwBOfOQ&usqp=CAU";
    private ListView lvPost;
    private ArrayList<Post> mPost;
    private RecyclerView rvPost;
    private PostAdapter mPostAdapter;

    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initData();
        initView();

    }

    private void initData() {
        mPost = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            Post post = new Post();
            post.setAvatar(MainActivity.URL2);
            post.setName("Tên người dùng " +i);
            post.setDay(i + " thg 3");
            post.setCaption("Nội dung bài viết " + i);
            post.setPicture(MainActivity.URL);
            post.setNumReact(i);
            post.setNumCmt(i);
            post.setNumShare(i);
            mPost.add(post);
        }
    }

    private void initView() {
        rvPost = findViewById(R.id.rvPost);
        mPostAdapter = new PostAdapter(mPost);
        rvPost.setAdapter(mPostAdapter);

        mPostAdapter.setCallback(new PostAdapter.IPostItemClickListener() {
            @Override
            public void onDeletePost(int pos) {
                mPost.remove(pos);
                mPostAdapter.notifyItemRemoved(pos);
            }

            @Override
            public void onEditPost(int pos, String caption) {
                showEditDialog(pos, caption);
            }
        });

    }
    private void showEditDialog(final int pos, String caption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chỉnh sửa bài viết");
        EditText input = new EditText(this);
        input.setText(caption);
        builder.setView(input);

        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newCaption = input.getText().toString();
                mPostAdapter.editPost(pos, newCaption);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}



//        lvPost = findViewById(R.id.lv_all);
//        mPost = new ArrayList<>();
//        for (int i = 1; i <= 10; i++){
//            Post post = new Post();
//            post.setAvatar(MainActivity.URL2);
//            post.setName("Tên người dùng " +i);
//            post.setDay(i + " thg 3");
//            post.setCaption("Nội dung bài viết " + i);
//            post.setPicture(MainActivity.URL);
//            post.setNumReact(i);
//            post.setNumCmt(i);
//            post.setNumShare(i);
//            mPost.add(post);
//        }
//        PostAdapter postAdapter = new PostAdapter(mPost, this);
//        lvPost.setAdapter(postAdapter);
//    }
//
//    @Override
//    public void onAvtClick(int position) {
//        Toast.makeText(this, "Click on avt "+mPost.get(position).getName(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onTvNameClick(int position) {
//        Toast.makeText(this, "Click on name "+mPost.get(position).getName(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onXButtonClick(int position) {
//        Toast.makeText(this, "Click on X "+mPost.get(position).getName(), Toast.LENGTH_SHORT).show();
//    }