package ro.mve.yql;

public enum StockMarket {
	XAMS("Amsterdam", "nl", "AMS:"),
	XBRU("Brussels", "be", "EBR:"),
	XPAR("Paris", "fr", "EPA:"),
	XETR("Frankfurt", "de", "ETR:"),
	XLIS("Lisbon", "pt", "ELI:");

	private String marketName;
	private String countryCode;
	private String googlePrefix;

	private StockMarket(String marketName, String countryCode, String googlePrefix) {
		this.marketName = marketName;
		this.countryCode = countryCode;
		this.googlePrefix = googlePrefix;
	}

	public String googlePrefix() {
		return super.toString();
	}
}