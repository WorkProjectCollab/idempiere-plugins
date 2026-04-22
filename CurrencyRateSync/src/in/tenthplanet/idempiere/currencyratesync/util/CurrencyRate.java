package in.tenthplanet.idempiere.currencyratesync.util;

public class CurrencyRate {
    private String date;
    private String base;
    private String quote;
    private double rate;

    // Getters and Setters
    public String getDate()        { return date; }
    public String getBase()        { return base; }
    public String getQuote()       { return quote; }
    public double getRate()        { return rate; }

    public void setDate(String date)   { this.date = date; }
    public void setBase(String base)   { this.base = base; }
    public void setQuote(String quote) { this.quote = quote; }
    public void setRate(double rate)   { this.rate = rate; }

}
