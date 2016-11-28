package ijp.assignment2;

import javafx.scene.image.Image;

/**
 * A class modelling a specific Item and its associated image.
 *
 * @author Sibylle Sehl
 * @version Version 3, 28th Nov 2016
 */

public class Item {

	private Image itemImage;

	public Item(Image itemImage) {
		this.itemImage = itemImage;
	}

	/**
	 * Returns the image for a specific Item
	 * 
	 * @return the image of the item
	 */
	public Image getItemImage() {
		return itemImage;
	}

	/**
	 * Sets the Item image (never used as set in constructor but included for
	 * completeness)
	 * 
	 * @param itemImage
	 *            The image of the item
	 */
	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}

}
