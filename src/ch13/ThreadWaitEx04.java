package ch13;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


class Customer implements Runnable {
    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }       //  while
    }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {
        this.table = table;
    }

    public void run() {
        while(true) {
            //  임의의 요리를 하나 선택해서 table에 추가한다.
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }       //  while
    }
}

class Table {
    String[] dishNames = {"donut", "donut", "burger"};     //  donut이 더 자주 나온다.
    final int MAX_FOOD = 6;     //  테이블에 놓을 수 있는 최대 음식의 개수
    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();

        try {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println((name + " is waiting."));
            try {
                forCook.await();     //  wait(); COOK쓰레드를 기다리게한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
        dishes.add(dish);
        forCust.signal();    //  notify(); 기다리고 있는 CUST를 꺠우기 위함.
        System.out.println("Dishes:" + dishes.toString());
    } finally {
        lock.unlock();
    }
}

    public void remove(String dishName){
        lock.lock();    //  synchronized(this)
        String name = Thread.currentThread().getName();
            try {
                while (dishes.size() == 0) {
                    System.out.println(name + " is waiting.");
                    try {
                        forCust.await();    //  wait(); CUST쓰레드를 기다리게 한다.
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishNames.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal();   //  잠자고 있는 COOK를 꺠우기 위함
                        return;
                    }
                }   //  for문의 끝

                try {
                    System.out.println(name + " is waiting.");
                    forCust.await();     // wait();  CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }       //  while (true)
//        }   //  synchronized
    } finally {
                lock.unlock();
            }
    }

    public int dishNum() {
        return dishNames.length;
    }
}

class ThreadWaitEx03 {
    public static void main(String[] args) throws Exception {
        Table table = new Table();      //  여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(2000);      //  0.1초(100 밀리 세컨드)  후에 강제 종료시킨다
        System.exit(0);     //  프로그램 전체를 종료(모든 쓰레드가 종료됨)
    }
}
