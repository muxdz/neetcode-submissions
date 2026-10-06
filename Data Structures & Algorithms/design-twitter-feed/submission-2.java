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
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> Integer.compare(postedMap.get(b.id), postedMap.get(a.id)));
        List<Integer> result = new ArrayList<>();

        HashSet<Integer> relevantIds = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
        relevantIds.add(userId);

        for (int id: relevantIds) {
            List<Integer> tweets = tweetMap.getOrDefault(id, new ArrayList<>());

            if (!tweets.isEmpty()) {
                int index = tweets.size()-1;
                int tweetId = tweets.get(index);
                Tweet newTweet = new Tweet(tweetId, id, index, postedMap.get(tweetId));

                heap.add(newTweet);
            }
        }

        while (!heap.isEmpty() && result.size() < 10) {
            Tweet newest = heap.poll();
            result.add(newest.id);

            if (newest.index-1 >= 0) {
                List<Integer> tweets = tweetMap.get(newest.userId);
                int index = newest.index-1;
                int id = tweets.get(index);

                Tweet newTweet = new Tweet(id, newest.userId, index, postedMap.get(id));

                heap.add(newTweet); 
            }
        }

        return result;
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

    class Tweet {
        int id;
        int userId;
        int index;
        int time;

        public Tweet(int id, int userId, int index, int time) {
            this.id = id;
            this.userId = userId;
            this.index = index;
            this.time = time;
        }

    }
}
