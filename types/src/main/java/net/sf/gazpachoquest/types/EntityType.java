package net.sf.gazpachoquest.types;

public enum EntityType {

	QUESTIONNAIR("Q", "questionnair");

	private String code;
	private String label;

	EntityType(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}
	public String getLabel() {
		return label;
	}

	public static EntityType fromCode(String code) {
		switch (code) {
		case "Q":
			return QUESTIONNAIR;
		default:
			throw new IllegalArgumentException("Unknown" + code);
		}
	}

}
