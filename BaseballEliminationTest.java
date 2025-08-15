/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
    void certificateOfEliminationRsultsTeam5aDetroit() {
        division = new BaseballElimination("teams5a.txt");
        Iterable<String> result = division.certificateOfElimination("Detroit");
        List<String> teams = new ArrayList<>();
        for (String s : result) teams.add(s);
        assertEquals(4, teams.size());
        assertTrue(teams.contains("Boston"));
        assertTrue(teams.contains("New_York"));
        assertTrue(teams.contains("Toronto"));
        assertTrue(teams.contains("Baltimore"));
    }

    @org.junit.jupiter.api.Test
    void certificateOfEliminationRsultsTeam4Phili() {
        division = new BaseballElimination("teams4.txt");
        Iterable<String> result = division.certificateOfElimination("Philadelphia");
        List<String> teams = new ArrayList<>();
        for (String s : result) teams.add(s);
        assertEquals(2, teams.size());
        assertTrue(teams.contains("Atlanta"));
        assertTrue(teams.contains("New_York"));
    }

    @org.junit.jupiter.api.Test
    void certificateOfEliminationRsultsTeam4aGhaddafi() {
        division = new BaseballElimination("teams4a.txt");
        Iterable<String> result = division.certificateOfElimination("Ghaddafi");
        List<String> teams = new ArrayList<>();
        for (String s : result) teams.add(s);
        assertEquals(2, teams.size());
        assertTrue(teams.contains("CIA"));
        assertTrue(teams.contains("Obama"));
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