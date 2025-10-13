package com.moodify.Config;

import lombok.Builder;

@Builder
public record JWTUserDate(Long id, String name, String email) {
}
