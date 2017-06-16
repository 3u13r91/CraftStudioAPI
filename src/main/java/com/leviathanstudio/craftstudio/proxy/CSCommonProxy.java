package com.leviathanstudio.craftstudio.proxy;

import com.leviathanstudio.craftstudio.CraftStudioApi;
import com.leviathanstudio.craftstudio.common.animation.AnimationHandler;
import com.leviathanstudio.craftstudio.common.animation.IAnimated;
import com.leviathanstudio.craftstudio.common.network.ClientIAnimatedEventMessage;
import com.leviathanstudio.craftstudio.common.network.ClientIAnimatedEventMessage.ClientIAnimatedEventHandler;
import com.leviathanstudio.craftstudio.common.network.EndAnimationMessage;
import com.leviathanstudio.craftstudio.common.network.EndAnimationMessage.EndAnimationHandler;
import com.leviathanstudio.craftstudio.common.network.FireAnimationMessage;
import com.leviathanstudio.craftstudio.common.network.FireAnimationMessage.FireAnimationHandler;
import com.leviathanstudio.craftstudio.common.network.FireEndAnimationMessage;
import com.leviathanstudio.craftstudio.common.network.FireEndAnimationMessage.FireEndAnimationHandler;
import com.leviathanstudio.craftstudio.common.network.RFireAnimationMessage;
import com.leviathanstudio.craftstudio.common.network.RFireAnimationMessage.RFireAnimationHandler;
import com.leviathanstudio.craftstudio.common.network.ServerIAnimatedEventMessage;
import com.leviathanstudio.craftstudio.common.network.ServerIAnimatedEventMessage.ServerIAnimatedEventHandler;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public abstract class CSCommonProxy
{
    public void preInit(FMLPreInitializationEvent e) {
        CraftStudioApi.NETWORK.registerMessage(FireAnimationHandler.class, FireAnimationMessage.class, 0, Side.CLIENT);
        CraftStudioApi.NETWORK.registerMessage(RFireAnimationHandler.class, RFireAnimationMessage.class, 1, Side.SERVER);
        CraftStudioApi.NETWORK.registerMessage(EndAnimationHandler.class, EndAnimationMessage.class, 2, Side.CLIENT);
        CraftStudioApi.NETWORK.registerMessage(FireEndAnimationHandler.class, FireEndAnimationMessage.class, 3, Side.CLIENT);
        
        CraftStudioApi.NETWORK.registerMessage(ClientIAnimatedEventHandler.class, ClientIAnimatedEventMessage.class, 4, Side.CLIENT);
        CraftStudioApi.NETWORK.registerMessage(ServerIAnimatedEventHandler.class, ServerIAnimatedEventMessage.class, 5, Side.SERVER);
    }

    public abstract <T extends IAnimated> AnimationHandler<T> getNewAnimationHandler(Class<T> animatedClass);
}
