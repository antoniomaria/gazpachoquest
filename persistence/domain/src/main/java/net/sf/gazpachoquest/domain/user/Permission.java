package net.sf.gazpachoquest.domain.user;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.jpa.converter.EntityTypeConverter;
import net.sf.gazpachoquest.types.EntityType;
import net.sf.gazpachoquest.types.Perm;

@Entity
public class Permission extends AbstractPersistable {

	private static final long serialVersionUID = 6599066653542691509L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Role role;

	@Convert(converter = EntityTypeConverter.class)
	private EntityType scope;

	private Integer numeral;

	private Integer entityId;

	public Permission() {
		super();
	}

	public EntityType getScope() {
		return scope;
	}

	public void setScope(EntityType scope) {
		this.scope = scope;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getNumeral() {
		return numeral;
	}

	public void setNumeral(Integer numeral) {
		this.numeral = numeral;
	}

	public static Builder with() {
		return new Builder();
	}

	public String getLiteral() {
		return new StringBuilder().append(scope.getLabel()).append(":")
				.append(Perm.getLiteral(numeral)).append(":").append(entityId)
				.toString();
	}

	public static class Builder {
		private Integer id;
		private int numeral;
		private Integer entityId;
		private EntityType scope;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder numeral(int numeral) {
			this.numeral = numeral;
			return this;
		}

		public Builder entityId(Integer entityId) {
			this.entityId = entityId;
			return this;
		}

		public Builder scope(EntityType scope) {
			this.scope = scope;
			return this;
		}

		public Builder addPerm(Perm perm) {
			if ((numeral & perm.getNumeral()) != perm.getNumeral()) {
				numeral += perm.getNumeral();
			}
			return this;

		}

		public Permission build() {
			Permission permission = new Permission();
			permission.setId(id);
			permission.numeral = numeral;
			permission.entityId = entityId;
			permission.scope = scope;
			return permission;
		}

	}

}
