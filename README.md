# Stock Monitor Application

This is a simple Java application that monitors the Dow Jones Industrial Average (DJI) stock price in real time and stores the stock value along with the timestamps in a queue.

## Features
- Fetches the Dow Jones Industrial Average (DJI) stock price every 5 seconds.
- Logs the stock price and timestamp to the console.
- Stores the latest 100 stock prices in memory using a queue.

## Requirements
- Java (version 8 or above)
- Gradle
- Internet connection

## How to Run
1. Clone the repository or download the ZIP file.
2. Navigate to the project directory in the terminal.
3. Run the following commands:
   ```
   gradle build
   gradle run
   ```
   

## Dependencies
- YahooFinanceAPI: A Java library to fetch stock market data.

## License
MIT License
