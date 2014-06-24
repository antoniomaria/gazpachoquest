package net.sf.gazpachoquest.types;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class PermsTest {

    @Test
    public void getLiteralTest() {
        System.out.println("eho");
        String literal = Perm.getLiteral(Perm.READ.getMask() + Perm.UPDATE.getMask() + Perm.DELETE.getMask());
        assertThat(literal).isEqualTo("read,update,delete");
    }

}
