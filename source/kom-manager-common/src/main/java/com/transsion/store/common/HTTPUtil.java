package com.transsion.store.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradmin on 2016/5/30.
 */
public class HTTPUtil {
    private HTTPUtil(){}

    public static String sendPostRequest(String url,String str){

        HttpURLConnection httpURLConnection=null;
        OutputStream out=null;
        BufferedReader br=null;
        int responseCode=0;//http状态码
        try {
            URL sendurl=new URL(url);
            try {
                httpURLConnection=(HttpURLConnection) sendurl.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                out=httpURLConnection.getOutputStream();
                out.write(str.getBytes());
                out.flush();//清空缓冲区,发送数据
                responseCode=httpURLConnection.getResponseCode();
                br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                String line = "";
                String result = "";
                while(null != (line=br.readLine())){
                    result += line;
                }
                if(responseCode==200)
                    return result;
            } catch (IOException e) {
//					System.out.println("与[" + url + "]通信异常,堆栈信息为");
                e.printStackTrace();
                return responseCode + "`" + "Failed`";
            }finally{
                if(out != null){
                    try{
                        out.close();
                    }catch (Exception e){
                        System.out.println("关闭输出流时发生异常,堆栈信息如下");
                        e.printStackTrace();
                    }
                }
                if(br != null){
                    try{
                        br.close();
                    }catch(Exception e){
                        System.out.println("关闭输入流时发生异常,堆栈信息如下");
                        e.printStackTrace();
                    }
                }
                if(httpURLConnection != null){
                    httpURLConnection.disconnect();
                    httpURLConnection = null;
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";

    }
    /**
     * 发送HTTP_POST请求
     * @see 若发送的<code>params</code>中含有中文,记得按照双方约定的字符集将中文<code>URLEncoder.encode(string,encodeCharset)</code>
     * @see 本方法默认的连接和读取超时时间均为30秒
     * @param reqURL 请求地址
     * @param params 发送到远程主机的正文数据
     * @return HTTP响应码`远程主机响应正文,如<code>"200`SUCCESS"</code><br>若通信过程中发生异常则返回"HTTP响应码`Failed",如<code>"500`Failed"</code>
     */
    public static String sendPostRequest(String reqURL, Map<String, String> params){
        StringBuilder sendData = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet()){
            sendData.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if(sendData.length() > 0){
            sendData.setLength(sendData.length() - 1); //删除最后一个&符号
        }
        return sendPostRequest(reqURL, sendData.toString());
    }
    
    public static String sendGetRequest(String url){
        HttpURLConnection httpURLConnection=null;
        BufferedReader br=null;
        int responseCode=0;//http状态码
        try {
            URL sendurl=new URL(url);
            try {
                httpURLConnection=(HttpURLConnection) sendurl.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.connect(); //建立到远程对象的实际连接
                
                responseCode = httpURLConnection.getResponseCode();
                br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                String line = "";
                String result = "";
                while(null != (line=br.readLine())){
                    result += line;
                }
                if(responseCode==200)
                    return result;
            } catch (IOException e) {
                e.printStackTrace();
                return responseCode + "`" + "Failed`";
            }finally{
                if(br != null){
                    try{
                        br.close();
                    }catch(Exception e){
                        System.out.println("关闭输入流时发生异常,堆栈信息如下");
                        e.printStackTrace();
                    }
                }
                if(httpURLConnection != null){
                    httpURLConnection.disconnect();
                    httpURLConnection = null;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    //	/**
//	 * 下面是测试代码
//	 */
    public static void main(String[] args){
        Map<String, String> params = new HashMap<String, String>();
        params.put("AFTSHOPSALEITEM.IMEI_NO", "#569845125632569");
        String result=sendPostRequest("http://127.0.0.1:6900/scm/FramworkServlet?ACTION=SCM_IAFBRANDSERVICE.QUERYIMEIFORMODEL",params);
        System.out.println(result);
    }
}
