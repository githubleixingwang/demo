package com.demo.test.schedule.schedule;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.ScheduledLockConfiguration;
import net.javacrumbs.shedlock.spring.ScheduledLockConfigurationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.time.Duration;

@Configuration
public class SchedulerConfig {
/*    CREATE TABLE shedlock(
            name VARCHAR(64) ,
    lock_until TIMESTAMP(3) NULL,
    locked_at TIMESTAMP(3) NULL,
    locked_by  VARCHAR(255),
    PRIMARY KEY (name)
)*/
    private final static String TABLE_NAME = "shedlock";

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource, TABLE_NAME);
    }

    @Bean
    public ScheduledLockConfiguration scheduledLockConfiguration(LockProvider lockProvider){
        return ScheduledLockConfigurationBuilder.withLockProvider(lockProvider)
                .withPoolSize(10)
                .withDefaultLockAtMostFor(Duration.ofMinutes(3))
                .build();
    }
}
