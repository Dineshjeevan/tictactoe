package tictactoc;

public class TicTacToc {

	static char [][] board;
	 
	public TicTacToc(){
		
		board=new char[3][3];
	}
	
	public void initBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				board[i][j]=' ';
			}
		}
	}
	
	
	public static void dispBoard(){
		System.out.println("-------------");
		
		for(int i=0;i<board.length;i++){
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++){
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public static void placeMark(int row,int col,char mark){
		
		if(row>=0 && row<=2 && col>=0 && col<=2){
			board[row][col]=mark;
		}
		else{
			System.out.println("Invalid Position");
		}
	}
  public static boolean checkColWin(){
	  for(int j=0;j<=2;j++){
		  if( board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]){
			  return true;
		  }
	  }
	  return false;
  }
  public static boolean checkRowWin(){
	  for(int i=0;i<=2;i++){
		  if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
			  return true;
		  }
	  }
	  return false;
  }
  
  public static boolean checkDiagWin(){
	  
	  if(board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]
			  || board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]){
		  return true;
	  }
	  else{
		  return false;
	  }
  }
  
  public static boolean checkDraw(){
	  for(int i=0;i<=2;i++){
		  for(int j=0;j<=2;j++){
			  if(board[i][j]==' '){
				  return false;
				  
			  }
		  }
	  }
	  return true;
  }
	public static void main(String[] args) {
		TicTacToc t=new TicTacToc();
		t.initBoard();
	
		HumanPlayer p1=new HumanPlayer("Dinesh", 'X');
		AiPlayer p2=new AiPlayer("jeevan", 'O');
		Player cp;
		cp=p1;
		while(true){
			System.out.println(cp.name+"make move");
			cp.makeMove();
			TicTacToc.dispBoard();
			if(TicTacToc.checkColWin() || TicTacToc.checkRowWin() || TicTacToc.checkDiagWin()){
				System.out.println(cp.name+"won");
				break;
			}
			else if(TicTacToc.checkDraw()){
				System.out.println("Game is a Draw");
				break;
			}
			else{
				if(cp==p1){
					cp=p2;
				}
				else{
	               cp=p1;
			}
			
		}
	  }
   }
}