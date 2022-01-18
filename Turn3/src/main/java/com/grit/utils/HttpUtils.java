package com.grit.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class HttpUtils {

    public static StringBuilder sendGet(String url, String param) {
        StringBuilder res = null;
        BufferedReader br = null;
        try {
            String urlNameString = url +"?"+  param;
            URL realUrl = new URL(urlNameString);

            URLConnection connection = realUrl.openConnection();

            connection.connect();

            GZIPInputStream gzipInputStream =new GZIPInputStream(connection.getInputStream());
            res=new StringBuilder();
            String line;
            br = new BufferedReader(new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return res;
    }
}
