package leetcode;

import java.io.*;

public class Problem71 {

    public static void main(String[] args ){



       try{
           String fileString  = readFile(new File("C:\\Users\\u6313\\Desktop\\TEAM19\\PTP\\Actual\\4-UTF8.txt"), "utf-8");

           write(fileString, new File("C:\\Users\\u6313\\Desktop\\TEAM19\\PTP\\Actual\\tmp.txt"));
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }

    public static String readFile(File file, String encoding) throws IOException {
        if (file != null && file.exists() && file.canRead() && file.isFile()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
            StringBuilder sb = new StringBuilder((int)file.length());

            try {
                boolean var4 = false;

                int c;
                while((c = in.read()) != -1) {
                    sb.append((char)c);
                }
            } finally {
                in.close();
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static void write(String inputString, File file) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "windows-1251"));
        //создание 1 блока
        out.write(inputString);

        out.flush();
        out.close();
    }
}
