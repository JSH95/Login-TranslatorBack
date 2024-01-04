//package com.example.translator.service;
//
//import com.example.translator.dto.TestDto;
//import org.springframework.stereotype.Service;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
//// 네이버 기계번역 (Papago SMT) API 예제
//
//@Service
//public class TestService {
//
//    public String testM(TestDto dto) {
//
//        String clientId = "BBnwR9tB8WRwAIEzYhHN";//애플리케이션 클라이언트 아이디값";
//
//        String clientSecret = "nJ2QtcebTB";//애플리케이션 클라이언트 시크릿값";
//
//
//        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
//
//        String text;
//        try {
//
//            text = URLEncoder.encode(dto.getMsg(), "UTF-8");
//
//        } catch (UnsupportedEncodingException e) {
//
//            throw new RuntimeException("인코딩 실패", e);
//
//        }
//
//
//        Map<String, String> requestHeaders = new HashMap<>();
//
//        requestHeaders.put("X-Naver-Client-Id", clientId);
//
//        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
//
//
//        return post(apiURL, requestHeaders, text, dto.getLang());
//
//    }
//
//    private static String post(String apiUrl, Map<String, String> requestHeaders, String text, String lang){
//
//        HttpURLConnection con = connect(apiUrl);
//
//        String postParams = "source=ko&target=" + lang + "&text=" + text;
//
//        try {
//
//            con.setRequestMethod("POST");
//
//            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
//
//                con.setRequestProperty(header.getKey(), header.getValue());
//
//            }
//
//
//            con.setDoOutput(true);
//
//            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//
//                wr.write(postParams.getBytes());
//
//                wr.flush();
//
//            }
//
//
//            int responseCode = con.getResponseCode();
//
//            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
//
//                return readBody(con.getInputStream());
//
//            } else {  // 에러 응답
//
//                return readBody(con.getErrorStream());
//
//            }
//
//        } catch (IOException e) {
//
//            throw new RuntimeException("API 요청과 응답 실패", e);
//
//        } finally {
//
//            con.disconnect();
//
//        }
//
//    }
//
//
//    private static HttpURLConnection connect(String apiUrl){
//
//        try {
//
//            URL url = new URL(apiUrl);
//
//            return (HttpURLConnection)url.openConnection();
//
//        } catch (MalformedURLException e) {
//
//            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
//
//        } catch (IOException e) {
//
//            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
//
//        }
//
//    }
//
//
//    private static String readBody(InputStream body){
//
//        InputStreamReader streamReader = new InputStreamReader(body);
//
//
//        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
//
//            StringBuilder responseBody = new StringBuilder();
//
//
//            String line;
//
//            while ((line = lineReader.readLine()) != null) {
//
//                responseBody.append(line);
//
//            }
//
//
//            return responseBody.toString();
//
//        } catch (IOException e) {
//
//            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
//
//        }
//
//    }
//
//}