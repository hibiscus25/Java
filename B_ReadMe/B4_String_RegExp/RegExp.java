package B_ReadMe.B4_String_RegExp;

//import jregex.Matcher;
//import jregex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp{
//методы для обучения
    private static void outPrint(String compile,String matcher) {
        Pattern p = Pattern.compile(compile);
        Matcher m = p.matcher(matcher);
        while (m.find()) {
            System.out.print(m.start() + "-" + m.group() + ";   ");
        }
        System.out.println("");
    }

    private static void outPrintPattern(String compile,int pattern,String matcher) {
        Pattern p = Pattern.compile(compile,pattern);
        Matcher m = p.matcher(matcher);
        while (m.find()) {
            System.out.print(m.start() + "-" + m.group() + ";   ");
        }
    }

//методы для примеров
    private static void examples(String pattern, String[] array){
         for(String el:array){
             outPrint(pattern,el);
         }
        System.out.println("");
    }

    public static void main(String[] args) {
//------------------------- урок_1  -  основы регулярных выражений -----------------------------------------------------
//    //  - проверка электронной почты
//        System.out.println("asdffasd".matches("\\b[A-Za-z0-9._%]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b"));
//        System.out.println("selsasss@gmail.com".matches("\\b[A-Za-z0-9._%]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b"));
//
//    //  - наличие буквы "a" в подстроке
//        String compile ="a";
//        String matcher = "Jack is a boy";
//        outPrint(compile, matcher);

//-------------------------------- урок_2  -  буквальные выражения -----------------------------------------------------
//    //  - нахождение слова "сat" в подстроке
//          outPrint("cat","About cats and dogs");

//    //  - cпециальные символы        //[]\^$.|&*+()
//        outPrint("1\\+1=2","1+1=2");
//        outPrint("\\Q1+1=2\\E","1+1=2");

//    //  - поиск несколько cat  в подстроке
//        outPrint("cat","He captured a catfish for his cat.");

//-------------------------------- урок_3  -  наборы символов  ---------------------------------------------------------
//    // пример 1
//        outPrint("[a-b]","abc");
//        outPrint("[a-c]","abcdc");
//        outPrint("[0-5]","147");
//        outPrint("[0-5a-z]","147d");
//        outPrint("[0-5a-z]","147dA");
//        outPrint("[0-5a-zA-Z]","147dA");
//        outPrint("[0-5a-zA-Z%_=]","1=47%d_A");

//    // пример 2
//          outPrint("gr[ae]y","gray");
//          outPrint("gr[ae]y","grey");

//    // пример 3 - cпециальные символы внутри [ ] не нужно экранировать, кроме cимволов ] \ ^ -
//        outPrint("[+]","1 + 1 = 2");
//        outPrint("q[^u]","Iraq is a country"); // ^ - означает, "кроме"
//        outPrint("q[^u]","Iraqu is a country");



//    // пример 4
//        outPrint("","x");  //находит все что угодно, кроме x
//        outPrint("[x^]","x");  //если ^ не вначале, тогда это не спец символ
//        outPrint("[x^]","^");
//        outPrint("[]x]","x");     // если ] не в конце, не считается спец символом
//        outPrint("[]x]","]");
//        outPrint("[-x]","x");
//        outPrint("[x-]","x");
//        outPrint("[-x]","-");
//        outPrint("[x-]","-");
//        outPrint("[\\\\x]","x");
//        outPrint("[\\\\x]","\\");
//        outPrint("\\Q[-]\\E","[ bla - absd ]");     // не находит, но должен находить

//    // пример 5 - классы
//        outPrint("[\\d]","abc 5sadf");      //d  - цифры  [0-9]
//        outPrint("[\\D]","abc 5sadf");      //D  - все, кроме цифр  [0-9]
//        outPrint("[\\w]","abc 5sadf");      //w  - буквы и цифры  [A-Za-z0-9]
//        outPrint("[\\W]","abc 5sadf");      //W  - все, кроме букв и цифр  [A-Za-z0-9]
//        outPrint("[\\s]","abc 5sadf");      //s  - пробел или табуляция [ \t]
//        outPrint("[\\S]","abc 5sadf");      //S  - все. кроме пробела или табуляции [ \t]

//        outPrint("[\\s\\d]","abc 5sadf");   //найдет или пробел или цифру
//        outPrint("\\s\\d","abc 5sadf");     //найдет "пробел + цифра"
//        outPrint("[\\D\\S]","abc 5sadf");   //найдет все

//    // пример 6
//          outPrint("[0-9]+","1222");
//          outPrint("[0-9]{4}","1222");

//------------------------------------------- урок_4  - точка  ---------------------------------------------------------
//    точка, заменяет любой символ, кроме конца строки (. - [^\r\n])

//    // пример 1 дата mm/dd/yy
//            outPrint("\\d\\d.\\d\\d.\\d\\d","02-12-03");
//            outPrint("\\d\\d.\\d\\d.\\d\\d","02712903");
//            outPrint("\\d\\d[-/.]\\d\\d[-/.]\\d\\d","02-12-03");

//    // пример 2
//            outPrint("\".*\"","Put a \"string\" between double quotes");

//    // пример 3 квантификатор
//            outPrint("\".*\"","We problem with \"string one\" and \"string two\". Please."); //жадный
//            outPrint("\".*?\"","We problem with \"string one\" and \"string two\". Please."); //ленивый
//            outPrint("\"[^\"\r\n]*\"","We problem with \"string one\" and \"string two\". Please."); //обход жадного

//------------------------------------------- урок_5  - граница слов  --------------------------------------------------
//b - разрыв слова
//B - любой символ, кроме символа разрыва слов

//            outPrint("\\bis\\b","This island is beautiful");
//            outPrint("\\b\\w+\\b","This island is beautiful");

//------------------------------------------- урок_6  - якоря  ---------------------------------------------------------
// ^ - cимвол начала строки
// $ - cимвол конца строки

//    // пример 1
//            outPrint("^a","abc");
//            outPrint("^b","abc");
//            outPrint("c$","abc");
//            outPrint("b$","abc");

//    // пример 2
//        outPrint("\\d+","ab4c");
//        outPrint("^\\d+$","ab4c");
//        outPrint("^\\d*$","");  //та как * - от 0 до множеста, поэтому найдет пустую строку

//    // пример 3 чтение по строкам
//        outPrint("ne$","first line\n second_line");                             //по умолчанию читает все как одна строка
//        outPrint("ne\\z","first line\n second_line");                           // \\z аналогия  $
//        outPrint("\\Afi","first line\n first_line");                            // \\A аналогия  ^
//        outPrintPattern("ne$",Pattern.MULTILINE,"first line\n second_line");    // Pattern.MULTILINE - разделение на строки
//        outPrintPattern("^4$",Pattern.MULTILINE,"749\n486\n4");

//------------------------------------------- урок_7  - Pipeline  ------------------------------------------------------
// | - или
//        outPrint("сat|dog","I like my dog");
//        outPrint("Get|GetValue|Set|SetValue","SetValue");
//        outPrint("Get|GetValue|SetValue|Set","SetValue");
//        outPrint("Get(Value)|Set(Value)","SetValue");
//        outPrint("\\b(Get|GetValue|Set|SetValue)\\b","SetValue");
//        outPrint("\\b(Get(Value)?|Set(Value)?)\\b","SetValue");
//        outPrint("\\b(Get|Set)(Value)?\\b","SetValue");

//------------------------------------------- урок_8  - знак вопроса  --------------------------------------------------
// ? - может быть, а может не быть

//        outPrint("colou?r","color colour");
//        outPrint("Nov(ember)?","Nov  November");
//        outPrint("Nov(ember)??","Nov  November");
//        outPrint("Feb(ruary)? 23(rd)?","February 23rd, February 23, Feb 23rd, Feb 23");


//------------------------------------------- урок_9  - cимвол * и +  --------------------------------------------------
// * - символ перед ним, повторяется от 0 до  бесконечности
// + - символ перед ним, повторяется от 1 до  бесконечности

//          outPrint("<[A-Za-z][A-Za-z0-9]*","<h1>");
//          outPrint("<[A-Za-z][A-Za-z0-9]+","<h>");  //так как  +, должно быть минимум 1 раз

//{0,}  = *     {1,}  = +
//          outPrint("\\b[1-9][0-9]{2,4}\\b","100 99999");
//          outPrint("\\b[1-9][0-9]{3}\\b","1000 1234 9999");

//          outPrint("<.+>","This is a <EM>first</EM> test");     //жадный квантификатор
//          outPrint("<.+?>","This is a <EM>first</EM> test");    //ленивый квантификатор
//          outPrint("<[^>]+>","This is a <EM>first</EM> test");

//          outPrint("\\Q\\d+*\\E","*\\d+**\\d+*"); // \\Q буквальное выражение \\E
//          outPrint("\\Q*\\d+\\E*","*\\d+**\\d+*");
//          outPrint("(?:\\Q*\\d+*\\E)+","*\\d+**\\d+*");
//          outPrint("(?:\\Q*\\d+*\\E)+?","*\\d+**\\d+*");

//------------------------------------------- урок_10  - группы  -------------------------------------------------------

//        outPrint("Set(Value)?","Set or SetValue");               //будет использоваться backreferences
//        outPrint("Set(?:Value)?","Set or SetValue");             //из-за ?:  не будет использоваться backreferences

//        outPrint("EditPad (Lite|Pro)","EditPad Lite version");

//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","$1 version"));       // \1
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)","$0 version"));       // all regex

