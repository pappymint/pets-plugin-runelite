package com.pappypets.helpers;

import net.runelite.client.ui.ColorScheme;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class UiUtilities {
    public static final Dimension ICON_SIZE = new Dimension(32, 32);
    public static final Border ITEM_BORDER = new CompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 0, 0, ColorScheme.DARK_GRAY_COLOR),
            BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR.darker(), 4));
    public final static String pappyPetsIcon = "/pappy_pets_icon.png";
}
