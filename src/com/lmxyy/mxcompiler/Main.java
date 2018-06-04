package com.lmxyy.mxcompiler;

import com.lmxyy.mxcompiler.compiler.Compiler;
import com.lmxyy.mxcompiler.utils.LLIRInterpreter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    private static final String Ver = "0.0.0";

    private static void printHelp() {
        System.out.println("Usage: mxcompiler [options] file...");
        System.out.println("Options:");
        System.out.println("  -h, --help                    Display this information");
        System.out.println("  -v, --version                 Display compiler version information");
        System.out.println("  -c, --config                  Display compiler configurations");
        System.out.println("  -o <file>                     Place the output into <file>");
    }

    private static void printVersion() {
        System.out.printf("mxcompiler %s\n", Ver);
    }

    private static void errorArgs() {
        System.out.println("Error: invalid arguments");
        printHelp();
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
//         String inFile = "/Users/limuyang/Desktop/Mx_star-Compiler/testcase/562.mx", outFile = null;
        String inFile = null,outFile = null;
        boolean isPrintHelp = false, isPrintVersion = false, isPrintConfig = false;
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i];
            switch (arg) {
                case "-h":
                case "--help":
                    isPrintHelp = true;
                    break;

                case "-v":
                case "--version":
                    isPrintVersion = true;
                    break;

                case "-c":
                case "--config":
                    isPrintConfig = true;
                    break;

                case "-o":
                    if (i + 1 < args.length) outFile = args[++i];
                    else errorArgs();
                    break;

                default:
                    if (inFile == null) inFile = arg;
                    else errorArgs();
            }
        }
        if (isPrintVersion) printVersion();
        if (isPrintHelp) printHelp();
        // if (isPrintConfig) printConfig();

        InputStream inS;
        PrintStream outS;
        if (inFile == null) inS = System.in;
        else inS = new FileInputStream(inFile);
        if (outFile == null) outS = System.out;
        else outS = new PrintStream(new FileOutputStream(outFile));

        Compiler compiler = new Compiler(inS,outS);
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss",Locale.US);
        try {
            if (!compiler.run()) {
                System.err.println("Compilation exited abnormally at "+formatter.format(new Date()));
                System.exit(1);
            }
            else {
                System.err.println("Compilation finished at "+formatter.format(new Date()));
            }
        }
        catch (Error error) {
            System.err.println("Compilation exited abnormally at "+formatter.format(new Date()));
            System.exit(1);
        }
        catch (Exception exception) {
            System.err.println("Compilation exited abnormally at "+formatter.format(new Date()));
            System.exit(1);
        }
//        LLIRInterpreter llirInterpreter = new LLIRInterpreter(
//                new FileInputStream("/Users/limuyang/Desktop/Mx_star-Compiler/ir.txt"),
//                falser
//        );
//        llirInterpreter.run();
//        System.err.println("exitcode:  " + llirInterpreter.getExitcode());
//        System.err.println("exception: " + llirInterpreter.exitException());
    }
}
