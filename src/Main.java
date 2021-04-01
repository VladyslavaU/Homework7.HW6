public class Main {
    public static void main(String[] args) {
        Subscriber one = new Subscriber("One", "One", "One");
        Subscriber two = new Subscriber("Two", "Two", "Two");
        Subscriber three = new Subscriber("three", "three", "three");
        Subscriber four = new Subscriber("four", "four", "four");
        Subscriber six = new Subscriber("six", "six", "six");
        Subscriber seven = new Subscriber("seven", "seven", "seven");
        Subscriber eight = new Subscriber("eight", "eight", "eight");
        Subscriber nine = new Subscriber("nine", "nine", "nine");
        Subscriber ten = new Subscriber("ten", "ten", "ten");
        Subscriber eleven = new Subscriber("eleven", "eleven", "eleven");
        Subscriber twelve = new Subscriber("twelve", "twelve", "twelve");
        Subscriber thirteen = new Subscriber("thirteen", "thirteen", "thirteen");
        Subscriber fourteen = new Subscriber("fourteen", "fourteen", "fourteen");
        Subscriber fifteen = new Subscriber("fifteen", "fifteen", "fifteen");
        Subscriber five = new Subscriber("five", "five", "five");

        one.setAddress("Address");
        one.setPhoneNumber("Phone Number");
        one.getAccount().deposit(100);
        two.getAccount().deposit(100);
        three.getAccount().deposit(100);
        four.getAccount().deposit(100);
        five.getAccount().deposit(100);
        six.getAccount().deposit(100);
        seven.getAccount().deposit(100);
        eight.getAccount().deposit(100);
        nine.getAccount().deposit(100);
        ten.getAccount().deposit(100);
        eleven.getAccount().deposit(100);
        twelve.getAccount().deposit(100);
        thirteen.getAccount().deposit(100);
        fourteen.getAccount().deposit(100);
        fifteen.getAccount().deposit(100);

        one.addLocalRecord(2);
        two.addLocalRecord(5);
        three.addLocalRecord(10);
        four.addLocalRecord(15);
        five.addLocalRecord(20);
        six.addLocalRecord(22);
        seven.addLocalRecord(25);
        eight.addLocalRecord(30);
        nine.addLocalRecord(35);
        ten.addLocalRecord(40);
        eleven.addLocalRecord(45);
        twelve.addLocalRecord(50);
        thirteen.addLocalRecord(55);
        fourteen.addLocalRecord(60);
        fifteen.addLocalRecord(65);

        two.addDistantRecord(10);
        one.addDistantRecord(20);
        three.addDistantRecord(25);
        seven.addDistantRecord(45);
        eight.addDistantRecord(50);
        ten.addDistantRecord(57);
        eleven.addDistantRecord(60);
        fourteen.addDistantRecord(17);
        fifteen.addDistantRecord(2);

        one.getAccount().deposit(200);
        one.addDistantRecord(20);
        one.addDistantRecord(20);
        one.addDistantRecord(20);
        one.addDistantRecord(20);
        one.addDistantRecord(20);
        one.addDistantRecord(20);

        one.addTrafficRecord(200);
        one.addTrafficRecord(500);
        one.addTrafficRecord(700);
        two.addTrafficRecord(1500);
        three.addTrafficRecord(2000);
        four.addTrafficRecord(5000);
        five.addTrafficRecord(500);
        six.addTrafficRecord(3000);
        seven.addTrafficRecord(100);
        eight.addTrafficRecord(50);
        nine.addTrafficRecord(150);
        ten.addTrafficRecord(300);
        eleven.addTrafficRecord(800);
        twelve.addTrafficRecord(900);
        thirteen.addTrafficRecord(4000);
        fourteen.addTrafficRecord(3500);
        fifteen.addTrafficRecord(600);


        //Phone: id, Фамилия, Имя, Отчество, Адрес, Номер телфона,
        // Номер кредитной карточки, Дебет, Кредит, Время городских
        // и междугородных разговоров, трафик интернета
        System.out.println("id, Фамилия, Имя, Отчество, Адрес, Номер телефона,\n" +
                "        // Номер кредитной карточки, Время городских\n" +
                "        // и междугородных разговоров, трафик интернета");
        System.out.println(one.toString());
        System.out.println("Дебет");
        one.getAccount().printDeposits(); // дебет
        System.out.println("Кредит");
        one.getAccount().printWithdrawals(); // кредит (если правильно поняла)


        System.out.println("a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное");
        LocalRecord.printSubscribersByUsage(20);

        System.out.println("b) сведения об абонентах, которые пользовались междугородной связью");
        DistantRecord.printSubscribers();

        System.out.println("c) сведения об абонентах в алфавитном порядке.");
        Subscriber.printSubscribersInAlphabeticalOrder();

        System.out.println("д) сведения об первых 10 абонентов у который самый большой трафик интернета");
        TrafficRecord.printTenHeaviestUsers();

    }
}
