package com.slack.api.methods.response.admin.teams.settings;

import com.slack.api.methods.SlackApiTextResponse;
import com.slack.api.model.Team;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AdminTeamsSettingsInfoResponse implements SlackApiTextResponse {

    private boolean ok;
    private String warning;
    private String error;
    private String needed;
    private String provided;
    private transient Map<String, List<String>> httpResponseHeaders;

    private Team team;
}