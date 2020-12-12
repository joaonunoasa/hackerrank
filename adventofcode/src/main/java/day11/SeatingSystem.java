package day11;

import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {

    public static List<Row> applyFirstRound(List<Row> rows) {

        List<Row> applyRound1 = new ArrayList<>();
        for (int row = 0; row < rows.size(); row++) {
            List<Character> seats = rows.get(row).getSeats();
            List<Character> newSeats = new ArrayList<>();
            for (int column = 0; column < seats.size(); column++) {
                Character seat = seats.get(column);
                if (seat.equals('.')) {
                    newSeats.add('.');
                } else if (seat.equals('#')) {
                    newSeats.add('#');
                } else if (seat.equals('L') && noOccupiedSeatsAdjacentToIt(row, column, rows)) {
                    newSeats.add('#');
                } else {
                    newSeats.add('L');
                }
            }
            Row newRow = new Row(newSeats);
            applyRound1.add(newRow);
        }

        return applyRound1;
    }

    public static List<Row> applySecondRound(List<Row> rows) {
        List<Row> applyRound2 = new ArrayList<>();
        for (int row = 0; row < rows.size(); row++) {
            List<Character> seats = rows.get(row).getSeats();
            List<Character> newSeats = new ArrayList<>();
            for (int column = 0; column < seats.size(); column++) {
                Character seat = seats.get(column);
                if (seat.equals('.')) {
                    newSeats.add('.');
                } else if (seat.equals('L')) {
                    newSeats.add('L');
                } else if (seat.equals('#') && countAdjacentSeatsOccupied(row, column, rows) >= 4) {
                    newSeats.add('L');
                } else {
                    newSeats.add('#');
                }
            }
            Row newRow = new Row(newSeats);
            applyRound2.add(newRow);
        }

        return applyRound2;
    }

    private static boolean noOccupiedSeatsAdjacentToIt(int row, int column, List<Row> rows) {

        boolean immediatelyUp = row - 1 <= 0 || rows.get(row - 1).getSeats().get(column) == 'L' || rows.get(row - 1).getSeats().get(column) == '.';
        boolean immediatelyDown = row + 1 >= rows.size() || rows.get(row+1).getSeats().get(column) == 'L' || rows.get(row+1).getSeats().get(column) == '.';
        boolean immediatelyLeft = column - 1 <= 0 || rows.get(row).getSeats().get(column-1) == 'L' || rows.get(row).getSeats().get(column-1) == '.';
        boolean immediatelyRight = column + 1 >= rows.size() || rows.get(row).getSeats().get(column+1) == 'L' || rows.get(row).getSeats().get(column+1) == '.';
        boolean diagonalUpLeft = row - 1 <= 0 || column - 1 <= 0 || rows.get(row - 1).getSeats().get(column-1) == 'L' || rows.get(row - 1).getSeats().get(column-1) == '.';
        boolean diagonalUpRight = row - 1 <= 0 || column + 1 >= rows.size() || rows.get(row - 1).getSeats().get(column+1) == 'L' || rows.get(row - 1).getSeats().get(column+1) == '.';
        boolean diagonalDownLeft = row + 1 >= rows.size() || column - 1 <= 0 || rows.get(row+1).getSeats().get(column-1) == 'L' || rows.get(row+1).getSeats().get(column-1) == '.';
        boolean diagonalDownRight = row + 1 >= rows.size() || column + 1 >= rows.size() || rows.get(row+1).getSeats().get(column+1) == 'L' || rows.get(row+1).getSeats().get(column+1) == '.';

        return immediatelyUp && immediatelyDown && immediatelyLeft && immediatelyRight &&
                diagonalUpLeft && diagonalUpRight && diagonalDownLeft && diagonalDownRight;
    }

    private static int countAdjacentSeatsOccupied(int row, int column, List<Row> rows) {

        int immediatelyUp = row - 1 < 0 ? 0 : (rows.get(row - 1).getSeats().get(column) == '#' ? 1 : 0);
        int immediatelyDown = row + 1 >= rows.size() ? 0 : (rows.get(row+1).getSeats().get(column) == '#' ? 1 : 0);
        int immediatelyLeft = column - 1 < 0 ? 0 : (rows.get(row).getSeats().get(column-1) == '#' ? 1 : 0);
        int immediatelyRight = column + 1 >= rows.size() ? 0 : (rows.get(row).getSeats().get(column+1) == '#' ? 1 : 0);
        int diagonalUpLeft = row - 1 < 0 || column - 1 < 0 ? 0 : (rows.get(row - 1).getSeats().get(column-1) == '#' ? 1 : 0);
        int diagonalUpRight = row - 1 < 0 || column + 1 >= rows.size() ? 0 : (rows.get(row - 1).getSeats().get(column+1) == '#' ? 1 : 0);
        int diagonalDownLeft = row + 1 >= rows.size() || column - 1 < 0 ? 0 : (rows.get(row+1).getSeats().get(column-1) == '#' ? 1 : 0);
        int diagonalDownRight = row + 1 >= rows.size() || column + 1 >= rows.size() ? 0 : (rows.get(row+1).getSeats().get(column+1) == '#' ? 1 : 0);

        return immediatelyUp + immediatelyDown + immediatelyLeft + immediatelyRight +
                diagonalUpLeft + diagonalUpRight + diagonalDownLeft + diagonalDownRight;
    }
}
