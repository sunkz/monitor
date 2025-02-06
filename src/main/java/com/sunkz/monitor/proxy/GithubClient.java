package com.sunkz.monitor.proxy;

import com.sunkz.monitor.proxy.model.GithubRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "github-client", url = "https://api.github.com")
public interface GithubClient {

    /**
     * <a href="https://docs.github.com/en/rest/repos/contents?apiVersion=2022-11-28">...</a>
     */
    @PutMapping(value = "/repos/${monitor.user}/${monitor.repo}/contents/{path}", headers = {"Accept=application/vnd.github+json", "X-GitHub-Api-Version=2022-11-28", "Authorization=Bearer ${monitor.token}"})
    void putContent(@PathVariable("path") String path, @RequestBody GithubRequest request);

}
