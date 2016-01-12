package DataStructures;

//-------------------------------------------------------------------------
/**
* This class is used to keep track of counter matches and the String
* which corresponds to
*  @author komelmerchant
*  @version Dec 5, 2015
*/
public class Sorter implements Comparable<Sorter>
{
 /**
  * name of the second file
  */
 String file1;
 /**
  * name of second file being
  */
 String file2;
 /**
  * number of matches or hits two files had with eachother
  */
 int    matches;


 // ----------------------------------------------------------
 /**
  * Create a new Sorter object.
  * @param file1 name of file 1
  * @param file2 name of file2
  * @param matches matches file1 adn file2 had
  */
 public Sorter(String file1, String file2, int matches)
 {
     this.file1 = file1;
     this.file2 = file2;
     this.matches = matches;
 }

 // ----------------------------------------------------------
 /**
  * retrieve the number of matches
  * @return matches
  */
 public int getMatches() {


     return matches;
 }
 // ----------------------------------------------------------
 /**
  * Place a description of your method here.
  * @return jointFile a single stirng that corresponds to to files
  */
 public String getJointFile() {

     return file1 + " compared with " + file2 + " recieves: ";
 }





 /**
  * method for compare to sorting method
  * @return positive number if
  */
 public int compareTo(Sorter match)
 {
     if( this.matches == match.matches) {
         return 0;

     }
     else if(this.matches > match.matches) {
         return -1;
     }
     else {
         return 1;
     }
 }



}
