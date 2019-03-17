import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

public class CharacterCount{
    private static final Logger log = Logger.getLogger(CharacterCount.class.getName());

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        log.info("Enter InputFile Name");
        /** The value is used for input file name storage. */
        String inputFile = s.next();
        saveInFile(countTheOccurance(inputFile));
    }

    /**
     * Calculate the count of different occurances in input file
     * and stores them in TreeMap.
     * @param   inputFile
     *          The name of the input file upon which count
     *          of different occurances is calculated.
     * @return  The object of the TreeMap that contains count of all occurances.
     * @throws IOException
     */
    public static TreeMap countTheOccurance(String inputFile) throws IOException
    {
        TreeMap<Character, Integer> charCount = new TreeMap<Character, Integer>();
        Scanner sc=null;
        try {
            File file = new File(inputFile);
            sc = new Scanner(file);
            while (sc.hasNext()) {
                char[] chars = sc.nextLine().toCharArray();
                for (Character c : chars) {
                    if (charCount.containsKey(c)) {
                        charCount.put(c, charCount.get(c) + 1);
                    } else {
                        charCount.put(c, 1);
                    }
                }
            }


        }

        catch(Exception e)
        {
            log.info(e.getMessage());
        }

        finally
        {
            if(sc!=null)
                sc.close();

        }
        return charCount;
    }

    /**
     * Stores all the key, value pairs of TreeMap in Output file.
     * @param charCount
     * @throws IOException
     */
    public static void saveInFile(TreeMap charCount) throws IOException
    {
        log.info("Enter OutputFile Name");
        Scanner s = new Scanner(System.in);
        final String outputFile = s.next();
        FileWriter fw =null;
        try {
            fw = new FileWriter(outputFile);
            Set keys = charCount.keySet();
            fw.write("-:Different characters and their count:-"+"\n");
            for (Iterator i = keys.iterator(); i.hasNext(); ) {
                Character key = (Character) i.next();
                Integer value = (Integer) charCount.get(key);
                String str = key + " = " + value + "\n";
                fw.write(str);
            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }

        finally
        {
            if(fw!=null)
                fw.close();

        }

    }


}

/*
*TestCase:
*Enter InputFile Name
* Test
* Enter OutputFile Name
* OutputFile
 */