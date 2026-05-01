package org.crypto;

public class Main {
    public static void main(String[] args) {
        PriceMonitor monitor=new PriceMonitor();

        monitor.addAlert(new CryptoPriceAlert("BTC MOON SHORT",78000.0,true));
        monitor.addAlert(new CryptoPriceAlert("BUY THE DIP",72000.0,false));
        monitor.start();

    }
}