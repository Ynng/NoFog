package virtuoel.no_fog.mixin.client.compat116;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import virtuoel.no_fog.util.NoFogDynamicRegistryManagerExtensions;

@Mixin(DynamicRegistryManager.class)
public abstract class DynamicRegistryManagerMixin implements NoFogDynamicRegistryManagerExtensions
{
	@Shadow(remap = false)
	abstract <E> MutableRegistry<E> method_30530(RegistryKey<? extends Registry<? extends E>> key);
	
	@Override
	public <E> SimpleRegistry<E> no_fog_get(RegistryKey<? extends Registry<? extends E>> key)
	{
		return (SimpleRegistry<E>) method_30530(key);
	}
}
