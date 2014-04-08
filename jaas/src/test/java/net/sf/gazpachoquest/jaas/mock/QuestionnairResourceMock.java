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
package net.sf.gazpachoquest.jaas.mock;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.cxf.jaxrs.client.Client;

public class QuestionnairResourceMock implements Client, QuestionnairResource {

    private static final long serialVersionUID = 8761502326075822046L;

    private List<QuestionnairDTO> questionnairDTOs;

    public QuestionnairResourceMock() {
        super();
        this.questionnairDTOs = new ArrayList<>();
    }

    public List<QuestionnairDTO> getQuestionnairDTOs() {
        return questionnairDTOs;
    }

    public void setQuestionnairDTOs(List<QuestionnairDTO> questionnairDTOs) {
        this.questionnairDTOs = questionnairDTOs;
    }

    @Override
    public List<QuestionnairDTO> list() {
        return questionnairDTOs;
    }

    @Override
    public PageDTO getPage(Integer questionnairId, RenderingMode mode, BrowsingAction action) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client type(MediaType ct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client type(String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client accept(MediaType... types) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client accept(String... types) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client language(String language) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client acceptLanguage(String... languages) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client encoding(String encoding) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client acceptEncoding(String... encodings) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client match(EntityTag tag, boolean ifNot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client modified(Date date, boolean ifNot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client cookie(Cookie cookie) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client header(String name, Object... values) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client headers(MultivaluedMap<String, String> map) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client reset() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MultivaluedMap<String, String> getHeaders() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public URI getBaseURI() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public URI getCurrentURI() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response getResponse() {
        // TODO Auto-generated method stub
        return null;
    }

}
