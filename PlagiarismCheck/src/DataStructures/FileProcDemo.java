package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * reading a file folder and comparing all of the ngram wrds
 *
 * @author komelmerchant
 * @version Nov 5, 2015
 */
public class FileProcDemo
{
/// /Users/komelmerchant/Desktop/CSE17/Test

    // ----------------------------------------------------------
    /**
     * main method
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args)
        throws IOException
    {
        // "/Users/komelmerchant/Desktop/CSE17/CSE17_F15_Project_DataSets-1/large_set/"

        File folder = new File(args[0]);
        int wordNum = Integer.parseInt(args[1]);
        int threshold = Integer.parseInt(args[2]);

        // this arraylist contains all the binary tree files
        ArrayList<TreeFile> treeHolder = new ArrayList<TreeFile>();

        // this arrylist will store all the sorted matches
        ArrayList<Sorter> matchSorter = new ArrayList<Sorter>();
        int counter = 0;
        for (File text : folder.listFiles())
        {
            BufferedReader bufferReader =
                new BufferedReader(new FileReader(text));
            BinarySearchTree<Integer> fileTree =
                new BinarySearchTree<Integer>();

            counter++;
            String line = "";
            while ((line = bufferReader.readLine()) != null) // Now we read the
                                                             // file a line a a
                                                             // time
            {
                Scanner scan = new Scanner(line);

                ArrayDeque<String> myQueue = new ArrayDeque<String>();

                while (scan.hasNext())
                {
                    String str = scan.next();
                    // add word to the queue
                    myQueue.add(str);

                    // once queue size is 6, get rid for the first word
                    if (myQueue.size() >= wordNum)
                    {

                        // add endgram as a node to a tree

                        fileTree.insert(myQueue.toString().hashCode());

                        myQueue.remove();

                    }

                }

                scan.close();

            }

            // make tree into a tree file along with file information
            treeHolder.add(new TreeFile(text.toString(), fileTree));
            bufferReader.close();

        }

        // print how many file hae been sotred
        System.out.println(
            counter + " files loaded in to the treeHolder," + " the files with "
                + threshold + " matches of " + wordNum
                + "-word combinations is coming up!");
        System.out.println("");

        // outer loop loop to chose first tree file to compare to
        for (int i = 0; i < treeHolder.size(); i++)
        {
            BinarySearchTree<Integer> file1 = treeHolder.get(i).getTree();
            // loop to compare first chosen tree to all the subsequent ones
            for (int j = i + 1; j < treeHolder.size(); j++)
            {

                BinarySearchTree<Integer> file2 = treeHolder.get(j).getTree();

                int matches = treeFileSearch(file1, file2);

                // if the statement allows me to only put values above or equals
                // to a certain point into tthe array list of cheaters
                if (matches >= threshold)
                {

                    matchSorter.add(new Sorter(
                        treeHolder.get(i).getFile(),
                        treeHolder.get(j).getFile(),
                        matches));

                }
            }

        }
        Collections.sort(matchSorter); // sort all teh countes above the
                                       // threshold
        for (int i = 0; i < matchSorter.size(); i++)
        {

            // print the files of the cheaters
            System.out.println(matchSorter.get(i).getJointFile());

            // the number of matches with the corresponding cheater file

            System.out.println(matchSorter.get(i).getMatches() + " matches");

        }

        // good-bye MESSAGE to know that were done running

        System.out.println("Thank you for using the Binary Plaigerist Program");
    }


    // ----------------------------------------------------------
    /**
     * Helper method to search tree which takes in two inputs
     *
     * @param file1
     *            tree of the first file inputes to comare to
     * @param file2
     *            tree of the second file comapred to
     * @return number matches
     */
    public static int treeFileSearch(
        BinarySearchTree<Integer> file1,
        BinarySearchTree<Integer> file2)
    {

        return treeFileSearch(file1.getRoot(), file2);

    }


    /**
     * // ---------------------------------------------------------- /** This is
     * helper method to search the tree for combinations
     *
     * @param root
     *            the root of the first file being searched
     * @param file2
     *            the second file
     * @return number of matched between one and two
     */
    private static int treeFileSearch(
        BinaryNode<Integer> root,
        BinarySearchTree<Integer> file2)
    {

        // once the tree his done being looked at
        if (root == null)
        {

            return 0;
        }
        // if the tree doesnt contain the word don't add to counter
        if (file2.find(root.getElement()) == null)
        {
            return treeFileSearch(root.getLeft(), file2)
                + treeFileSearch(root.getRight(), file2);
        }
        // if there is a match (find is non null), add one to counter
        return 1 + treeFileSearch(root.getLeft(), file2)
            + treeFileSearch(root.getRight(), file2);

    }

}
