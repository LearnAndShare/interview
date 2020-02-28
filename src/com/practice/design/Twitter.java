package com.practice.design;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class Twitter {
    class Tweet{

        int tweetId;
        int ts;
        public Tweet(int ts,int tweetId){
            this.tweetId = tweetId;
            this.ts = ts;
        }
    }
    Map<Integer, List<Tweet>> usersTweetList = null;
    Map<Integer, Set<Integer>> usersFollowersList = null;
    int feedMaxNum = 10;
    static int ts = 0;
//    Map<Integer,List>
    /** Initialize your data structure here. */
    public Twitter() {
        usersTweetList =new HashMap<>();
        usersFollowersList = new HashMap<>();
        feedMaxNum = 10;
        ts = 0;
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
        tweetList.add(new Tweet(ts++,tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet o1, Tweet o2) {
                        return o1.ts - o2.ts;
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
                        if (foTweet.ts >pq.peek().ts) {

                            pq.add(foTweet);
                            pq.poll();
                        }

                    }
                }
            }
        }
        List<Integer> myFeed = new LinkedList<>();
        while(!pq.isEmpty()){
            myFeed.add(0, pq.poll().tweetId);
        }
        return myFeed;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> list = null;
        if(usersFollowersList.containsKey(followerId)){
            list = usersFollowersList.get(followerId);
        } else {
            list = new HashSet<>();
            usersFollowersList.put(followerId,list);

        }
        list.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if(followerId != followeeId && usersFollowersList.containsKey(followerId)){
            Set<Integer> set = usersFollowersList.get(followerId);
            set.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.testCase1();

    }

    public void testCase1(){
        Twitter twitter = new Twitter();


        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        System.out.println("====================================");
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println("====================================");
        System.out.println(twitter.getNewsFeed(1));


    }

}