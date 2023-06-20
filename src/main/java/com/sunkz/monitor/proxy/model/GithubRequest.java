package com.sunkz.monitor.proxy.model;

import com.sunkz.common.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GithubRequest {

    private String message;
    private Committer committer;
    private String content;

    public static GithubRequest build(String content) {
        GithubRequest request = new GithubRequest();
        request.setMessage(TimeUtil.now(TimeUtil.PATTERN_3));
        request.setCommitter(new Committer(System.getProperty("user.name"), "Your Email"));
        request.setContent(content);
        return request;
    }

    @Data
    @AllArgsConstructor
    private static class Committer {
        private String name;
        private String email;
    }

}
