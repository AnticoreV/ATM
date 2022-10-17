package sapronov.atm.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurrencyRateParser {
    public static String parse(){
        Elements p = null;
        try{
            Document doc = Jsoup.connect("https://www.xe.com/currencycharts/?from=USD&to=EUR&view=1Y").get();
            p = doc.select("p");
        }catch (Exception e){
            e.printStackTrace();
        }
        return p.text();
    }
}
