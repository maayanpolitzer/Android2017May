
class Feline {
    public String type = "f ";

    public Feline() {
        super();
        System.out.print("feline ");
    }

    public Feline(String type) {
        this.type = type;
    }
}

public class Cougar extends Feline {
    String type;


    public Cougar() {
        super();
        System.out.print("cougar ");
    }

    void go() {
        type = "c ";
        System.out.print(this.type + super.type);
    }

    public static void main(String[] args) {
        new Cougar().go();
        String a = null;
        String b = null;
        if (null == b) {
            System.out.println("true");
        }
        FindPath(-1, -1, 0, 0);
    }


    static int[][] matrix;

    public static int FindPath(int px, int py, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length)
            return -1;
        if (matrix[x][y] == 2)
            return 1;

        int result;
        if ((px != x + 1 || py != y) && matrix[x + 1][y] == 0 && (result = FindPath(x, y, x + 1, y)) != -1) {
            return result + 1;
        } else if ((px != x + 1 || py != y) && matrix[x][y + 1] == 0 && (result = FindPath(x, y, x, y + 1)) != -1) {
            return result + 1;
        } else if ((px != x + 1 || py != y) && matrix[x - 1][y] == 0 && (result = FindPath(x, y, x - 1, y)) != -1) {
            return result + 1;
        } else if ((px != x + 1 || py != y) && matrix[x][y - 1] == 0 && (result = FindPath(x, y, x, y - 1)) != -1) {
            return result + 1;
        } else {
            return -1;
        }
    }


}
