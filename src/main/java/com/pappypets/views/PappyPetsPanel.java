package com.pappypets.views;

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;

/**
 * Render:
 * - Header (Pets title, pets count)
 * - List component
 */
public class PappyPetsPanel extends PluginPanel
{
	private ItemManager itemManager;

	public PappyPetsPanel(final ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}
}