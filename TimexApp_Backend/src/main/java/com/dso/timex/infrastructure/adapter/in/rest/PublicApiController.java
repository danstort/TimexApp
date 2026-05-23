package com.dso.timex.infrastructure.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicApiController {

    @GetMapping
    public Map<String, String> info() {
        return Map.of(
                "name", "Timex Public API",
                "status", "up",
                "version", "v1"
        );
    }
}
