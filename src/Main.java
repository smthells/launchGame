import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    private static StringBuilder logBuilder = new StringBuilder();

    public static void main(String[] args) {
        List<String> listOfPath = List.of("/Users/kirillmakarov/Games/src", "/Users/kirillmakarov/Games/src/main",
                "/Users/kirillmakarov/Games/src/test", "/Users/kirillmakarov/Games/res",
                "/Users/kirillmakarov/Games/res/drawables", "/Users/kirillmakarov/Games/res/vectors",
                "/Users/kirillmakarov/Games/res/icons", "/Users/kirillmakarov/Games/savegames",
                "/Users/kirillmakarov/Games/temp");

        for (String directory : listOfPath) {
            createDirectory(directory);
        }

        createFile("/Users/kirillmakarov/Games/src/main", "Main.java");
        createFile("/Users/kirillmakarov/Games/src/main", "Utils.java");
        createFile("/Users/kirillmakarov/Games/temp", "temp.txt");

        try (FileWriter writer = new FileWriter("/Users/kirillmakarov/Games/temp/temp.txt")) {
            writer.write(logBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Установка игры завершена!");
    }

    private static void createDirectory(String path) {
        File newDir = new File(path);
        if (newDir.mkdir()) {
            logBuilder.append("Директория ").append(path).append(" создана\n");
        } else {
            logBuilder.append("Не удалось создать директорию ").append(path).append("\n");
        }
    }

    private static void createFile(String path, String fileName) {
        File newFile = new File(path, fileName);
        try {
            if (newFile.createNewFile()) {
                logBuilder.append("Файл ").append(fileName).append(" создан\n");
            } else {
                logBuilder.append("Не удалось создать файл ").append(fileName).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}