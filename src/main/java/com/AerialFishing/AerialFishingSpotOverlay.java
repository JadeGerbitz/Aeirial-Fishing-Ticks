package com.AerialFishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.FishingSpot;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class AerialFishingSpotOverlay extends Overlay {
    private static final int ONE_TICK_AERIAL_FISHING = 1;
    private static final int THREE_TICK_AERIAL_FISHING = 4;
    private static final int FIVE_TICK_AERIAL_FISHING = 7;
    private final AerialFishingPlugin plugin;
    private final AerialFishingConfig config;
    private final Client client;
    private final ItemManager itemManager;

    @Setter(AccessLevel.PACKAGE)
    private boolean hidden;

    @Inject
    private AerialFishingSpotOverlay(AerialFishingPlugin plugin, AerialFishingConfig config, Client client, ItemManager itemManager) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        this.itemManager = itemManager;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (hidden) {
            return null;
        }

        FishingSpot previousSpot = null;
        WorldPoint previousLocation = null;
        for (NPC npc : plugin.getFishingSpots()) {
            FishingSpot spot = FishingSpot.findSpot(npc.getId());

            if (spot == null) {
                continue;
            }
            Integer distance = npc.getWorldLocation().distanceTo2D(client.getLocalPlayer().getWorldLocation());
            Color color;
            if (distance == ONE_TICK_AERIAL_FISHING) {
                color = config.Color1T();
            }
            else if (distance < THREE_TICK_AERIAL_FISHING) {
                color = config.Color2T();
            }
            else if (distance == THREE_TICK_AERIAL_FISHING) {
                color = config.Color3T();
            }
            else if (distance < FIVE_TICK_AERIAL_FISHING) {
                color = config.Color4T();
            }
            else if (distance == FIVE_TICK_AERIAL_FISHING)
            {
                color = config.Color5T();
            }
            else
            {
                color = config.Color6T();
            }

            Polygon poly = npc.getCanvasTilePoly();

            if (poly != null) {
                OverlayUtil.renderPolygon(graphics, poly, color.darker());
            }
        }
        return null;
    }
}