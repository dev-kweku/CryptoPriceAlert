package org.crypto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PriceMonitor {
    private final CryptoService service=new CryptoService();
    private final List<CryptoPriceAlert> alerts=new ArrayList<>();
    private final ScheduledExecutorService scheduler= Executors.newSingleThreadScheduledExecutor();

    public void addAlert(CryptoPriceAlert alert){
        alerts.add(alert);

    }

    public void start(){
        System.out.println("Starting crypto monitoring.....");
        scheduler.scheduleAtFixedRate(()->{
            try{
                double price=service.fetchDataPrice("bitcoin","usd");
                System.out.println("Current BTC Price: USD " + price);

                alerts.stream()
                        .filter(alert -> alert.isTriggered(price))
                        .forEach(alert -> {
                            System.out.println("ALERT TRIGGERED : " + alert.getName());
                            AudioPlayer.playScream();
                        });


        }catch(Exception e){
            System.out.println("Monitoring error : " + e.getMessage());
        }
        },0,10,TimeUnit.SECONDS);
    }
}
