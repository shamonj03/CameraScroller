package com.joe.game;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.joe.engine.EngineFrame;

public class Game extends EngineFrame<GameCanvas> {

	@Override
	public void setAWTComponenets(Frame frame) {
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("File");
		
		menu.add(exitItem());
		menuBar.add(menu);

		frame.setMenuBar(menuBar);
	}

	/**
	 * Creates a new exit menu item.
	 * 
	 * @return the menu item.
	 */
	private MenuItem exitItem() {
		MenuItem menuItem = new MenuItem("Exit");

		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		return menuItem;
	}
}
