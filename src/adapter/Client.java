package adapter;

/**
 * @author wb
 * @date 2019/1/23
 */
public class Client {

    public void test1(Target t) {
        t.handleRequest();
    }
    public static void main(String[] args){
     Client client = new Client();
     Adapte adapte = new Adapte();
     Target target = new Adapter(adapte);
     client.test1(target);
    }
}