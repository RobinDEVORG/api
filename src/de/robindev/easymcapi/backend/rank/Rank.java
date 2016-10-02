package de.robindev.easymcapi.backend.rank;

import de.robindev.easymcapi.codec.CodecTable;

/**
* @author RobinDEV (25.09.2016, 13:01:04)
*/
public enum Rank {
	
	OWNER(CodecTable.DATA_RANK_OWNER, "§4§lOwner §7| ", "owner"),
	ADMIN(CodecTable.DATA_RANK_ADMIN, "§4Admin §7| ", "admin"),
	HEAD_DEVELOPER(CodecTable.DATA_RANK_HEADDEVELOPER, "§bDev§7+ | ", "headdeveloper"),
	DEVELOPER(CodecTable.DATA_RANK_DEVELOPER, "§bDev §7| ", "developer"),
	HEAD_MODERATOR(CodecTable.DATA_RANK_HEADMODERATOR, "§cMod§7+ | ", "headmoderator"),
	MODERATOR(CodecTable.DATA_RANK_MODERATOR, "§cMod §7| ", "moderator"),
	HEAD_BUILDER(CodecTable.DATA_RANK_HEADBUILDER, "§eBuilder§7+ | ", "headbuilder"),
	BUILDER(CodecTable.DATA_RANK_BUILDER, "§eBuilder §7| ", "builder"),
	SUPPORTER(CodecTable.DATA_RANK_SUPPORTER, "§aSup §7| ", "supporter"),
	CHAT_SUPPORTER(CodecTable.DATA_RANK_CHATSUPPORTER, "§eCS §7| ", "chatsupporter"),
	YOUTUBER(CodecTable.DATA_RANK_YOUTUBER, "§5YT §7| ", "youtuber"),
	ULTIMATE(CodecTable.DATA_RANK_ULTIMATE, "§5§l", "ultimate"),
	ELITE(CodecTable.DATA_RANK_ELITE, "§e", "elite"),
	VIP(CodecTable.DATA_RANK_VIP, "§6", "vip"),
	PLAYER(CodecTable.DATA_RANK_PLAYER, "§7", "player");
	
	private String codec, prefix, teamName;

	private Rank(String codec, String prefix, String teamName) {
		this.codec = codec;
		this.prefix = prefix;
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public String getCodec() {
		return codec;
	}
	
	public String getPrefix() {
		return prefix;
	}
}
