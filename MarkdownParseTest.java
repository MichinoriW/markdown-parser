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
}
