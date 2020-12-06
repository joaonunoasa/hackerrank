package day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryBoarding {
    public static int seatIdFor(List<Seat> seats) {

        int highestSeatId = 0;
        List<Integer> seatIds = new ArrayList<>();

        for (Seat seat : seats) {

            String sequence = seat.getSequence();

            String row = sequence.substring(0, 7);
            String column = sequence.substring(7, 10);

            int minRowNumber = 0;
            int maxRowNumber = 127;
            for (char id : row.toCharArray()) {

                if (id == 'F') {
                    maxRowNumber = (((maxRowNumber - 1) - minRowNumber) / 2) + minRowNumber;
                }

                if (id == 'B') {
                    minRowNumber = (((maxRowNumber + 1) - minRowNumber) / 2) + minRowNumber;
                }
            }

            int minColumnNumber = 0;
            int maxColumnNumber = 7;

            for (char id : column.toCharArray()) {

                if (id == 'L') {
                    maxColumnNumber = (((maxColumnNumber - 1) - minColumnNumber) / 2) + minColumnNumber;
                }

                if (id == 'R') {
                    minColumnNumber = (((maxColumnNumber + 1) - minColumnNumber) / 2) + minColumnNumber;
                }
            }

            int seatId = (maxRowNumber * 8) + maxColumnNumber;
            seatIds.add(seatId);
            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }
        }

        seatIds.sort(Integer::compare);

        for(int i = 0; i < seatIds.size() - 1; i++ ) {

            if ((seatIds.get(i) + 1 != (seatIds.get(i+1)))) {
                System.out.println(seatIds.get(i));
                System.out.println(seatIds.get(i+1));
            }
        }

        return highestSeatId;
    }


}
