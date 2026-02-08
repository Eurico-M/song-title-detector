# Song Title Detector

## Motivation:

When I'm streaming I'm almost always looking at a browser window to read the chords of the song I'm playing.

This little program runs in a terminal and looks at all the windows open, searching for one that has a pattern (in my case, "@ Ultimate-Guitar.com", the website I use to read chords).
Then it ouputs this window's name to a java program, that cleans it and outputs it to a simple .txt file. OBS can then simply use this .txt file as a source for a text object, and display it on stream.

For example, if I have a browser window open called:

NUTSHELL CHORDS by Alice in Chains @ Ultimate-Guitar.com

the program will update the text file (stream-song-title.txt) to:

"Nutshell" by Alice in Chains

## Requirements:

This tool was written to fit my workflow: I'm using CachyOS Linux, with KDE Plasma 6 Wayland, and Zsh shell. And OBS to stream.

- *[kdotool](https://github.com/jinliu/kdotool)*: this tool is like xdotool but for KDE-Wayland. It can search window names and do other useful stuff. You could adapt this to X11 with xdotool.
- *java*: I'm using `jdk21-openjdk` because I'm on CachyOS, just grab whatever allows you to compile and run java.
- *zsh*: The shell script was written for Zsh, but I'm sure it's easily adapted to Bash.

## Usage:

- Open a terminal in song-title-detector folder.
- Once, before first run, compile the java program: `$ javac WindowTitleCleaner.java`
- Everytime you want to run: `$ ./song-detector.sh` (make sure song-detector.sh has permission to execute).
- Leave it running in the terminal window. It will search for any windows which have "@ Ultimate-Guitar.com" in the name, and output a formated "Song by Artist" type title to stream-song-title.txt. Use this text file in OBS as a text source to display the song title on stream.
- When you want to close it, simply Ctrl+C.
