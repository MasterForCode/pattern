package adapter;

/**
 * @author wb
 * @date 2019/1/23
 * 适配器
 */
public class Adapter implements Target {
    private Adapte adapte;

    public Adapter(Adapte adapte) {
        this.adapte = adapte;
    }

    @Override
    public void handleRequest() {
          this.adapte.request();
    }
}