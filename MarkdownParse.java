//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        //System.out.println(markdown.length());
        while(currentIndex < markdown.length()) {
            //System.out.println(markdown.length());
            int openBracket = markdown.indexOf("[", currentIndex);
            if(openBracket == -1){
                break;
            }
            //System.out.println("ob " + openBracket);
            int closeBracket = markdown.indexOf("]", openBracket);
            //System.out.println("cb " + closeBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            //System.out.println("op " + openParen);
            int closeParen = markdown.indexOf(")", openParen);
            //System.out.println("cp " + closeBracket);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen+1;
            System.out.println("ci" + currentIndex);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
