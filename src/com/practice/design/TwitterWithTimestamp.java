package com.practice.design;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/design-twitter/
 */
public class TwitterWithTimestamp {
    class Tweet{
        int userId;
        int tweetId;
        Timestamp ts;
        public Tweet(int userId,int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
            ts = new Timestamp(System.currentTimeMillis());
        }
    }
    Map<Integer,List<Tweet>> usersTweetList = null;
    Map<Integer, Set<Integer>> usersFollowersList = null;
    int feedMaxNum = 10;
//    Map<Integer,List>
    /** Initialize your data structure here. */
    public TwitterWithTimestamp() {
        usersTweetList =new HashMap<>();
        usersFollowersList = new HashMap<>();
        feedMaxNum = 10;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweetList = null;
        follow(userId, userId);
        if(usersTweetList.containsKey(userId)){
            tweetList = usersTweetList.get(userId);
        } else {
            tweetList = new ArrayList<>();
            usersTweetList.put(userId,tweetList);
        }
        tweetList.add(new Tweet(userId,tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet o1, Tweet o2) {
                        return o1.ts.compareTo(o2.ts);
                    }
                }
        );
//        List userTweets = usersTweetList.get(userId).stream().map(e->e.tweetId).collect(Collectors.toList());

//        newsFeed.addAll(userTweets);
        Set<Integer> followers = usersFollowersList.get(userId);
        if(followers != null && followers.size() > 0) {
            for (Integer followerId : followers) {
                List<Tweet> foTweets = usersTweetList.get(followerId);
                if (foTweets == null || foTweets.size() == 0)
                    continue;
                for (Tweet foTweet : foTweets) {
                    if (pq.size() < feedMaxNum) {
                        pq.add(foTweet);
                    } else {
                        if (foTweet.ts.compareTo(pq.peek().ts) < 0) {
                            break;
                        } else {
                            pq.add(foTweet);
                            pq.poll();
                        }

                    }
                }
            }
        }

        return pq.stream().map(e->e.tweetId).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> list = null;
        if(usersFollowersList.containsKey(followeeId)){
            list = usersFollowersList.get(followeeId);
        } else {
            list = new HashSet<>();
            usersFollowersList.put(followeeId,list);
        }
        list.add(followerId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if(usersFollowersList.containsKey(followeeId)){
            Set<Integer> set = usersFollowersList.get(followeeId);
            set.remove(followerId);
        }
    }

    public static void main(String[] args) {
        TwitterWithTimestamp twitter = new TwitterWithTimestamp();
        // User 1 posts a new tweet (id = 5).
        //twitter.postTweet(1, 5);

        twitter.getNewsFeed(1).forEach(System.out::println);
        /*twitter.postTweet(1, 6);
        twitter.getNewsFeed(1).forEach(System.out::println);*/
        for(int i=0;i<12;i++){
            twitter.postTweet(1, i+1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        }

        for (Integer integer : twitter.getNewsFeed(1)) {
            System.out.println(integer);
        }

    }

}
