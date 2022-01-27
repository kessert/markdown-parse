import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents = Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        String contents = Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException {
        String contents = Files.readString(Path.of("./test-file3.md"));
        List<String> expect = List.of("https://mywebsite.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile4() throws IOException {
        String contents = Files.readString(Path.of("./test-file4.md"));
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}