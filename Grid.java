
public class Grid {
  GamePiece[][] field = new GamePiece[12][12];
  
  for (int i = 0; i < 12; i++) {
    for (int j = 0; i < 12; i++) {
      if (i == 0 || i == 11) {
        field[i][j] = You();
      }
    }
  }
    
  
}
