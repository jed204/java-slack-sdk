package com.slack.api.methods.response.usergroups;

import com.slack.api.methods.SlackApiTextResponse;
import com.slack.api.model.Usergroup;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UsergroupsCreateResponse implements SlackApiTextResponse {

    private boolean ok;
    private String warning;
    private String error;
    private String needed; // "usergroups:write"
    private String provided; // some permissions
    private transient Map<String, List<String>> httpResponseHeaders;

    private Usergroup usergroup;
}