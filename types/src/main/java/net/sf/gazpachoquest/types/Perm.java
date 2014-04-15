package net.sf.gazpachoquest.types;

import java.util.ArrayList;
import java.util.List;

public enum Perm {

	READ(1, "read"), UPDATE(2, "update"), DELETE(4, "delete");

	private int numeral;
	private String literal;

	Perm(int numeral, String literal) {
		this.numeral = numeral;
		this.literal = literal;
	}

	public int getNumeral() {
		return numeral;
	}

	public static String getLiteral(int numeral) {
		Perm values[] = Perm.values();
		List<String> literals = new ArrayList<String>();
		for (int idx = 0; idx < values.length; idx++) {
			Perm value = values[idx];
			if ((numeral & value.getNumeral()) == value.getNumeral()) {
				literals.add(value.literal);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int idx = 0; idx < literals.size(); idx++) {
			builder.append(literals.get(idx));
			if (idx != literals.size() - 1) {
				builder.append(",");
			}
		}
		return builder.toString();
	}

	public boolean imply(int numeral) {
		return (this.numeral & numeral) == numeral;
	}

}
