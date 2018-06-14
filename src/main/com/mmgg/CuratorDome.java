package mmgg;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Auther: wangxinjie
 * @Date: 2018/6/12 14:34
 * @Description:
 */
public class CuratorDome {

    static final String CONNECT_ADDR = "39.108.184.140:2181";
    static final int SESSION_OUTTIME = 10000;

    public static void main(String[] args) {
        try {
            //重连策略
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
            CuratorFramework client = CuratorFrameworkFactory.newClient(CONNECT_ADDR,5000,SESSION_OUTTIME,retryPolicy);
            client.start();
          //  Thread.sleep(Integer.MAX_VALUE);

           /* client.create()
                    //.creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                    .forPath("/testCurator","init".getBytes());*/
           client.delete().deletingChildrenIfNeeded().forPath("/zookeeper");
            // client.getData().forPath("/zkPath");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
