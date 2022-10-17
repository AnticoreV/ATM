package sapronov.atm.model;

import sapronov.atm.parser.CurrencyRateParser;

public class CurrencyRate {
    private String currency = CurrencyRateParser.parse();

    public String getCurrency() {
        return currency;
    }
}
