#!/bin/zsh


echo Song Detector started ...

# on an infinite loop:
while :
do
    # grab the ID of the window that has Ultimate Guitar opened
    WINDOWID=$(kdotool search --name Ultimate-Guitar.com)
    #echo $WINDOWID

    # using the ID, grab the name of said window
    WINDOWNAME=$(kdotool getwindowname $WINDOWID)
    #echo $WINDOWNAME

    # feed the name to a little program that cleans it and outputs it
    java WindowTitleCleaner.java $WINDOWNAME

    # wait x seconds, then do it again 
    sleep 5
done