//        outPrint("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>","This is a <EM>first</EM> test"); // \\1 выражение первой группы
//        outPrint("([a-c])x\\1x\\1","axaxa");

//        outPrint("([a-c]\\1)","axaxa"); //error - нельзя вызывать из самой группы

//          outPrint("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>","Testing <B><I>bold italic</I></B> text");

//          outPrint("([abc]+)","cab"); //но backreferences = cab
//          outPrint("([abc])+","cab"); // backreferences = b (1 - c, перезапись 2 - а, перезапись 3 - b)
//
//          outPrint("([abc]+)=\\1","cab=cab");
//          outPrint("([abc])+=\\1","cab=cab");   //не найдет, т.к. backreferences = b
//          outPrint("([abc])+=\\1","cab=b");

//          System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1\\b","$1"));

//            outPrint("[(a)b\1]","abc()\\1");  //не будет создаваться группа, т.к. []

//------------------------------------------- урок_11  - именованные группы  -------------------------------------------

//формат именных груп:  (?<name>regex)   при обращении ${name}text или  $numbertext
//                      (?<name>regex)   при обращении </\\k<name> или  </\\number>

//          System.out.println("abc".replaceAll("(?<Aletter>a)","${Aletter}-"));
//          outPrint("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>","This is a <EM>first</EM> test");

