package calculator.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import calculator.services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	
	@Value("${application.url.nbpCurrencyRates}")
	String CURRENCY_RATES_URL;
	
	@Value("${application.xpath.currencyQuery}")
	String CURRENCY_XPATH;
	
	@Value("${application.xpath.currencyCode}")
	String CURRENCY_CODE;
	
	public float getExchangeRateFor(String currencyCode) throws IOException, Exception {
		
		URL url = new URL(CURRENCY_RATES_URL);
        URLConnection connection = url.openConnection();
        Document doc = parseXML(connection.getInputStream());
        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = CURRENCY_XPATH.replace(CURRENCY_CODE, currencyCode);
		String rate = xPath.compile(expression).evaluate(doc);
		
        return Float.parseFloat(rate.replace(',', '.'));
	}
	
	private Document parseXML(InputStream stream) throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
    }
}
