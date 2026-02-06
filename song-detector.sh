#!/bin/zsh

OUTPUTFILE='/home/eurico/Documents/stream-song-details.txt'

echo Song Detector started ...

# on an infinite loop:
while :
do
    # grab the ID of the window that has Ultimate Guitar opened
    WINDOWID=$(kdotool --name search Ultimate-Guitar.com)
    #echo $WINDOWID

    # using the ID, grab the name of said window
    WINDOWNAME=$(kdotool getwindowname $WINDOWID)
    #echo $WINDOWNAME

    # feed the name to a little program that cleans it and outputs it
    ./window-title-cleaner $WINDOWNAME

    # wait x seconds, then do it again 
    sleep 5
done