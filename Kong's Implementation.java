package hci2022fall;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This Java library contains methods that students may find useful when they
 * are working on projects in my courses.
 * <p>
 * Copyright Dr. Kam Kong
 */
public class KkHciLib {
  static private Scanner consScanner = null;
  /**
   * Returns a random boolean with probability p being true.
   */
  static public boolean randBool(double p) {
    return p < 0.000001 ? false : (p > 0.999999 ? true : Math.random() < p);
  }
  /**
   * Returns a random integer n such that:   min <= n <= max.
   */
  static public int randInt(int min, int max) {
    return min + (int) ((max - min + 1) * Math.random());
  }

  /**
   * Returns a random decimal number x such that:   min <= x < max.
   */
  static public double randDbl(double min, double max) {
    return min + (int) ((max - min + 1) * Math.random());
  }

  /**
   * Parses an integer from a string, expects the result within given bounds.
   * Returns errVal if something is wrong.
   */
  static public int parseInt(String intStr, int min, int max, int errVal) {
    int val = errVal;
    try {
      val = Integer.parseInt(intStr.trim());
    } catch (Exception e) {
      return errVal;
    }
    return min <= val && val <= max ? val : errVal;
  }
  /**
   * Parses a decimal number from a string, expects the result within given bounds.
   * Returns errVal if something is wrong.
   */
  static public double parseDbl(String numStr, double min, double max, double errVal) {
    double val = errVal;
    try {
      val = Double.parseDouble(numStr.trim());
    } catch (Exception e) {
      return errVal;
    }
    return min <= val && val <= max ? val : errVal;
  }
  /**
   * Prompts the user for a string input (inside a console window).
   */
  static public String consInpStr(String prompt) {
    if (consScanner == null) {
      consScanner = new Scanner(System.in);
    }
    System.out.print(prompt);
    return consScanner.nextLine();
  }
  /**
   * Prompts the user for a non-empty string input (inside a console window).
   * Returns errVal if something is wrong.
   */
  static public String consInpStr(String prompt, String errVal) {
    if (consScanner == null) {
      consScanner = new Scanner(System.in);
    }
    try {
      System.out.print(prompt);
      String line = consScanner.nextLine();
      if (line.trim().equals("")) {
        return errVal;
      }
      return line;
    } catch (Exception e) {
      return errVal;
    }
  }
  /**
   * Prompts the user for an integer input, expects the result within the specified bounds.
   * Returns errVal if something is wrong.
   */
  static public int consInpInt(String prompt, int min, int max, int errVal) {
    return parseInt(consInpStr(prompt), min, max, errVal);
  }
  /**
   * Prompts the user for a decimal number input, expects the result within the specified bounds.
   * Returns errVal if something is wrong.
   */
  static public double consInpDbl(String prompt, double min, double max, double errVal) {
    return parseDbl(consInpStr(prompt), min, max, errVal);
  }

  /**
   * Returns an array of the individual words (without spaces) in the source string.
   * Returns null if something is wrong.
   */
  static public String[] extractWords(String src) {
    if (src == null) {
      return null;
    }
    return src.trim().split("\\s+");
  }

  static public void writeTextFile(String filename, String contents) {
    try {
      File file = new File(filename);
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(contents);
      fileWriter.close();
      System.out.printf("Text file written \"%s\"\n", file.getAbsolutePath());
    } catch (Exception e) {
      System.out.printf("Cannot write text file \"%s\"", filename);
    }
  }
  /**
   * Returns null if something is wrong.
   */
  static public List<String> readTextFile(String filename, boolean nonEmptyOnly) {
    try {
      List<String> lines = new ArrayList<>();
      File file = new File(filename);
      Scanner fileScanner = new Scanner(file);
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        if (nonEmptyOnly) {
          line = line.trim();
          if (!line.equals("")) {
            lines.add(line);
          }
        } else {
          lines.add(line);
        }
      }
      fileScanner.close();
      return lines;
    } catch (Exception e) {
      System.out.printf("Cannot read text file \"%s\"", filename);
      return null;
    }
  }
}





package hci2022fall;

public class Kam2022F_quiz1a {
  static public void main(String[] args) {
    int gridOfsX = KkHciLib.consInpInt("grid margin:  left      eg: 20   ", 0, 50, KkHciLib.randInt(5, 30));
    int gridOfsY = KkHciLib.consInpInt("grid margin:  top       eg: 20   ", 0, 50, KkHciLib.randInt(5, 30));
    int tileGapX = KkHciLib.consInpInt("tile gap:  horizontal   eg: 10   ", 0, 40, KkHciLib.randInt(3, 20));
    int tileGapY = KkHciLib.consInpInt("tile gap:  vertical     eg: 10   ", 0, 40, KkHciLib.randInt(3, 20));
    int tileSizX = KkHciLib.consInpInt("tile size:  width       eg: 80   ", 40, 120, KkHciLib.randInt(60, 90));
    int tileSizY = KkHciLib.consInpInt("tile size:  height      eg: 80   ", 40, 120, KkHciLib.randInt(60, 90));
    int tileCntX = KkHciLib.consInpInt("tile count: per row     eg: 7    ", 1, 20, KkHciLib.randInt(5, 9));
    int tileCntY = KkHciLib.consInpInt("tile count: per column  eg: 7    ", 1, 20, KkHciLib.randInt(5, 9));
    String tileColorA = KkHciLib.consInpStr("tile color: A   eg: pink, #F27A05, rgb(50,10,230)   ", "blue");
    String tileColorB = KkHciLib.consInpStr("tile color: B   eg: blue, #F27A05, rgb(50,10,230)   ", "orange");
    String fc = "<html><body>\n";  // file contents
    fc += "<h2>Procedural Generated SVG Checkerboard Pattern by Kam Kong</h2>\n";
    fc += String.format("gridOfsX,Y=%d,%d   tileGapX,Y=%d,%d   tileSizX,Y=%d,%d   tileCntX,Y=%d,%d<br>\n",
            gridOfsX, gridOfsY, tileGapX, tileGapY, tileSizY, tileSizY, tileCntX, tileCntY);
    fc += String.format("tileColorA,B=%s,%s\n", tileColorA, tileColorB);
    fc += "<div><svg width=\"1000\" height=\"800\">\n";
    for (int iy = 0; iy < tileCntY; iy++) {
      int y = gridOfsY + iy * (tileSizY + tileGapY);
      for (int ix = 0; ix < tileCntX; ix++) {
        int x = gridOfsX + ix * (tileSizX + tileGapX);
        String fill = (ix + iy) % 2 == 0 ? tileColorA : tileColorB;
        fc += String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"fill:%s\" />\n",
                x, y, tileSizX, tileSizY, fill);
      }
    }
    fc += "</svg></div></body></html>\n";
    KkHciLib.writeTextFile("HCI Kam Kong quiz-1.html", fc);
  }

}