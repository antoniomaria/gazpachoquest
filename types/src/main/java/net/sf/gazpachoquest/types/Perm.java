package net.sf.gazpachoquest.types;

import java.util.ArrayList;
import java.util.List;

public enum Perm {

    READ(1, "read"), UPDATE(2, "update"), DELETE(4, "delete");

    private int mask;
    private String literal;

    Perm(int mask, String literal) {
        this.mask = mask;
        this.literal = literal;
    }

    public int getMask() {
        return mask;
    }

    public static String getLiteral(int mask) {
        Perm values[] = Perm.values();
        List<String> literals = new ArrayList<String>();
        for (int idx = 0; idx < values.length; idx++) {
            Perm value = values[idx];
            if ((mask & value.getMask()) == value.getMask()) {
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
        return (this.mask & numeral) == numeral;
    }

}
