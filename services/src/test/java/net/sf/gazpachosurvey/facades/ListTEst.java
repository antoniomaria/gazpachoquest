package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;

public class ListTEst {

    @Test
    public void listLabelSetTest() {
        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN).name("Feelings").build();
        LabelDTO label1 = LabelDTO.with().id(1).title("Agree strongly").build();
        LabelDTO label2 = LabelDTO.with().id(2).title("Agree strongly").build();
        LabelDTO label3 = LabelDTO.with().id(3).title("Agree strongly").build();

        labelSet.addLabel(1, label1);
        labelSet.addLabel(1, label2);
        labelSet.addLabel(3, label3);

        System.out.println(labelSet.getLabels());
        labelSet.swapLabel(0, 2);

        System.out.println(labelSet.getLabels());

    }

}
