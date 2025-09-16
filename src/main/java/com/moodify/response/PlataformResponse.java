package com.moodify.response;

import lombok.Builder;

@Builder
public record PlataformResponse(Long id, String name) {
}
