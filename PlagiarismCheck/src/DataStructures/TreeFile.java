package DataStructures;


//-------------------------------------------------------------------------
/**
* This is a custom class that contains a an Integer BinarySeachTree and a
* string assosciated with the file ofthe binary search tree It is only used to
* keep track of of file names.
*
* @author komelmerchant
* @version Dec 6, 2015
*/
public class TreeFile
{
 private String                    file;
 private BinarySearchTree<Integer> tree;


 // ----------------------------------------------------------
 /**
  * Create a new TreeFile object.
  *
  * @param file
  *            file name
  * @param tree
  *            BST of ngrams
  */
 public TreeFile(String file, BinarySearchTree<Integer> tree)
 {

     this.file = file;
     this.tree = tree;

 }


 // ----------------------------------------------------------
 /**
  * getter for Tree
  *
  * @return tree BST ofengrams
  */
 public BinarySearchTree<Integer> getTree()
 {
     return tree;

 }


 // ----------------------------------------------------------
 /**
  * getter for the file name
  *
  * @return file
  */
 public String getFile()
 {
     return file;
 }

}
