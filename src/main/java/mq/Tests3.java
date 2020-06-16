package mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


/** 
* @author 
* @version
*/
public class Tests3 {
    
    public static void main(String[] args) {

       doHandle("C:\\Users\\hasee\\Desktop\\Ê§°Ü´ýÈ·ÈÏ.txt","C:\\Users\\hasee\\Desktop\\1.txt","pos_sn");
    }
    
    public static void doHandle(String fileName,String newFileName,String field) {
        System.out.println(fileName);
        File file = new File(fileName);  
        InputStreamReader read = null;
        OutputStreamWriter output = null;
        BufferedReader bufferedReader = null;
        try {  
            if(!file.exists()) {
                System.out.println("123");
                return ;
            }
            File newFile = new File(newFileName); 

            String encoding="utf-8";
            read = new InputStreamReader(new FileInputStream(file),encoding);//
            output = new OutputStreamWriter(new FileOutputStream(newFile));
            bufferedReader = new BufferedReader(read);
            StringBuffer buffer = new StringBuffer();
            buffer.append(" ").append(field).append(" IN (");
            String lineTxt = "";  
            int i =1;
            while((lineTxt = bufferedReader.readLine()) != null){
                buffer.append("'").append(lineTxt).append("'");
                if(i++==999) {
                    buffer.append(") \r\n");
                    output.write(buffer.toString());
                    buffer = new StringBuffer();
                    buffer.append(" OR ").append(field).append(" IN (");
                    i=1;
                }else {
                    buffer.append(",");
                }
            }
            if(i!=1) {
            	buffer.deleteCharAt(buffer.length()-1);
                buffer.append(") \r\n");
                output.write(buffer.toString());
            }

        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }finally {
            if(read!=null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output!=null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}