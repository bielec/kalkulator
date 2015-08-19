package calculator.services;

import java.io.IOException;

public interface CurrencyExchangeService {

	public float getExchangeRateFor(String currencyCode) throws IOException, Exception;
}
