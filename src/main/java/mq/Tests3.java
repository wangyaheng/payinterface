package mq;

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
* @version ����ʱ�䣺2018��11��16�� ����3:09:45
*/
public class Tests3 {
    
    public static void main(String[] args) {
        ArrayList<String> ts = new ArrayList<>();

        /*ts.add("b");
        ts.add("d");
        ts.add("c");
        ts.add("a");
        ts.add("g");
        Collections.sort(ts,(s1,s2)->s1.compareTo(s2));*/
    	/*Date date = new Date(1556176060954l);
    	System.out.println(date);*/
    	
        doHandle("C:\\Users\\hasee\\Desktop\\失败待确认.txt","C:\\Users\\hasee\\Desktop\\1.txt","customer_no");
    }
    
    public static void doHandle(String fileName,String newFileName,String field) {
        File file = new File(fileName);  
        InputStreamReader read = null;
        OutputStreamWriter output = null;
        BufferedReader bufferedReader = null;
        try {  
            if(!file.exists()) {
                System.err.println("�ļ������ڡ�"+fileName);
                return ;
            }
            File newFile = new File(newFileName); 
            System.out.println("�ļ���ʼ������"); 
            String encoding="utf-8";
            read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ  
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
            System.out.println("�ļ���ʼ����ɹ�"); 
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