
package CodeFiles;
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void method(File file) throws IOException {
        String fileDirectory=file.getParent();
        System.out.print(fileDirectory);
        FileInputStream fis=new FileInputStream(file);//reads input file
        FileOutputStream fos=new FileOutputStream(fileDirectory+"\\compressedfile.gz");//gets the ouptput
        GZIPOutputStream gpos=new GZIPOutputStream(fos);//compress the output
        byte[]buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            gpos.write(buffer,0,len);
        }
        fis.close();
        gpos.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        File path=new File("C:\\Users\\91817\\Desktop\\pro.txt");
        method(path);
    }
    public static long size(File file){
        file = new File("C:\\Users\\91817\\Desktop\\compressedfile.gz");
        return file.length();
    }
}