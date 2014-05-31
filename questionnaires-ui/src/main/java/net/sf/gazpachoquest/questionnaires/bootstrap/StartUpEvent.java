package net.sf.gazpachoquest.questionnaires.bootstrap;

import java.io.Serializable;
import java.util.Properties;

public class StartUpEvent implements Serializable {
	private static final long serialVersionUID = 7352233383288297183L;
	private Properties properties;

	public StartUpEvent() {
		super();
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static Builder with(){
		return new Builder();
	}
	public static class Builder {
		private Properties properties;

		public Builder properties(Properties properties) {
			this.properties = properties;
			return this;
		}

		public StartUpEvent build() {
			StartUpEvent startUpEvent = new StartUpEvent();
			startUpEvent.properties = properties;
			return startUpEvent;
		}
	}
}
