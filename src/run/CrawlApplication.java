/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import crawlers.SignatureCrawler;
import db.DbAccessor;
import java.util.Scanner;

/**
 *
 * @author Hoang Pham
 */
public class CrawlApplication {

    static String getInput() {
        String input = "quit";
        System.out.println("========================");
        System.out.println("- crawl");
        System.out.println("- insertHead");
        System.out.println("- insertIem");
        System.out.println("Enter cmd: ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args) {
        DbAccessor dbAccessor;
        String input = getInput();
        while (input.equalsIgnoreCase("crawl")
                || input.equalsIgnoreCase("insertHead")
                || input.equalsIgnoreCase("insertIem")) {
            switch (input) {
                case "crawl":
                    System.out.println("---- Crawl");
                    SignatureCrawler crawler = new SignatureCrawler();
                    crawler.crawl();
                    break;
                case "insertHead":
                    System.out.println("---- Insert headphones to Db");
                    dbAccessor = new DbAccessor();
                    if (!dbAccessor.insertHeadphones()) {
                        System.out.println("!!! ATTENTION !!!");
                    }
                    break;
                case "insertIem":
                    System.out.println("---- Insert headphones to Db");
                    dbAccessor = new DbAccessor();
                    if (!dbAccessor.insertIems()) {
                        System.out.println("!!! ATTENTION !!!");
                    }
                    break;
            }
            input = getInput();
        }
    }
}
