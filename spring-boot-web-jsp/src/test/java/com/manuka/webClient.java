package com.manuka;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class webClient {
	
	private WebClient webClient;
	 
	@Before
	public void init() throws Exception {
	    webClient = new WebClient();
	}
	 
	@After
	public void close() throws Exception {
	    webClient.close();
	}
	 
	@Test
	public void homePage() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	        Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

	        final String pageAsXml = page.asXml();
	        Assert.assertTrue(pageAsXml.contains("<body class=\"topBarDisabled\">"));

	        final String pageAsText = page.asText();
	        Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	        
	        Assert.assertNotNull(page.getElementByName("viewport"));	        
	    }
	}


}
