class Solution {
    public void solve(char[][] board) {
       int r=board.length;
       int c=board[0].length;
       char mark[][]=new char[r][c];
       for(int i=0;i<c;i++)
       {
        if(board[0][i]=='O')
        {
          mark[0][i]='O';
        markit(0,i,r,c,board,mark);
        }
        if(board[r-1][i]=='O')
        {
          mark[r-1][i]='O';
        markit(r-1,i,r,c,board,mark);
        }
       } 
       for(int i=1;i<r-1;i++)
       {
        if(board[i][0]=='O')
        {
          mark[i][0]='O';
        markit(i,0,r,c,board,mark);
        }
        if(board[i][c-1]=='O')
        {
          mark[i][c-1]='O';
        markit(i,c-1,r,c,board,mark);
        }
       }
       for(int i=0;i<r;i++)
       {
        for(int j=0;j<c;j++)
        {
          if(board[i][j]=='O' && mark[i][j]!='O')
          board[i][j]='X';
        }
       }
    }
    void markit(int i,int j,int er,int ec,char board[][],char mark[][])
{
     if(i+1<er&&board[i+1][j]=='O'&& mark[i+1][j]!='O')
     {
      mark[i+1][j]='O';
      markit(i+1,j,er,ec,board,mark);
     }
     if(j+1<ec&&board[i][j+1]=='O'&& mark[i][j+1]!='O')
     {
      mark[i][j+1]='O';
      markit(i,j+1,er,ec,board,mark);
     }
     if(i-1>=0&&board[i-1][j]=='O'&& mark[i-1][j]!='O')
     {
      mark[i-1][j]='O';
      markit(i-1,j,er,ec,board,mark);
     }
     if(j-1>=0&&board[i][j-1]=='O'&& mark[i][j-1]!='O')
     {
      mark[i][j-1]='O';
      markit(i,j-1,er,ec,board,mark);
     }
}
}
