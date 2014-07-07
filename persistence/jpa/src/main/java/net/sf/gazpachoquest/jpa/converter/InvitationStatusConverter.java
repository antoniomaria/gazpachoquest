package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.InvitationStatus;

@Converter(autoApply = true)
public class InvitationStatusConverter implements AttributeConverter<InvitationStatus, String> {

    @Override
    public String convertToDatabaseColumn(InvitationStatus status) {
        return status == null ? InvitationStatus.ACTIVE.getCode() : status.getCode();
    }

    @Override
    public InvitationStatus convertToEntityAttribute(String code) {
        return InvitationStatus.fromCode(code);
    }

}
