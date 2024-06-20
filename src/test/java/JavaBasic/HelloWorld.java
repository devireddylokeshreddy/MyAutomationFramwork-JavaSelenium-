package JavaBasic;

public class HelloWorld {
    public static void main(String[] args) {
        String str = "devireddy";
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            int count = 1;
            for (int j = i+1; j < str.length(); j++){
                if (ch[i] == ch[j]){
                    ch[j] = '$';
                    count++;
                }
            }
            if (count > 1 && ch[i] != '$'){
                System.out.println(ch[i]);
            }
        }
    }
}
