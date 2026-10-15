
public class ResourceDemo {

    static class FileResource implements AutoCloseable {
        private final String name;

        FileResource(String name) {
            this.name = name;
            System.out.println(name + " opened");
        }

        @Override
        public void close() {
            System.out.println(name + " closed");
        }
    }

    public static void demonstrate() {
        try (FileResource first = new FileResource("Resource A");
             FileResource second = new FileResource("Resource B")) {

            System.out.println("Working with resources");

        }
    }
}
