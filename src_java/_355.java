import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nekocode on 16/7/19.
 */
public class _355 {
    private static class User {
        ArrayList<User> following = new ArrayList<>();
        ArrayList<Tweet> myTweets = new ArrayList<>();
    }

    private static class Tweet {
        public static int COUNTER = 0;
        int id;
        int counter;

        public Tweet(int id) {
            this.id = id;
            this.counter = COUNTER++;
        }
    }

    private HashMap<Integer, User> database = new HashMap<>();

    /** Initialize your data structure here. */
    public _355() {

    }

    private User getOrCreateUser(int userId) {
        User user = database.get(userId);
        if (user == null) {
            user = new User();
            database.put(userId, user);
        }
        return  user;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        Tweet tweet = new Tweet(tweetId);
        user.myTweets.add(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user
     * followed or by the user herself. Tweets must be ordered from
     * most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Tweet> feeds = new ArrayList<>();

        User user = getOrCreateUser(userId);
        feeds.addAll(user.myTweets);
        for (User followee : user.following) {
            feeds.addAll(followee.myTweets);
        }

        feeds.sort(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.counter - o1.counter;
            }
        });

        ArrayList<Integer> rlt = new ArrayList<>();

        for (Tweet tweet : feeds) {
            rlt.add(tweet.id);
        }

        if (rlt.size() > 10)
            return rlt.subList(0, 10);

        return rlt;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User follower = getOrCreateUser(followerId);
        User followee = getOrCreateUser(followeeId);

        if (!follower.following.contains(followee))
            follower.following.add(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User follower = database.get(followerId);
        if (follower == null) return;

        User followee = database.get(followeeId);
        if (followee == null) return;

        follower.following.remove(followee);
    }

    public static void main(String[] args) {
        _355 obj = new _355();
        obj.postTweet(1, 5);
        List<Integer> feeds = obj.getNewsFeed(1);
        for (int feed : feeds) {
            System.out.print(feed + ", ");
        }
        System.out.print("\n");

        obj.follow(1, 2);
        obj.postTweet(2, 6);
        feeds = obj.getNewsFeed(1);
        for (int feed : feeds) {
            System.out.print(feed + ", ");
        }
        System.out.print("\n");

        obj.unfollow(1, 2);
        feeds = obj.getNewsFeed(1);
        for (int feed : feeds) {
            System.out.print(feed + ", ");
        }
        System.out.print("\n");
    }
}
