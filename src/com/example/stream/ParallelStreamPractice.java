package com.example.stream;
import static com.example.ds.DataSource.*;
public class ParallelStreamPractice {
    public static void main(String[] args) throws InterruptedException {
       /* Thread.sleep(1000); // Warm-up

        measureTime("Parallel", () ->
                students.parallelStream().forEach(ParallelStreamPractice::heavyTask)
        );

        measureTime("Sequential", () ->
                students.stream().forEach(ParallelStreamPractice::heavyTask)
        );*/
        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread.sleep(100);

        long start = System.currentTimeMillis();
        students.stream()
                .filter(student -> student.getAge()>21)
                .forEach(System.out::println);

        System.out.println("Time taken: "+(System.currentTimeMillis()-start));

        System.out.println("***********************************************");
        long start1 = System.currentTimeMillis();
        students.stream().parallel()
                .filter(student -> {
                    System.out.println("Applying filter on "+ student.getName()+" by "+Thread.currentThread().getName());
                    return student.getAge()>21;
                })
                .map(student -> {
                    System.out.println("Applying map on "+ student.getName()+" by "+Thread.currentThread().getName());
                    return student.getName();
                })
                .forEach(studentName -> {
                    System.out.println("Applying forEach on "+ studentName+" by "+Thread.currentThread().getName());
                });

        System.out.println("Time taken: "+(System.currentTimeMillis()-start1));





    }

//    private static void heavyTask(Object student) {
//        long sum = 0;
//        for (long i = 0; i < 50_000_000L; i++) {
//            sum += i;
//        }
//    }
//
//    private static void measureTime(String label, Runnable task) {
//        long start = System.nanoTime();
//        task.run();
//        System.out.printf("%s time: %d ms%n", label, (System.nanoTime() - start) / 1_000_000);
//    }
}
