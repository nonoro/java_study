package ch11;

import java.util.*;

class QueueEx01 {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;      //  Queue에 최대 5개까지만 저장되도록 한다. 5글자 이런게 아님 Queue q 객체의 저장공간이 5개가 최대가 되는거임

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.print(">>");
            try {
                //  화면으로부터 라인단위로 입력받는다.
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().trim();       //  " Hello Word " 이경우 Hello 앞이랑 Word위에 공백 삭제

                if ("".equals(input))
                    continue;


                    if (input.equalsIgnoreCase("q")) {
                        System.exit(0);     //  프로그램종료
                    } else
                        if (input.equalsIgnoreCase("help")) {       //  대소문자 구분안하고 입력하는거 equalsIgnoreCase
                            System.out.println(" help - 도움말을 보여줍니다.");
                            System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                            System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다. ");

                    } else
                        if (input.equalsIgnoreCase("history")) {
                            //  입력받은 명령어를 저장하고,
                            save(input);

                            //  LinkedList의 내용을 보여준다.
                            LinkedList list = (LinkedList)q;
//                            ListIterator it = tmp.listIterator();         얘는 잘안씀
                            final int SIZE = list.size();
                            for (int i = 0; i < SIZE; i++) {            //  원래 SIZE에 자리에 list.SIZE()가 들어감 근데 어짜피 SIZE의 값은 5로 정해져있는데 이렇게하면 계속 돌아가므로 list.size()의 크기를 상수로 바꿔서 해준다
                                System.out.println((i + 1) + "." + list.get(i));            //  얘는 1부터 떠야되는데 i는 0부터 시작이므로 i + 1을 해줌
                            }

                    } else {
                        save(input);
                        System.out.println(input);
                    }  //  if (input.equalsIgnoreCase("q") {

                } catch(Exception e){
                    System.out.println("입력오류입니다.");
            }
        }       //  while(true)
    }       //  main()

    public static void save(String input) {
        //  queue에 저장한다.
        if (!"".equals(input)) {
            q.offer(input);     //  큐에 명령어를 저장
        }

        //  queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (q.size() > MAX_SIZE) {      //  size()는 Collection인터페이스에 정의
            q.remove();             //  remove대신 poll써도 똑같음
        }
    }
}   //  end of class
