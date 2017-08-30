import java.io.*;

public class MyFileReader implements Reader {
    private String path = "C:\\test_hillel\\1.txt";
    private File file = new File(path);

    @Override
    public String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String in_file;
        StringBuilder out = new StringBuilder();
        while ((in_file = br.readLine()) != null) {
            out.append(in_file);
            out.append(" ");
        }
        return String.valueOf(out);
    }
}
