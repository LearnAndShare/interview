package com.practice.dfs;
/*
https://leetcode.com/problems/flood-fill/
 Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)
        floodFillHelper(image,image[sr][sc],sr,sc,newColor);
        return image;
    }

    private void floodFillHelper(int[][] image, int color, int sr, int sc, int newColor) {

        if(sr< image.length && sr>=0 && sc>=0 && sc< image[0].length && image[sr][sc] == color) {
            image[sr][sc] = newColor;
        } else{
            return;
        }
       // if((sr + 1)< image.length )
        floodFillHelper(image,color,sr+1,sc,newColor);
        //if((sr - 1)>= 0 )
        floodFillHelper(image,color,sr-1,sc,newColor);
       // if((sc + 1)<image[0].length )
        floodFillHelper(image,color,sr,sc+1,newColor);
        //if((sc -1)>=0)
        floodFillHelper(image,color,sr,sc-1,newColor);

    }

    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        int [][] img = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        f.floodFill(img,1,1,2);
        for(int i =0;i<img.length;i++){
            for (int j=0;j<img[0].length;j++) {
                System.out.print(img[i][j]);
            }
            System.out.println();
        }
    }
}
