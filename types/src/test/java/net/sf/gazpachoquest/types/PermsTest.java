package net.sf.gazpachoquest.types;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class PermsTest {

	@Test
	public void getLiteralTest() {
		System.out.println("eho");
		String literal = Perm.getLiteral(Perm.READ.getNumeral()
				+ Perm.UPDATE.getNumeral() + Perm.DELETE.getNumeral());
		assertThat(literal).isEqualTo("read,update,delete");
	}

}
