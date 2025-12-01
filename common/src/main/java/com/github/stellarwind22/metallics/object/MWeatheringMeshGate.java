package com.github.stellarwind22.metallics.object;

import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

public class MWeatheringMeshGate extends MMeshGate implements WeatheringCopper {

    private final WeatherState weatherState;

    public MWeatheringMeshGate(WeatherState weatherState, BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
