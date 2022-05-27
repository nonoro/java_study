package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

class IOEx02 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);       //  읽어 온 데이터를 배열 temp에 담는다. temp에 10개의 데이터칸에다가 인덱스 0 부터 쭉 10개를 temp배열에 저장
        output.write(temp, 5, 5);           //  temp배열에 저장된 것들중에 인덱스 5부터 5개를 write한다.

        outSrc = output.toByteArray();

        System.out.println("Input source=" + Arrays.toString(inSrc));
        System.out.println("temp source=" + Arrays.toString(temp));
        System.out.println("Output source=" + Arrays.toString(outSrc));
    }
}
