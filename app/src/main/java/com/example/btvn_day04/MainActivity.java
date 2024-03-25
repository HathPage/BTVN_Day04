package com.example.btvn_day04;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://w.forfun.com/fetch/62/624e27fde335d49e2dd3c6b75c6027a3.jpeg";
    private static final String URL2 ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDkfP2FemkWOqisNf945D5FLjFKcqbwBOfOQ&usqp=CAU";
    private ListView lvPost;
    private ArrayList<Post> mPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPost = findViewById(R.id.lv_all);
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
        PostAdapter postAdapter = new PostAdapter(mPost);
        lvPost.setAdapter(postAdapter);
    }
}