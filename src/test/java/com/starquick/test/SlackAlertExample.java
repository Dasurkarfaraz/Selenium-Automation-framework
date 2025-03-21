package com.starquick.test;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackAlertExample {

    public static void main(String[] args) {
        String webhookUrl = "https://hooks.slack.com/services/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";

        String message = "Selenium script failed. Check logs for details.";

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonPayload = "{\"text\":\"" + message + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Message sent successfully to Slack.");
            } else {
                System.out.println("Failed to send message to Slack. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while sending message to Slack: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
