package com.github.stellarwind22.metallics.object;

import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import org.jetbrains.annotations.NotNull;

public class MWeatheringLeverBlock extends LeverBlock implements WeatheringCopper {

    public WeatherState weatherState;

    public MWeatheringLeverBlock(Properties properties, WeatherState weatherState) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
