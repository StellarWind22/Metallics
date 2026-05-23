package com.github.stellarwind22.metallics.object.blockentity;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MCampfireBlockEntity extends BlockEntity implements Clearable {
    private final NonNullList<ItemStack> items;
    private final int[] cookingProgress;
    private final int[] cookingTime;
    private final RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> quickCheck;

    public MCampfireBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityType.CAMPFIRE, blockPos, blockState);
        this.items = NonNullList.withSize(4, ItemStack.EMPTY);
        this.cookingProgress = new int[4];
        this.cookingTime = new int[4];
        this.quickCheck = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);
    }

    public static void cookTick(Level level, BlockPos blockPos, BlockState blockState, MCampfireBlockEntity campfireBlockEntity) {
        boolean bl = false;

        for(int i = 0; i < campfireBlockEntity.items.size(); ++i) {
            ItemStack itemStack = campfireBlockEntity.items.get(i);
            if (!itemStack.isEmpty()) {
                bl = true;
                int var10002 = campfireBlockEntity.cookingProgress[i]++;
                if (campfireBlockEntity.cookingProgress[i] >= campfireBlockEntity.cookingTime[i]) {
                    SingleRecipeInput singleRecipeInput = new SingleRecipeInput(itemStack);
                    ItemStack itemStack2 = campfireBlockEntity.quickCheck.getRecipeFor(singleRecipeInput, level).map((recipeHolder) -> recipeHolder.value().assemble(singleRecipeInput, level.registryAccess())).orElse(itemStack);
                    if (itemStack2.isItemEnabled(level.enabledFeatures())) {
                        Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemStack2);
                        campfireBlockEntity.items.set(i, ItemStack.EMPTY);
                        level.sendBlockUpdated(blockPos, blockState, blockState, 3);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, Context.of(blockState));
                    }
                }
            }
        }

        if (bl) {
            setChanged(level, blockPos, blockState);
        }

    }

    public static void cooldownTick(Level level, BlockPos blockPos, BlockState blockState, MCampfireBlockEntity campfireBlockEntity) {
        boolean bl = false;

        for(int i = 0; i < campfireBlockEntity.items.size(); ++i) {
            if (campfireBlockEntity.cookingProgress[i] > 0) {
                bl = true;
                campfireBlockEntity.cookingProgress[i] = Mth.clamp(campfireBlockEntity.cookingProgress[i] - 2, 0, campfireBlockEntity.cookingTime[i]);
            }
        }

        if (bl) {
            setChanged(level, blockPos, blockState);
        }

    }

    public static void particleTick(Level level, BlockPos blockPos, BlockState blockState, MCampfireBlockEntity campfireBlockEntity) {
        RandomSource randomSource = level.random;
        if (randomSource.nextFloat() < 0.11F) {
            for(int i = 0; i < randomSource.nextInt(2) + 2; ++i) {
                CampfireBlock.makeParticles(level, blockPos, blockState.getValue(CampfireBlock.SIGNAL_FIRE), false);
            }
        }

        int i = blockState.getValue(CampfireBlock.FACING).get2DDataValue();

        for(int j = 0; j < campfireBlockEntity.items.size(); ++j) {
            if (!campfireBlockEntity.items.get(j).isEmpty() && randomSource.nextFloat() < 0.2F) {
                Direction direction = Direction.from2DDataValue(Math.floorMod(j + i, 4));
                float f = 0.3125F;
                double d = (double)blockPos.getX() + (double)0.5F - (double)((float)direction.getStepX() * 0.3125F) + (double)((float)direction.getClockWise().getStepX() * 0.3125F);
                double e = (double)blockPos.getY() + (double)0.5F;
                double g = (double)blockPos.getZ() + (double)0.5F - (double)((float)direction.getStepZ() * 0.3125F) + (double)((float)direction.getClockWise().getStepZ() * 0.3125F);

                for(int k = 0; k < 4; ++k) {
                    level.addParticle(ParticleTypes.SMOKE, d, e, g, 0.0F, 5.0E-4, 0.0F);
                }
            }
        }

    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.items.clear();
        ContainerHelper.loadAllItems(compoundTag, this.items, provider);
        if (compoundTag.contains("CookingTimes", 11)) {
            int[] is = compoundTag.getIntArray("CookingTimes");
            System.arraycopy(is, 0, this.cookingProgress, 0, Math.min(this.cookingTime.length, is.length));
        }

        if (compoundTag.contains("CookingTotalTimes", 11)) {
            int[] is = compoundTag.getIntArray("CookingTotalTimes");
            System.arraycopy(is, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, is.length));
        }

    }

    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        ContainerHelper.saveAllItems(compoundTag, this.items, true, provider);
        compoundTag.putIntArray("CookingTimes", this.cookingProgress);
        compoundTag.putIntArray("CookingTotalTimes", this.cookingTime);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundTag, this.items, true, provider);
        return compoundTag;
    }

    public Optional<RecipeHolder<CampfireCookingRecipe>> getCookableRecipe(ItemStack itemStack) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getRecipeFor(new SingleRecipeInput(itemStack), this.level);
    }

    public boolean placeFood(@Nullable LivingEntity livingEntity, ItemStack itemStack, int i) {
        for(int j = 0; j < this.items.size(); ++j) {
            ItemStack itemStack2 = this.items.get(j);
            if (itemStack2.isEmpty()) {
                this.cookingTime[j] = i;
                this.cookingProgress[j] = 0;
                this.items.set(j, itemStack.consumeAndReturn(1, livingEntity));
                assert this.level != null;
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), Context.of(livingEntity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }

        return false;
    }

    private void markUpdated() {
        this.setChanged();
        assert this.getLevel() != null;
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void clearContent() {
        this.items.clear();
    }

    public void dowse() {
        if (this.level != null) {
            this.markUpdated();
        }

    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        dataComponentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
    }

    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @SuppressWarnings("deprecation")
    public void removeComponentsFromTag(CompoundTag compoundTag) {
        compoundTag.remove("Items");
    }
}
