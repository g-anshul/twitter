# twitter
Boot camp

1. Download code repository on your local, ask for permission if not added to collaborators group.
2. run "mvn clean install"
3. Go the respective class which you want to run and execute

Run from .jar file
1. Download code repository on your local, ask for permission if not added to collaborators group.
2. run "mvn clean install"
3. In the downloaded code repo :
"`java -jar target/twitter-1.0-SNAPSHOT-jar-with-dependencies.jar twitter.ReadTimeline`" - run this to ReadTimeline data

b)
"`java -jar target/twitter-1.0-SNAPSHOT-jar-with-dependencies.jar twitter.PublishPost`"

**************** Config file ****************

Before running the jar command, keys needs to be updated.
a) Go to the command line :
    1. OAuthConsumerKey=${You consumer keys}
    2. OAuthConsumerSecret=${You consumer secret keys}
    3. OAuthAcessToken=${You Access token keys}
    4. OAuthAccessTokenSecret=${You Access secret keys}

b) then run `java -jar target/twitter-1.0-SNAPSHOT-jar-with-dependencies.jar server src/main/resources/yml/config.yml`
c) Service must be accessible over: <Use post man or rest service client for accessing below http endpoint>
    1. http://localhost:8080/api/1.0/twitter/timeline
    2. http://localhost:8080/api/1.0/twitter/tweet?tweet=hello this is tweet from twitter4j
