package cse214homework3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ritwik Banerjee Jack Smith ID: 110366081
 */
public class BinarySearchTreeBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<TimeInterval> timeIntervals = new HashSet<>();
        System.out.println("Enter the initial input for the tree by typing Tree: followed by time intervals.");
        String line = scanner.nextLine();
        if (line.startsWith("Tree: ")) {
            Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(line);
            while (matcher.find()) {
                timeIntervals.add(TimeInterval.fromString(matcher.group()));
            }
        }
        BinarySearchTree<TimeInterval> intervalTree = new BinarySearchTree<>();
        timeIntervals.forEach(intervalTree::add);
        intervalTree.print();
        System.out.println("You have 4 commands available: add, remove, search, and print. Enter 'done' to exit the program.");
        System.out.println("For example, 'add (0,3)' or 'print'");
        for (String cmd = ""; !cmd.equals("done"); cmd = scanner.nextLine()) {
            if (cmd.startsWith("add ")) {
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(cmd);
                if (matcher.find()) {
                    intervalTree.add(TimeInterval.fromString(matcher.group()));
                }
            } else if (cmd.startsWith("remove ")) {
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(cmd);
                if (matcher.find()) {
                    intervalTree.remove(TimeInterval.fromString(matcher.group()));
                }
            } else if (cmd.startsWith("search ")) {
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(cmd);
                if (matcher.find()) {
                    System.out.println(intervalTree.find(TimeInterval.fromString(matcher.group())));
                }
            } else if (cmd.startsWith("print")) {
                intervalTree.print();
            }
        }

    }

}