import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNameGenerator {
    static String[] firstNames_Male = {"Reuven", "Shimon", "Levi", "Yehuda", "Yissachar", "Zevulun", "Dan", "Naphtali", "Gad", "Asher", "Yoseph", "Binyamin"};
    static String[] firstNames_Female = {"Sarah", "Rivka", "Rachel", "Leah", "Miriam", "Devorah", "Chuldah", "Tzippora", "Yocheved", "Channah", "Avigayil", "Esther"};
    static String[] lastNames = {"Goldstein", "Issacs", "Jackier", "Khayyat", "Koppel", "Kupchik", "Maltz", "Markowitz", "Stechler", "Weiss", "Zer"};
    static Random random = new Random();

    public static void main(String[] args) {
        int birthYear_lowerBound = 1975;
        int birthYear_upperBound = 2015;
        
        int iterations = 20;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            String firstName, lastName;
            int birthday, birthMonth, birthYear;
            boolean isFemale = random.nextBoolean();

            if (isFemale) {
                firstName = firstNames_Female[random.nextInt(firstNames_Female.length)];
            } else {
                firstName = firstNames_Male[random.nextInt(firstNames_Male.length)];
            }
            lastName = lastNames[random.nextInt(lastNames.length)];

            birthday = random.nextInt(30) + 1;
            birthMonth = random.nextInt(12) + 1;
            birthYear = random.nextInt(birthYear_lowerBound, birthYear_upperBound);

            output.append(firstName);
            output.append(",");
            output.append(lastName);
            output.append(",");
            if (birthMonth < 10) output.append("0");
            output.append(birthMonth);
            output.append("/");
            if (birthday < 10) output.append("0");
            output.append(birthday);
            output.append("/");
            output.append(birthYear);
            output.append(",");
            output.append(isFemale?"Female":"Male");
            output.append("\n");
        }
        saveToFile(output.toString());
    }
    private static void saveToFile(String output) {
        try {
            FileWriter myWriter = new FileWriter("people.csv");
            myWriter.write(output);
            myWriter.close();
            System.out.println("The following data was saved to the file 'people.csv':");
            System.out.println(output);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
