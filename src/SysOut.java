import java.util.ArrayList;
import java.util.List;

/**
 * Created by olymp on 03.11.2016.
 */
public class SysOut extends Thread {
    SysOut(Runnable runnable) {
        super(runnable);
    }
    {
        commonResource = new ArrayList();
    }
    @Override
    public void run() {
        for (int i=0; i<1000; ++i)
            System.out.println(i);
    }
    private List commonResource;

    public List getCommonResource() {
        return commonResource;
    }

    public void setCommonResource(List commonResource) {
        this.commonResource = commonResource;
    }
}
