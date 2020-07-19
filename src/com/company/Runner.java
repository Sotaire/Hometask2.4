package com.company;

public class Runner extends Thread {

    private Runner name1;
    private Runner name2;
    private Boolean isStarted = false;

    public void setName2(Runner name2) {
        this.name2 = name2;
    }

    public void setName1(Runner name1) {
        this.name1 = name1;
    }

    public Boolean getStarted() {
        return isStarted;
    }

    public void setStarted(Boolean started) {
        isStarted = started;
    }

    public void run() {
        if(isStarted == true){
            name1.setStarted(true);
        System.out.println(this.getName() + " берет палочку");
        if (this.getName() == "Runner " + 5) {
            System.out.println(this.getName() + " бежит к финишу");
            runner(name1);
        } else {
            runner(name1);
        }
        }
        if (this.getName()!= "Runner " + 5){
            try {
                name1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " берет палочку");
        }
        if (name2 != null && this.getName()!= "Runner " + 1 ) {
            runner(name2);
        }
    }

    public void runner(Runner runner){
        try {
            System.out.println(this.getName() + " бежит к " + runner.getName());
            this.sleep(5000);
        } catch (InterruptedException i) {
            System.out.println(i.getMessage());
        }
    }
}
