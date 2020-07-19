package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
       /* for (int i = 1; i < 6 ; i++) {
            Runner runner = new Runner();
            runner.setName("Runner " + i);
            runner.start();
        }*/
       Runner runner1 = new Runner();
       runner1.setName("Runner 1");
       runner1.setStarted(true);

        Runner runner2 = new Runner();
        runner2.setName("Runner 2");

        Runner runner3 = new Runner();
        runner3.setName("Runner 3");

        Runner runner4 = new Runner();
        runner4.setName("Runner 4");

        Runner runner5 = new Runner();
        runner5.setName("Runner 5");

        runner1.setName1(runner2);
        runner2.setName1(runner3);
        runner3.setName1(runner4);
        runner4.setName1(runner5);
        runner5.setName1(runner4);

        runner4.setName2(runner3);
        runner3.setName2(runner2);
        runner2.setName2(runner1);

       runner1.start();
       runner2.start();
       runner3.start();
       runner4.start();
       runner5.start();

    }
}
