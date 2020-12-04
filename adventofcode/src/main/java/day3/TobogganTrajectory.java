package day3;

public class TobogganTrajectory {

    public static int howManyTrees(String[][] fullPath, int right, int down, int bottom) {
        int trees = 0;
        boolean reachedBottom = false;
        int positionI = 0;
        int positionY = 0;

        while (!reachedBottom) {

            if (fullPath[positionI][positionY].equals(Geology.TREE)) {
                trees++;
            }

            positionI = positionI + down;
            positionY = positionY + right;

            if (positionI >= bottom) {
                reachedBottom = true;
            }

        }

        return trees;
    }
}
