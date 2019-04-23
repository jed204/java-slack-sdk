package com.github.seratch.jslack;

import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileGetRequest;
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileSetRequest;
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileGetResponse;
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileSetResponse;
import com.github.seratch.jslack.api.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import testing.Constants;
import testing.SlackTestConfig;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@Slf4j
public class Slack_users_profile_Test {

    Slack slack = Slack.getInstance(SlackTestConfig.get());

    @Test
    public void usersProfile() throws IOException, SlackApiException {
        String token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN);

        {
            UsersProfileGetResponse response = slack.methods().usersProfileGet(UsersProfileGetRequest.builder().token(token).build());
            assertThat(response.getError(), is(nullValue()));
            assertThat(response.isOk(), is(true));
            assertThat(response.getProfile(), is(notNullValue()));
        }

        {
            UsersProfileSetResponse response = slack.methods().usersProfileSet(
                    UsersProfileSetRequest.builder().token(token).name("skype").value("skype-" + System.currentTimeMillis()).build());
            assertThat(response.getError(), is(nullValue()));
            assertThat(response.isOk(), is(true));
            assertThat(response.getProfile(), is(notNullValue()));
        }

        {
            User.Profile profile = new User.Profile();
            profile.setSkype("skype-" + System.currentTimeMillis());
            UsersProfileSetResponse response = slack.methods().usersProfileSet(
                    UsersProfileSetRequest.builder().token(token).profile(profile).build());
            assertThat(response.getError(), is(nullValue()));
            assertThat(response.isOk(), is(true));
            assertThat(response.getProfile(), is(notNullValue()));
        }
    }

}