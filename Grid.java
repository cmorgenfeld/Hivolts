public class Grid {
	public static GamePiece[][] field = new GamePiece[12][12];
	
	public void init() {
		int fenceCount = 0;
		for (int i = 0; i < 12; i++) {
			  for (int j = 0; j < 12; j++) {
				  if (i == 0 || i == 11) {
					  field[i][j] = new Fence(i, j);
			      }if (j == 0 || j == 11) {
			    	  field[i][j] = new Fence(i, j);
			      }else if (Math.random() <= 0.2 && fenceCount < 20) {
			    	  field[i][j] = new Fence(i, j);
			    	  fenceCount++;
			      }
			  }
		}
		int mhoCount = 0;
		while (mhoCount < 12) {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					if (field[i][j] == null && Math.random() <= 0.12) {
						field[i][j] = new Mho(i, j, mhoCount);
						mhoCount++;
					}
				}
			}
		}
	}
}
