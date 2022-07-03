package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Post> get_posts(int user_id, List<Integer> postIds) {
        List<Post> posts = repository.selectPostsFromPostList(postIds);

        for (Post post : posts) {
            boolean isFollowed = repository.isUserFollowed(user_id, post.getUser_id());
            boolean isLiked = repository.isPostLiked(user_id, post.getId());
            post.setLiked(isLiked);
            post.setFollowed(isFollowed);
        }
        return posts;
    }

    public List<Post> mix_by_owners(List<Post> posts) {
        List<Post> result = new ArrayList<>();
        List<List<Post>> arr = new ArrayList<>();

        int prevKey = Integer.MAX_VALUE;
        List<Post> prevList = null;
        for (Post post : posts) {
            if (prevKey == post.getUser_id()) {
                prevList.add(post);
            } else {
                List<Post> list = new ArrayList<>();
                list.add(post);
                arr.add(list);
                prevList = list;
            }
            prevKey = post.getUser_id();
        }

        int turn = 0;
        for (int i = 0; i < posts.size(); i++) {
            List<Post> list = arr.get(turn);

            if (!list.isEmpty()) {
                result.add(list.get(0));
                list.remove(0);
            }
            turn++;

            if (turn == arr.size())
                turn = 0;
        }

        return result;
    }

    public void callFirst() {
        User user1 = new User(
                "u1.username",
                "u1@gmail.com",
                "u1",
                "u1 picture",
                "u1 bio",
                LocalDate.of(1996, 4, 5));

        User user2 = new User(
                "u2.username",
                "u2@gmail.com",
                "u2",
                "u2 picture",
                "u2 bio",
                LocalDate.of(1995, 5, 15));

        User user3 = new User(
                "u3.username",
                "u3@gmail.com",
                "u3",
                "u3 picture",
                "u3 bio",
                LocalDate.of(1994, 6, 25));

        List<Integer> posts = new ArrayList<>();
        posts.add(2);
        posts.add(4);
        get_posts(2 , posts);
    }

    public void callSecond() {

        Post p1 = new Post();
        Post p2 = new Post();
        Post p3 = new Post();
        Post p4 = new Post();
        Post p5 = new Post();
        Post p6 = new Post();

        p1.setUser_id(2);
        p1.setId(1);

        p2.setUser_id(2);
        p2.setId(2);

        p3.setUser_id(2);
        p1.setId(3);

        p4.setUser_id(3);
        p1.setId(5);

        p5.setUser_id(3);
        p1.setId(7);

        p6.setUser_id(4);
        p1.setId(4);

        List<Post> posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
        posts.add(p5);
        posts.add(p6);

        mix_by_owners(posts);
    }

}
