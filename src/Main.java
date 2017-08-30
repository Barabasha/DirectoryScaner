
// 1. Создание ConsoleReader для чтения файла из консоли
// 2. Создание FileReader для чтения из файла
// 3. Создание общего интерфейса для них
// 4. Поиск строк, содержащих данное слово в заданной директории DirectoryScanner
// 5. Поиск строк, содержащих данное слово в заданной директории рекурсивно RecursiveDirectoryScanner
// 6. Фильтрация файлов по расширению .txt
// 7. Работа программы с консольным вводом (ConsoleReader) до введения слова exit.
// 8. Возвращать не число вхождений, а коллекцию строк, в которые входит заданное слово.
// 9. Сериализовать результаты поиска в файл.

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String path_directory = "C:\\test_hillel";
        String path = "C:\\test_hillel\\1.txt\"";

        MyFileReader myFile = new MyFileReader();
        System.out.println(myFile.read());

        FileScanner sc = new FileScanner(path_directory);
        System.out.println(sc.scan("Hello"));

        RecursivFileScanner recursive_sc = new RecursivFileScanner(path_directory);
        recursive_sc.scan("Hello");
        System.out.println(Result.total_count);
        RecursivFileScanner recursive_sc_string = new RecursivFileScanner(path_directory);
        recursive_sc_string.scan_string("Hello");
        System.out.println(Result.list);

        Result result = new Result();
        File file = new File("C:\\test_hillel\\res.ser");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
