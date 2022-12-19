import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            day1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void day1() throws IOException {
        File file = new File("day1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<Integer> elves = new ArrayList<>();
        int currentSum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isBlank()) {
                currentSum += Integer.parseInt(line);
            } else {
                elves.add(currentSum);
                currentSum = 0;
            }
        }
        System.out.println(Collections.max(elves));
    }
}