package cz.fi.muni.pa165.currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Currency;


/**
 * This is base implementation of {@link CurrencyConvertor}.
 *
 * @author petr.adamek@embedit.cz
 */
public class CurrencyConvertorImpl implements CurrencyConvertor {

    private final ExchangeRateTable exchangeRateTable;
    private final Logger logger = LoggerFactory.getLogger(CurrencyConvertorImpl.class);

    public CurrencyConvertorImpl(ExchangeRateTable exchangeRateTable) {

        this.exchangeRateTable = exchangeRateTable;
    }

    @Override
    public BigDecimal convert(Currency sourceCurrency, Currency targetCurrency, BigDecimal sourceAmount)
    {
        if(sourceCurrency == null || targetCurrency == null){
            throw new IllegalArgumentException("Heloo null");
        }
        if(sourceAmount == null){
            logger.warn("nieco spadlo hahas");
            throw new IllegalArgumentException("bad rate");
        }

        try {
            return exchangeRateTable.getExchangeRate(sourceCurrency, targetCurrency);
        } catch (ExternalServiceFailureException e) {
            logger.warn("error");
        }

        return null;
    }

}
