package dam.ejemplo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FilesMain {


    public static void main(String[] args) throws IOException {
        System.out.println(Files.list(Path.of("./src/main/java/dam/asimetrico"))
                .map(path -> path.getName(0).toString())
                .collect(Collectors.joining(".")));
        //Files.exists()


    }
}
