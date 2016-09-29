package cz.fi.muni.pa165.currency;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Currency;

import static org.mockito.Mockito.when;

public class CurrencyConvertorImplTest {


    @Test(expected = UnsupportedOperationException.class)
    public void testConvert() throws ExternalServiceFailureException {
        // Don't forget to test border values and proper rounding.
        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        BigDecimal number = new BigDecimal("20");

        when(currencyConvertor.convert(Currency.getInstance("CZK"), Currency.getInstance("EUR"), number))
            .thenThrow(UnsupportedOperationException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithNullSourceCurrency() throws ExternalServiceFailureException {
        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);
        BigDecimal number = new BigDecimal("20");
        Currency eur = Currency.getInstance("EUR");
        Currency czk = null;
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);

        when(currencyConvertor.convert(eur, czk, number ))
            .thenThrow(IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithNullTargetCurrency() throws ExternalServiceFailureException {
        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);
        BigDecimal number = new BigDecimal("20");
        Currency eur =  null;
        Currency czk = Currency.getInstance("EUR");
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        when(currencyConvertor.convert(eur, czk, number ))
            .thenThrow(IllegalArgumentException.class);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertWithNullSourceAmount() throws ExternalServiceFailureException {
        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);

        BigDecimal number = null;
        Currency eur = Currency.getInstance("CZK");
        Currency czk = Currency.getInstance("EUR");
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        when(currencyConvertor.convert(eur, czk, number ))
            .thenThrow(IllegalArgumentException.class);
    }

    @Test(expected = UnknownExchangeRateException.class)
    public void testConvertWithUnknownCurrency() throws ExternalServiceFailureException {
        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);

        BigDecimal number =  new BigDecimal("20");
        Currency eur = Currency.getInstance("CYYYZK");
        Currency czk = Currency.getInstance("EUR");
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        when(currencyConvertor.convert(eur, czk, number ))
            .thenThrow(UnknownExchangeRateException.class);
    }

    @Test(expected = ExternalServiceFailureException.class)
    public void testConvertWithExternalServiceFailure() throws ExternalServiceFailureException {

        ExchangeRateTable exchangeRateTable = Mockito.mock(ExchangeRateTable.class);

        BigDecimal number =  new BigDecimal("20");
        Currency eur = Currency.getInstance("CZK");
        Currency czk = Currency.getInstance("EUR");
        CurrencyConvertor currencyConvertor = new CurrencyConvertorImpl(exchangeRateTable);
        when(currencyConvertor.convert(eur, czk, number))
            .thenThrow(ExternalServiceFailureException.class);
    }

}
