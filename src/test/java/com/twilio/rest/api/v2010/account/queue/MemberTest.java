/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class MemberTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.API.toString(),
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members/CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Member.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"call_sid\": \"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_enqueued\": \"Tue, 07 Aug 2012 22:57:41 +0000\",\"position\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members/CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\",\"wait_time\": 143}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Member.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testUpdateRequest() {
                    new NonStrictExpectations() {{
                        Request request = new Request(HttpMethod.POST,
                                                      Domains.API.toString(),
                                                      "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members/CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json");
                        request.addPostParam("Url", serialize(URI.create("https://example.com")));
        request.addPostParam("Method", serialize(HttpMethod.GET));
                        twilioRestClient.request(request);
                        times = 1;
                        result = new Response("", 500);
                        twilioRestClient.getAccountSid();
                        result = "AC123";
                    }};
        
        try {
            Member.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", URI.create("https://example.com"), HttpMethod.GET).execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"call_sid\": \"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_enqueued\": \"Tue, 07 Aug 2012 22:57:41 +0000\",\"position\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members/CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\",\"wait_time\": 143}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Member.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", URI.create("https://example.com"), HttpMethod.GET).execute();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.API.toString(),
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Member.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json?Page=0&PageSize=50\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json?Page=0&PageSize=50\",\"next_page_uri\": null,\"num_pages\": 1,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"queue_members\": [{\"call_sid\": \"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_enqueued\": \"Tue, 07 Aug 2012 22:57:41 +0000\",\"position\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members/CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\",\"wait_time\": 124}],\"start\": 0,\"total\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Member.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json?Page=0&PageSize=50\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json?Page=0&PageSize=50\",\"next_page_uri\": null,\"num_pages\": 1,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"queue_members\": [],\"start\": 0,\"total\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Queues/QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Members.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Member.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "QUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }
}