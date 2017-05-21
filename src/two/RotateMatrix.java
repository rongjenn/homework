package two;

import java.util.Random;

public class RotateMatrix {
	public static void main(String[] args) {
		int height = 10;
		int width = 10;
		int[][] matrix = new int[height][width];
		initMatrix(matrix);
		printMatrix(matrix);
		rotateMatrix(matrix, 0, 0);
		printMatrix(matrix);
	}
	public static void rotateMatrix(int[][] matrix, int h, int w) {
		int leftUpperCornerHIndex = h;
		int leftUpperCornerWIndex = w;
		int rightUpperCornerHIndex = h;
		int rightUpperCornerWIndex = matrix[0].length - 1 - w;
		int rightBottomCornerHIndex = matrix.length - 1 - h;
		int rightBottomCornerWIndex = rightUpperCornerWIndex;
		int leftBottomCornerHIndex = rightBottomCornerHIndex;
		int leftBottomCornerWIndex = leftUpperCornerWIndex;
		
		if(rightUpperCornerWIndex-leftUpperCornerWIndex < 1) {
			return;
		}
		for(int i=0 ; i<=rightUpperCornerWIndex-1-w ; i++) {
			rotate(matrix, 
				   new int[]{leftUpperCornerHIndex, leftUpperCornerWIndex+i},
				   new int[]{rightUpperCornerHIndex+i, rightUpperCornerWIndex},
				   new int[]{rightBottomCornerHIndex, rightBottomCornerWIndex-i},
				   new int[]{leftBottomCornerHIndex-i, leftBottomCornerWIndex});
		}
		rotateMatrix(matrix, h+1, w+1);
	}
	private static void rotate(int[][] matrix, int[] p1, int[] p2, int[] p3, int[] p4) {
		int tmp2 = matrix[p2[0]][p2[1]];
		int tmp3 = matrix[p3[0]][p3[1]];
		int tmp4 = matrix[p4[0]][p4[1]];
		matrix[p2[0]][p2[1]]=matrix[p1[0]][p1[1]];
		matrix[p3[0]][p3[1]]=tmp2;
		matrix[p4[0]][p4[1]]=tmp3;
		matrix[p1[0]][p1[1]]=tmp4;
	}
	public static void initMatrix(int[][] matrix) {
		for(int h=0 ; h<matrix.length ; h++) {
			for(int w=0 ; w<matrix[0].length ; w++) {
				Random random = new Random();
				matrix[h][w] = random.nextInt(100);
			}
		}
	}
	public static void printMatrix(int[][] matrix) {
		for(int h=0 ; h<matrix.length ; h++) {
			for(int w=0 ; w<matrix[0].length ; w++) {
				System.out.print(matrix[h][w] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
