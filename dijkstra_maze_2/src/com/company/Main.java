package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        int[][] cost_matrix = {
                {10, 4, -1, 5, 5, 6},
                {1, 20, -1, 6, 6, 6},
                {7, 18, -1, 12, 12, 7},
                {28, 7, -1, 8, 10, 27},
                {30, 5, 5, 7, 7, 10},
                {25, 25, -1, 8, 8, 8}

        };

        Scanner scanner = new Scanner(System.in);
        int stx,sty,endx,endy;
        //int visited[][] = new int[6][6];
        System.out.println("Enter start and end location (x,y) , (x,y) : ");
        stx = scanner.nextInt();sty = scanner.nextInt();
        endx = scanner.nextInt();endy = scanner.nextInt();

        Dijkstra_Maze dijkstra_maze = new Dijkstra_Maze();
        ArrayList<Cell> path = dijkstra_maze.run_maze(cost_matrix,stx,sty,endx,endy);
        System.out.println(path);
    }
}
