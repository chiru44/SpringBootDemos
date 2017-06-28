package demo.model;
/**
 * Model class for item
 * @author chiru
 *
 */

public class Item {

	private int id;

	private String name;

	public Item(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
