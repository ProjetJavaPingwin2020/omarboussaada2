package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
 
public class sendSMS {
	public void sendSms(String Anumbers, String Amessage) {
          
		try {
			// Construct data
		       String apiKey = "apikey=" +"Kle7MQGR2Vo-xSzV4Z41ZWahlN2RPGggg2pptjQcoo";
                  // try to get ur apikey, and verif plz !!
                       
                       String  message = "&message=" +Amessage;
                       String  sender = "&sender=" + "HuntKingdom";
                       String  numbers = "&numbers="+Anumbers;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
                                JOptionPane.showMessageDialog(null, "message" + line);
			}
			rd.close();
			
			//return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
		}
            
	}
}