import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

      /************************* Lambda for functional and dynamic polymorf

         A a1  = new A1(); // cmd opt v
        a1.n();

        a1 = new A1(){ //  при создании объекта переписали класс


            @Override
            public void n() {
                System.out.println( " Hi from not name class   ");
            }
        };
        a1.n();
        A1 a2 = new A1();
        a2.n();


        a1 =()->{ // only functional interface can preobrazovat в lanmdu

            System.out.println( " HI from lambda  ");
        };
        a1.n(); // вызвали метод. и тут у нас динамиечский полиморфизм, при вызове определяется наша реализация и выводится, хотя по коду все ссылаось на пустой метод

    }

    ***********/


        Predicate <String> a1 =(s)-> s.startsWith("a");
        Predicate <String> a =(s)-> s.startsWith("s");
        System.out.println(a1.test( "adsds"));

        Function<String, String> s = k->k+100;

        Consumer <String> l =System.out::println;
       System.out.println( s.apply("äaadfdff"));

        System.out.println(Stream.of( "aäsdddd", " see", "äassddd", "ghfdhgfj").filter(a1).count());
        //Stream.of( "aäsdddd", " see", "äassddd", "ghfdhgfj").filter(a1).forEach(s -> System.out.println());
        Stream.of("asdfd", "bdfgdfg", "sbewfw", "adsadq", "baeoqw").filter(a1).forEach(System.out::println);
        List<String> list1 = Stream.of("asdfd", "bdfgdfg", "sbewfw", "adsadq", "baeoqw").filter(a1.or(a)).collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = Stream.of("asdfd", "bdfgdfg", "sbewfw", "adsadq", "baeoqw").filter(a1.or(a)).map(s).collect(Collectors.toList());

        System.out.println(list2);

        //new Random().ints('a','z').limit(256).mapToObj(j->"" +(char)j).forEach(j-> System.out.print(j+" "));
        new Random().ints('a','z').limit(256).mapToObj(j->"" +(char)j).collect(Collectors.joining());// чтоб одна строка в которой буквы нагенеренные

        System.out.println(new Random().ints('a','z').limit(256).mapToObj(j->"" +(char)j).collect(Collectors.joining()));



        // если нужно юзеров нагененрить в объекте A1

        List <A1> d =Stream.generate(A1::new)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(d);

    }
}