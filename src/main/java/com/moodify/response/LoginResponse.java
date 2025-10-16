package com.moodify.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(type = "string", description = "Token Bearer")
                             String token
) {
}
