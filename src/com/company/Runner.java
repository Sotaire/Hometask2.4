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

    public void setStarted(Boolean started) {
        isStarted = started;
    }

    public Boolean getStarted() {
        return isStarted;
    }

    public void run() {
        if(isStarted == true ){
            name1.setStarted(true);             // для последовательности, мы через поле isStarted позволяем бежать только тому Раннеру,
                                                   // который идет следующим по порядковому номеру,
                                                         // т.е после запуска первого даем разрешение второму,а после запуска второго третьему  и т.д
        System.out.println(this.getName() + " берет палочку");
        if (this.getName().equals("Runner " + 5)) {

            System.out.println(this.getName() + " бежит к финишу");
            runner(name1);

        } else {
            runner(name1);
        }

        }
        if (this.getName().equals("Runner " + 5) != true){
            try {
                name1.join();                    //здесь ждем пока предыдущий по порядковому номеру Ранеер не добежит до нас
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " берет палочку");

        }
        if (name2 != null && this.getName().equals("Runner " + 1) != true) {

            runner(name2);                       // в этой проверке мы позволяем бегать всем Раннерам,кроме первого,
                                                 // так как в конце эстафеты Раннер один должен просто взять палочку
        }
    }

    public void runner(Runner runner){                                     // метод который позволяет нам избежать повторений в коде
        try {
            System.out.println(this.getName() + " бежит к " + runner.getName());
            this.sleep(5000);
        } catch (InterruptedException i) {
            System.out.println(i.getMessage());
        }
    }
}
