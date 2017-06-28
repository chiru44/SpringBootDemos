package demo.model;
/**
 * Menu model class containg items
 * @author chiru
 *
 */
public class Menu {	

	public Item[] items;
	public Menu(int size) {
		 items = new Item[size];
		populateItems();
	}

	public Item[] getItemList() {
		return items;
	}

	public void populateItems() {
		Item item;

		for (int i = 0; i < items.length; i++) {
			item = new Item(i, "Dish-" + i);
			items[i] = item;
		}

	}

}
