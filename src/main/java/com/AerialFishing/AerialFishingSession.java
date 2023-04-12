package com.AerialFishing;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

class AerialFishingSession
{
    @Getter
    @Setter
    private Instant lastFishCaught;
}
