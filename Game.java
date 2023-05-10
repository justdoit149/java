public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s) {
        char ans[][] = {{' ', 'A', 'B', 'C'},
                {'1', '_', '_', '_'},
                {'2', '_', '_', '_'},
                {'3', '_', '_', '_'}};

        String[] str = new String[15];
        str = s.split(",");
        for (int i = 0; i < str.length; i++) {
            char[] inchar = new char[3];
            inchar = str[i].toCharArray();
            if (i % 2 == 0) {
                ans[inchar[1] - '0'][inchar[0] - 'A' + 1] = 'X';
            } else {
                ans[inchar[1] - '0'][inchar[0] - 'A' + 1] = 'O';
            }
            for(int j = 0; j <= 3; j++){
                for(int k = 0; k < 3; k++){
                    System.out.printf("%c ",ans[j][k]);
                }
                System.out.println(ans[j][3]);
            }
//ToDo 这个枚举怎么优化捏
            if ((ans[1][1] == 'X' && ans[1][2] == 'X' && ans[1][3] == 'X') ||
                    (ans[2][1] == 'X' && ans[2][2] == 'X' && ans[2][3] == 'X') ||
                    (ans[3][1] == 'X' && ans[3][2] == 'X' && ans[3][3] == 'X') ||
                    (ans[1][1] == 'X' && ans[2][1] == 'X' && ans[3][1] == 'X') ||
                    (ans[1][2] == 'X' && ans[2][2] == 'X' && ans[3][2] == 'X') ||
                    (ans[1][3] == 'X' && ans[2][3] == 'X' && ans[3][3] == 'X') ||
                    (ans[1][1] == 'X' && ans[2][2] == 'X' && ans[3][3] == 'X') ||
                    (ans[3][1] == 'X' && ans[2][2] == 'X' && ans[1][3] == 'X')) {
                return Result.X_WIN;
            } else if ((ans[1][1] == 'O' && ans[1][2] == 'O' && ans[1][3] == 'O') ||
                    (ans[2][1] == 'O' && ans[2][2] == 'O' && ans[2][3] == 'O') ||
                    (ans[3][1] == 'O' && ans[3][2] == 'O' && ans[3][3] == 'O') ||
                    (ans[1][1] == 'O' && ans[2][1] == 'O' && ans[3][1] == 'O') ||
                    (ans[1][2] == 'O' && ans[2][2] == 'O' && ans[3][2] == 'O') ||
                    (ans[1][3] == 'O' && ans[2][3] == 'O' && ans[3][3] == 'O') ||
                    (ans[1][1] == 'O' && ans[2][2] == 'O' && ans[3][3] == 'O') ||
                    (ans[3][1] == 'O' && ans[2][2] == 'O' && ans[1][3] == 'O')) {
                return Result.O_WIN;

            } else if (i == str.length - 1 && i == 8) {
                return Result.DRAW;
            } else if (i == str.length - 1 && i < 8) {
                return Result.GAMING;
            }
        }
        return null;
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
