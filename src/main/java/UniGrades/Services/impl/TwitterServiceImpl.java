package UniGrades.Services.impl;

import UniGrades.DAO.TwitterDAO;
import UniGrades.Services.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitterServiceImpl implements TwitterService {

    private TwitterDAO twitterDAO;
    private int bgnI=1;
    private int midI=1;
    private int endI=1;
    private String consumerKey = "sddl6FJB9yfCIAOuXkjRapgzl";
    private String consumerSecret = "71hxklzhPszVK8NBFKk9KH7VY056QxFZjxd1zh6fqLhh0VI3df";
    private String accessToken = "983416989329842177-XjHTYrNED5Zp6UfR0DOJJWPKVqiOV1D";
    private String accessSecret = "kcl6LW0dvCHVwAaxRJVAiZ3jYBjm9euXKqApRnq3rVuFe";

    @Autowired
    public TwitterServiceImpl(TwitterDAO twitterDAO) {
        this.twitterDAO= twitterDAO;
    }

    @Override
    public String getTweet() {
        String tweet="";

        tweet = ""+twitterDAO.getTweetBgn(bgnI)+""+twitterDAO.getTweetMid(midI)+""+twitterDAO.getTweetEnd(endI)+"";

        if (endI >= 5){
            endI = 1;
            if (midI >= 7){
                midI = 1;
                if (bgnI>=12){
                    bgnI = 1;
                }
                else {
                    bgnI++;
                }
            }
            else{
                midI++;
            }
        }
        else{
            endI++;
        }
        System.out.println(tweet);
        return tweet;
    }

    @Override
    public void performTweet(String tweet) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecret);
        try
        {
            TwitterFactory factory = new TwitterFactory(cb.build());
            Twitter twitter = factory.getInstance();
            twitter.updateStatus(tweet);
        }catch (TwitterException te) {
            te.printStackTrace();
            System.exit(-1);
        }
    }


}
