package ch13;

class ThreadEx21 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        new Thread(r).start();  //  ThreadGroup에 의해 참조되므로 gc대상이 아니다
        new Thread(r).start();  //  ThreadGroup에 의해 참조되므로 gc대상이 아니다
    }
}

class Account2 {
    private int balance = 1000;

    public synchronized int getBalance2() {
        return balance;
    }

    public synchronized void withdraw2(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
    }   //  withdraw
}

class RunnableEx21 implements Runnable {
    Account2 acc = new Account2();

    public void run() {
        while (acc.getBalance2() > 0) {
            //  100, 200, 300중의 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw2(money);
            System.out.println("balance:" + acc.getBalance2());
        }
    }
}