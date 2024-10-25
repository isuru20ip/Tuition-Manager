package modal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author isuru priyamntha
 */
public class SendSMS {

    public static HttpURLConnection conn;

    private static void setHTTP() throws MalformedURLException, IOException {
        if (conn == null) {
            // URL of Notify.LK API
            URL url = new URL("https://app.notify.lk/api/v1/send");

            // Open connection
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
        }
    }

    public static void sendSms(String phoneNumber, String message) {
        try {
            setHTTP();
            // Build the request body
            String data = "user_id=****"
                    + "&api_key=*****"
                    + "&sender_id=NotifyDEMO"
                    + "&to=" + phoneNumber
                    + "&message=" + message;

            // Write the data to the request
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();

            // Get the response code to check if the request was successful
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("SMS sent successfully.");
            } else {
                System.out.println("Failed to send SMS.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
