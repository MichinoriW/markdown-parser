import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void links() throws IOException{
        ArrayList<String> arr = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, arr);

        arr = MarkdownParse.getLinks(Files.readString(Path.of("markdown-test.md")));
        expected.clear();
        expected.add("https://link1.com");
        expected.add("https://link2.com");
        assertEquals(expected, arr);

        arr = MarkdownParse.getLinks(Files.readString(Path.of("new-md-test.md")));
        expected.clear();
        expected.add("suup.com");
        expected.add("bbb.mng");
        expected.add("linkme.com");
        expected.add("dooba.com");
        assertEquals(expected, arr);
    }

    @Test
    public void links2() throws IOException{
        for(int i = 2; i < 9; i++){
            ArrayList<String> arr = MarkdownParse.getLinks(Files.readString(Path.of("test-file"+i+".md")));
            System.out.println(Files.readString(Path.of("test-file"+i+".md")));
            ArrayList<String> expected = new ArrayList<String>();
            switch(i){
                case 2:
                    expected.add("https://something.com");
                    expected.add("some-page.html");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
            assertEquals(expected, arr);
            expected.clear();
        }
    }
}
