package org.ayo.robot.observe;

/**
 * Created by Administrator on 2016/12/17.
 */

public interface Observer {

    void update(Observable observable, Object src, Object data);

}
