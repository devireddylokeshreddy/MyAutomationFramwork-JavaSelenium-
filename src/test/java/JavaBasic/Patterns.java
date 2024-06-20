package JavaBasic;

public class Patterns {
    public static void main(String[] args){
        int n = 7;
        for (int i = 0; i < n; i++){
            for (int k = 0; k <= i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = n-1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < n; i++){
            for (int j = n-i; j > 1; j--){
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 1; i <= n; i++){
            if (i==7){
                break;
            }
            for (int j = 1; j < i; j++){
                System.out.print(" ");
            }
            for (int k = i; k <= n; k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }

//        System.out.println();
        for (int i = n; i > 0; i--){
            for (int j = 1; j < i; j++){
                System.out.print(" ");
            }
            for (int k = i; k <= n; k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("*");
                if (j == i){
                    System.out.print("");
                } else{
                    System.out.print("|");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++){
                System.out.print("# ");
            }
            System.out.println();
        }

    }
}
