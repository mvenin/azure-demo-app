package ro.mve.yql;

import lombok.NonNull;
import ro.mve.util.LocalhostConfig;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author veninma
 */
public class EuronextScrapper {
	static {
		LocalhostConfig.setProxyOnLocalHost();
	}

	private static final String tUrl = "https://live.euronext.com/en/product/equities/%s-%s/market-information";

	public static void main(String[] args) {
		bel20().forEach(t->System.out.println(t.xlsToString()));
	}

	public static List<Stock> bel20() {
		List<Stock> bel20 = null;
		try {
			bel20 = Files.readAllLines(Paths.get(EuronextScrapper.class.getResource("/euronext/bel20.txt").toURI()))
					.stream().filter(t -> t.contains("/"))
					.map(t -> {String[] arr = t.split("/"); return Stock.of(arr[0].trim(),arr[1].trim());})
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if(bel20 != null){
			bel20.forEach(t -> t.setIcbSector(extractICBSectors(t, StockMarket.XBRU)));
			return bel20;
		}
		return Collections.emptyList();
	}

	/**
	 * @param stock
	 * @param marketId
	 * @return
	 */
	public static ICBSector extractICBSectors(@NonNull  Stock stock, @NonNull  StockMarket marketId){
		JsoupExtractor jsExtractor = new JsoupExtractor(String.format(tUrl, stock.getIsin(), marketId));
		return jsExtractor.extractICBSector();
	}


}
