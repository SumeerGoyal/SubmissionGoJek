

public class Slots {
	String regNumber;
	boolean state; //0 for empty, 1 for occupied
	int level; // 0 for ground, level 
	String color;
	int slotNumber; // to indicate distance from the entry point
	// 0 being the closest
	
	public Slots(){
		regNumber = null;
		state = false;
		level = 0;
		color = null;
		slotNumber = 0; // they start with 1, 2, ....
	}
	
	public Slots(int addedSlotNumber){
		regNumber = null;
		state = false;
		level = 0;
		color = null;
		slotNumber = addedSlotNumber;
	
	}
	public boolean isSlotFree() {
		return state;
	}
	
	public void AddVehicle(String carNumber, String carColor) {
		state = true;
		regNumber = carNumber;
		color = carColor;
		// System.out.println("Added vehicle at slot " + slotNumber );
	}
	
	public void EmptySlot() {
		state = false;
		regNumber = null;
		color = null;
	}
	public void removeVehicle() {
		// whatVehicle = null;
	}
}
