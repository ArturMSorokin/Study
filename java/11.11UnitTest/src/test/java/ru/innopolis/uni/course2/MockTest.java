package ru.innopolis.uni.course2;

/**
 * Created by olymp on 11.11.2016.
 */
        import org.junit.Before;
        import org.junit.Test;
        import org.mockito.cglib.proxy.InvocationHandler;
        import org.mockito.cglib.proxy.Proxy;
//        import ru.innopolis.streams.Mock;
//        import ru.innopolis.streams.StreamReader;

        import java.lang.reflect.Method;

        import static org.junit.Assert.*;
        import static org.mockito.Mockito.*;
/**
 * Created by d.sapaev on 11.11.2016.
 */
public class MockTest {

    private Mock mock;

    @Before
    public void resetFields(){
        this.mock = new Mock();
        this.mock.setStreamReader(new StreamReader() {
            @Override
            public String read(long id) {
                if(id == 5)
                    return "Object";
                throw new RuntimeException();
            }
        });

    }

    @Test
    public void testCalculate(){

        String result = this.mock.calculate(5l);
        assertEquals(result, "calculated Object");
        this.mock.setStreamReader((StreamReader) Proxy.newProxyInstance(this.mock.getClass().getClassLoader(),
                new Class[]{StreamReader.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if((long)args[0] == 5)
                            return "Object";
                        throw new RuntimeException();
                    }
                }));
    }
}