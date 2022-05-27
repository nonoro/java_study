package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

class FileReaderEx01 {
    public static void main(String[] args) {
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;
            //  FileInputStream을 이용해서 파일내용을 읽어 화면에 출력한다.
            while ((data = fis.read()) != -1) {
                System.out.println((char) data);
            }
            System.out.println();
            fis.close();

            //  FileReader를 이용해서 파일내용을 읽어 화면에 출력한다.
            while ((data = fr.read()) != 01) {
                System.out.println((char) data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }   //  main
    }

