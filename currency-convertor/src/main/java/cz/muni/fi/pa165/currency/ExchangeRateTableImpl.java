package cz.muni.fi.pa165.currency;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

/**
 * @author rba on 06.10.2016.
 */

@Service
public class ExchangeRateTableImpl implements ExchangeRateTable {

    @Override public BigDecimal getExchangeRate(Currency sourceCurrency, Currency targetCurrency)
        throws ExternalServiceFailureException {
        if (sourceCurrency != null && targetCurrency != null) {
            if(Objects.equals(sourceCurrency.getCurrencyCode(), "EUR")
                && Objects.equals(targetCurrency.getCurrencyCode(), "CZK")) {
                return new BigDecimal("27");
            } else {
                return null;
            }
        } else {
            throw new ExternalServiceFailureException("No vlaida data");
        }
    }
}
