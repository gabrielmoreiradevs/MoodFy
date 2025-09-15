package com.moodify.Controller.response;

import lombok.Builder;

@Builder
public record MoodsResponse(Long id, String name) {
}
