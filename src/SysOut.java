import java.util.ArrayList;
import java.util.List;

/**
 * Created by olymp on 03.11.2016.
 */


public class SysOut extends Thread {
    SysOut() {
//        this.commonResource=list;
    }
    {
//        commonResource = new ArrayList();
    }
    private boolean inc=true;
    @Override
    public void run() {
        for (int i=0; i<1000000; ++i) {
            commonResource++;
        }
    }
    public static int  commonResource;

    public int getCommonResource() {
        return commonResource;
    }

    public void setCommonResource(int commonResource) {
        this.commonResource = commonResource;
    }
}
