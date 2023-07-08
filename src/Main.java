import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String gamesPath = "/Users/kirillmakarov/Games";

        File srcMainDir = new File(gamesPath + "/src/main");
        File srcTestDir = new File(gamesPath + "/src/test");
        File resDrawablesDir = new File(gamesPath + "/res/drawables");
        File resVectorsDir = new File(gamesPath + "/res/vectors");
        File resIconsDir = new File(gamesPath + "/res/icons");
        File savegamesDir = new File(gamesPath + "/savegames");
        File tempDir = new File(gamesPath + "/temp");

        boolean srcMainDirCreated = srcMainDir.mkdirs();
        boolean srcTestDirCreated = srcTestDir.mkdirs();
        boolean resDrawablesDirCreated = resDrawablesDir.mkdirs();
        boolean resVectorsDirCreated = resVectorsDir.mkdirs();
        boolean resIconsDirCreated = resIconsDir.mkdirs();
        boolean savegamesDirCreated = savegamesDir.mkdir();
        boolean tempDirCreated = tempDir.mkdir();

        File mainFile = new File(gamesPath + "/src/main/Main.java");
        File utilsFile = new File(gamesPath + "/src/main/Utils.java");
        File tempFile = new File(gamesPath + "/temp/temp.txt");

        boolean mainFileCreated = false;
        boolean utilsFileCreated = false;
        boolean tempFileCreated = false;

        try {
            mainFileCreated = mainFile.createNewFile();
            utilsFileCreated = utilsFile.createNewFile();
            tempFileCreated = tempFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("src,main и test директории созданы: ").append(srcMainDirCreated &&
                srcTestDirCreated).append("\n");
        logBuilder.append("res,drawable,vectors и icons директории созданы: ").append(resDrawablesDirCreated &&
                resVectorsDirCreated && resIconsDirCreated).append("\n");
        logBuilder.append("savegames директория создана: ").append(savegamesDirCreated).append("\n");
        logBuilder.append("temp директория создана: ").append(tempDirCreated).append("\n");
        logBuilder.append("Файл Main.java создан: ").append(mainFileCreated).append("\n");
        logBuilder.append("Файл Utils.java создан: ").append(utilsFileCreated).append("\n");
        logBuilder.append("Файл temp.txt создан: ").append(tempFileCreated).append("\n");

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(logBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Установка игры завершена!");
    }
}