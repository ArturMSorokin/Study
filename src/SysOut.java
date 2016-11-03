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
        while (!interrupted()) {
            if (inc) {
                if (commonResource < 1000)
                    ++commonResource;
                else {
                    inc = false;
                    --commonResource;
                }
            } else {
                if (commonResource > 0)
                    --commonResource;
                else {
                    inc = true;
                    ++commonResource;
                }
            }
        }
    }
    private int  commonResource;

    public int getCommonResource() {
        return commonResource;
    }

    public void setCommonResource(int commonResource) {
        this.commonResource = commonResource;
    }
}
