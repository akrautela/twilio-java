/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.fax.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class FaxCreator extends Creator<Fax> {
    private final String to;
    private final URI mediaUrl;
    private Fax.Quality quality;
    private URI statusCallback;
    private String from;
    private String sipAuthUsername;
    private String sipAuthPassword;

    /**
     * Construct a new FaxCreator.
     * 
     * @param to The to
     * @param mediaUrl The media_url
     */
    public FaxCreator(final String to, 
                      final URI mediaUrl) {
        this.to = to;
        this.mediaUrl = mediaUrl;
    }

    /**
     * The quality.
     * 
     * @param quality The quality
     * @return this
     */
    public FaxCreator setQuality(final Fax.Quality quality) {
        this.quality = quality;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public FaxCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The status_callback.
     * 
     * @param statusCallback The status_callback
     * @return this
     */
    public FaxCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The from.
     * 
     * @param from The from
     * @return this
     */
    public FaxCreator setFrom(final String from) {
        this.from = from;
        return this;
    }

    /**
     * The sip_auth_username.
     * 
     * @param sipAuthUsername The sip_auth_username
     * @return this
     */
    public FaxCreator setSipAuthUsername(final String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
        return this;
    }

    /**
     * The sip_auth_password.
     * 
     * @param sipAuthPassword The sip_auth_password
     * @return this
     */
    public FaxCreator setSipAuthPassword(final String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Fax
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Fax create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.FAX.toString(),
            "/v1/Faxes",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Fax creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Fax.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to);
        }

        if (mediaUrl != null) {
            request.addPostParam("MediaUrl", mediaUrl.toString());
        }

        if (quality != null) {
            request.addPostParam("Quality", quality.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (from != null) {
            request.addPostParam("From", from);
        }

        if (sipAuthUsername != null) {
            request.addPostParam("SipAuthUsername", sipAuthUsername);
        }

        if (sipAuthPassword != null) {
            request.addPostParam("SipAuthPassword", sipAuthPassword);
        }
    }
}