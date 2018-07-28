//package UniGrades.Services.impl;
//
//import UniGrades.DAO.TwitterDAO;
//import UniGrades.Services.TwitterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;
//
//
//@Service
//public class TwitterServiceImpl implements TwitterService {
//
//    private TwitterDAO twitterDAO;
//    private int bgnI=1;
//    private int midI=1;
//    private int endI=1;
//    private String consumerKey = "YNLM7as0WQRNWHWZv2si77brY";
//    private String consumerSecret = "YASpxAMnNvgBmdUwu1sh3jr2T2yLgl8YAoRwGUP7g4CQGZtXSO";
//    private String accessToken = "1021015731729829889-rLzBXBuGUVJd98RMsIVDMCX9R6Di2f";
//    private String accessSecret = "pbXFHy0iWdg7magldsE9spuxknGZA9h252u6cTPmbntam";
//
//    @Autowired
//    public TwitterServiceImpl(TwitterDAO twitterDAO) {
//        this.twitterDAO= twitterDAO;
//    }
//
//    @Override
//    public String getTweet() {
//        String tweet="";
//
//        tweet = ""+twitterDAO.getTweetBgn(bgnI)+""+twitterDAO.getTweetMid(midI)+""+twitterDAO.getTweetEnd(endI)+" "+getBitLy();
//
//        if (endI >= 5){
//            endI = 1;
//            if (midI >= 7){
//                midI = 1;
//                if (bgnI>=12){
//                    bgnI = 1;
//                }
//                else {
//                    bgnI++;
//                }
//            }
//            else{
//                midI++;
//            }
//        }
//        else{
//            endI++;
//        }
//        System.out.println(tweet);
//        return tweet;
//    }
//
//    @Override
//    public void performTweet(String tweet) {
//
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true)
//                .setOAuthConsumerKey(consumerKey)
//                .setOAuthConsumerSecret(consumerSecret)
//                .setOAuthAccessToken(accessToken)
//                .setOAuthAccessTokenSecret(accessSecret);
//        try
//        {
//            TwitterFactory factory = new TwitterFactory(cb.build());
//            Twitter twitter = factory.getInstance();
//            twitter.updateStatus(tweet);
//        }catch (TwitterException te) {
//            te.printStackTrace();
//            System.exit(-1);
//        }
//    }
//
//    private String getBitLy(){
//
//        BitlyClient client = new BitlyClient("... the access token ...")
//        ShortenResponse respShort = client.shorten() //
//                .setLongUrl("https://github.com/stackmagic/bitly-api-client") //
//                .call();
//
//        return uri;
//    }
//
//
//}
