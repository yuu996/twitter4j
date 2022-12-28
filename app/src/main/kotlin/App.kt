import twitter4j.Twitter
import java.util.ResourceBundle

fun main(args: Array<String>) {
    val bundle : ResourceBundle = ResourceBundle.getBundle("twitter4j")
    val consumerKey = bundle.getString("oauth.consumerKey")
    val consumerSecret = bundle.getString("oauth.consumerSecret")
    val accessToken = bundle.getString("oauth.accessToken")
    val accessTokenSecret = bundle.getString("oauth.accessTokenSecret")

    val twitter :Twitter = Twitter.newBuilder()
        .prettyDebugEnabled(true)
        .oAuthConsumer(consumerKey,consumerSecret)
        .oAuthAccessToken(accessToken, accessTokenSecret)
        .build()

    val gettimeline = twitter.v1().timelines().homeTimeline
    for(timeline in gettimeline){
        println(timeline)
    }

}