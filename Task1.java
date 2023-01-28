//Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
//Требуется перехватить все возможные ошибки и вывести их в логгер.
//
//После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Task1 {
    private static final Logger logger = Logger.getLogger(Task1.class.getName());

    public static void log_err(String msg) throws IOException{
        FileHandler fh = new FileHandler("log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.addHandler(fh);
        logger.log(Level.SEVERE, msg);
        fh.close();
    }

    public static byte[] get_byte_num() throws IOException {
        byte[] res = new byte[1];
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите число: ");
        try{
            byte num = scn.nextByte();
            res[0] = num;
        } catch (Exception e){
            log_err(e.toString());
        }
        return res;
    }

    public static void write_to_file(byte[] num) throws IOException {
        try {
            FileOutputStream file = new FileOutputStream("result.txt", true);
            file.write(num);
            file.write(10);
        } catch (Exception e) {
            log_err(e.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        byte[] input_byte = get_byte_num();
        try {
            write_to_file(input_byte);
        } catch (FileNotFoundException e) {
            log_err(e.toString());
        }
   }
}


