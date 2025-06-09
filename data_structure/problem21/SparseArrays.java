package data_structure.problem21;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. STRING_ARRAY stringList
     * 2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Count frequencies of each string in stringList
        for (String str : stringList) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }

        // Prepare result list for each query
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            result.add(freqMap.getOrDefault(query, 0));
        }

        return result;
    }
}

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> stringList = IntStream.range(0, stringListCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<Integer> res = Result.matchingStrings(stringList, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}