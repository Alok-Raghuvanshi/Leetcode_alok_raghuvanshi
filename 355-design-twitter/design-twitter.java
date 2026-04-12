class Twitter {
HashMap<Integer,List<Integer>>ff=new HashMap<>();
HashMap<Integer,List<timer>>tweets=new HashMap<>();
int time=0;
    public Twitter() {
        
    }
    class timer
    {
        int id;
        int time;
        timer(int id,int time)
        {
            this.id=id;
            this.time=time;
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new timer(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
       PriorityQueue<timer> pq = new PriorityQueue<>((a,b)->b.time-a.time);
       if(tweets.containsKey(userId)){
       for(timer t:tweets.get(userId))
       pq.add(t);}
     
         if(ff.containsKey(userId)) {
    for(int id : ff.get(userId)) {
        if(tweets.containsKey(id)) {
            for(timer t : tweets.get(id)) {
                pq.add(t);
            }
        }
    }
}
       List<Integer>tw=new ArrayList<>();int count=0;
       while(pq.size()!=0&&count<10)
       {
            tw.add(pq.poll().id);
            count++;
       }
       return tw;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
      ff.putIfAbsent(followerId, new ArrayList<>());

if(!ff.get(followerId).contains(followeeId)) {
    ff.get(followerId).add(followeeId);
}
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!ff.containsKey(followerId)) return;
        ff.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
