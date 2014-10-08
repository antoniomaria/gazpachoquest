/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.api;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairePageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

@Path("/questionnaires")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface QuestionnaireResource extends Serializable {

    @GET
    @Path("/{questionnaireId}/definition")
    QuestionnaireDefinitionDTO getDefinition(@PathParam("questionnaireId") Integer questionnaireId);

    @GET
    @Path("/{questionnaireId}/page")
    QuestionnairePageDTO getPage(@PathParam("questionnaireId") Integer questionnaireId,
            @QueryParam("mode") RenderingMode mode, @QueryParam("preferredLanguage") Language language,
            @QueryParam("action") NavigationAction action);

    @POST
    @Path("/{questionnaireId}/answer")
    void saveAnswer(Answer answer, @PathParam("questionnaireId") Integer questionnaireId,
            @QueryParam("questionCode") String questionCode);
}
