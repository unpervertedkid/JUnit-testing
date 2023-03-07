package preparingcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(HotelClassParameterResolver.class)
class HotelTest {

    @Test
    @DisplayName("Should greet a  known guest correctly")
    void greetNormalGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("John");

        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Welcome"));
    }

    @Test
    @DisplayName("Should greet a  known  guest correctly")
    void greetKnownGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("Jane");

        System.out.println(greeting);
        assertTrue(greeting.contains("Jane") && greeting.contains("Good") && greeting.contains("Welcome"));
    }

    @Test
    @DisplayName("Should greet a  unknown guest correctly")
    void greetUnknownGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("Unknown");

        assertTrue(greeting.contains("stranger"));
    }

    @Test
    @DisplayName("Should assign a non vip guest a room correctly")
    void assignNonVipGuestRoomTest(Hotel hotel) {
        String room = hotel.assignRoom("Mary");

        assertTrue(room.contains("room"));
        assertFalse(room.contains("VIP"));
    }

    @Test
    @DisplayName("Should assign a vip guest a room correctly")
    void assignVipGuestRoomTest(Hotel hotel) {
        String room = hotel.assignRoom("Jane");

        assertTrue(room.contains("VIP"));
        assertTrue(room.contains("room"));
    }

    @Test
    @DisplayName("Should not assign a stranger a room")
    void assignStrangerRoomTest(Hotel hotel) {
        String room = hotel.assignRoom("Unknown");

        assertTrue(room.contains("register"));
        assertFalse(room.contains("VIP"));
    }
}