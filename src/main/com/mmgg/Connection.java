package mmgg;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;


/**
 * @Auther: wangxinjie
 * @Date: 2018/6/11 16:36
 * @Description:
 */
public class Connection {


    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch=new CountDownLatch(1);
            ZooKeeper zooKeeper=
                    new ZooKeeper("39.108.184.140:2181",4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if(Event.KeeperState.SyncConnected==event.getState()){
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());//CONNECTED

            zooKeeper.create("/zk","123".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
