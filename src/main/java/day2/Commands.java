package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class Commands {
    public static List<String> generate(String filename) {
        List<String> resultList = new ArrayList<>();
        final String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("\\src\\main\\java\\day2\\" + filename);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                resultList.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
