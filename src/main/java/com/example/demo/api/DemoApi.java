package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoApi {
    @GetMapping("/healthcheck")
    public ResponseEntity<ApiResponse> healthcheck(@RequestHeader(value = "X-Request-ID", required = false) String hostHeader) {
        ApiResponse response;
        if (hostHeader != null && !hostHeader.isEmpty()) {
            response = new ApiResponse("Healthcheck successful!! ", HttpStatus.OK);
            return ResponseEntity.ok(response);
        } else {
            response = new ApiResponse("Healthcheck failed", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create() {
        ApiResponse response = new ApiResponse("Create successful!! ", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
