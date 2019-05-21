package jianzhiOffer;

/**
 * problem65:矩阵中的路径
 * description:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e
 *     s f c s
 *     a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * Created by wtwang on 2019/5/16.
 */
public class Problem65 {
    public static void main(String[] args){
//        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
//        char[] str = {'a','b','c','b'};
        char[] matrix = {'A'};
        char[] str = {'A'};
//        char[] str = {'b','c','c','e','d'};
        System.out.println(hasPath(matrix,1,1,str));
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(str.length == 0){
            return false;
        }
        char[][] m = new char[rows][cols];
        for(int i=0;i<matrix.length;++i){
            m[i/cols][i%cols] = matrix[i];
        }
        int index = 0;
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                boolean[][] visited = new boolean[rows][cols];
                if(help(m,i,j,str,0,visited) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean help(char[][] m,int x,int y,char[] str,int index,boolean[][] visited){
        /**
         * 此处判断顺序不能颠倒，对于只有一个元素的m，其上下左右均超出边界，但已经匹配
         */
        if(index == str.length){
            return true;
        }
        if(x<0 || x>=m.length || y<0 || y>=m[0].length){
            return false;
        }
        if(!visited[x][y] && m[x][y] == str[index]){
            visited[x][y] = true;
            return help(m,x-1,y,str,index+1,visited) || help(m,x+1,y,str,index+1,visited)
                    || help(m,x,y-1,str,index+1,visited) || help(m,x,y+1,str,index+1,visited);
        }else{
            return false;
        }
    }
}
