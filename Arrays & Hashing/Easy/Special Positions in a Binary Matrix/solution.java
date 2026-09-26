class Solution {
    public int numSpecial(int[][] mat) {
      int count =0;
      for (int i=0;i<mat.length;i++){
        for (int j=0;j<mat[0].length;j++){
            if (mat[i][j]==1){
                int rowCount = 0;
                int colCount =0;


                for(int k=0;k<mat[0].length;k++){
                    if (mat[i][k]==1){
                        rowCount++;
                    }
                }
                for (int k=0;k<mat.length;k++){
                    if (mat[k][j]==1){
                        colCount++;
                    }
                }

if (rowCount == 1 && colCount == 1){
    count ++;
}


            }
        }
      } 

    return count;
    }
    }