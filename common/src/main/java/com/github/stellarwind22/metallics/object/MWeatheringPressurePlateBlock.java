package com.github.stellarwind22.metallics.object;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

public class MWeatheringPressurePlateBlock extends PressurePlateBlock implements WeatheringCopper {

    public WeatherState weatherState;

    public MWeatheringPressurePlateBlock(BlockSetType blockSetType, Properties properties, WeatherState weatherState) {
        super(blockSetType, properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
