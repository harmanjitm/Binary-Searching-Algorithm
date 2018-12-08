package problemDomain;

import BST.BSTReferencedBased;
import com.sun.org.apache.bcel.internal.classfile.LineNumber;
import exceptions.TreeException;
import utility.DLL;
import utility.Iterator;

import javax.swing.*;
import java.io.*;

/**
 * COULD NOT GET IT WORKING ;(
 * I tried my best
 */
public class WordTracker {
    static DLL<Word> dll = new DLL<Word>();
    static BSTReferencedBased<Word> bst = new BSTReferencedBased<>();
    static String output = null;

    public static void main(String args[])
    {
        if(args.length == 2 || args.length == 3)
        {
            String flag = args[0].replace("-","");
            String file = args[1];
            if(flag.equals("pf") || flag.equals("pl")|| flag.equals("po"))
            {
                readFile(file);
//                if(flag.equals("pf"))
//                {
//                    pf();
//                }
//                if(flag.equals("pl"))
//                {
//                    pl();
//                }
//                if(flag.equals("po"))
//                {
//                    po();
//                }
            }
            else
            {
                System.out.println("First: " + args[0] + " Second: " + args[1]);
                System.out.println("Invalid parameters");
            }

            if(args.length == 3)
            {
                if(args[2].substring(1,2).equals("f"))
                {
                    output = args[2].substring(2);
                }
            }
        }
        else
        {
            System.out.println("Invalid arguments. Check the README.txt file");
        }
    }

    public static String removeGarbage(String line)
    {
        String finalLine = "";
        for(int i=0;i<line.length();i++)
        {
            if(Character.isLetter(line.charAt(i)))
            {
                finalLine += line.charAt(i);
            }
            if(Character.isWhitespace(line.charAt(i)))
            {
                finalLine += "%%";
            }
        }
        return finalLine;
    }

    public static void readFile(String file)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            String line = br.readLine();
            int lineNum = 0;
            while(line!=null)
            {
                lineNum+=1;
                String[] fields = removeGarbage(line).split("%%");
                for(int i=0;i<fields.length;i++)
                {
                    Word check = new Word(fields[i]);
                    check.setLineNum(lineNum + ";");
                    check.setFileName(file);
                    dll.add(check);
//                    System.out.println(dll.get(i));
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Whoops something went wrong.");
        }
        checkDuplicates();
        System.out.println("BST: " + bst.size() + " DLL: " + dll.size());
    }

    /**
     * COULD NOT GET IT WORKING ;(
     * I tried my best
     */
    public static void checkDuplicates()
    {
        int[] dupes = new int[dll.size()];
        for(int i = 0;i<dll.size();i++)
        {
            for(int k = 0;k<dll.size();i++)
            {
                if(dll.get(k).getWord().equals(dll.get(i).getWord()))
                {
                    Word newWord = dll.get(k);
                    newWord.setLineNum(newWord.getLineNum() + dll.get(i).getLineNum());
                    dll.set(i, newWord);
                    dupes[i] = i;
                    System.out.println(dll.get(i));
                }
            }
        }
    }

    public static void pf()
    {

    }

    public static void pl()
    {

    }

    public static void po()
    {

    }
}
