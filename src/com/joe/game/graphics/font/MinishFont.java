package com.joe.game.graphics.font;

import java.io.File;

import com.joe.engine.graphics.CustomFont;
import com.joe.engine.graphics.renderable.sprite.SpriteSheet;
import com.joe.engine.util.EngineConstants;

public class MinishFont extends CustomFont {

	/**
	 * Create a new font based on the minish cap font sheet.
	 */
	public MinishFont() {
		super(new SpriteSheet(new File("./data/font/minishfont_nontrans.png"), 16));
	}
	
	@Override
	public void initializeCharacters() {
		/**
		 * Loop through the list of valid characters and map them
		 * to the character found in the font sheet.
		 */
		for (int valid_character_index = 0; valid_character_index < EngineConstants.VALID_CHARACTERS.length; valid_character_index++) {
			char current_character = EngineConstants.VALID_CHARACTERS[valid_character_index];
			if (valid_character_index >= 0 && valid_character_index < 13) {
				mapCharacterToFontSheet(current_character, valid_character_index);
			} else if (valid_character_index >= 13 && valid_character_index < 26) {
				mapCharacterToFontSheet(current_character, valid_character_index + 3);
			} else if (valid_character_index >= 26 && valid_character_index < 39) {
				mapCharacterToFontSheet(current_character, valid_character_index + 54);
			} else if (valid_character_index >= 39 && valid_character_index < 52) {
				mapCharacterToFontSheet(current_character, valid_character_index + 57);
			} else if (valid_character_index >= 52 && valid_character_index < 57) {
				mapCharacterToFontSheet(current_character, valid_character_index + 4);
			} else if (valid_character_index >= 57 && valid_character_index < 70) {
				mapCharacterToFontSheet(current_character, valid_character_index + 7);
			}
		}
	}
}
