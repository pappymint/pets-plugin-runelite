package com.pappypets;

import com.google.inject.Provides;
import javax.inject.Inject;
import java.awt.image.BufferedImage;

import com.pappypets.controllers.PappyPetsController;
import com.pappypets.views.PappyPetsPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

@Slf4j
@PluginDescriptor(
	name = "Pets"
)
public class PappyPetsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PappyPetsConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	private PappyPetsPanel panel;

	private NavigationButton navButton;

	private PappyPetsController pappyPetsController;

	@Override
	protected void startUp() throws Exception {
		pappyPetsController = new PappyPetsController(clientToolbar, itemManager);
	}

	@Override
	protected void shutDown() throws Exception {
		pappyPetsController.onPluginShutdown();
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event) {
		pappyPetsController.onMenuOpened(event, client);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event) {
		pappyPetsController.onMenuOptionClicked(event, client);
	}

	@Provides
	PappyPetsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PappyPetsConfig.class);
	}
}