package com.moodify.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "string", description = "Nome")
                            String name,
                          @Schema(type = "string", description = "Email")
                          String email,
                          @Schema(type = "string", description = "Senha")
                          String password) {

}
