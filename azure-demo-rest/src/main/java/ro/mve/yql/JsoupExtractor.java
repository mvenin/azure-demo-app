package ro.mve.yql;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@Data
public class JsoupExtractor {

	private Document doc;
	private String htmlDoc;
	private ICBSector icbSector = new ICBSector();

	public JsoupExtractor(String url) {
		try {
			this.doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Macintosh;") //
					.header("Content-Language", "en-US") //
					.get();
			this.htmlDoc = doc.html();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ICBSector extractICBSector() {
		this.doc.select("div.card").stream().forEach(c -> {
			Elements cardHeader = c.select("div.card-header h3");
			if (!cardHeader.isEmpty()) {
				String cardHeaderText = cardHeader.text();
				if (cardHeaderText.startsWith("ICB")) {
					c.select("div.card-body tr").stream().forEach(t->{
						Elements tds = t.select("td");
						String sectorId = tds.get(0).text();
						String sectorValue = tds.get(1).text();
						icbSector.of(sectorId,sectorValue);
					});
				}
			}
		});
		return icbSector;
	}

}
