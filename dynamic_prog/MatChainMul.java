import java.util.Arrays;

public class MatChainMul {

	static class FinalCost
	{
		public String label = "";
		public int cost = Integer.MAX_VALUE;
	}

	private void optimalCost(int[][] matrices,
							String[] labels, int prevCost,
							FinalCost finalCost)
	{
		int len = matrices.length;

		if (len < 2)
		{
			finalCost.cost = 0;
			return;
		}
		else if (len == 2)
		{
			int cost = prevCost
					+ (matrices[0][0] *
						matrices[0][1] *
						matrices[1][1]);

			// This is where minimal cost has been caught
			// for whole program
			if (cost < finalCost.cost)
			{
				finalCost.cost = cost;
				finalCost.label
					= "(" + labels[0]
					+ labels[1] + ")";
			}
			return;
		}

		// recursive Reduce
		for (int i = 0; i < len - 1; i++)
		{
			int j;
			int[][] newMatrix = new int[len - 1][2];
			String[] newLabels = new String[len - 1];
			int subIndex = 0;

			// STEP-1:
			// - Merge two matrices's into one - in each
			// loop, you move merge position
			//	 - if i = 0 THEN (AB) C D ...
			//	 - if i = 1 THEN A (BC) D ...
			//	 - if i = 2 THEN A B (CD) ...
			// - and find the cost of this two matrices
			// multiplication
			int cost = (matrices[i][0] * matrices[i][1]
						* matrices[i + 1][1]);

			// STEP - 2:
			// - Build new matrices after merge
			// - Keep track of the merged labels too
			for (j = 0; j < i; j++) {
				newMatrix[subIndex] = matrices[j];
				newLabels[subIndex++] = labels[j];
			}

			newMatrix[subIndex][0] = matrices[i][0];
			newMatrix[subIndex][1] = matrices[i + 1][1];
			newLabels[subIndex++]
				= "(" + labels[i] + labels[i + 1] + ")";

			for (j = i + 2; j < len; j++) {
				newMatrix[subIndex] = matrices[j];
				newLabels[subIndex++] = labels[j];
			}

			optimalCost(newMatrix, newLabels,
						prevCost + cost, finalCost);
		}
	}

	public FinalCost findOptionalCost(int[] arr)
	{
		// STEP -1 : Prepare and convert inout as Matrix
		int[][] matrices = new int[arr.length - 1][2];
		String[] labels = new String[arr.length - 1];

		for (int i = 0; i < arr.length - 1; i++) {
			matrices[i][0] = arr[i];
			matrices[i][1] = arr[i + 1];
			labels[i] = Character.toString((char)(65 + i));
		}
		printMatrix(matrices);

		FinalCost finalCost = new FinalCost();
		optimalCost(matrices, labels, 0, finalCost);

		return finalCost;
	}

	/**
	* Driver Code
	*/
	public static void main(String[] args)
	{
		MatChainMul calc = new MatChainMul();

		// ======= *** TEST CASES **** ============

		int[] arr = { 30, 35, 15, 5, 10, 20, 25 };
		FinalCost cost = calc.findOptionalCost(arr);
		System.out.println("Final labels: \n" + cost.label);
		System.out.println("Final Cost:\n" + cost.cost);
	}

	/**
	* Ignore this method
	* - THIS IS for DISPLAY purpose only
	*/
	private static void printMatrix(int[][] matrices)
	{
		System.out.print("matrices = \n[");
		for (int[] row : matrices) {
			System.out.print(Arrays.toString(row) + " ");
		}
		System.out.println("]");
	}
}

// This code is contributed by suvera
