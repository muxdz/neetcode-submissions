class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, List<Integer>> tweetMap;
    HashMap<Integer, Integer> postedMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        postedMap = new HashMap<>();

        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;

        List<Integer> list = tweetMap.getOrDefault(userId, new ArrayList<>());
        list.add(tweetId);
        tweetMap.put(userId, list);

        postedMap.put(tweetId, time);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(postedMap.get(a), postedMap.get(b)));
        HashSet<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        List<Integer> ownTweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        
        for (int id: ownTweets) {
            maxHeap.add(id);
            if (maxHeap.size() > 10) {
                maxHeap.poll();
            }
        }

        for (Integer followee: followees) {
            List<Integer> tweets = tweetMap.getOrDefault(followee, new ArrayList<>());
            for (int id: tweets) {
                maxHeap.add(id);
                if (maxHeap.size() > 10) {
                    maxHeap.poll();
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            feed.add(maxHeap.poll());
        }

        Collections.reverse(feed);

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followMap.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = followMap.get(followerId);
        if (set != null) {
            set.remove(followeeId);
            followMap.put(followerId, set);
        }
    }
}
