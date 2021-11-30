import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void tooHightooLow() {
        assertEquals(false,Main.tooHightooLow(3,8));
        assertEquals(false,Main.tooHightooLow(8,3));
        assertEquals(true,Main.tooHightooLow(3,3));
    }

//    @org.junit.jupiter.api.Test
//    void restarting(){
//        assertEquals(true,Main.restarting("y"));
//        assertEquals(false,Main.restarting("n"));
//    }
}