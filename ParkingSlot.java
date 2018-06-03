
import java.util.*;

public class ParkingSlot {
	
	public SlotList parkingSlot;
	
	public ParkingSlot() {
		// System.out.println("test");
	}
	public ParkingSlot(int number) {
		System.out.println("Created a parking lot with " + number + " slots");
		parkingSlot = new SlotList(number);
		
	}
	public void removeVehicle(int slotNumber) {
		if (parkingSlot == null)
			return;
		parkingSlot.CO_Vehicle(slotNumber - 1);
	}
	public int AddVehicle(String regNo, String color) {
		if (parkingSlot == null) {
			return -1;
		}
		int slotNumber = parkingSlot.CI_Vehicle(regNo, color);
		if (slotNumber == -1)
			return slotNumber;
		return slotNumber + 1;
	}
	public void pushBack() {
		// whichStack.push(whichObject);
	}
	
	public void popSlot() {
		// return (Slots) whichStack.pop();
	}
	public String getParkingStatus() {
		if (parkingSlot == null)
			return "";
		return parkingSlot.getParkingSlotStatus();
	}
	public String handle_registration_number_for_cars_with_color(String color){
		if (parkingSlot == null)
			return "";
		return parkingSlot.handle_registration_numbers_for_cars_with_color(color);
	}
	public String handle_slot_number_for_cars_with_color(String color){
		if (parkingSlot == null)
			return "";
		return parkingSlot.handle_slot_number_for_cars_with_color(color);
	}
	public int handle_slot_number_for_registration_number(String regNo){
		if (parkingSlot == null)
			return -1;
		return parkingSlot.handle_slot_number_for_registration_number(regNo);
	}
	
	
}
