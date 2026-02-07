package com.Suman16iitkgp.contentCalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentCalenderProperties(String welcomeMessage, String desc) {
}
