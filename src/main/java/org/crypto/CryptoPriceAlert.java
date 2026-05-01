package org.crypto;

public class CryptoPriceAlert {
    private final String name;
    private final double targetPrice;
    private final boolean alertIfAbove;

    public CryptoPriceAlert(String name,double targetPrice,boolean alertIfAbove){
        this.name=name;
        this.targetPrice=targetPrice;
        this.alertIfAbove=alertIfAbove;
    }
    public boolean isTriggered(double currentPrice){
        if(alertIfAbove){
            return currentPrice >= targetPrice;
        }else {
            return currentPrice<=targetPrice;
        }
    }

    public String getName(){return name;}

}
