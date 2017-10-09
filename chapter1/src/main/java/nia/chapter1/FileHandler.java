package nia.chapter1;

import java.io.*;

/**
 * Created by piaolinzhi on 2017/10/2.
 */
public class FileHandler {

    public static void main(String[] args) {
        File src = new File("D://1.txt");
        File des = new File("D://2.html");

        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(src))) {
            if(!des.exists()) {
                des.createNewFile();
            }
            ;
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(des));
            bufferedWriter.append("<!DOCTYPE html>");
            bufferedWriter.newLine();
            bufferedWriter.append("<html>");
            bufferedWriter.newLine();
            bufferedWriter.append("<head>");
            bufferedWriter.newLine();
            bufferedWriter.append("<script src='http://libs.baidu.com/jquery/1.10.2/jquery.min.js'></script>");
            bufferedWriter.newLine();
            bufferedWriter.append("<script type='text/javascript'>");
            bufferedWriter.newLine();
            bufferedWriter.append("$(document).ready(function(){$('a').click(function(){$(this).html('ok');});});");
            bufferedWriter.newLine();
            bufferedWriter.append("</script></head>");
            bufferedWriter.newLine();
            bufferedWriter.append("<body>");
            bufferedWriter.newLine();

            String row = bufferedReader.readLine();
            while(null != row && !"".equalsIgnoreCase(row.trim())) {
                System.out.println(row);
                String changedString = "<a href='" + row
                        + "' target='_blank'>download</a><br />";
                bufferedWriter.append(changedString);
                bufferedWriter.newLine();
                row = bufferedReader.readLine();
            }
            bufferedWriter.append("</body></html>");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
