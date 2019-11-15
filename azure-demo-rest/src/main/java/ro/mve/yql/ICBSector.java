package ro.mve.yql;

import lombok.Data;
import lombok.NonNull;

@Data
public class ICBSector {
	private String industry;
	private String superSector;
	private String sector;
	private String subsector;

	public ICBSector of(@NonNull String icbId, @NonNull String icbValue) {
		switch (icbId.toLowerCase()) {
		case "industry":
			this.industry = icbValue;
			break;
		case "supersector":
			this.superSector = icbValue;
			break;
		case "sector":
			this.sector = icbValue;
			break;
		case "subsector":
			this.subsector = icbValue;
			break;
		}
		return this;
	}

	@Override public String toString() {
		return "ICBSector{" +
				"industry='" + industry + '\'' +
				", superSector='" + superSector + '\'' +
				", sector='" + sector + '\'' +
				", subsector='" + subsector + '\'' +
				'}';
	}
}