//          System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)","$1$2$3$4"));         //можно по номеру
//          System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)","$1${x}$3${y}"));     //можно по имени

//------------------------------------------- урок_12  - Unicode  ------------------------------------------------------
//          outPrint("\u00E0","à");
//          outPrint("\\x{00E0}","à");          //можно задавать C_Pattern_Algorithms.pattern в таком формате
//          outPrint("\u0061","a");
//          outPrint("\u0300","̀̀");

//  \p{}   L - unicode letter   M-ascii and symbol of new line     Z-any space
//         S - symbol (dollar etc.)   N - number   P-punctuation    C - other, invisible character, unused code point
//          outPrint("\\p{L}","̀̀a 1");
//          outPrint("\\p{M}","̀̀a 1");
//          outPrint("\\p{Z}","̀̀a 1");
//          outPrint("\\pZ","̀̀a 1");
//          outPrint("(\\p{L}\\p{M})*","̀̀a 1");

//          outPrint("̀̀a","̀̀a");
//          outPrintPattern("̀̀a",Pattern.CANON_EQ,"̀̀a");  //паттерн используется для поиска похожих символов


//------------------------------------------- урок_13  - режимы регулярных выражений  ----------------------------------

//          outPrintPattern("word#this is comment",Pattern.COMMENTS,"word");  //разрешает использ коммент в шаблоне
//          outPrintPattern("word",Pattern.CASE_INSENSITIVE,"Word");         //игнорирует регистр

