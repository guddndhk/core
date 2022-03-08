package hello.core.singleton;

public class SingletonService {

    /*
    내가 이해하는 바로는 static 으로 객체를 생성하면 해당 객체는 인스턴스시 힙 메모리 할당 영역이 아닌
    스테틱 메모리 할당영역에서 저장된다. 스테틱 메모리는 GC 의 관여를 받지 않으며 다른 객체 인스턴스와 메모리를 공유하지 않는다.
    스태틱 메모리 라고 하지만 메모리 구조의 스택? 메모리에 저장 되는걸로 알고있음 스테틱 메모리가 초기화 되려면 애플리케이션이
    종료 되어야한다.
     */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
