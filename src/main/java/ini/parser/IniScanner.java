/* The following code was generated by JFlex 1.3.5 on 9/28/19 7:54 AM */


/*
 * This source code file is the exclusive property of its author. No copy or 
 * usage of the source code is permitted unless the author contractually 
 * allows it under the terms of a well-defined agreement.
 */

package ini.parser;

import java_cup.runtime.*;
import ini.ast.Token;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 9/28/19 7:54 AM from the specification file
 * <tt>file:/Users/renaudpawlak/Documents/INI/ini/src/main/java/ini/parser/ini.lex</tt>
 */
class IniScanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  final public static int YYEOF = -1;

  /** initial size of the lookahead buffer */
  final private static int YY_BUFFERSIZE = 16384;

  /** lexical states */
  final public static int LAMBDA = 4;
  final public static int STRING = 1;
  final public static int EMBEDED_EXPRESSION2 = 6;
  final public static int EMBEDED_EXPRESSION1 = 5;
  final public static int YYINITIAL = 0;
  final public static int CHAR = 2;
  final public static int USERTYPE = 3;

  /** 
   * Translates characters to character classes
   */
  final private static String yycmap_packed = 
    "\11\0\1\3\1\1\1\0\1\3\1\2\22\0\1\3\1\54\1\5"+
    "\1\10\1\60\1\0\1\61\1\64\1\20\1\17\1\7\1\62\1\21"+
    "\1\43\1\16\1\6\1\14\11\15\1\45\1\0\1\52\1\53\1\44"+
    "\1\57\1\63\32\13\1\50\1\4\1\51\1\0\1\12\1\0\1\36"+
    "\1\11\1\33\1\42\1\34\1\30\1\11\1\41\1\22\2\11\1\37"+
    "\1\23\1\32\1\25\1\24\1\11\1\26\1\35\1\27\1\31\3\11"+
    "\1\40\1\11\1\46\1\56\1\47\1\55\uff81\0";

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = yy_unpack_cmap(yycmap_packed);

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    53,   106,   159,   212,   265,   318,   371,   371,   424, 
      371,   477,   530,   371,   583,   636,   689,   742,   795,   848, 
      371,   901,   371,   954,  1007,  1060,  1113,  1166,  1219,  1272, 
     1325,  1378,  1431,  1484,   371,   371,   371,   371,   371,  1537, 
     1590,  1643,   371,  1696,   371,   371,  1749,  1802,   371,   371, 
      371,   371,  1855,  1908,   371,   371,  1961,  2014,  2067,  2120, 
     2173,  2226,   371,   371,   371,  2279,   371,   371,   371,  2332, 
     2385,   371,  1696,   371,   583,  2438,   424,  2491,  2544,  2597, 
     2650,  2703,   371,   901,  2756,  2809,  2862,  2915,   636,  2968, 
     3021,  3074,  3127,  3180,  3233,  3286,  3339,  3392,   371,   371, 
      371,   371,   371,   371,   371,   371,   371,   371,   371,  1908, 
      371,   371,  3445,  3498,  3551,  3604,  3657,  2173,  3710,   371, 
     3763,  3816,   371,   371,  3869,   371,  3922,  3975,  2491,  4028, 
     4081,  4134,  4187,  4240,  4293,  4346,  4399,  4452,  4505,  4558, 
     4611,  4664,  4717,  4770,  4823,  4876,  4929,  4982,  5035,  5088, 
      636,   636,   636,  5141,  5194,   636,   636,  5247,  5300,  5353, 
     5406,  5459,  5512,  5565,  5618,  5671,  5724,  5777,   636,  5830, 
     5883,  5936,   371,  5989,  6042,   636,  6095,   636,  6148,  6201, 
     6254,  6307,  6360,  6413,   636,  6466,   636,  6519,  6572,  6625, 
      636,  6678,  6731,  6784,  6837,  6890,  6943,  6996,  7049,  7102, 
     7155,  7208,  7261,  7314,  7367,  7420,  7473,  7526,  7579,  7632, 
     7685,  7738,  7791,  7844,  7897,  7950,  8003,  8056,   636,  8109, 
      371,  8162,  8215,   636,   371
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\10\1\11\1\12\1\13\1\10\1\14\1\15\1\16"+
    "\1\17\1\20\1\10\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\20\1\31\1\32\1\33\1\34"+
    "\1\35\2\20\1\36\1\37\5\20\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
    "\1\63\1\64\2\63\1\65\1\64\40\63\1\66\16\63"+
    "\1\67\1\70\2\67\1\71\57\67\1\70\1\10\1\72"+
    "\1\73\1\13\2\10\1\74\1\16\1\75\1\76\1\10"+
    "\1\21\5\10\1\27\21\76\2\10\1\43\2\10\1\46"+
    "\1\47\1\10\1\77\2\10\1\100\7\10\1\11\1\10"+
    "\1\13\2\10\1\74\1\10\1\75\1\76\5\10\1\25"+
    "\1\101\1\27\21\76\10\10\1\102\57\10\1\103\1\104"+
    "\23\10\1\105\1\16\1\10\1\76\2\10\1\22\1\23"+
    "\1\106\1\25\1\101\1\27\21\76\1\107\2\10\1\101"+
    "\1\110\1\46\1\47\1\10\1\51\1\52\1\53\1\111"+
    "\1\55\1\56\1\57\1\60\2\10\66\0\1\11\70\0"+
    "\1\112\65\0\1\113\1\114\55\0\1\113\1\11\1\115"+
    "\62\113\1\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\21\20\10\0\1\120\22\0\5\21\4\0\21\21\40\0"+
    "\1\121\62\0\2\23\1\121\57\0\1\122\4\0\1\123"+
    "\3\0\21\122\23\0\1\124\1\125\1\124\5\0\1\126"+
    "\10\0\21\126\23\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\1\20\1\127\17\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\4\20\1\130\14\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\6\20\1\131\12\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\12\20\1\132\6\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\4\20\1\133\11\20\1\134\1\135\1\20\10\0"+
    "\1\120\12\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\7\20\1\136\4\20\1\137\4\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\14\20\1\140"+
    "\4\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\15\20\1\141\3\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\12\20\1\142"+
    "\6\20\10\0\1\120\54\0\1\143\1\144\73\0\1\145"+
    "\64\0\1\146\55\0\1\147\6\0\1\150\64\0\1\151"+
    "\67\0\1\152\67\0\1\153\65\0\1\154\7\0\1\63"+
    "\40\0\1\155\16\0\1\156\1\0\45\156\1\157\15\156"+
    "\64\0\1\67\1\0\1\160\1\161\21\0\1\162\2\0"+
    "\1\163\1\164\11\0\1\165\23\0\1\72\71\0\1\166"+
    "\1\114\55\0\1\166\1\13\1\167\62\166\11\0\5\76"+
    "\4\0\21\76\66\0\1\170\31\0\1\122\10\0\21\122"+
    "\65\0\1\143\21\0\7\171\1\172\55\171\1\0\1\116"+
    "\1\117\1\116\47\0\1\120\12\0\1\116\127\0\1\173"+
    "\34\0\1\174\1\175\60\0\5\122\2\0\1\176\1\0"+
    "\21\122\23\0\1\124\64\0\1\177\1\200\1\177\5\0"+
    "\5\126\1\0\1\201\1\0\1\124\21\126\23\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\2\20\1\202\16\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\3\20\1\203\15\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\5\20\1\204\13\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\7\20\1\205\11\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\2\20\1\206\16\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\1\207\20\20\10\0\1\120\12\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\10\20\1\210\10\20\10\0"+
    "\1\120\12\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\15\20\1\211\3\20\10\0\1\120\12\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\13\20\1\212\5\20\10\0"+
    "\1\120\12\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\13\20\1\213\5\20\10\0\1\120\12\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\6\20\1\214\2\20\1\215"+
    "\7\20\10\0\1\120\12\0\1\160\111\0\1\216\76\0"+
    "\1\217\55\0\1\220\67\0\1\221\31\0\1\13\63\0"+
    "\7\171\1\222\55\171\7\172\1\223\55\172\14\0\2\175"+
    "\50\0\1\177\1\200\1\177\13\0\1\201\1\0\1\124"+
    "\44\0\1\177\64\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\3\20\1\224\15\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\11\20\1\225\7\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\7\20\1\226\11\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\12\20\1\227\6\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\12\20\1\230\6\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\13\20\1\231\5\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\11\20\1\232\7\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\13\20\1\233\5\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\12\20\1\234\6\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\12\20\1\235\6\20"+
    "\10\0\1\120\12\0\1\116\1\117\1\116\5\0\5\20"+
    "\4\0\14\20\1\236\4\20\10\0\1\120\12\0\1\116"+
    "\1\117\1\116\5\0\5\20\4\0\15\20\1\237\3\20"+
    "\10\0\1\120\36\0\1\240\63\0\1\241\72\0\1\242"+
    "\65\0\1\243\31\0\6\171\1\13\1\222\55\171\6\172"+
    "\1\13\1\244\55\172\1\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\4\20\1\245\14\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\12\20\1\246"+
    "\6\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\4\20\1\247\14\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\5\20\1\250"+
    "\13\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\12\20\1\251\6\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\7\20\1\252"+
    "\11\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\14\20\1\253\4\20\10\0\1\120\44\0"+
    "\1\254\65\0\1\255\63\0\1\256\70\0\1\257\25\0"+
    "\6\172\1\0\1\244\55\172\1\0\1\116\1\117\1\116"+
    "\5\0\5\20\4\0\5\20\1\260\13\20\10\0\1\120"+
    "\12\0\1\116\1\117\1\116\5\0\5\20\4\0\13\20"+
    "\1\261\5\20\10\0\1\120\12\0\1\116\1\117\1\116"+
    "\5\0\5\20\4\0\10\20\1\262\10\20\10\0\1\120"+
    "\12\0\1\116\1\117\1\116\5\0\5\20\4\0\1\263"+
    "\20\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\15\20\1\264\3\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\4\20\1\265"+
    "\14\20\10\0\1\120\45\0\1\266\57\0\1\267\73\0"+
    "\1\270\27\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\13\20\1\271\5\20\10\0\1\120\12\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\3\20\1\272\15\20\10\0"+
    "\1\120\12\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\5\20\1\273\13\20\10\0\1\120\12\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\12\20\1\274\6\20\10\0"+
    "\1\120\46\0\1\275\51\0\1\276\70\0\1\241\37\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\10\20\1\277"+
    "\10\20\10\0\1\120\12\0\1\116\1\117\1\300\5\0"+
    "\5\20\4\0\2\20\1\301\6\20\1\302\7\20\10\0"+
    "\1\120\46\0\1\255\54\0\1\303\40\0\1\116\1\117"+
    "\1\300\20\0\1\304\6\0\1\305\17\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\4\20\1\306"+
    "\14\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\17\20\1\307\1\20\10\0\1\120\43\0"+
    "\1\255\60\0\1\310\77\0\1\311\24\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\12\20\1\312\6\20\10\0"+
    "\1\120\12\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\14\20\1\313\4\20\10\0\1\120\45\0\1\314\66\0"+
    "\1\315\27\0\1\116\1\117\1\116\5\0\5\20\4\0"+
    "\20\20\1\316\10\0\1\120\12\0\1\116\1\117\1\116"+
    "\5\0\5\20\4\0\10\20\1\317\10\20\10\0\1\120"+
    "\53\0\1\320\54\0\1\321\33\0\1\116\1\117\1\116"+
    "\5\0\5\20\4\0\1\322\20\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\10\20\1\323"+
    "\10\20\10\0\1\120\33\0\1\324\74\0\1\325\33\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\11\20\1\326"+
    "\7\20\10\0\1\120\12\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\12\20\1\327\6\20\10\0\1\120\44\0"+
    "\1\330\65\0\1\331\31\0\1\116\1\117\1\116\5\0"+
    "\5\20\4\0\14\20\1\332\4\20\10\0\1\120\12\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\15\20\1\333"+
    "\3\20\10\0\1\120\47\0\1\334\65\0\1\335\26\0"+
    "\1\116\1\117\1\116\5\0\5\20\4\0\5\20\1\336"+
    "\13\20\10\0\1\120\40\0\1\337\36\0\1\116\1\117"+
    "\1\116\5\0\5\20\4\0\12\20\1\340\6\20\10\0"+
    "\1\120\45\0\1\341\30\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack();


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  0,  0,  0,  0,  0,  0,  9,  9,  1,  9,  1,  1,  9,  1,  3, 
     1,  1,  1,  3,  9,  1,  9,  3,  3,  3,  3,  3,  3,  3,  3,  3, 
     1,  1,  9,  9,  9,  9,  9,  1,  1,  1,  9,  1,  9,  9,  1,  1, 
     9,  9,  9,  9,  1,  3,  9,  9,  1,  3,  1,  1,  1,  1,  9,  9, 
     9,  1,  9,  9,  9,  3,  1,  9,  1,  9,  0,  0,  0,  0,  0,  0, 
     0,  0,  9,  0,  0,  0,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3, 
     3,  3,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  0, 13,  9, 
     0,  0,  0,  0,  0,  0,  0,  9,  0,  0, 13,  9,  1, 13,  0,  0, 
     2,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  0,  0,  0, 
     0,  0,  0,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  0, 
     0,  0,  0,  0,  3,  3,  3,  3,  3,  3,  3,  0, 13,  0,  0,  3, 
     3,  3,  3,  3,  3,  0,  0,  0,  3,  3,  3,  3,  0,  0,  3,  0, 
     3,  3,  0,  0,  0,  3,  3,  0,  0,  3,  3,  0,  0,  3,  3,  0, 
     0,  3,  3,  0,  0,  3,  3,  0,  0,  3,  3,  0,  9,  3,  0,  3,  9
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */
	StringBuffer string=new StringBuffer();
	String fileName;
	public void setFileName(String name) {
		fileName=name;
	}
	public String getFileName() {
		return fileName;
	}
	private Symbol symbol(int type) {
		return new Symbol(type,yyline,yycolumn,
		    new Token(type,fileName,yytext(),
		                    yyline+1,yycolumn+1,
		                    yycolumn+1+yytext().length()));
	}
	private Symbol emptyString() {
		return new Symbol(sym.STRING,yyline,yycolumn,
		    new Token(sym.STRING,fileName,"",
		                    yyline+1,yycolumn+1,
		                    yycolumn+1+0));
	}
	private Symbol symbol(int type, String text) {
		return new Symbol(sym.STRING,yyline,yycolumn,
		    new Token(sym.STRING,fileName,text,
		                    yyline+1,yycolumn+1,
		                    yycolumn+1+0));
	}
	
	//private Symbol symbol(int type,Object value) {
	//	return new Symbol(type,yyline,yycolumn,value);
	//}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  IniScanner(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  IniScanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[8268];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] yy_unpack_cmap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  final public void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  final public char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;
    int yy_pushbackPos_l = yy_pushbackPos = -1;
    boolean yy_was_pushback;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_r = false;
          yycolumn++;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;

      yy_was_pushback = false;

      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            yy_pushbackPos = yy_pushbackPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            yy_pushbackPos_l = yy_pushbackPos;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 2) == 2 )
            yy_pushbackPos_l = yy_currentPos_l;

          if ( (yy_attributes & 1) == 1 ) {
            yy_was_pushback = (yy_attributes & 4) == 4;
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;
      if (yy_was_pushback)
        yy_markedPos = yy_pushbackPos_l;

      switch (yy_action) {

        case 16: 
          {  return symbol(sym.TIDENTIFIER);  }
        case 226: break;
        case 15: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 86: 
        case 87: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 138: 
        case 139: 
        case 140: 
        case 147: 
        case 148: 
        case 149: 
        case 153: 
        case 154: 
        case 157: 
        case 158: 
        case 164: 
        case 165: 
        case 166: 
        case 167: 
        case 169: 
        case 170: 
        case 176: 
        case 178: 
        case 179: 
        case 180: 
        case 185: 
        case 192: 
        case 193: 
        case 197: 
        case 198: 
        case 201: 
        case 202: 
        case 205: 
        case 206: 
        case 209: 
        case 210: 
        case 213: 
        case 214: 
        case 217: 
        case 221: 
          {  return symbol(sym.IDENTIFIER);  }
        case 227: break;
        case 61: 
          {  return symbol(sym.IDENTIFIER);  }
        case 228: break;
        case 98: 
          {  return symbol(sym.MINUSMINUS);  }
        case 229: break;
        case 99: 
          {  return symbol(sym.ARROW_RIGHT);  }
        case 230: break;
        case 67: 
          {  yybegin(STRING); return symbol(sym.PLUS);  }
        case 231: break;
        case 119: 
          {  yybegin(YYINITIAL); return symbol(sym.IMPLIES);  }
        case 232: break;
        case 7: 
        case 9: 
        case 14: 
        case 58: 
        case 59: 
        case 60: 
        case 65: 
        case 72: 
          {  System.out.println("unmatched: '"+yytext()+"'");  }
        case 233: break;
        case 73: 
          {  return emptyString();  }
        case 234: break;
        case 151: 
          {  yybegin(USERTYPE); return symbol(sym.TYPE);  }
        case 235: break;
        case 223: 
        case 224: 
          {  return symbol(sym.PREDICATE);  }
        case 236: break;
        case 190: 
          {  return symbol(sym.FUNCTION);  }
        case 237: break;
        case 51: 
          {  yybegin(YYINITIAL); Symbol s = symbol(sym.STRING, string.toString()); string.setLength(0); return s;  }
        case 238: break;
        case 44: 
          {  return symbol(sym.QUESTION);  }
        case 239: break;
        case 104: 
          {  return symbol(sym.NOTEQUALS);  }
        case 240: break;
        case 107: 
          {  return symbol(sym.PLUSPLUS);  }
        case 241: break;
        case 108: 
          {  string.append("{");  }
        case 242: break;
        case 48: 
          {  return symbol(sym.AT);  }
        case 243: break;
        case 46: 
          {  return symbol(sym.AND);  }
        case 244: break;
        case 41: 
          {  return symbol(sym.NOT);  }
        case 245: break;
        case 39: 
          {  return symbol(sym.LT);  }
        case 246: break;
        case 12: 
          {  return symbol(sym.DIV);  }
        case 247: break;
        case 10: 
          {  /* ignore */  }
        case 248: break;
        case 8: 
          {  return symbol(sym.LF);  }
        case 249: break;
        case 17: 
        case 18: 
          {  return symbol(sym.INT);  }
        case 250: break;
        case 19: 
          {  return symbol(sym.DOT);  }
        case 251: break;
        case 33: 
          {  return symbol(sym.GT);  }
        case 252: break;
        case 34: 
          {  return symbol(sym.COL);  }
        case 253: break;
        case 57: 
          {  return symbol(sym.LF);  }
        case 254: break;
        case 68: 
          {  return symbol(sym.DIV);  }
        case 255: break;
        case 69: 
          {  return symbol(sym.DOT);  }
        case 256: break;
        case 88: 
          {  return symbol(sym.OF);  }
        case 257: break;
        case 100: 
          {  return symbol(sym.GTE);  }
        case 258: break;
        case 101: 
          {  return symbol(sym.LTE);  }
        case 259: break;
        case 123: 
        case 124: 
          {  return symbol(sym.NUM);  }
        case 260: break;
        case 168: 
          {  return symbol(sym.FALSE);  }
        case 261: break;
        case 54: 
        case 56: 
          {  return symbol(sym.CHAR);  }
        case 262: break;
        case 47: 
          {  return symbol(sym.PLUS);  }
        case 263: break;
        case 43: 
          {  return symbol(sym.TUBE);  }
        case 264: break;
        case 13: 
          {  return symbol(sym.MULT);  }
        case 265: break;
        case 22: 
          {  return symbol(sym.COMMA);  }
        case 266: break;
        case 32: 
          {  return symbol(sym.MINUS);  }
        case 267: break;
        case 63: 
          {  return symbol(sym.TUBE);  }
        case 268: break;
        case 70: 
          {  return symbol(sym.MINUS);  }
        case 269: break;
        case 105: 
          {  return symbol(sym.OROR);  }
        case 270: break;
        case 150: 
          {  return symbol(sym.TRUE);  }
        case 271: break;
        case 152: 
          {  return symbol(sym.THIS);  }
        case 272: break;
        case 155: 
          {  return symbol(sym.CASE);  }
        case 273: break;
        case 156: 
          {  return symbol(sym.ELSE);  }
        case 274: break;
        case 122: 
          {  Symbol s = symbol(sym.LAMBDA); yypushback(yylength()); yybegin(LAMBDA); return s;  }
        case 275: break;
        case 50: 
        case 52: 
        case 53: 
          {  string.append(yytext());  }
        case 276: break;
        case 55: 
          {  yybegin(YYINITIAL);  }
        case 277: break;
        case 66: 
          {  Symbol s = symbol(sym.PLUS); yybegin(EMBEDED_EXPRESSION2); yypushback(yylength());  return s;  }
        case 278: break;
        case 11: 
          {  yybegin(STRING);  }
        case 279: break;
        case 172: 
          {  Symbol s = symbol(sym.END); yybegin(YYINITIAL); yypushback(yylength()); return s;  }
        case 280: break;
        case 111: 
          {  Symbol s = symbol(sym.END); yybegin(YYINITIAL); yypushback(yylength()); return s;  }
        case 281: break;
        case 71: 
          {  Symbol s = symbol(sym.RPAREN); yybegin(EMBEDED_EXPRESSION1); yypushback(yylength());  return s;  }
        case 282: break;
        case 110: 
          {  yybegin(EMBEDED_EXPRESSION1); yypushback(yytext().length()); Symbol s = symbol(sym.STRING, string.toString()); string.setLength(0); return s;  }
        case 283: break;
        case 218: 
        case 220: 
          {  return symbol(sym.CHANNEL);  }
        case 284: break;
        case 187: 
          {  return symbol(sym.DECLARE);  }
        case 285: break;
        case 186: 
          {  return symbol(sym.DEFAULT);  }
        case 286: break;
        case 184: 
          {  return symbol(sym.PROCESS);  }
        case 287: break;
        case 177: 
          {  return symbol(sym.RETURN);  }
        case 288: break;
        case 175: 
          {  return symbol(sym.IMPORT);  }
        case 289: break;
        case 49: 
          {  yybegin(CHAR);  }
        case 290: break;
        case 45: 
          {  return symbol(sym.DOLLAR);  }
        case 291: break;
        case 42: 
          {  return symbol(sym.MATCHES);  }
        case 292: break;
        case 40: 
          {  return symbol(sym.ASSIGN);  }
        case 293: break;
        case 38: 
          {  return symbol(sym.RSPAREN);  }
        case 294: break;
        case 37: 
          {  return symbol(sym.LSPAREN);  }
        case 295: break;
        case 36: 
          {  return symbol(sym.RCPAREN);  }
        case 296: break;
        case 20: 
          {  return symbol(sym.RPAREN);  }
        case 297: break;
        case 21: 
          {  return symbol(sym.LPAREN);  }
        case 298: break;
        case 35: 
          {  return symbol(sym.LCPAREN);  }
        case 299: break;
        case 62: 
          {  return symbol(sym.ASSIGN);  }
        case 300: break;
        case 64: 
          {  return symbol(sym.LPAREN);  }
        case 301: break;
        case 82: 
          {  return symbol(sym.DOTDOT);  }
        case 302: break;
        case 102: 
          {  return symbol(sym.IMPLIES);  }
        case 303: break;
        case 103: 
          {  return symbol(sym.EQUALS);  }
        case 304: break;
        case 106: 
          {  return symbol(sym.ANDAND);  }
        case 305: break;
        case 125: 
          {  return symbol(sym.INVDOT);  }
        case 306: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
            switch (yy_lexical_state) {
            case USERTYPE:
              {  yybegin(YYINITIAL); return symbol(sym.END);  }
            case 226: break;
            default:
              { return new java_cup.runtime.Symbol(sym.EOF); }
            }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
