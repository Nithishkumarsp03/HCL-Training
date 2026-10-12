package com.hcldailytask;
import java.util.*;

public class LibraryWaitlist {

    public static void main(String[] args) {

        // Catalogue: ordered books with indexed access
        List<String> catalogue = new ArrayList<>();
        catalogue.add("Java");
        catalogue.add("DBMS");
        catalogue.add("Operating Systems");

        // De-duplication: preserve registration order
        Set<String> registered = new LinkedHashSet<>();
        registered.add("Nithish");
        registered.add("Student A");
        registered.add("Nithish");

        // Ordinary FIFO waitlist
        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.offer("Student A");
        waitlist.offer("Student B");
        waitlist.offer("Student C");

        // Faculty requests have priority 0; students priority 1
        PriorityQueue<Request> priorityQueue =
                new PriorityQueue<>(
                        Comparator.comparingInt((Request r) -> r.priority)
                                .thenComparingInt(r -> r.order)
                );

        priorityQueue.offer(new Request("Student A", 1, 1));
        priorityQueue.offer(new Request("Faculty A", 0, 2));
        priorityQueue.offer(new Request("Faculty B", 0, 3));

        System.out.println("Catalogue: " + catalogue);
        System.out.println("Registered: " + registered);
        System.out.println("FIFO waitlist: " + waitlist);

        System.out.println("\nFaculty-first processing:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().name);
        }

        // Remove overdue books safely using Iterator.remove()
        List<String> overdue = new ArrayList<>(
                Arrays.asList("Java", "DBMS", "Networks")
        );

        Iterator<String> iterator = overdue.iterator();

        while (iterator.hasNext()) {
            String book = iterator.next();

            if (book.equals("DBMS")) {
                iterator.remove();
            }
        }

        System.out.println("\nOverdue after removal: " + overdue);
    }

    static class Request {
        String name;
        int priority;
        int order;

        Request(String name, int priority, int order) {
            this.name = name;
            this.priority = priority;
            this.order = order;
        }
    }
}

