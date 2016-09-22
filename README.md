"#SlackBot" 

SlackBot built in Java, compiled by Maven and executed on a Raspberry Pi 2

This project requires a Java Runtime environment and a Maven Setup

Thanks to Xianic for the instructions for settin up a Maven environment on a Raspberry Pi
https://www.xianic.net/post/installing-maven-on-the-raspberry-pi/

Java should be provided on a Rasberry Pi. Java is used to execute the .jar after maven has provided a new build of the project when pulled from this repo.

User Tokens for the bot need to be provided in a local file name userToken.txt. This file is not provided as the token I am using is specific to the bot in my integration of Slack. If the build fails immediately then the User Token is not being provided in a usable format.

Current Functionality:
Responds to Taylor in any message that has recently been posted with one of 8 messages made up of song lyrics
Run-time set from 8am to 6pm localtime

Pending:
Posting Pinned Items
Twitter integration
Giphy style responses
Google Image puller
Username recogination

ALSO ALL THE STUFF THAT NORMALLY FINDS IT'S WAY INTO A REPO
