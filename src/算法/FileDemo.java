package 算法;

import org.junit.Test;
import org.omg.CORBA.portable.OutputStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题描述：给定一个URL,文件服务器的链接地址,将这个服务器上的所有文件下载到本地
 */
public class FileDemo {

    private static final String remotePath = "http://learning.happymmall.com/git/Git-2.12.1-32-bit.exe";
    private static final String localPath = "D:\\Work\\IO";

    @Test
    public void test() {

        ListNode node = create(Arrays.asList(1,2,3,4));
        System.out.println(node);
    }
    public static void getAllFile(File dir){
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                getAllFile(file);
            }else{
                //downloadFile(file,localPath);
            }
        }
    }
    class ListNode{
        int value;
        ListNode next ;
        public ListNode(int value) {
            this.value = value;
            this.next=null;
        }
    }


    public ListNode create(List<Integer> values){
        if (values.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(values.get(0));
        ListNode headOfSublist = create(values.subList(1,values.size()));
        head.next=headOfSublist;
        return head;
    }




    public static void download(String urlPath,String local){
        try {
            URL url = new URL(urlPath);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置超时
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            // post方式不能使用缓存
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(1000*5);
            //设置请求方式，默认是GET
            httpURLConnection.setRequestMethod("POST");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");

            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// 打开到此 URL引用的资源的通信链接（如果尚未建立这样的连接）
            httpURLConnection.connect();

            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(local));
            int len=0; byte[] bytes= new byte[1024];
            while ((len=bin.read())!=-1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
