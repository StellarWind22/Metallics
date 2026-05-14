package com.github.stellarwind22.metallics.object;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

public class MWeatheringButtonBlock extends ButtonBlock implements WeatheringCopper {

    public WeatherState weatherState;

    public MWeatheringButtonBlock(BlockSetType blockSetType, int i, Properties properties, WeatherState weatherState) {
        super(blockSetType, i, properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
