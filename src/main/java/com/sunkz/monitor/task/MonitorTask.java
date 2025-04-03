package com.sunkz.monitor.task;

import cn.hutool.core.codec.Base64;
import com.sunkz.common.util.FileUtil;
import com.sunkz.common.util.ImageUtil;
import com.sunkz.common.util.TimeUtil;
import com.sunkz.monitor.proxy.GithubClient;
import com.sunkz.monitor.proxy.model.GithubRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MonitorTask {

    @NonNull
    private final GithubClient githubClient;

    private BufferedImage pre;

    @SneakyThrows
    @Scheduled(fixedDelayString = "${monitor.frequency}")
    public void monitor() {
        BufferedImage curr = FileUtil.captureScreen();
        if (!ImageUtil.isSame(pre, curr)) {
            upload(curr);
            pre = curr;
        }
    }

    public void upload(BufferedImage image) throws IOException {
        File file = new File(System.getProperty("user.name") + TimeUtil.now(TimeUtil.PATTERN_3) + ".jpg");
        ImageIO.write(image, "jpg", file);
        String encode = Base64.encode(file);
        cn.hutool.core.io.FileUtil.del(file);
        githubClient.putContent(file.getName(), GithubRequest.build(encode));
    }

}
