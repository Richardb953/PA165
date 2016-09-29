package cz.fi.muni.pa165.currency;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author rba on 29.09.2016.
 */
public class ExchangeRateTableImpl implements ExchangeRateTable {
    @Override public BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency)
        throws ExternalServiceFailureException, UnsupportedOperationException {
        if(!Currency.getAvailableCurrencies().contains(sourceCurrency) || !Currency.getAvailableCurrencies().contains(targetCurrency)){
            throw new ExternalServiceFailureException("neexistuje rate");
        }
        throw  new UnsupportedOperationException("nehehe");
    }
}
