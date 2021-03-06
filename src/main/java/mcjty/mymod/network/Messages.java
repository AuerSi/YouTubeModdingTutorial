package mcjty.mymod.network;

import mcjty.mymod.input.PacketToggleMode;
import mcjty.mymod.mana.PacketSendMana;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Messages {

    public static SimpleNetworkWrapper INSTANCE;

    private static int ID = 0;
    private static int nextID() {
        return ID++;
    }

    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);

        // Server side
        INSTANCE.registerMessage(PacketToggleMode.Handler.class, PacketToggleMode.class, nextID(), Side.SERVER);

        // Client side
        INSTANCE.registerMessage(PacketSyncMachineState.Handler.class, PacketSyncMachineState.class, nextID(), Side.CLIENT);
        INSTANCE.registerMessage(PacketSendMana.Handler.class, PacketSendMana.class, nextID(), Side.CLIENT);
    }
}
