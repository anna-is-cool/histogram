import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Histogramma {
    private static void swap(int[] array, int a, int b) {
        int k = array[a];
        array[a] = array[b];
        array[b] = k;
    }
    public static void sort(int[] array) {
        for (int out = array.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(array, in, in + 1);
                }
            }
        }
    }
    public static String noRepeats(int[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            String a = "" + (char) array[i];
            if (!str.contains(a)) {
                str += a;
            }
        }
        return str;
    }

    public static int max(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        String result =  new String(Files.readAllBytes(Paths.get("/Users/ann/IdeaProjects/Algorythms/src/text.txt")), StandardCharsets.UTF_8) ;
        String cleared = "";
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != ' ' && result.charAt(i) != '\n') {
                cleared += result.charAt(i);
            }
        }
        int[] str = new int[cleared.length()];
        for (int i = 0; i < cleared.length(); i++) {
           str[i] = (int)cleared.charAt(i);
       }
        sort(str);
        String filtered = noRepeats(str);
        int[] count = new int[str.length];
        for (int i = 0; i < filtered.length(); i++) {
            int c = 0;
            for (int j = 0; j < str.length; j++) {
                if (str[j] == filtered.charAt(i)) c++;
            }
            count[i] = c;
        }

        int max = max(count);
        int k = max;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < str.length; j++) {
                if (count[j] >= k) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            k--;
            System.out.println();
        }
        System.out.println(noRepeats(str));
    }
}
