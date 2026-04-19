package com.warpgames.vesperwilds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.Level;
import java.lang.reflect.Method;
public class Reflector {
    public static void main(String[] args) {
        System.out.println("Methods in ServerLevel returning long:");
        for(Method m : ServerLevel.class.getMethods()) {
            if(m.getReturnType() == long.class) System.out.println(m.getName());
        }
        System.out.println("Methods in Level returning long:");
        for(Method m : Level.class.getMethods()) {
            if(m.getReturnType() == long.class) System.out.println(m.getName());
        }
    }
}
