/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.fetcher.lookups.v1;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.lookups.v1.PhoneNumber;

public class PhoneNumberFetcher extends Fetcher<PhoneNumber> {
    private final com.twilio.sdk.type.PhoneNumber phoneNumber;
    private String countryCode;
    private String type;

    /**
     * Construct a new PhoneNumberFetcher.
     * 
     * @param phoneNumber The phone_number
     */
    public PhoneNumberFetcher(final com.twilio.sdk.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * The country_code.
     * 
     * @param countryCode The country_code
     * @return this
     */
    public PhoneNumberFetcher setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The type.
     * 
     * @param type The type
     * @return this
     */
    public PhoneNumberFetcher setType(final String type) {
        this.type = type;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched PhoneNumber
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PhoneNumber execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.LOOKUPS,
            "/v1/PhoneNumbers/" + this.phoneNumber + "",
            client.getAccountSid()
        );
        
        if (countryCode != null) {
            request.addQueryParam("CountryCode", countryCode);
        }
        
        if (type != null) {
            request.addQueryParam("Type", type);
        }
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("PhoneNumber fetch failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
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
        
        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }
}