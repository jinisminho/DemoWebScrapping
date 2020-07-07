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
        System.out.println("- insertProducts");
        System.out.println("Enter cmd: ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args) {
        DbAccessor dbAccessor;
        String input = getInput();
        while (input.equalsIgnoreCase("crawl")
                || input.equalsIgnoreCase("insertProducts")) {
            switch (input) {
                case "crawl":
                    System.out.println("---- Crawl");
                    SignatureCrawler crawler = new SignatureCrawler();
                    crawler.crawl();
                    break;
                case "insertProducts":
                    System.out.println("---- Insert headphones to Db");
                    dbAccessor = new DbAccessor();
                    if (!dbAccessor.insertCompleteProducts()) {
                        System.out.println("!!! ATTENTION !!!");
                    }
                    break;
            }
            input = getInput();
        }
    }
}
