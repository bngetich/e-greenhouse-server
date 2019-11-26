package com.brian.egreenhouse.web.rest.client;

import com.brian.egreenhouse.domain.Channel;
import com.brian.egreenhouse.domain.Feed;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThinkSpeakJsonResponse {

    public Channel channel;
    public List<Feed> feeds;

}
