# 🎸 CryptoPriceAlert: Real-Time Price Monitor & Alert System

A high-performance Java application that monitors cryptocurrency prices via the **CoinGecko API** and triggers real-time alerts, including a heavy metal audio notification when price thresholds are met.

## 🚀 Features
- **Real-Time Monitoring**: Fetches live BTC prices every 10 seconds using a `ScheduledExecutorService`.
- **Observer Pattern Logic**: Uses Java Streams to filter and trigger multiple price alerts simultaneously.
- **Hardware Integration**: Custom `AudioPlayer` utility using the Java Sound API (`javax.sound.sampled`) to play `.wav` files.
- **Secure Configuration**: Integrated `dotenv-java` to keep API keys safe and out of source control.
- **Clean Architecture**: Utilizes Java 21 **Records** for immutable data modeling and **Jackson** for nested JSON parsing.

---

## 🛠️ Tech Stack
- **Language**: Java 21
- **API**: [CoinGecko Demo API](https://www.coingecko.com/en/api)
- **Libraries**:
    - `Jackson Databind` (JSON Parsing)
    - `Dotenv Java` (Environment Variables)
    - `Standard Java HttpClient` (Asynchronous Requests)

---

## 📋 Prerequisites
1. **Java 21** or higher.
2. **Maven** for dependency management.
3. A **CoinGecko API Key** (Free Demo Tier).
4. A `.wav` sound file located in `resources/scream.wav`.

---

## ⚙️ Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/dev-kweku/CryptoPriceAlert.git](https://github.com/dev-kweku/CryptoPriceAlert)
   cd CryptoScream