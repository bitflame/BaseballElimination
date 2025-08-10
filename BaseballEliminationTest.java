import static org.junit.Assert.assertEquals;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
class BaseballEliminationTest {
    BaseballElimination baseballElimination;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void against() {
    }

    @org.junit.jupiter.api.Test
    void montrealIsEliminated() {
        baseballElimination = new BaseballElimination("teams4.txt");
        assertEquals(true, baseballElimination.isEliminated("Montreal"));
    }

    @org.junit.jupiter.api.Test
    void certificateOfElimination() {
    }
}