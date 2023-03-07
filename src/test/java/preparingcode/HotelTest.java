package preparingcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(HotelClassParameterResolver.class)
class HotelTest {

    @Test
    @DisplayName("Should greet a user correctly according to the time of day")
    void greetGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("John", LocalTime.of(6, 0));

        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Morning"));

        greeting = hotel.greetGuest("John", LocalTime.of(12, 0));
        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Afternoon"));

        greeting = hotel.greetGuest("John", LocalTime.of(18, 0));
        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Evening"));

        greeting = hotel.greetGuest("John", LocalTime.of(23, 59));
        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Evening"));
    }
    @Test
    @DisplayName("Should greet a  known guest correctly")
    void greetNormalGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("John", LocalTime.of(23, 59));

        assertTrue(greeting.contains("John") && greeting.contains("Good") && greeting.contains("Welcome"));
    }

    @Test
    @DisplayName("Should greet a  known  guest correctly")
    void greetKnownGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("Jane", LocalTime.of(23, 59));

        System.out.println(greeting);
        assertTrue(greeting.contains("Jane") && greeting.contains("Good") && greeting.contains("Welcome"));
    }

    @Test
    @DisplayName("Should greet a  unknown guest correctly")
    void greetUnknownGuestTest(Hotel hotel) {
        String greeting = hotel.greetGuest("Unknown", LocalTime.of(23, 59));

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