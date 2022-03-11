package com.pappypets.controllers;

import com.pappypets.helpers.UiUtilities;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

import com.pappypets.views.PappyPetsPanel;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

public class PappyPetsController {
    private ClientToolbar clientToolbar;
    private PappyPetsPanel pappyPetsPanel;
    private NavigationButton navButton;

    public PappyPetsController(ClientToolbar clientToolbar, ItemManager itemManager) {
        this.clientToolbar = clientToolbar;
        this.pappyPetsPanel = new PappyPetsPanel(itemManager);

        setUpNavigationButton(this.pappyPetsPanel);
    }

    public void onPluginShutdown() {
        clientToolbar.removeNavigation(navButton);
    }

    public void onMenuOpened(MenuOpened event, Client client) {
    }

    public void onMenuOptionClicked(MenuOptionClicked event, Client client) {

    }

    private void setUpNavigationButton(PappyPetsPanel panel) {
        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), UiUtilities.pappyPetsIcon);

        navButton = NavigationButton.builder()
                .tooltip("Pets")
                .icon(icon)
                .panel(panel)
                .build();

        clientToolbar.addNavigation(navButton);
    }
}
