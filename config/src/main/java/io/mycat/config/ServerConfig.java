/**
 * Copyright (C) <2019>  <gaozhiwen>
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program.  If
 * not, see <http://www.gnu.org/licenses/>.
 */

package io.mycat.config;

import io.mycat.util.JsonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Data
@EqualsAndHashCode
public class ServerConfig {
    private int mycatId = 1;
    private String ip = "127.0.0.1";
    private int port = 8066;
    private int reactorNumber = Runtime.getRuntime().availableProcessors();
    private ThreadPoolExecutorConfig workerPool = ThreadPoolExecutorConfig
            .builder()
            .corePoolSize(Runtime.getRuntime().availableProcessors())
            .maxPoolSize(1024)
            .keepAliveTime(1)
            .timeUnit(TimeUnit.MINUTES.name())
            .maxPendingLimit(65535)
            .taskTimeout(1)
            .build();
    private ThreadPoolExecutorConfig timeWorkerPool = ThreadPoolExecutorConfig
            .builder()
            .corePoolSize(0)
            .maxPoolSize(2)
            .keepAliveTime(1)
            .timeUnit(TimeUnit.MINUTES.name())
            .maxPendingLimit(65535)
            .taskTimeout(1)
            .build();
    private BufferPoolConfig bufferPool = new BufferPoolConfig();
    private TimerConfig idleTimer = new TimerConfig(3, 15, TimeUnit.SECONDS.name());
    private String tempDirectory;

    public String getTempDirectory() {
        String mycat_temp_directory = "mycat_temp_directory";
        if (tempDirectory == null) {
            try {
                Path target = Optional.ofNullable(ServerConfig.class.getClassLoader())
                        .map(i -> i.getResource(""))
                        .map(i -> {
                            try {
                                return i.toURI();
                            } catch (URISyntaxException e) {
                                return null;
                            }
                        })
                        .map(i -> i.resolve("target"))
                        .map(Paths::get)
                        .orElse(null);
                if (target != null && Files.exists(target)) {
                    tempDirectory = target.toString();
                } else {
                    tempDirectory = Files.createTempDirectory(mycat_temp_directory).toAbsolutePath().toString();
                }
            } catch (Throwable e) {
                try {
                    tempDirectory = Files.createTempDirectory(mycat_temp_directory).toAbsolutePath().toString();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.println("tempDirectory:" + tempDirectory);
        }
        return tempDirectory;
    }


    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(new ServerConfig()));
    }
}
