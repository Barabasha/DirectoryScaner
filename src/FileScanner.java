import java.io.*;
import java.util.ArrayList;

class FileScanner implements MyScanner {
    private String path;

    FileScanner(String path) {
        this.path = path;
    }

    @Override
    public int scan(String word) throws IOException {
        int count = 0;
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
                }
            }
        }
        return count;
    }
}
