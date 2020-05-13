package com.company.practicum;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class SeaBattle {

    public static void main(String[] args) {
        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner( file);
            short m = scanner.nextShort();
            short n = scanner.nextShort();

            short numB = scanner.nextShort();
            Boat[] boats = new Boat[numB];
            for (int i = 0; i < numB; i++) {
                short begI = scanner.nextShort();
                short begJ = scanner.nextShort();
                short endI = scanner.nextShort();
                short endJ = scanner.nextShort();

                boats[i] = new Boat(new Coord(begI, begJ), new Coord(endI, endJ));
            }
            short numShot = scanner.nextShort();
            for (int i = 0; i < numShot; i++) {
                short sI = scanner.nextShort();
                short sJ = scanner.nextShort();
                for (int j = 0; j < boats.length; j++) {
                    boats[j].checkShot(new Coord(sI, sJ));
                }
            }
            short numInj = 0;
            short numD = 0;
            for (int i = 0; i < boats.length; i++) {
                if (boats[i].isInj) numInj++;
                if (boats[i].isDes) numD++;
            }
            System.out.print(numInj + " ");
            System.out.print(numD);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }


    static class Boat {
        short lenght;

        Coord[] coords;
        HashSet<Coord> set;

        boolean isDes = false;
        boolean isInj = false;

        Boat (Coord beg, Coord end) {
            short di = (short) (end.i - beg.i);
            short dj =(short) (end.j - beg.j);
            set = new HashSet<>();
            if (di == 0 && dj ==0) {
                coords = new Coord[1];
                coords[0] = new Coord(beg.i, beg.j);
                set.add(new Coord(beg.i, beg.j));
            } else {
                if (di != 0) {
                    coords = new Coord[Math.abs(di)+1];
                    if (di > 0) {
                        for (short i = 0; i < di + 1; i++) {
                            coords[i] = new Coord((short)(beg.i + i), beg.j);
                            set.add(new Coord((short)(beg.i + i), beg.j));

                        }
                    } else if (di < 0) {

                    }
                } else if (dj != 0) {
                    coords = new Coord[Math.abs(dj)+1];
                    if (dj > 0) {
                        for (short i = 0; i < dj + 1; i++) {
                            coords[i] = new Coord(beg.i, (short)(beg.j + i));
                            set.add(new Coord(beg.i, (short)(beg.j + i)));
                        }
                    } else if (dj < 0) {

                    }
                }
            }
        }

        void checkShot(Coord coord) {
            if (set.contains(coord)) {
                set.remove(coord);
                isInj = true;
                if (set.size() == 0) {
                    isDes = true;
                    isInj = false;
                }
            }
        }

    }

    static class Coord {
        short i;
        short j;

        Coord(short i,short j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return i == coord.i &&
                    j == coord.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
