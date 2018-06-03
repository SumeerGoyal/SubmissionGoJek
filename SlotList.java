


public class SlotList {
	int slotNumbers;
	Slots[] slotList;
	
	SlotList(){
		slotNumbers = -1;
		slotList = null;
	}
	SlotList(int noOfSlots){
		slotNumbers = noOfSlots;
		slotList = new Slots[slotNumbers];
		for (int i =0; i < slotNumbers; i++) {
			int j = i+1;
			slotList[i] = new Slots(j); // we want the slot numbers to start from 1
			// System.out.println("added slot at pos " + i + " with number " + j); 
		}
	}
	
	public int findEmptySlot() {
		for (int i = 0; i< slotNumbers; i++) {
			if ((slotList[i].isSlotFree() == false)) {
				// System.out.println("returning " + i);
				return i;
			}
		}
		return -1;
	}
	public int changeStateToOccupied(int slotNumber, String regNumber, String color) {
		Slots freeSlot = slotList[slotNumber];
		freeSlot.AddVehicle(regNumber, color);
		return slotNumber;
	}
	public void changeStateToFree(int slotNumber) {
		Slots freeSlot = slotList[slotNumber];
		freeSlot.EmptySlot();
	}
	public int CI_Vehicle (String regNumber, String color) {
		// find the nearest slot
		int freeSlot = findEmptySlot();
		if (freeSlot == -1){
			System.out.println("Sorry, parking lot is full");
			return -1;
		}
		changeStateToOccupied(freeSlot, regNumber, color);
		// System.out.println("adding vehicle " + regNumber + " " + color + " " + freeSlot);
		return freeSlot;
	}
	public int CO_Vehicle (int slotNumber) {
		// find the nearest slot

		changeStateToFree(slotNumber);
		return slotNumber;
	}
	
	public String getParkingSlotStatus() {
		// this should go into a string, but for the time being
		System.out.println("Slot No. " +  "Registration No " + " Colour");
		for (int i = 0; i< slotNumbers; i++) {
			if ((slotList[i].isSlotFree())== true) 	{
				Slots s = slotList[i];
				System.out.println(s.slotNumber + " " + s.regNumber + " "+ s.color);
	
				}
		
		}
		return "";
	}
	public String handle_registration_numbers_for_cars_with_color(String carColor){
		String outputStr = null;
		for (int i = 0; i< slotNumbers; i++) {
			if ((slotList[i].isSlotFree())== true) 	{
				Slots s = slotList[i];
				if (s.color.compareTo(carColor) == 0){
					if (outputStr == null){
						outputStr = s.regNumber;
					}
					else {
						outputStr = outputStr + ", " + s.regNumber;
					}
						
				}
				// System.out.println("output string " + outputStr);
			}
		}
		System.out.println(outputStr);
		return outputStr;
	}
	// handle slot numbers properly
	public String handle_slot_number_for_cars_with_color(String carColor){
		String outputStr = null;
		for (int i = 0; i< slotNumbers; i++) {
			if ((slotList[i].isSlotFree())== true) 	{
				Slots s = slotList[i];
				if (s.color.compareTo(carColor) == 0){
					if (outputStr == null){
						outputStr = Integer.toString(i+1);
					}
					else {
						
						outputStr = outputStr + ", " + Integer.toString(i+1);
	
					}
					// System.out.println(outputStr);
				}
			}
		}
		System.out.println(outputStr);
		return outputStr;
	}
	public int handle_slot_number_for_registration_number(String regNo){
		// String outputStr = null;
		for (int i = 0; i< slotNumbers; i++) {
			if ((slotList[i].isSlotFree())== true) 	{
				Slots s = slotList[i];
				// System.out.println(s.regNumber + " " +  regNo);
				if (s.regNumber.compareTo(regNo) == 0){
					return i+1;
						
				}
			}
		}
		// System.out.println(outputStr);
		return 0;
	}
}
