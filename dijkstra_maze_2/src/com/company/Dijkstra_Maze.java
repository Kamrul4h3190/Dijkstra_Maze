package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dijkstra_Maze {
    int[][] visited = new int[6][6];
    ArrayList<Cell> path = new ArrayList<Cell>();
    ArrayList<Cell> adjacent_cells;

    public ArrayList<Cell> run_maze(int[][] cost_matrix,int stx,int sty,int endx,int endy){

        Cell curr_cell = new Cell(stx,sty,cost_matrix[stx][sty]);
        if(!path.contains(curr_cell) && visited[stx][sty] == 0){
            path.add(curr_cell);
            visited[stx][sty] = 1;
        }

        //Checking whether start is equal to end
        if(stx == endx && sty == endy){
            return path;
        }

        adjacent_cells = find_adjacent(cost_matrix,path.get(path.size()-1));
        for (Cell cell:adjacent_cells){
            int adj_x = cell.getX();
            int adj_y = cell.getY();
            if(adj_x == endx && adj_y == endy){
                path.add(cell);
                visited[adj_x][adj_y] = 1;
                return path;
            }
        }

        Cell min_cost_cell = findMin_cost_cell(adjacent_cells);
        int min_x = min_cost_cell.getX();
        int min_y = min_cost_cell.getY();
        path.add(min_cost_cell);
        visited[min_x][min_y] = 1;


        run_maze(cost_matrix,min_x,min_y,endx,endy);

        return path;
    }



    public ArrayList<Cell> find_adjacent(int[][] cost_matrix,Cell current_cell){
        adjacent_cells = new ArrayList<Cell>();
        int x = current_cell.getX();
        int y = current_cell.getY();
        //checking up
        if (x-1>=0 && cost_matrix[x-1][y]!=-1 && visited[x-1][y]==0){
            Cell adjacent_cell = new Cell(x-1,y,cost_matrix[x-1][y]);
            //adjacent_cell.setCost(cost_matrix[x-1][y]);
            adjacent_cells.add(adjacent_cell);
        }
        //checking down
        if (x+1<6 && cost_matrix[x+1][y]!=-1 && visited[x+1][y]==0 ){
            Cell adjacent_cell = new Cell(x+1,y,cost_matrix[x+1][y]);
            //adjacent_cell.setCost(cost_matrix[x+1][y]);
            adjacent_cells.add(adjacent_cell);
        }
        //checking left
        if (y-1>=0 && cost_matrix[x][y-1]!=-1 && visited[x][y-1]==0){
            Cell adjacent_cell = new Cell(x,y-1,cost_matrix[x][y-1]);
            //adjacent_cell.setCost(cost_matrix[x][y-1]);
            adjacent_cells.add(adjacent_cell);
        }
        //checking right
        if (y+1<6 && cost_matrix[x][y+1]!=-1 && visited[x][y+1]==0 ){
            Cell adjacent_cell = new Cell(x,y+1,cost_matrix[x][y+1]);
            //adjacent_cell.setCost(cost_matrix[x][y+1]);
            adjacent_cells.add(adjacent_cell);
        }
        return adjacent_cells;
    }


    public Cell findMin_cost_cell(ArrayList<Cell> all_adjacent){
        int min_cell_x = all_adjacent.get(0).getX();
        int min_cell_y = all_adjacent.get(0).getY();
        int min_cell_cost = all_adjacent.get(0).getCost();

        for(int i=1; i<all_adjacent.size(); i++){
            Cell cell = all_adjacent.get(i);
            if(cell.getCost()<min_cell_cost){
                min_cell_x = cell.getX();
                min_cell_y = cell.getY();
                min_cell_cost = cell.getCost();
            }
        }

        Cell min_cost_cell = new Cell(min_cell_x,min_cell_y,min_cell_cost);

        return min_cost_cell;
    }
}
