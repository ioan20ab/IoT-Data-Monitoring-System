import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Random;

public class ClientSimulator {

    public static void main(String[] args) {
        Random random = new Random();
        String serverUrl = "http://localhost:8080/data";

        while (true) {
            try {
                // Simulate sensor data
                String deviceId = "Device-" + random.nextInt(10);
                double temperature = 20 + random.nextDouble() * 15;
                double humidity = 30 + random.nextDouble() * 20;
                String timestamp = LocalDateTime.now().toString();

                // JSON payload
                String payload = String.format(
                        "{\"deviceId\":\"%s\", \"temperature\":%.2f, \"humidity\":%.2f, \"timestamp\":\"%s\"}",
                        deviceId, temperature, humidity, timestamp);

                // Send HTTP POST request
                URL url = new URL(serverUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                try (OutputStream os = conn.getOutputStream()) {
                    os.write(payload.getBytes());
                    os.flush();
                }

                System.out.println("Sent: " + payload);
                System.out.println("Response Code: " + conn.getResponseCode());

                Thread.sleep(5000); // Send data every 5 seconds
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
