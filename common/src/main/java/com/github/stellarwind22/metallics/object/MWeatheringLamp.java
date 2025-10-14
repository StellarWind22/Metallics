package com.github.stellarwind22.metallics.object;

import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import org.jetbrains.annotations.NotNull;

public class MWeatheringLamp extends RedstoneLampBlock implements WeatheringCopper {

    public WeatherState weatherState;

    public MWeatheringLamp(Properties properties, WeatherState weatherState) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
