package stockmonitorapp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    private static final String API_KEY = "YOUR_ALPHA_VANTAGE_API_KEY";
    private static final String SYMBOL = "DJI";
    private static final String API_URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + SYMBOL + "&apikey=" + API_KEY;
    private static final Queue<String> dataQueue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Stock Monitoring Application Started.");

        while (true) {
            try {
                // Fetch stock data
                HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Parse and add to queue
                String stockData = response.toString();
                String timestamp = java.time.LocalDateTime.now().toString();
                String output = "Data: " + stockData + " at " + timestamp;
                dataQueue.add(output);
                System.out.println(output);

                // Sleep for 5 seconds
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println("Error fetching stock data: " + e.getMessage());
            }
        }
    }
}
