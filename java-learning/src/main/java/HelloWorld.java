public class HelloWorld {
    public static void main(String[] args) {
        if(args.length==2){
            System.out.println(String.format("Hello %s and %s",args[0],args[1]));
            System.out.println(String.format("Goodbye  %s and %s",args[0],args[1]));
        }
    }
}
