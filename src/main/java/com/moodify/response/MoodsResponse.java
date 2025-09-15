package com.moodify.response;

import lombok.Builder;

@Builder
public record MoodsResponse(Long id, String name) {
}
