package DataStructures;


//-------------------------------------------------------------------------
/**
* Implements an unbalanced binary search tree. Note that all "matching" is
* based on the compareTo() method.
*
* @param <T>
*            The type of data element contained in the node.
* @author Mark Allen Weiss (with modifications by John Lewis)
* @author komelmercahnt
* @version 2015.11.17 (modified)
*/
public class BinarySearchTree<T extends Comparable<? super T>>
{
 // ~ Instance/static variables .............................................

 private BinaryNode<T> root;

 // ~ Constructor ...........................................................


 // ----------------------------------------------------------
 /**
  * Constructs an empty tree.
  */

 public BinarySearchTree()
 {
     root = null;
 }

 // ~ Public methods ........................................................


 // ----------------------------------------------------------
 /**
  * Insert into the tree.
  *
  * @param x
  *            the item to insert. if x is already present.
  */
 public void insert(T x)
 {
     root = insert(x, root);
 }


 // ----------------------------------------------------------
 /**
  * retrieves the value of the root node of the tree
  *
  * @return root the root of the tree
  */
 public BinaryNode<T> getRoot()
 {

     return root;
 }


 // ----------------------------------------------------------
 /**
  * Find the smallest item in the tree.
  *
  * @return The smallest item, or null if the tree is empty.
  */
 public T findMin()
 {
     return elementAt(findMin(root));
 }


 // ----------------------------------------------------------
 /**
  * Find the largest item in the tree.
  *
  * @return The largest item in the tree, or null if the tree is empty.
  */
 public T findMax()
 {
     return elementAt(findMax(root));
 }


 // ----------------------------------------------------------
 /**
  * Find an item in the tree.
  *
  * @param x
  *            the item to search for.
  * @return the matching item or null if not found.
  */
 public T find(T x)
 {
     return elementAt(find(x, root));
 }


 // ----------------------------------------------------------
 /**
  * Make the tree logically empty.
  */
 public void makeEmpty()
 {
     root = null;
 }


 // ----------------------------------------------------------
 /**
  * Test if the tree is logically empty.
  *
  * @return true if empty, false otherwise.
  */
 public boolean isEmpty()
 {
     return root == null;
 }


 // ----------------------------------------------------------
 /**
  * Internal method to get element value stored in a tree node, with safe
  * handling of null nodes.
  *
  * @param node
  *            the node.
  * @return the element field or null if node is null.
  */
 private T elementAt(BinaryNode<T> node)
 {
     return (node == null) ? null : node.getElement();
 }


 // ----------------------------------------------------------
 /**
  * Internal method to insert a value into a subtree. Modified to not throw
  * DuplicateItemSxception (multiple string of same kind can exist)
  *
  * @param x
  *            the item to insert.
  * @param node
  *            the node that roots the subtree.
  * @return the new root of the subtree.
  */
 private BinaryNode<T> insert(T x, BinaryNode<T> node)
 {
     if (node == null) // isnt a node like that there
     {

         return new BinaryNode<T>(x);
     }
     else if (x.compareTo(node.getElement()) > 0)
     {

         node.setRight(insert(x, node.getRight()));

     }
     else if (x.compareTo(node.getElement()) < 0)
     {

         node.setLeft(insert(x, node.getLeft()));

     }

     return node;

 }

 // ----------------------------------------------------------


 // ----------------------------------------------------------
 /**
  * Internal method to find the smallest item in a subtree.
  *
  * @param node
  *            the node that roots the tree.
  * @return node containing the smallest item.
  */
 private BinaryNode<T> findMin(BinaryNode<T> node)
 {
     if (node == null)
     {
         return node;
     }
     else if (node.getLeft() == null)
     {
         return node;
     }
     else
     {
         return findMin(node.getLeft());
     }
 }


 // ----------------------------------------------------------
 /**
  * Internal method to find the largest item in a subtree.
  *
  * @param node
  *            the node that roots the tree.
  * @return node containing the largest item.
  */
 private BinaryNode<T> findMax(BinaryNode<T> node)
 {
     if (node == null)
     {
         return node;

     }
     if (node.getRight() == null)
     {
         return node;
     }
     else
     {
         return findMax(node.getRight());
     }
 }


 // ----------------------------------------------------------
 /**
  * Internal method to find an item in a subtree.
  *
  * @param x
  *            is item to search for.
  * @param node
  *            the node that roots the tree.
  * @return node containing the matched item.
  */
 private BinaryNode<T> find(T x, BinaryNode<T> node)
 {
     if (node == null)
     {

         return null;
     }
     if (x.compareTo(node.getElement()) > 0)
     {

         return find(x, node.getRight());
     }
     else if (x.compareTo(node.getElement()) < 0)
     {

         return find(x, node.getLeft());
     }
     else
     {
         return node;
     }
 }

}

