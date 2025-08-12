/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BaseballElimination {
    private In in;
    private String[] teams;
    private int[] wins, losses, gamesRemaining;
    private int[][] g;
    private Queue<String> certificateList;
    private FordFulkerson maxFlow;
    private FlowNetwork flowNetwork;
    private final Integer INFINITY = Integer.MAX_VALUE;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        in = new In(filename);
        int lineItems = in.readInt();
        teams = new String[lineItems];
        wins = new int[lineItems];
        losses = new int[lineItems];
        gamesRemaining = new int[lineItems];
        g = new int[lineItems][lineItems];
        for (int i = 0; i < lineItems; i++) {
            teams[i] = in.readString();
            wins[i] = in.readInt();
            losses[i] = in.readInt();
            gamesRemaining[i] = in.readInt();
            for (int j = 0; j < lineItems; j++) {
                g[i][j] = in.readInt();
            }
        }
    }

    // number of teams
    public int numberOfTeams() {
        return teams.length;
    }

    // all teams
    public Iterable<String> teams() {
        return Arrays.asList(teams);
    }

    // number of wins for given team
    public int wins(String team) {
        validateTeam(team);
        for (int i = 0; i < numberOfTeams(); i++) {
            if (teams[i].equals(team)) return wins[i];
        }
        return -1;
    }

    // number of losses for given team
    public int losses(String team) {
        validateTeam(team);
        for (int i = 0; i < numberOfTeams(); i++) {
            if (teams[i].equals(team)) return losses[i];
        }
        return -1;
    }

    // number of remaining games for given team
    public int remaining(String team) {
        validateTeam(team);
        for (int i = 0; i < numberOfTeams(); i++) {
            if (teams[i].equals(team)) return gamesRemaining[i];
        }
        return -1;
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        validateTeam(team1);
        validateTeam(team2);
        for (int i = 0; i < numberOfTeams(); i++) {
            for (int j = 0; j < numberOfTeams(); j++) {
                return g[i][j];
            }
        }
        return -1;
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        validateTeam(team);
        int bestScore = 0;
        int vertices = 0, teamIndex = 0, games = 0;
        for (int i = 0; i < numberOfTeams(); i++) {
            if (teams[i].equals(team)) {
                bestScore = wins[i] + gamesRemaining[i];
                teamIndex = i;
            }
        }
        for (int i = 0; i < numberOfTeams(); i++) {
            if (i == teamIndex) continue;
            if (wins[i] > bestScore) return true;
        }
        games = games(numberOfTeams() - 1);
        vertices = games + (numberOfTeams() - 1) + 2;
        flowNetwork = new FlowNetwork(vertices);
        for (int i = 0; i < numberOfTeams(); i++) {
            if (i == teamIndex) continue;
            for (int j = 0; j < numberOfTeams(); j++) {
                if (j == teamIndex || i >= j) continue;
                // add an edge from source to each game vertex
                flowNetwork.addEdge(new FlowEdge(0, i, g[i][j]));
                // todo - below line and the one after it are wrong, this one will add more than 2 edges from
                // a game vertex to a team, and the next one will skip some nodes. I think I have to create
                // another loop
                flowNetwork.addEdge(new FlowEdge(i, j, INFINITY));
            }
            flowNetwork.addEdge(new FlowEdge(i, vertices, bestScore - wins[i]));
        }
        maxFlow = new FordFulkerson(flowNetwork, 0, flowNetwork.V());
        return false;
    }

    private int games(int teams) {
        // teams! / 2!(teams -2)!
        return teams * (teams - 1) / 2;
    }
    // subset R of teams that eliminates given team; null if not eliminated

    public Iterable<String> certificateOfElimination(String team) {
        validateTeam(team);
        return certificateList;
    }

    private void validateTeam(String team) {
        for (String t : teams()) {
            if (t.equals(team)) return;
        }
        throw new IllegalArgumentException("This team is not in the list.");
    }

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        System.out.println("Should be six: " + division.games(3));
        System.out.println("Should be 6: " + division.games(4));
        System.out.println("Should be 10: " + division.games(5));
        division.isEliminated("Philadelphia");
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
