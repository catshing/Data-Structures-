package HW2;

public class ConnectFour {
	static final int P1=1, P2=2, EMPTY=0;
	
	static final int COLUMNS = 4;
	static final int ROWS = 4;
	
	static int first_player;
	static int p1_score=0, p2_score=0;
	static long recursive_cnt=0;

	public static void main(String[] args) throws Exception {

		// Starting scores
		first_player = P1;

		// All possible first moves
		for (int i=0; i<COLUMNS; i++) {
			int[][] board = createBoard();	// new board every call
			recursive_cnt = 0;
			p1_score = 0;
			p2_score = 0;

			board[ROWS-1][i] = first_player;
			System.out.println ("NetWins:" + Play(board , first_player));
			System.out.println ("Recursion calls: " + recursive_cnt);
			System.out.println("P1 wins:  " + p1_score + " P2 Wins:" + p2_score);
			System.out.println();
		}
	}
	
	public static int[][] createBoard() { // create an empty board
		int[][] new_board = new int[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; ++i) {
			for (int j=0; j<COLUMNS; ++j) {
				new_board[i][j] = EMPTY;
			}
		}
		return new_board;
	}
	
	/* 
	 * Return types: (returns the different between P1 and P2 wins)
	 * 0: No one ones
	 * 1: P1 wins
	 * -1: p2 wins
	 */
	public static int Play(int[][] board, int player) throws Exception {
		if (!(player == P1 || player == P2)) {  // if it is not player 1 or player 2
			throw new Exception("Invalid player " + player);
		}
		
		recursive_cnt++;
		int sum = 0;

		int res = checkBoard(board, player);
		if (res < 3) {
			if (res == 0) {					// Board is full no one wins
				return 0;
			} else {
				if (res == first_player) {   // if the first player wins, then add score of p1
					p1_score++; 
					return 1;
				} else {
					p2_score++;    
					return -1;
				}
			}
		}
		
		// Switch player    if player is p1 then p1, else p2
		player = (player == P1) ? P2 : P1;
		
		int[][] next_board;
		
		for (int col=0; col<COLUMNS; ++col) {
			if (!isColumnFull(board, col)) {					// If column is not full then 
				next_board = placePiece(board, col, player);	// Place piece in column
				sum += Play(next_board, player);				// Pass in new board with last player's move
			}
		}
		
		return sum;
	}
	
	public static boolean isColumnFull(int[][] board, int col) {
		if (board[0][col] != EMPTY) {
			return true;
		}
		return false;
	}
	
	// Clone board, and drop piece into column.
	public static int[][] placePiece(int[][] board, int col, int player) {
		int[][] cloned_board = cloneBoard(board);
		
		for (int row = ROWS-1; row >= 0; --row) {
			if (cloned_board[row][col] == EMPTY) {   //if slot is empty, then place a piece in that slot 
				cloned_board[row][col] = player;
				return cloned_board;
			}
		}
		
		return cloned_board;	// Guaranteed not to reach here since column is NOT FULL!
	}

	public static int[][] cloneBoard(int[][] board) {
		 int[][] clone_board = new int[ROWS][COLUMNS];
		 
			for (int row = 0; row<ROWS; row++){
				for (int col = 0; col<COLUMNS; col++){
					clone_board[row][col] = board[row][col] ;
				}
			}
		return clone_board;
	}
	
	public static boolean isFull(int[][] board){
		boolean empty = true;
		for (int i = 0 ; i<COLUMNS ; i++ ) {
			for (int i2 = 0 ; i2<COLUMNS ; i2++ ) {
				if (board[i][i2] ==0   ) { 
					empty = false; 
					break;} 
			}
		}
		return empty;
	}
	
	/*
	 * START CHECK BOARD ======================================
	 */
	
	/*
	 * Return types:
	 * 0: board full
	 * 1: P1 wins
	 * 2: P2 wins
	 * 3: keep playing
	 */
	public static int checkBoard(int[][] board, int player) throws Exception {
		
		if (!(player == P1 || player == P2)) {
			throw new Exception("Invalid player " + player);
		}
		
		int ret;		// return
				
		ret = checkPlayerWinRows(board, player);
		if (ret != -1)
			return ret;
		
		ret = checkPlayerWinsColumns(board, player);
		if (ret != -1)
			return ret;
		
		ret = checkPlayerWinsDiagnolULLR(board, player);
		if (ret != -1)
			return ret;

		ret = checkPlayerWinsDiagnolLLUR(board, player);
		if (ret != -1)
			return ret;

		if (isFull(board)) 
			return 0; 
			
		return 3;
	}
	
	public static int checkPlayerWinRows(int[][] board, int player) {
		for (int i = 0 ; i<ROWS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<COLUMNS; j++) {
				if (board[i][j] == player) {
					colcnt++;
					if (colcnt == ROWS)  { return player;}	 
				}  else {
					break;
				}
			}
		}
		
		return -1;
	}
	
	public static int checkPlayerWinsColumns(int[][] board, int player) {
		for (int i = 0 ; i<COLUMNS; i++ ) {
			int colcnt = 0;
			for (int j=0; j<COLUMNS; j++) {
				if (board[j][i] == player) {
					colcnt++;
					if (colcnt == ROWS)  { return player;}	 
				}  else {
					break;
				}
			}
		}
		
		return -1;
	}
	
	public static int checkPlayerWinsDiagnolULLR(int[][] board, int player) {
		int colcnt = 0;

		for (int i = 0 ; i<COLUMNS; i++ ) {
			if (board[i][i] == player) {
				colcnt++;
				if (colcnt == ROWS)  {
					return player;
				}	 
			}  else {
				break;
			}
		}
		
		return -1;
	}
	
	public static int checkPlayerWinsDiagnolLLUR(int[][] board, int player) {
		int colcnt = 0;
		
		for (int i = 0 ; i<COLUMNS; i++ ) {
			if (board[COLUMNS-1-i][i] == player) {
				colcnt++;
				if (colcnt == ROWS)  { 
					return player;}	 
			}  else {
				break;
			}
		}
		return -1;
		
	}
	
	/*
	 * END CHECK BOARD ======================================
	 */
	
	public static void printlist(int[][] board) {
		for (int i =0; i<board.length; i++) {
			for (int j =0; j<board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