//          System.out.println("A".matches("(?i)a"));       //регистр игнорируется
//          System.out.println("A".matches("(?s)a"));       //single line
//          System.out.println("A".matches("(?m)a"));       //multiline

//          System.out.println("A".matches("(?x)A#this is comment"));      //допустимость комментарией в шаблоне
//          System.out.println("A".matches("(?ix)a#this is comment"));     //регистр игнор + комментарии
//          System.out.println("AA".matches("(?i)a(?-i)a"));               //(?-i) - отключение i
//          System.out.println("AA".matches("(?i)a(?-i)A"));               //(?-i) - отключение i
//          System.out.println("AAA".matches("(?i)a(?-i:A)a"));            //(?-i:A) - i включено, только для А

//------------------------------------------- урок_14  - Possesive Quantifier  -----------------------------------------

// варианты:    ++   *+   ?+
//          outPrint("\"[^\"]*+\"","\"abc\"");    //дойдет до конца строки и не пойдет назад

//          outPrint("\".*\"","\"abc\"x");         //жадный квантификатор
//          outPrint("\".*+\"","\"abc\"x");        //сверхжадный квантификатор (не запоминает, что нашел до этого)

// possesive X*+  можно заменить на (?>X*) - atomic group
//          outPrint("(a|b)*+b","b");  //не найдет, так как пока будет искать вторую b, забудет
//          outPrint("(?>(?:a|b)*)b","b");  //аналогия первого примера
//          outPrint("(?>a|b)*b","b");

//------------------------------------------- урок_15  - Atomic Groups  ------------------------------------------------
//  (?>group) - format atomic group
//        System.out.println("abcc".matches("a(bc|b)c"));         //true
//        System.out.println("abc".matches("a(bc|b)c"));          //true
//
//        System.out.println("abcc".matches("a(?>bc|b)c"));       //true - найдет bc, потом искать не будет
//        System.out.println("abc".matches("a(?>bc|b)c"));        //false - найдет bc, потом искать не будет
//
//        System.out.println("integers".matches("\\b(integer|insert|in)\\b"));    //false - дольше, так как проверяет все совпадения
//        System.out.println("integers".matches("\\b(?>integer|insert|in)\\b"));  //false - быстрее, т.к. после integer дальше не проверяет

//------------------------------------------- урок_16  - LookAround  ---------------------------------------------------
//  (?=(regex))reg - format  (перед reg будет regex) - бывают позитивные - =, негативные - !
    // lockahead - смотреть вперед
           //позитивный
//                outPrint("q(?=s)","Iraqs");                    //ищу q после s
//                outPrint("q(?=s)","Iraq");
//           //негативный
//                outPrint("q(?!s)","Iraq");                    //ищу q после которой нет s
//                outPrint("q(?!s)","Iraqs");

//  lockbehind - смотреть назад
//                outPrint("(?<=a)b","cb");       //ищу b перед которой есть  a
//                outPrint("(?<=a)b","cab");
//                outPrint("(?<!a)b","cb");       //ищу b перед которой нет  a
//                outPrint("(?<!a)b","ab");

//                outPrint("\\b\\w+(?<!s)\\b","John`s");
//                    outPrint("\\b\\w+(?<!s)\\b","Johns");       //false
//                outPrint("\\b\\w+[^s]\\b","John's");            //найдет с `(aпострофом)
//                outPrint("\\b\\w*[^s\\W]\\b","John's");

//------------------------------------------- урок_17  - множественные требования  ------------------------------------
//найит слово, у которого  6 букв и есть cat
        //1 этап:  b\w{6}\b         - ищем слово, которое состоит из  6 букв
        //2 этап:  b\w*сat*\w*\b    - ищем слово, в котором есть  cat
        //3 этап:  (?=\b\w{6}\b)\b\w*cat*\w*\b - объединяем         ((?=\b\w{6}\b) - LookAround используется как условие
        //         (?=\b\w{6}\b)\w{0,3}cat\w*  - упрощаем
