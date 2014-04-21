package net.sf.gazpachoquest.jaas.mock;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import net.sf.gazpachoquest.api.AuthenticationResource;
import net.sf.gazpachoquest.dto.auth.Account;

import org.apache.cxf.jaxrs.client.Client;

public class AuthenticationResourceMock implements Client,
		AuthenticationResource {

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

	@Override
	public Account authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
