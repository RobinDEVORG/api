package de.robindev.easymcapi.display.chat;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

/**
* @author RobinDEV (15.09.2016, 21:07:13)
*/
public abstract class Chat {
	
	public static IChatBaseComponent getComponentFromString(String string) {
		return ChatSerializer.a("{text: '" + string + "'}");
	}
}
