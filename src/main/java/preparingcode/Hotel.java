package preparingcode;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String[] knownNames = {"John", "Jane", "Mary", "Peter", "Paul", "Mark"};
    private String[] vipNames = {"John", "Jane"};
    private static Map<String,Boolean> vipRooms = new HashMap<>();
    private static Map<String,Boolean> normalRooms = new HashMap<>();

    public Hotel(){
        initializeRooms(vipRooms,List.of("101", "102", "103", "104", "105"));
        initializeRooms(normalRooms,List.of("201", "202", "203", "204", "205"));
    }

    public String greetGuest(String name,LocalTime time) {
        if (isKnownName(name)){
            StringBuilder greeting = new StringBuilder();
            greeting.append("Good ").append(getTimeBasedGreeting(time)).append(" ").append(name).append(". ");
            greeting.append("Welcome to our hotel.");

            return greeting.toString();
        }
        else {
            return "Good " + getTimeBasedGreeting(LocalTime.now()) + " stranger.";
        }
    }

    public String assignRoom(String name) {
        if (isKnownName(name)){
            StringBuilder greeting = new StringBuilder();
            if (isVip(name)) {
               greeting.append("Please head over to the ").append(getVacantRoom(vipRooms)).append(" VIP room.");
            }else {
               greeting.append("Please head over to the ").append(getVacantRoom(normalRooms)).append(" room.");
            }
            return greeting.toString();
        }
        else {
            return "Kindly register at the reception to be assigned a room.";
        }
    }

    private String getVacantRoom(Map<String, Boolean> rooms) {
        for (String room: rooms.keySet()) {
            if (rooms.get(room)) {
                rooms.put(room, false);
                return room;
            }
        }
        throw new RuntimeException("No vacant rooms");
    }

    private boolean isVip(String name) {
        return Arrays.asList(vipNames).contains(name);
    }


    private String getTimeBasedGreeting(LocalTime now) {
        int hour = now.getHour();
        if (hour < 12) {
            return "Morning";
        } else if (hour < 18) {
            return "Afternoon";
        } else {
            return "Evening";
        }
    }

    private boolean isKnownName(String name) {
        return Arrays.asList(knownNames).contains(name);
    }

    private void initializeRooms(Map<String,Boolean> roomType, List<String> roomNames) {
        for (String room: roomNames) {
            roomType.put(room, true);
        }
    }
}
