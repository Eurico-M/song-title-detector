import java.io.*;

public class WindowTitleCleaner {

    // function to format THIS TITLE to This Title
    public static String capitalize(String s) {
        String output = "";
        
        // split a string into it's components by whitespace
        String[] sComponents = s.split(" ");
        
        // for each component
        for (int i = 0; i < sComponents.length; i++) {

            String upperCaseString = sComponents[i];
            // if the first character is a letter and the component is bigger than 1
            if (upperCaseString.length() > 1 && upperCaseString.charAt(0) >= 65) {

                // grab the first letter as is
                String firstLetter = upperCaseString.substring(0, 1);
                // grab the rest of the string and turn it into lowercase
                String restString = upperCaseString.substring(1);
                restString = restString.toLowerCase();
                // join them again
                String correctFormat = firstLetter + restString;

                output += correctFormat;

            }
            // single char words or numbers
            else if (upperCaseString.length() > 0) {
                // just add it to the final result without any changes
                output += upperCaseString;
            }

            if (upperCaseString.length() > 0 && i < sComponents.length - 1) {
                // add a space to all components except the last one
                output += " ";
            }
        }

        return output;
    }
    
    public static void main(String[] args) throws IOException {

        if (args.length != 0) {

            // receive the raw input from the kdotool search
            String rawName = args[0];

            // replace all fuckin em-dashes with regular dashes
            rawName = rawName.replaceAll("\u2014", "-");

            // remove "@ Ultimate-Guitar.com - Zen Browser"
            int idxAt = rawName.indexOf("@");
            rawName = rawName.substring(0, idxAt);

            // this array will receive the multiple parts of the split title
            String[] titleComponents;
            String outString;
            String song = "";
            String artist = "";

            // Ultimate Guitar appears to have two formats:
            // 1) SONG CHORDS by Artist
            // 2) ARTIST - SONG

            if (rawName.contains("CHORDS")) {

                // split title around "CHORDS by" or "CHORDS (ver 2) by"
                titleComponents = rawName.split("CHORDS (\\(.*\\) )?by");

                song = capitalize(titleComponents[0]);
                artist = titleComponents[1];
            } 
            else {

                // split title around a dash
                titleComponents = rawName.split("-");

                if (titleComponents.length > 1) {                
                    
                    song = capitalize(titleComponents[1]);
                    artist = " " + capitalize(titleComponents[0]);
                }
            }

            // build correct output
            if (song.equals("")) {

                outString = "Picking next song...";
            }
            else {  

                outString = "\"" + song + "\"" + " by" + artist;
            } 

            // output to this file
            String path = "stream-song-title.txt";
            FileWriter fWriter = new FileWriter(path);
            fWriter.write(outString);
            fWriter.close();            
        }
    }
}
