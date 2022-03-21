package me.mcblueparrot.client.mod.impl;

import java.text.DecimalFormat;

import me.mcblueparrot.client.Client;
import me.mcblueparrot.client.DetectedServer;
import me.mcblueparrot.client.mod.Mod;
import me.mcblueparrot.client.mod.ModCategory;
import me.mcblueparrot.client.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.EnumChatFormatting;

public class TNTTimerMod extends Mod {

	public static boolean enabled;
	private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

	public TNTTimerMod() {
		super("TNT Timer", "tnt_timer", "Display the time before TNT explodes.", ModCategory.UTILITY);
	}

	// Unfortunately doesn't work with TNT chains due to their random nature.
	public static String getText(EntityTNTPrimed tnt) {
		float fuse = tnt.fuse;

		if(Client.INSTANCE.detectedServer == DetectedServer.HYPIXEL && "BED WARS".equals(Utils.getScoreboardTitle())) {
			fuse -= 28;
		}

		EnumChatFormatting colour = EnumChatFormatting.GREEN;

		if(fuse < 20) {
			colour = EnumChatFormatting.DARK_RED;
		}
		else if(fuse < 40) {
			colour = EnumChatFormatting.RED;
		}
		else if (fuse < 60) {
			colour = EnumChatFormatting.GOLD;
		}

		return colour + FORMAT.format(fuse / 20);
	}

	@Override
	protected void onEnable() {
		super.onEnable();
		enabled = true;
	}

	@Override
	protected void onDisable() {
		super.onDisable();
		enabled = false;
	}

}