//         outPrint("(?=\\b\\w{6}\\b)\\w{0,3}cat\\w*","wecate");

//найит слово, у которого  6 -12 букв и есть cat или dog или mouse
//        outPrint("(?=\\b\\w{6,12}\\b)\\w{0,9}(cat|dog|mouse)\\w*","wermouser");

//------------------------------------------- урок_18  - If-Then-Else  -------------------------------------------------
//нужно качать  jar.regexp и импортировать класс
        //need jRegex
        //(?ifthen|else)
        //(?ifthen)
        //(?(?=regex)then|else)
        //(?(?=condition)(then1|then2|then3)|(else1|else2|else3))
//          System.out.println("bd".matches("(a)?b(?(1)c|d)"));
//          Pattern p= new Pattern("(a)?b(?(1)c|d)");    //^
//          Pattern p = new Pattern("(?<test>a)?b(?(\\k<test>c\d"); //not work
//        Matcher m=p.matcher("bd");
//        Matcher m=p.matcher("abc");
//        Matcher m=p.matcher("adb");
//        while(m.find()){
//            System.out.println(m.start() + "  " + m + "  ");
//        }
//        System.out.println(" ");

//------------------------------------------- урок_19  - Posix символы  ------------------------------------------------
    //[:digit:]
    //[x-z[:digit:]]
//         outPrint("[x-z^\\p{Digit}]","5");        //\\p{Digit} - символы от [0-9]
//         outPrint("[^x-z\\p{Digit}]","5");

//------------------------------------------- урок_20  - Комментарии  --------------------------------------------------
/* Cпособы включения комментариев
        -   #comment
        -   (?#year) regexp (?#moth) regexp
        -   Pattern p = Pattern.compile("a(?#aLetter)", Pattern.COMMENTS);    - такой поддерживается, только в jregex
        -   Pattern p = Pattern.compile("(?x)a#aLetter)");  - но в этом случае игнорируются пробелы
        -   Pattern p = Pattern.compile("a#aLetter)", Pattern.COMMENTS);    */

//         outPrint("(?x)a b c","abc");   //игнорирует пробелы
//         (?x) (?> ato mic ) or ( ?>ato mic), но (? >atomic) - будет ошибка

//         outPrint("(?x)\\ d","4");   //не игнорирует пробел
//         [a b c] не равняется [abc]

//------------------------------------------- урок_21  - Примеры  ------------------------------------------------------
//           outPrint("ab","abaaaba");                //ab ab
//           outPrint("aba","abababa");               //aba aba, после первохого вхождения, начинает поис со след символа
//           outPrint("\\d","a12c3e456f");            //1 2 3 4 5 6
//           outPrint("\\d+","a12c3e456f");           //12 3 456
//           outPrint("\\w","a 1 56 _Z");             //a 1 5 6 _ Z
//           outPrint("[a-c]","abc");                 //a b c
//           outPrint("proj1([^,])*","proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java");   //proj1sched.pdf  proj1  proj1.java
//           outPrint("\\d\\d\\d([-\\s])?\\d\\d\\d\\d","123 4567");                        //123 4567
//           outPrint("a.c","ac abc a c");            //abc  a c
//    //greedy
//           outPrint(".*xx","yyxxxyxx");             //yyxxxyxx
//    //reluctant
//           outPrint(".*?xx","yyxxxyxx");            //yyxx xyxx
//    //possesiv
//           outPrint(".*+xx","yyxxxyxx");            //    -т.к. захватывает все, потом начинает поиск хх

