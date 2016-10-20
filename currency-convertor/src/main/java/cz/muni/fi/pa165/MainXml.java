package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author rba on 06.10.2016.
 */

public class MainXml {

    public static void main(String ...args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/WEB-INF/springapp-servlet.xml");
        CurrencyConvertor currencyConvertor = applicationContext.getBean(CurrencyConvertor.class);
        // vypíšeme zprávu
        Currency czk=  Currency.getInstance("CZK");
        Currency euro = Currency.getInstance("EUR");

        String value = currencyConvertor.convert(euro, czk, new BigDecimal("100")).toString();
        System.out.println(value);
        currencyConvertor.convert(euro, czk, new BigDecimal("100")).toString();

    }


}
