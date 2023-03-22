package com.lottecard.main.sample;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class MtlsTset {
	public static void main(String[] args) throws Exception {
//		String urlString = "https://www.example.com";
		String urlString = "https://vpn.dongkuksystems.co.kr/";
//		String urlString = "https://test-kapi.kakao.com/test-ca-certificates";
		String line = null;
		InputStream in = null;
		BufferedReader reader = null; 
		HttpsURLConnection httpsConn = null;
		
		
		 KeyStore keyStore  = KeyStore.getInstance("PKCS12");
		    FileInputStream instream = new FileInputStream(new File("D:/badssl.com-client.p12"));
//		    try {
		    
		        keyStore.load(instream, "badssl.com".toCharArray());
		        
		        
//		    } finally {
//		        instream.close();
//		    }
		    
		    
		    
		
		try {
			// Get HTTPS URL connection
			URL url = new URL(urlString);
			httpsConn = (HttpsURLConnection) url.openConnection();
			
			// Set Hostname verification
			httpsConn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					// Ignore host name verification. It always returns true.
					return true;
				}
			});
			// MTLS 를 위한 Client Certi 자체 API 호출 전 등록
			httpsConn.setSSLSocketFactory(getFactory(new File("D:/badssl.com-client.p12"), "badssl.com"));
			
			// Input setting
			httpsConn.setDoInput(true);
			// Output setting
			//httpsConn.setDoOutput(true);
			// Caches setting
			httpsConn.setUseCaches(false);
			// Read Timeout Setting
			httpsConn.setReadTimeout(1000);
			// Connection Timeout setting
			httpsConn.setConnectTimeout(1000);
			// Method Setting(GET/POST)
			httpsConn.setRequestMethod("GET");
			// Header Setting
			httpsConn.setRequestProperty("HeaderKey","HeaderValue");
			
			int responseCode = httpsConn.getResponseCode();
			System.out.println("응답코드 : " + responseCode);
			System.out.println("응답메세지 : " + httpsConn.getResponseMessage());
			
			// SSL setting
//			SSLContext context = SSLContext.getInstance("TLS");
//			context.init(null, null, null); // No validation for now
//			httpsConn.setSSLSocketFactory(context.getSocketFactory());
			// Connect to host
			httpsConn.connect();
			httpsConn.setInstanceFollowRedirects(true);
			
			// Print response from host
			if (responseCode == HttpsURLConnection.HTTP_OK) { // 정상 호출 200
				in = httpsConn.getInputStream();
			} else { // 에러 발생
				in = httpsConn.getErrorStream();
			}
			reader = new BufferedReader(new InputStreamReader(in));
			while ((line = reader.readLine()) != null) {
				System.out.printf("%s\n", line);
			}
			
			reader.close();
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException : " + e);
		} catch (MalformedURLException e) {
			System.out.println(urlString + " is not a URL I understand");
        } catch (IOException e) {
        	System.out.println("IOException :" + e);
        } catch (Exception e) {
        	System.out.println("error : " + e);
        } finally {
            if (reader != null) {
            	reader.close();
            }
            if (httpsConn != null) {
                httpsConn.disconnect(); 
            }
        }
	}
	
	 private static SSLSocketFactory getFactory( File pKeyFile, String pKeyPassword ) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException, KeyManagementException{
	        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
	        KeyStore keyStore = KeyStore.getInstance("PKCS12");
	       
	        InputStream keyInput = new FileInputStream(pKeyFile);
	        keyStore.load(keyInput, pKeyPassword.toCharArray());
	        keyInput.close();
	       
	        keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
	       
	        
	        KeyStore trustStore = KeyStore.getInstance("JKS");
	        trustStore.load(new FileInputStream(System.getProperty("java.home") + "/lib/security/cacerts"), "changeit".toCharArray());

	        // Get Trust Manager Start 신뢰 저장소 체크 할 경우만 Start
	      
	        //사전 작업 도메인에 접속하여 인증서 추출
	        //keytool -import -file "D:\dongkuk.crt" -keystore "D:\JAVA\jdk1.8.0_362\openjdk\jre\lib\security\cacerts" -storepass "changeit"
	        KeyStore trustStoreJava = KeyStore.getInstance("JKS");
//	        trustStoreJava.load(new FileInputStream(System.getProperty("java.home") + "/lib/security/cacerts"), "changeit".toCharArray());
	        trustStoreJava.load(new FileInputStream("D:\\JAVA\\jdk1.8.0_362\\openjdk\\jre\\lib/security/cacerts"), "changeit".toCharArray());
//	        trustStoreJava.load(new FileInputStream("D:\\JAVA\\jdk1.8.0_362\\openjdk\\jre\\lib/security/cacerts"), "changeit".toCharArray());  
//	        trustStoreJava.load(new FileInputStream("D:\\dongkuk.crt"), null);
	        TrustManagerFactory tmf_java = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        tmf_java.init(trustStoreJava);
	        TrustManager[] tms_java = tmf_java.getTrustManagers();
	        // Get Trust Manager Start 신뢰 저장소 체크 할 경우만 End
	        
	        
	        SSLContext context = SSLContext.getInstance("TLS");
	        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        tmf.init(keyStore);
	        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
	        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
	        
	        //신뢰 체크 무시
//	        context.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{tm}, new SecureRandom());
	       
	        //자바기준 cacert 신뢰 도메인 체크
	        
	        context.init(keyManagerFactory.getKeyManagers(), tms_java, new SecureRandom());
	        return context.getSocketFactory();
	    }
	 
}