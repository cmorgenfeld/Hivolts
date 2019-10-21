
public class Grid {
  GamePiece[][] field = new GamePiece[12][12];
  int fenceCount = 0;
  for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 12; j++) {
      if (i == 0 || i == 11) {
        field[i][j] = new Fence(i, j);
      }
      if (j == 0 || j == 11) {
        field[i][j] = new Fence(i, j);
      }
      else if (Math.random() >= 0.2 && fenceCount < 20) {
        field[i][j] = new Fence(i, j);
        fenceCount++;
      }
    }
  }
    
  
}
