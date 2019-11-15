package ro.mve.yql;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {
	private String symbol;
	private String isin;
	private String name;
	private String currency;
	private ICBSector icbSector;
	private BigDecimal marketCap;


	public Stock(String symbol, String isin) {
		this.symbol = symbol;
		this.isin = isin;
	}

	public static Stock of(String symbol, String isin) {
		return new Stock(symbol, isin);
	}

	public String xlsToString() {
		return "";
	}
}


