package com.AerialFishing;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("AerialFishing")
public interface AerialFishingConfig extends Config
{

	@Alpha
	@ConfigItem(
			keyName = "aerialColor1T",
			name = "1-tick color",
			description = "Color of overlays when 1-tick aerial fishing",
			position = 0
	)
	default Color Color1T()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
			keyName = "aerialColor2T",
			name = "2-tick color",
			description = "Color of overlays when 2-tick aerial fishing",
			position = 1
	)
	default Color Color2T()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
			keyName = "aerialColor3T",
			name = "3-tick color",
			description = "Color of overlays when 3-tick aerial fishing",
			position = 2
	)
	default Color Color3T()
	{
		return Color.RED;
	}
	@Alpha
	@ConfigItem(
			keyName = "aerialColor4T",
			name = "4-tick color",
			description = "Color of overlays when 4-tick aerial fishing",
			position = 3
	)
	default Color Color4T()
	{
		return Color.RED;
	}
	@Alpha
	@ConfigItem(
			keyName = "aerialColor5T",
			name = "5-tick color",
			description = "Color of overlays when 5-tick aerial fishing",
			position = 4
	)
	default Color Color5T()
	{
		return Color.RED;
	}
	@Alpha
	@ConfigItem(
			keyName = "aerialColor6T",
			name = "6-tick color",
			description = "Color of overlays when 6-tick aerial fishing",
			position = 5
	)
	default Color Color6T()
	{
		return Color.RED;
	}
}
