package net.sf.gazpachoquest.questionnaires.renderer.question;

import net.sf.gazpachoquest.dto.QuestionDTO;

import com.vaadin.ui.Panel;

public interface Renderer {

    Panel render(QuestionDTO questionDTO);
}
