package ro.mve.yql;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ro.mve.util.LocalhostConfig;
import ro.mve.util.TimeLimiter;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.xml.transform.Source;
import java.math.BigDecimal;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author veninma
 */
public class YahooService {
	static {
		LocalhostConfig.setProxyOnLocalHost();
	}

	public static void main(String[] args) throws Exception {
		Stock stock = YahooFinance.get("AGS.BR");
		BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal marketCap = stock.getStats().getMarketCap();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		stock.print();

		List<String> tiks = Files.readAllLines(Paths.get("c:\\Downloads\\bel20.txt"))
				.stream().filter(t -> t.contains("/"))
				.map(t -> t.split("/")[0].trim())
				.collect(Collectors.toList());
		String[] symbols = tiks.toArray(new String[0]);
		Map<String, Stock> stockMap = YahooFinance.get(symbols);

//		stockMap.keySet().stream().forEach(t-> stockMap.get(t).print());
//		stockMap.keySet().stream().forEach(t-> System.out.println("EBR:"+t));

	}


	public static void main2(String[] args) throws Exception {
//		new YahooService().jsoup(new URI("https://query1.finance.yahoo.com/v7/finance/quote?symbols=INTC"));
	}

	public static void main1(String[] args) throws Exception {
		URL url = new URL("https://query1.finance.yahoo.com/v7/finance/quote?symbols=INTC");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("147.67.138.13", 8012));
		URLConnection con = url.openConnection(proxy);
		con.getInputStream();
	}


}
