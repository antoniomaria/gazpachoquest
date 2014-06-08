package net.sf.gazpachoquest.dto.answers;

public class BlankAnswer extends AbstractAnswer {

	private static final long serialVersionUID = 8164989374494030339L;

	private String value;

	@Override
	public Object getValue() {
		return value;
	}

	public static BlankAnswer create() {
		return new BlankAnswer();
	}

	@Override
	public String toString() {
		return "BlankAnswer [value=" + value + "]";
	}

	public static class Builder {
		private String value;

		public Builder value(String value) {
			this.value = value;
			return this;
		}

		public BlankAnswer build() {
			BlankAnswer blankAnswer = new BlankAnswer();
			blankAnswer.value = value;
			return blankAnswer;
		}
	}
}
