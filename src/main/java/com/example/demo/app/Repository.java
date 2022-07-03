package com.example.demo.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Post, Long> {

    @Query("Select p from Post p where p.id in (:posts)")
    List<Post> selectPostsFromPostList(List<Integer> posts);

    @Query("select count(f)>0 from Follow f where f.follower_id =?1 and f.following_id = ?2")
    boolean isUserFollowed(int followerId, int followingId);

    @Query("select count(l)>0 from Like l where l.user_id =?1 and l.post_id = ?2")
    boolean isPostLiked(int user_id, long post_id);
}
