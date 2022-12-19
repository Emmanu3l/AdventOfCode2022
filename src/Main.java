import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> elves = day1();
            System.out.println(Collections.max(elves));
            day2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Integer> day1() throws IOException {
        File file = new File("elves.txt");
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
        return elves;
    }

    public static void day2() throws IOException {
        ArrayList<Integer> elves = day1();
        Collections.sort(elves);
        List<Integer> topElves = elves.subList(elves.size() - 3, elves.size());
        System.out.println(topElves.stream().mapToInt(Integer::intValue).sum());
    }
}