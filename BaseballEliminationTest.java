/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballEliminationTest {
    BaseballElimination division;

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
    void IsEliminatedRsultsTeam4() {
        division = new BaseballElimination("teams4.txt");
        assertEquals(1, division.against("Atlanta", "Philadelphia"));
    }

    @org.junit.jupiter.api.Test
    void IsEliminatedRsultsTeam5() {
        division = new BaseballElimination("teams5.txt");
        assertEquals(3, division.against("New_York", "Baltimore"));
    }

    @org.junit.jupiter.api.Test
    void IsEliminatedRsultsTeam8() {
        division = new BaseballElimination("teams8.txt");
        assertEquals(9, division.against("Brown", "Princeton"));
    }

    @org.junit.jupiter.api.Test
    void IsEliminatedRsultsTeam10() {
        division = new BaseballElimination("teams10.txt");
        assertEquals(9, division.against("Atlanta", "Boston"));
    }

    @org.junit.jupiter.api.Test
    void IsEliminatedRsultsTeam29() {
        division = new BaseballElimination("teams29.txt");
        assertEquals(7, division.against("Atlanta", "Boston"));
    }

    @org.junit.jupiter.api.Test
    void IsEliminatedRsultsTeam48() {
        division = new BaseballElimination("teams48.txt");
        assertEquals(1, division.against("Team0", "Team1"));
    }

    @org.junit.jupiter.api.Test
    void certificateOfElimination() {
    }
}