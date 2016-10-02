package de.robindev.easymcapi.codec;

import java.util.Base64;

/**
* @author RobinDEV (25.09.2016, 12:31:50)
*/
public abstract class CodecTable {
	
	public static final String DATA_SKIN = encode("SKIN");
	public static final String DATA_NO_SKIN = encode("00");
	
	public static final String MSG_JOIN = encode("MSG_JOIN");
	public static final String MSG_QUIT = encode("MSG_QUIT");
	public static final String MSG_KICK = encode("MSG_KICK");
	
	public static final String DATA_RANK = encode("RANK");
	public static final String DATA_RANK_PLAYER = encode("RANK_PLAYER");
	public static final String DATA_RANK_VIP = encode("RANK_VIP");
	public static final String DATA_RANK_ELITE = encode("RANK_ELITE");
	public static final String DATA_RANK_ULTIMATE = encode("RANK_ULTIMATE");
	public static final String DATA_RANK_YOUTUBER = encode("RANK_YOUTUBER");
	public static final String DATA_RANK_CHATSUPPORTER = encode("RANK_CHATSUPPORTER");
	public static final String DATA_RANK_SUPPORTER = encode("RANK_SUPPORTER");
	public static final String DATA_RANK_BUILDER = encode("RANK_BUILDER");
	public static final String DATA_RANK_HEADBUILDER = encode("RANK_HEADBUILDER");
	public static final String DATA_RANK_MODERATOR = encode("RANK_MODERATOR");
	public static final String DATA_RANK_HEADMODERATOR = encode("RANK_HEADMODERATOR");
	public static final String DATA_RANK_DEVELOPER = encode("RANK_DEVELOPER");
	public static final String DATA_RANK_HEADDEVELOPER = encode("RANK_HEADDEVELOPER");
	public static final String DATA_RANK_ADMIN = encode("RANK_ADMIN");
	public static final String DATA_RANK_OWNER = encode("RANK_OWNER");
	
	public static final String DATA_MONEY = encode("MONEY");
	
	public static final String encode(String toEncode) {
		return Base64.getEncoder().encodeToString(toEncode.getBytes());
	}
	
	public static final String decode(String toDecode) {
		return new String(Base64.getDecoder().decode(toDecode));
	}
}
