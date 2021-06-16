package test.jdk;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class FileTest {

    @Test
    public void testFormat() {
        List<String> targetFileNames = Stream.of(new File("/tmp/").listFiles())
            .filter(file -> file.isFile())
            .filter(file -> StringUtils.equalsIgnoreCase(FilenameUtils.getExtension(file.getName()), "gz") == false)
            .filter(file -> {
                File f = new File(file.getAbsolutePath() + ".gz");
                return f.exists();
            })
            .map(file -> file.getName())
            .collect(Collectors.toList());

        assertNotNull(targetFileNames);
    }

}
