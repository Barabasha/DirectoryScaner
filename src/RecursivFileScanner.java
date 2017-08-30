import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecursivFileScanner implements MyScanner {
    private String path;
    private int count;

    RecursivFileScanner(String path) {
        this.path = path;
    }

    @Override
    public int scan(String word) throws IOException {
        String line_in_file;
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File unit : files) {
                if (!unit.isDirectory()) {
                    BufferedReader br = new BufferedReader(new FileReader(unit.getAbsolutePath()));
                    try {
                        while ((line_in_file = br.readLine()) != null) {
                            if (line_in_file.contains(word)) {
                                count++;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Catch" + e);
                    }
                    br.close();
                } else {
                    path = unit.getAbsolutePath();
                    RecursivFileScanner new_sc = new RecursivFileScanner(path);
                    new_sc.scan(word);
                }
            }
        }
        Result.total_count += count;
        return count;
    }

    void scan_string(String word) throws IOException {
        String line_in_file;
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File unit : files) {
                if (!unit.isDirectory()) {
                    if (isTxt(unit)) {
                        BufferedReader br = new BufferedReader(new FileReader(unit.getAbsolutePath()));
                        try {
                            while ((line_in_file = br.readLine()) != null) {
                                if (line_in_file.contains(word)) {
                                    Result.list.add(line_in_file);
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Catch" + e);
                        }

                        br.close();
                    }
                } else {
                    path = unit.getAbsolutePath();
                    RecursivFileScanner new_sc = new RecursivFileScanner(path);
                    new_sc.scan_string(word);
                }
            }
        }
    }

    private boolean isTxt(File file) {
        path = file.getAbsolutePath();
        path = path.substring(path.length() - 3, path.length());
        return path.equals("txt");
    }
}