//------------------------------------------- урок_22  - домашнее задание  ---------------------------------------------
////      https://regexone.com/
////задача_1:
//        examples("abc", new String[]{"abcdefg", "abcde", "abc"});
////задача_2:
//        examples("123", new String[]{"abc123xyz","define \"123\"","var g = 123;"});
////задача_3:
//        examples("...\\.", new String[]{"cat.","896.","?=+.","abc1"});                  //кроме - abc1
////задача_4:
//        examples("[cmf]an", new String[]{"can","man","fan","dan","ran","pan"});         //кроме - dan,ran,pan
//        examples("[^drp]an", new String[]{"can","man","fan","dan","ran","pan"});
////задача_5:
//        examples("[hd]og", new String[]{"hog","dog","bog"});                            //кроме - bog
//        examples("[^b]og", new String[]{"hog","dog","bog"});
////задача_6:
//        examples("[A-C][n-p][a-c]", new String[]{"Ana","Bob","Cpc","aax","bby","ccz"});  //кроме - aax,bby,ccz
////задача_7:
//        examples("waz{3,5}up", new String[]{"wazzzzzup","wazzzup","wazup"});             //кроме - wazup
////задача_8:
//        examples("aa+b*c+", new String[]{"aaaabcc","aabbbbc","aacc","a"});               //кроме - a
//        examples("a{2,4}b{0,4}c{1,2}", new String[]{"aaaabcc","aabbbbc","aacc","a"});
////задача_9:
//        examples("\\d+ files? found\\?", new String[]{"1 file found?","2 files found?","24 files found?",
//                "No files found."});                                                        //кроме - No files found.
////задача_10:
//        examples("\\d\\.\\s+abc", new String[]{"1.   abc","2.\tabc","3.     abc","4.abc"});  //кроме - 4.abc
////задача_11:
//        examples("^Mission: successful$", new String[]{"Mission: successful",
//                "Last Mission: unsuccessful",
//                "Next Mission: successful upon capture of target"});  //кроме - Last Mission....  Next Mission:.....
////задача_12:
//        examples("^(file.+)\\.pdf$",
//                new String[]{"file_record_transcript.pdf",      // Capture Groups = file_record_transcript
//                "file_07241999.pdf",                            // Capture Groups = file_07241999
//                "testfile_fake.pdf.tmp"});                      //кроме - testfile_fake.pdf.tmp
////задача_13:
//        examples("(\\w+ (\\d+))",
//                new String[]{"Jan 1987",                        // Capture Groups = Jan 1987   и     1987
//                             "May 1969",                        // Capture Groups = May 1969   и     1969
//                             "Aug 2011"});                      // Capture Groups = Aug 2011   и     2011
////задача_14:
//        examples("(\\d+)x(\\d+)",
//                new String[]{"1280x720",                        // Capture Groups = 1280   и     720
//                             "1920x1600",                       // Capture Groups = 1920   и     1600
//                             "1024x768"});                      // Capture Groups = 1024   и     768
////задача_15:
//        examples("I love (cats|dogs)", new String[]{"I love cats","I love dogs",
//                                "I love logs","I love cogs"});                  //кроме - I love logs, I love cogs
////задача_16:
//        examples(".*",                                                  //или "^(The)"
//                new String[]{"The quick brown fox jumps over the lazy dog.",
//                             "There were 614 instances of students getting 90.0% or above.",
//                             "The FCC had to censor the network for saying &$#*@!."});
////задача_17:
//        examples("^-?\\d+(,\\d+)*(\\.\\d+(e\\d+)?)?$",
//                new String[]{"3.14529","-255.34","128","1.9e10","123,340.00","720p"});       //кроме - 720p
////задача_18:
//        examples("1?[\\s-]?\\(?(\\d{3})\\)?[\\s-]?\\d{3}[\\s-]?\\d{4}",
//                new String[]{"415-555-1234",                        //Capture Groups = 415
//                             "650-555-2345",                        //Capture Groups = 650
//                             "(416)555-3456",                       //Capture Groups = 416
//                             "202 555 4567",                        //Capture Groups = 202
//                             "4035555678",                          //Capture Groups = 403
//                              "1 416 555 9292"});                   //Capture Groups = 416
////задача_19:
//        examples("^([\\w\\.]*)",                 //будет совпадать до места, где достигает «@» или «+»
//                new String[]{"tom@hogwarts.com",                    //Capture Groups = tom
//                        "tom.riddle@hogwarts.com",                  //Capture Groups = tom.riddle
//                        "tom.riddle+regexone@hogwarts.com",         //Capture Groups = tom.riddle
//                        "tom@hogwarts.eu.com",                      //Capture Groups = tom
//                        "potter@hogwarts.com",                      //Capture Groups = potter
//                        "harry@hogwarts.com",                       //Capture Groups = harry
//                        "hermione+regexone@hogwarts.com"});         //Capture Groups = hermione
////задача_20:
//        String[] str={"<a>This is a link</a>",                      //Capture Groups = a
//                "<a href='https://regexone.com'>Link</a>",          //Capture Groups = a
//                "<div class='test_style'>B_readMe.Test</div>",               //Capture Groups = div
//                "<div>Hello <span>world</span></div>"};             //Capture Groups = div
//
//        examples("<(\\w+)", str);                   //захватит начало тегов <.
//        examples(">([\\w\\s]*)<", str);             //значение между тегами > ....  <
//        examples("='([\\w://.]*)'", str);           //значение атрибутов
////задача_21:
//        String[] str2={"img0912.jpg",                               //Capture Groups = img0912  и  jpg
//                "updated_img0912.png",                              //Capture Groups = updated_img0912  и  png
//                "<favicon.gif",                                     //Capture Groups = favicon  и  gif
//                ".bash_profile","workspace.doc",                            //кроме перечисленных в строке
//                "documentation.html","img0912.jpg.tmp","access.lock" };     //кроме перечисленных в строке
//        examples("(\\w+)\\.(jpg|png|gif)$", str2);
////задача_22:
//        String[] str3={"\t\t\t\tThe quick brown fox..  ",            //Capture Groups = The quick brown fox...
//                "\t   jumps over the lazy dog."};                    //Capture Groups = jumps over the lazy dog.
//        examples("^\\s*(.*)\\s*$", str3);
////задача_23:
//        String[] str4={
//                "E/( 1553):   at widget.List.makeView(ListView.java:1727)",   //Capture Groups = makeView и ListView.java и 1727
//                "E/( 1553):   at widget.List.fillDown(ListView.java:652)",    //Capture Groups = fillDown и ListView.java и 652
//                "E/( 1553):   at widget.List.fillFrom(ListView.java:709)",    //Capture Groups = fillFrom и ListView.java и 709
//                "W/dalvikvm( 1553): threadid=1: uncaught exception",                //кроме перечисленных в строке
//                "E/( 1553): FATAL EXCEPTION: main",                                 //кроме перечисленных в строке
//                "E/( 1553): java.lang.StringIndexOutOfBoundsException"};            //кроме перечисленных в строке
//        examples("(\\w+)\\(([\\w\\.]+):(\\d+)\\)", str4);
////задача_24:
//        String[] str5={
//                "ftp://file_server.com:21/top_secret/life_changing_plans.pdf",   //Capture Groups = ftp и file_server.com и 21
//                "https://regexone.com/lesson/introduction#section",              //Capture Groups = https и regexone.com
//                "file://localhost:4040/zip_file",                                //Capture Groups = file и localhost и 4040
//                "https://s3cur3-server.com:9999/",                               //Capture Groups = https и s3cur3-server.com и 9999
//                "market://search/angry%20birds"};                                //Capture Groups = market и search
//        examples("(\\w+)://([\\w\\-\\.]+)(:(\\d+))?", str5);
//                        // (\w+)://         -  первая часть  capture
//                        // ://([\w\-\.]+)   -  вторая часть  capture
//                        // (:(\d+))         -  третья часть  capture
////задача_25:
//        String[] str6={
//                "ftp://file_server.com:21/top_secret/life_changing_plans.pdf",   //Capture Groups = ftp и file_server.com и 21
//                "https://regexone.com/lesson/introduction#section",              //Capture Groups = https и regexone.com
//                "file://localhost:4040/zip_file",                                //Capture Groups = file и localhost и 4040
//                "https://s3cur3-server.com:9999/",                               //Capture Groups = https и s3cur3-server.com и 9999
//                "market://search/angry%20birds"};                                //Capture Groups = market и search
//        examples("(\\w+)://([\\w\\-\\.]+)(:(\\d+))?", str6);
//        // (\w+)://         -  первая часть  capture
//        // ://([\w\-\.]+)   -  вторая часть  capture
//        // (:(\d+))         -  третья часть  capture
    }
}
